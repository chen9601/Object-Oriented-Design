/**
 * 맵의 타일 13개를 그래프를 사용해 이동가능 여부를 알려주는 클래스
 * 그래프 값->2:자기 자신, 1:이동 가능, 0:이동 불가
 * 
 * @author Chanho Park
 */

public class MapPath
{
    private int[][] Path={
{2,1,1,1,1,1,1,0,0,0,0,0,0},
{1,2,1,0,0,0,1,1,1,0,0,0,0},
{1,1,2,1,0,0,0,0,1,1,0,0,0},
{1,0,1,2,1,0,0,0,0,1,1,0,0},
{1,0,0,1,2,1,0,0,0,0,1,1,0},
{1,0,0,0,1,2,1,0,0,0,0,1,1},
{1,1,0,0,0,1,2,1,0,0,0,0,1},
{0,1,0,0,0,0,1,0,0,0,0,0,0},
{0,1,1,0,0,0,0,0,0,0,0,0,0},
{0,0,1,1,0,0,0,0,0,0,0,0,0},
{0,0,0,1,1,0,0,0,0,0,0,0,0},
{0,0,0,0,1,1,0,0,0,0,0,0,0},
{0,0,0,0,0,1,1,0,0,0,0,0,0}
};
/**
 * 플레이어와 이동하고 싶은 장소를 받아 해당 장소로의 이동가능 여부를 확인하는 메소드
 * 
 * @param player_num
 * @param place_num
 * @return boolean 이동가능 여부
 */
public boolean pathValid(int player_num, int place_num)
{
    int nowPlace=getPlayer(player_num).getPosition();
    if(Path[nowPlace][place_num]==1)
    return true;
    else
    return false;
}

MapPath()
{
    
}
}