public class temporaryFunction
{
    ItemHandler itemInd=new ItemHandler();

    public Player getPlayer(int player_num)                         //해당하는 Player 객체 반환
    {
        if(player_num==1)
         return player1;
         else if(player_num==2)
         return player2;
    }

    public void ItemAdapter(int item_num, int player_num)
    {
        Item tempItem=ItemInd.getItem(item_num);
        getPlayer(player_num).setPower(getPlayer(player_num).getPower()+tempItem.p_power);
        getPlayer(player_num).setDexterity(getPlayer(player_num).getDexterity()+tempItem.p_dex);
        getPlayer(player_num).setIntelligence(getPlayer(player_num).getIntelligence()+tempItem.p_int);

        if(getPlayer(player_num).getHealth()+tempItem.p_health>0)
        getPlayer(player_num).setHealth(getPlayer(player_num).getHealth()+tempItem.p_health);

        if(getPlayer(player_num).getMental()+tempItem.p_mental>0)
        getPlayer(player_num).setMental(getPlayer(player_num).getMental()+tempItem.p_mental);
    }

    public void ItemDelete(int item_num, int player_num)
    {
        Item tempItem=ItemInd.getItem(item_num);
        getPlayer(player_num).setPower(getPlayer(player_num).getPower()-tempItem.p_power);
        getPlayer(player_num).setDexterity(getPlayer(player_num).getDexterity()-tempItem.p_dex);
        getPlayer(player_num).setIntelligence(getPlayer(player_num).getIntelligence()-tempItem.p_int);

        if(getPlayer(player_num).getHealth()-tempItem.p_health>0)
        getPlayer(player_num).setHealth(getPlayer(player_num).getHealth()-tempItem.p_health);

        if(getPlayer(player_num).getMental()-tempItem.p_mental>0)
        getPlayer(player_num).setMental(getPlayer(player_num).getMental()-tempItem.p_mental);
    }

    public void BossSelect(int boss_num)
    {
        
    }
}