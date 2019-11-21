/**
 * 몬스터를 생성하는 클래스
 * @author Chanho Park
 */
public class MonsterBuilder
{
    MonsterHandler t;
    public Monster[] monsters=new Monster[9];
    public int monster_count=0;

    /**
     * 몬스터를 생성하는 메소드
     * 호출 시 받은 번호에 해당하는 몬스터를 monsters 배열에 집어넣는다.
     * @param monster_num
     */
    public void CreateMonster(int monster_num)
    {
        Monster temp=new Monster();
        temp=t.getMonster(monster_num);
        monsters[monster_count]=temp;
        monster_count++;
    }
}