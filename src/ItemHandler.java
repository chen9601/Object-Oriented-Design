/**
 * 아이템의 이름과 세부 스테이터스를 정의하고 반환하는 클래스
 * @author Chanho Park
 */

public class ItemHandler {
    private Item[] itemlist = new Item[11];

    /**
     * 아이템 번호로 원하는 아이템을 반환하는 메소드
     * @param itemnumber
     *        원하는 아이템 번호
     * @return Item
     */
    public Item getItem(int itemnumber)
    {
        return itemlist[itemnumber];
    }

    public ItemHandler(){
    itemlist[0].name="엑스칼리버";itemlist[0].p_power=2;itemlist[0].p_dex=1;itemlist[0].p_int=0;itemlist[0].p_health=1;itemlist[0].p_mental=0;

    itemlist[1].name="네크로노미콘";itemlist[1].p_power=0;itemlist[1].p_dex=0;itemlist[1].p_int=4;itemlist[1].p_health=0;itemlist[1].p_mental=-1;

    itemlist[2].name="빛나는 부등변다면체";itemlist[2].p_power=1;itemlist[2].p_dex=1;itemlist[2].p_int=1;itemlist[2].p_health=1;itemlist[2].p_mental=1;

    itemlist[3].name="황금의 벌꿀술";itemlist[3].p_power=2;itemlist[3].p_dex=0;itemlist[3].p_int=0;itemlist[3].p_health=2;itemlist[3].p_mental=0;

    itemlist[4].name="시간의 문제";itemlist[4].p_power=0;itemlist[4].p_dex=0;itemlist[4].p_int=2;itemlist[4].p_health=0;itemlist[4].p_mental=2;

    itemlist[5].name="이븐 가지의 분말";itemlist[5].p_power=1;itemlist[5].p_dex=1;itemlist[5].p_int=1;itemlist[5].p_health=0;itemlist[5].p_mental=0;

    itemlist[6].name="사냥개 부적";itemlist[6].p_power=2;itemlist[6].p_dex=2;itemlist[6].p_int=2;itemlist[6].p_health=-2;itemlist[6].p_mental=-2;

    itemlist[7].name="지혜의 열쇠";itemlist[7].p_power=0;itemlist[7].p_dex=0;itemlist[7].p_int=3;itemlist[7].p_health=0;itemlist[7].p_mental=0;

    itemlist[8].name="우주의 감로주";itemlist[8].p_power=1;itemlist[8].p_dex=1;itemlist[8].p_int=0;itemlist[8].p_health=2;itemlist[8].p_mental=0;

    itemlist[9].name="검은 파라오의 단장";itemlist[9].p_power=0;itemlist[9].p_dex=0;itemlist[9].p_int=0;itemlist[9].p_health=0;itemlist[9].p_mental=1;

    itemlist[10].name="알 하자드의 램프";itemlist[10].p_power=0;itemlist[10].p_dex=2;itemlist[10].p_int=1;itemlist[10].p_health=0;itemlist[10].p_mental=0;
    }
}