import java.util.Math;

/**
 * 특정 조건에서 반드시 일어나야하는 이벤트들을 정리한 클래스
 * @author Chanho Park
 */

public class ConstantEventHandler
{
    private int death_count=3;
    private MapPath t;
    private RandomEVentHandler r;
    private ItemHandler i;

    /**
     * 움직일 플레이어와 목적지를 받아 이동가능 여부를 확인 후 이동시키는 메소드
     * @param player_num
     *        해당 플레이어
     * @param place_num
     *        목적지
     */
    public void Move(int player_num, int place_num)
    {
        if(t.pathValid(player_num, place_num)==true)
        {
            getCurrentPlayer().setPosition(place_num);
            getCurrentPlayer().setEnergy(getCurrentPlayer().getEnergy()-1);
            CheckHere(place_num, player_num);
        }
        else
        {
            ClearDialog();
            ShowDialog("그곳으로는 이동할 수 없습니다.");
        }
    }

    /**
     * 이동한 장소에 몬스터나 차원문이 있는지 확인하는 메소드.
     * 확인 결과 몬스터가 있을 경우 전투를 발생시킨다.
     * 확인 결과 차원문이 있을 경우 차원문 전투를 발생시킨다.
     * @param place_num
     *        이동한 장소
     * @param player_num
     *        도착한 플레이어
     */
    public void CheckHere(int place_num, int player_num)
    {
        if(isMonster(place_num)>0)
        GenerateFight(player_num, monster_num);

        if(isPortal(place_num)>0)
        PortalClose(player_num, place_num);
    }
    /**
     * 해당 장소에 몬스터가 존재하는지 확인하는 메소드
     * @param place_num
     *        해당 장소
     * @return int 존재 여부
     */
    public int isMonster(int place_num)
    {
        if(getTile(place_num).monster_count==1)
        return 1;
        else return 0;
    }
    /**
     * 해당 장소에 차원문아 존재하는지 확인하는 메소드
     * @param place_num
     *        해당 장소
     * @return int 존재 여부
     */
    public int isPortal(int place_num)
    {
        if(getTile(place_num).portal_count==1)
        return 1;
        else return 0;
    }
    /**
     * 차원문 전투를 수행하고 전투 성공 시 차원문을 제거하고 차원문 토큰을 추가하는 메소드
     * @param player_num
     *        해당 이벤트를 수행할 플레이어
     * @param place_num
     *        해당 장소
     * @return int 존재 여부
     */
    public void PortalClose(int player_num, int place_num)
    {
        GenerateFight(player_num, place_num);
        if(getCurrentPlayer().getHealth() > 0)
        {
            getTile(place_num).summoned_portal=0;
            setToken(getToken()+1);
        }
    }

    /**
     * 일반 전투 화면을 출력하고 승리했을 경우 전리품을 획득하는 메소드
     * @param player_num
     *        전투를 수행할 플레이어
     * @param monster_num
     *        전투를 수행할 몬스터
     */
    public void GenerateFight(int player_num, int monster_num)
    {
        Fight(player_num, monster_num);
        if(getCurrentPlayer().getHealth() > 0)
        getCurrentPlayer().setMoney(getCurrentPlayer().getMoney()+getMonsterResult(monster_num));
    }

    /**
     * 보스 전투 화면을 출력하는 메소드
     */
    public void GenerateBossFight()
    {
        ShowBossFight();
    }

    /**
     * 랜덤 이벤트를 발생시키기 위한 메소드
     * @param player_num
     *        해당 이벤트를 수행할 플레이어
     */
    public void GenerateRandomEvent(int player_num)
    {
        int ranVal=Math.floor(Math.random()*21);
        r.RandomEventIndicator(player_num, ranVal);
    }

    /**
     * 이벤트를 통한 특정 장소로의 이동의 경우에 쓰이는 메소드, 이동가능 여부를 확인하지 않음
     * @param player_num
     *        이동할 플레이어
     * @param place_num
     *        이동 장소
     */
    public void Teleport(int player_num, int place_num)
    {
        getCurrentPlayer().setPosition(place_num);
        RenewView();
    }

    /**
     * 이벤트를 통한 랜덤 이동의 경우에 쓰이는 메소드, 이동가능 여부를 확인하지 않음
     * @param player_num
     *        이동할 플레이어
     */
    public void RandomTeleport(int player_num)
    {
        int ranVal=Math.floor(Math.random()*13);                //맵 수만큼 ranVal을 뽑아냄
        Teleport(player_num, ranVal);
    }

    /**
     * 주사위 값이 필요한 경우에 호출되는 메소드
     * @return int 주사위 값
     */
    public int RollDice()
    {
        int diceVal=Dice();
        return diceVal;
    }

    /**
     * 플레이어의 체력이나 정신력이 0이 되었을 경우 즉사 여부를 확인하기 위한 메소드.
     * 즉사 여부를 확인할 때마다 굴릴 수 있는 주사위 수가 줄어든다.
     * @param player_num
     *        즉사 여부를 확인할 플레이어
     * @param death_reason
     *        사망 이유. 0->체력, 1->정신력
     */
    public void Death(int player_num, int death_reason)
    {
        int now_live=0;
        for(int i=0;i<death_count;i++)
        {
            if(RollDice()>4)
           { if(death_reason==1)                                         //체력이 0인 것이 사망 이유
            getCurrentPlayer().setHealth(getCurrentPlayer().getHealth()+1);
            else if(death_reason==2)                                    //정신력 0이 이유
            getCurrentPlayer().setMental(getCurrentPlayer().getMental()+1);
            now_live=1;
            death_count--;
            break;
           }
        }
        if(now_live==0)
        getCurrentPlayer().setStatus(2);

    }

    /**
     * 플레이어1,2의 행동치(Energy)가 모두 0이 되었을 때 턴 종료를 위해 실행되는 메소드.
     * 다음의 순서에 의해 실행된다.
     * 1. 승리조건 확인->토큰 수>10
     * 2. 패배조건 확인->플레이어1,2 모두 스테이터스가 즉사 상태
     * 3. 보스 소환 조건 확인->필드 위 몬스터 수가 7 이상 또는 차원문이 5개 이상
     * 4. 몬스터, 차원문 랜덤 생성
     * 5. 플레이어1,2 행동치 재생
     */
    public void TurnEnd()
    {
        if(getToken()>9)
        ViewVictory();
        
        if(getPlayer(1).getStatus()==2 && getPlayer(2).getStatus()==2)
        ViewDefeat();

        if(getMonsterCount()>6||getPortalCount()>4)
        GenerateBossFight();

        RandomGenerateMonster();
        RandomGeneratePortal();

        getPlayer(1).setEnergy(getPlayer(1).getHealth()/3);
        getPlayer(2).setEnergy(getPlayer(2).getHealth()/3);
    }
    /**
     * 플레이어에게 아이템을 추가하는 메소드
     * @param player_num
     *        아이템을 받을 플레이어
     * @param item_num
     *        해당 아이템 번호
     */
    public void AddItem(int player_num, int item_num)
    {
        getCurrentPlayer().addItem(i.getItem(item_num));
    }
/**
 * 랜덤으로 플레이어에게 아이템을 추가하는 메소드
 * @param player_num
 *        아이템을 받을 플레이어
 */
    public void AddRandomItem(int player_num)
    {
        int ranVal=Math.floor(Math.random()*11);
        AddItem(player_num, ranVal);
    }
}