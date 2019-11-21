package src;
/**
 * 몬스터를 생성하고 생성된 몬스터 정보들을 가지고 있는 클래스
 * @author Chanho Park
 */
public class MonsterBuilder
{
    MonsterDictionary m;
    public Monster[] monsters=new Monster[13];
    public int monster_count=0;
    /**
     * 몬스터를 생성하고 그 것을 배열에 저장하는 메소드
     * @param MonsterType
     *        생성할 몬스터 이름
     */
    public void CreateMonster(MonsterType monster, int place_num)
    {
        Monster temp=new Monster();

        temp=m.getMonster(monster);
        monsters[place_num]=temp;
        monster_count++;
    }
    /**
     * 해당 번호 타일에서 몬스터를 삭제하는 메소드
     * @param num
     *        타일 번호
     */
    public void DeleteMonster(int num)
    {
        monsters[num]=null;

        if(monster_count>=1)
        monster_count--;
    }
}