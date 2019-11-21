package src;
/**
 * 몬스터 타입 정의 enumeration
 * @author Chanho Park
 */
public enum MonsterType {
    Nightgaunt("나이트건트", 0),Dark_Paraoh("검은파라오", 1),Byakhee("비야키", 2),Ghoul("구울", 3),Elder_Thing("옛 것", 4);

    private String name;
    private int index;
    MonsterType(String name, int index)
    {
        this.name=name;
        this.index=index;
    }
    public String getName()
    {
        return name;
    }
    public int getIndex()
    {
        return index;
    }
}
