package src;
/**
 * 몬스터의 기본 속성들을 정의하는 클래스<br>
 * health:몬스터 체력<br>
 * requireVal:몬스터에게 데미지를 주기 위한/몬스터가 플레이어에게 데미지를 주기 위한 주사위 요구치<br>
 * damage:몬스터가 플레이어에게 주는 데미지<br>
 * damageType:데미지 타입. 1->체력, 2->정신력<br>
 * monsterresult:몬스터와의 전투 승리 시 얻을 수 있는 소지금 보상<br>
 * name:몬스터 이름
 * @author Chanho Park
 */
public class Monster
{
    public int health;
    public int requireVal;
    public int damage;
    public int damageType;
    public int monsterresult;
    public String name;

    public void setHealth(int val)
    {
        health-=val;
    }
}