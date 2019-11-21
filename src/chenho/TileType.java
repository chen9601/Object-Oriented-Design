package src;

/**
 * 타일타입 enum, 타일을 쉽게 접근하기 위해 사용한다. 인덱스로도 사용하고, 파라미터로도 사용해서 접근성을 용이하게 함.
 * @author Se-Ok Jeon
 * @version 1.0
 */
public enum TileType {
    HOSPITAL("병원", 8),
    MENTAL_HOSTPITAL("정신병원", 11),
    STORE("상점", 0),
    A("A", 1),
    B("B", 2),
    C("C", 3),
    D("D", 4),
    E("E", 5),
    F("F", 6),
    G("G", 7),
    H("H", 9),
    I("I", 10),
    J("J", 12);

    private String name;
    private int index;
    TileType(String name, int index){
        this.index=index;
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public int getIndex()
    {
        return index;
    }
}