/**
 * 몬스터 세부 사항들을 정의하는 클래스
 * @author Chanho Park
 */

public class MonsterHandler
{
    private Monster[] monsterlist=new Monster[5];
    enum MonsterType
    {
        Nightgaunt("나이트건트", 0),Dark_Paraoh("검은파라오", 1),Byakhee("비야키", 2),Ghoul("구울", 3),Elder_Thing("옛 것", 4);

        private String name;
        MonsterType(String name)
        {
            this.name=name;
        }
        public String getName()
        {
            return name;
        }

        private int index;
        MonsterType(int index)
        {
            this.index=index;
        }
        public int getIndex()
        {
            return index;
        }
    }

    MonsterHandler()
    {
        monsterlist[0].name="나이트건트";monsterlist[0].health=3;monsterlist[0].requireVal=3;monsterlist[0].damage=1;monsterlist[0].damageType=1;monsterlist[0].monsterresult=3;
        monsterlist[1].name="검은파라오";monsterlist[1].health=1;monsterlist[1].requireVal=6;monsterlist[1].damage=2;monsterlist[1].damageType=2;monsterlist[1].monsterresult=5;
        monsterlist[2].name="비야키";monsterlist[2].health=2;monsterlist[2].requireVal=2;monsterlist[2].damage=1;monsterlist[2].damageType=1;monsterlist[2].monsterresult=1;
        monsterlist[3].name="구울";monsterlist[3].health=4;monsterlist[3].requireVal=4;monsterlist[3].damage=2;monsterlist[3].damageType=1;monsterlist[3].monsterresult=4;
        monsterlist[4].name="옛 것";monsterlist[0].health=5;monsterlist[0].requireVal=4;monsterlist[0].damage=1;monsterlist[0].damageType=2;monsterlist[0].monsterresult=5;
    }
    /**
     * 몬스터 번호를 받아 그에 대응하는 몬스터를 반환하는 메소드
     * @param monster_num
     *        몬스터 번호
     * @return Monster
     *        해당 몬스터
     */
    public Monster getMonster(int monster_num)
    {
        return monsterlist[monster_num];
    }
}