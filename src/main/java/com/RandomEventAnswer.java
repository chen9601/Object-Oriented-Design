package com;

import com.Monster.MonsterType;

import GUI.View;

/**
 * RandomEventHandler에 의해 생성된 선택지를 클릭 시 ActionListener에 의해 실행될 각각의 선택지들에 대한 결과를 정리한 클래스
 * @author Chanho Park
 */

public static class RandomEventAnswer{
    /**
     * 이벤트를 진행할 플레이어와 클릭한 선택지에 해당하는 지칭자로 알맞은 메소드를 호출하는 메소드
     * @param indicator
     *        메소드 지칭자
     * @param player
     *        이벤트를 진행하는 플레이어
     */
public static void AnswerIndicator(Player player, Answer answer) 
    {
        switch(answer.getTag())
        {
            case "1_1":
            Ans1_1(player);
            break;
            case "1_1_1":
            Ans1_1_1(player);
            break;
            case "1_1_2":
            Ans1_1_2(player);
            break;
            case "1_2":
            Ans1_2(player);
            break;
            case "2_1":
            Ans2_1(player);
            break;
            case "2_2":
            Ans2_2(player);
            break;
            case "3_1":
            Ans3_1(player);
            break;
            case "3_2":
            Ans3_2(player);
            break;
            case "4_1":
            Ans4_1(player);
            break;
            case "4_2":
            Ans4_2(player);
            break;
            case "4_3":
            Ans4_3(player);
            break;
            case "5_1":
            Ans5_1(player);
            break;
            case "6_1":
            Ans6_1(player);
            break;
            case "6_2":
            Ans6_2(player);
            break;
            case "7_1":
            Ans7_1(player);
            break;
            case "7_2":
            Ans7_2(player);
            break;
            case "8_1":
            Ans8_1(player);
            break;
            case "8_2":
            Ans8_2(player);
            break;
            case "9_1":
            Ans9_1(player);
            break;
            case "9_2":
            Ans9_2(player);
            break;
            case "10_1":
            Ans10_1(player);
            break;
            case "10_2":
            Ans10_2(player);
            break;
            case "11_1":
            Ans11_1(player);
            break;
            case "12_1":
            Ans12_1(player);
            break;
            case "12_2":
            Ans12_2(player);
            break;
            case "13_1":
            Ans13_1(player);
            break;
            case "14_1":
            Ans14_1(player);
            break;
            case "14_2":
            Ans14_2(player);
            break;
            case "15_1":
            Ans15_1(player);
            break;
            case "16_1":
            Ans16_1(player);
            break;
            case "17_1":
            Ans17_1(player);
            break;
            case "18_1":
            Ans18_1(player);
            break;
            case "18_2":
            Ans18_2(player);
            break;
            case "19_1":
            Ans19_1(player);
            break;
            case "20_1":
            Ans20_1(player);
            break;
            case "21_1":
            Ans21_1(player);
            break;
            case "21_2":
            Ans21_2(player);
            break;

        }
    }

    public static void Ans1_1(Player player)//서브 이벤트 구현에 대한 이야기 필요
    {
        String message="당신은 집회에 가보기로 했습니다.";
        view.show_dialog(message);
        View.Renew_Dialog();
        String message2="\"고통은 인간을 계몽시키지.\" 비밀 결사의 교주가 말한다. \"동의하는가?\"";
        view.show_dialog(message2);     
        Answer answer1=new Answer("1. 동의한다.","1_1_1"); 
        Answer answer2=new Answer("2. 동의하지 않는다.","1_1_2");                                                                   
        view.show_dialog_answer(answer1);                                                                 
        view.show_dialog_answer(answer2);
    }
    public static void Ans1_1_1(Player player)
    {
        String message="\"고통을 받아들여라.\" 교주가 당신에게 낙인을 찍습니다.";
        view.show_dialog(message);
        int tempHealth=player.getHealth();
        int tempMental=player.getMental();
        player.setHealth(tempHealth-2);
        player.setMental(tempMental+2);
    }
    public static void Ans1_1_2(Player player)
    {
        String message="\"때로는 피할 수 없는 고통도 있는 법이지.\" 교주가 당신에게 저주를 날립니다.";
        view.show_dialog(message);
        int tempHealth=player.getHealth();
        player.setHealth(tempHealth-1);
        int tempMental=player.getMental();
        player.setMental(tempMental-1);
    }
    public static void Ans1_2(Player player)
    {
        String message="위험해보입니다. 그런 곳은 가지 않는 것이 상책입니다.";
        view.show_dialog(message);
    }
    public static void Ans2_1(Player player)
    {
        String message1="소리가 닿지 않는 곳으로 성공적으로 피했습니다.";
        String message2="메아리 소리에 정신이 아득해졌습니다.";
        if(player.getDexterity()<3)
        {
            int tempMental=player.getMental();
            player.setMental(tempMental-2);
            view.show_dialog(message2);
        }
        else
        view.show_dialog(message1);
    }
    public static void Ans2_2(Player player)
    {
        String message="소리를 내는 기괴한 생물체를 발견했습니다.";
        view.show_dialog(message);
        GenerateFight(player, MonsterType.Nightgaunt);
    }
    public static void Ans3_1(Player player)
    {
        String message1="당신은 훌륭하게 적을 꺾었고, 파이트 머니를 얻었습니다.";
        String message2="당신은 처참하게 적에게 패배했고, 그들은 당신을 내버려둔채 떠났습니다.";
        if(player.getPower()<6)
        {
            player.setHealth(player.getHealth()-2);
            player.setMental(player.getMental()-1);
            view.show_dialog(message2);
        }
        else
        {
            view.show_dialog(message1);
            player.setMoney(player.getMoney()+5);
        }
    }
    public static void Ans3_2(Player player)
    {
        String message="회원들이 당신에게 겁쟁이라고 욕했지만, 당신은 아랑곳하지 않고 자리를 떠났습니다.";
        view.show_dialog(message);
    }
    public static void Ans4_1(Player player)
    {
        String message1="그가 망토 속에서 기이한 물건 하나를 꺼내 당신에게 건네줍니다.";
        String message2="그는 갑자기 망토 속에서 독을 바른 칼날을 꺼내 당신을 찌릅니다.";
        int tempDice=view.Dice();
        if(tempDice>4)
        {
            view.show_dialog(message1);
            AddRandomItem(player);
        }
        else
        {
            view.show_dialog(message2);
            player.setHealth(player.getHealth()-tempDice);
        }
    }
    public static void Ans4_2(Player player)
    {
        player.setMental(player.getMental()-1);
        String message="우연히 그와 눈이 마주치자 당신의 영혼의 일부가 손실된 것처럼 허전해집니다.";
        view.show_dialog(message);
    }
    public static void Ans4_3(Player player)
    {
        String message="불길한 사람입니다. 자리에서 떠납니다.";
        view.show_dialog(message);
    }
    public static void Ans5_1(Player player)
    {
        String message1="당신을 가격하는 몽둥이를 피했습니다.";
        String message2="당신을 가격하는 몽둥이를 피하지 못했습니다. 눈앞이 캄캄해집니다.";
        if(Dice()>2 && player.getDexterity()>2)
        view.show_dialog(message1);
        else
        {
            view.show_dialog(message2);
            int temp=Math.floor(Math.random()*13);
            ConstantEventHandler.movebyTeleport(TileType.values()[temp]);
            GenerateRandomEvent(player);
        }
    }
    public static void Ans6_1(Player player)
    {
        String message1="조각상 안에 숨겨져 있던 주문을 해제하는 것을 성공했습니다. 알 수 없는 힘이 온 몸을 휘감습니다.";
        String message2="으스스한 공포가 온 몸을 휘감습니다.";
        if(player.getIntelligence()>5)
        {
            player.setDexterity(player.getDexterity()+1);
            view.show_dialog(message1);
        }
        else
        {
            player.setPower(player.getPower()-1);
            player.setDexterity(player.getDexterity()-1);
            view.show_dialog(message2);
        }
    }
    public static void Ans6_2(Player player)
    {
        String message="불길한 소문입니다. 무시합니다.";
        view.show_dialog(message);
    }


    public static void Ans7_1(Player player)
    {
        String message1="상자를 열고 신비로운 힘이 느껴지는 물건을 얻었습니다.";
        String message2="상자를 여는 것을 경비원에게 들켰습니다.";
        if(player.getDexterity()>2&&Dice()>3)
        {
            AddRandomItem(player);
            view.show_dialog(message1);
        }
        else
        {
            int temp=Math.floor(Math.random()*13);
            ConstantEventHandler.movebyTeleport(TileType.values()[temp]);
            view.show_dialog(message2);
        }
    }
    
    public static void Ans7_2(Player player)
    {
        String message="호기심이 고양이를 죽이는 법입니다.";
        view.show_dialog(message);
    }
    public static void Ans8_1(Player player)
    {
        String message1="이야기를 제보하고 5$를 받습니다.";
        String message2="할 이야기가 없습니다.";
        if(getToken()>2)
        {
            player.setMoney(player.getMoney()+5);
            view.show_dialog(message1);
        }
        else
        {
            view.show_dialog(message2);
        }
    }
    public static void Ans8_2(Player player)
    {
        String message="이런 이야기는 사람들에게 알려져서는 안됩니다. 제보하지 않습니다.";
        view.show_dialog(message);
    }

    public static void Ans9_1(Player player)
    {
        String message1="당신은 이제 자랑스러운 파이트 클럽의 회원입니다.";
        String message2="충분한 돈이 없습니다.";
        String message3="\"돈도 없으면서 허세를 부린건가?\" 회원들에게 흠씬 맞고 문밖으로 내던져집니다.";
        if(player.getMoney()>2)
        {
            player.setMoney(player.getMoney()-3);
            player.setPower(player.getPower()+2);
            view.show_dialog(message1);
        }
        else
        {
            if(player.getPower()>2)
            view.show_dialog(message2);
            else
            {
                player.setHealth(player.getHealth()-3);
                view.show_dialog(message3);
            }
        }
    }
    public static void Ans9_2(Player player)
    {
        String message1="그런 조직에 쓸 시간도, 돈도 없습니다.";
        String message2="\"우리 조직을 무시하다니.\" 회원들에게 흠씬 맞고 문밖으로 내던져집니다.";
        if(player.getPower()>2)
        view.show_dialog(message1);
        else
        {
            player.setHealth(player.getHealth()-3);
            view.show_dialog(message2);
        }
    }
    public static void Ans10_1(Player player)
    {
        String message1="그를 향해 뛰어올라 그를 붙잡는 순간 사라집니다. 신비로운 힘이 당신을 휘감습니다.";
        String message2="그가 당신의 눈 앞에서 소멸됩니다.";
        int tempDice=Dice();
        if(player.getDexterity()>5&&tempDice>3)
        {
            player.setPower(player.getPower()+1);
            player.setDexterity(player.getDexterity()+1);
            player.setIntelligence(player.getIntelligence()+1);
            view.show_dialog(message1);
        }
        else
        {
            player.setHealth(player.getHealth()-tempDice);
            view.show_dialog(message2);
        }
    }
    public static void Ans10_2(Player player)
    {
        String message="정말 그는 당신이 모르는 사람일까요?";
        view.show_dialog(message);
    }
    public static void Ans11_1(Player player)
    {
        String message="그의 연주를 듣고 있으니 마음 한구석이 치유되는 것 같습니다.";
        player.setMental(player.getMental()+2);
    }
    public static void Ans12_1(Player player)
    {
        String message1="\"거래 고맙네.\" 노인은 갑자기 사라졌고, 당신은 주머니가 허전해짐과 동시에 손에 정체모를 램프가 들려있는 것을 발견합니다.";
        String message2="\"이런..3달러도 없단 말인가?\" 노인이 갑자기 사라집니다.";
        int tempDice=Dice();
        if(player.getMoney()>2)
        {
            AddItem(player, 10); 
            view.show_dialog(message1);
        }
        else
        {
            view.show_dialog(message2);
        }
    }
    public static void Ans12_2(Player player)
    {
        String message="\"존중할줄 아는 자세가 필요하겠군.\" 노인이 갑자기 사라지고 당신은 현기증을 느낍니다.";
        player.setMental(player.getMental()-1);
        view.show_dialog(message);
    }

    public static void Ans13_1(Player player)
    {
        String message="공포가 당신을 휘감습니다.";
        player.setMental(player.getMental()-1);
        view.show_dialog(message);
    }

    public static void Ans14_1(Player player)
    {
        String message1="\"안타깝네, 뒤...\" 당신은 날렵한 손놀림으로 도박사가 다른 동전을 빼돌리는 것을 막습니다. \"지만 참가상품도 있으니까!\"";
        String message2="\"안타깝네, 뒤야.\"";
        if(player.getDexterity()>5)
        {
            AddRandomItem(player);
            view.show_dialog(message1);
        }
        else
        {
            player.setMoney(player.getMoney()-2);
            view.show_dialog(message2);
        }
    }

    public static void Ans14_2(Player player)
    {
        String message1="\"안타깝네, 앞...\" 당신은 날렵한 손놀림으로 도박사가 다른 동전을 빼돌리는 것을 막습니다. \"이지만 참가상품도 있으니까!\"";
        String message2="\"안타깝네, 앞이야.\"";
        if(player.getDexterity()>5)
        {
            AddRandomItem(player);
            view.show_dialog(message1);
        }
        else
        {
            player.setMoney(player.getMoney()-2);
            view.show_dialog(message2);
        }
    }

    public static void Ans15_1(Player player)
    {
        String message="당신은 오싹한 기분을 느낍니다.";
        player.setMental(player.getMental()-1);
        view.show_dialog(message);
    }

    public static void Ans16_1(Player player)
    {
        String message="정신이 아득해지는 것을 느꼈지만, 단서 또한 얻었습니다.";
        player.setMental(player.getMental()-1);
        GameMaster.token++;
        view.show_dialog(message);
    }

    public static void Ans17_1(Player player)
    {
        String message="유령선이라...철 지난 농담같군요.";
        int tempPlace=Math.floor(Math.random()*13);
        int tempPlace2=Math.floor(Math.random()*13);
        int tempMon=Math.floor(Math.random()*5);
        int tempMon2=Math.floor(Math.random()*5);
        CreateMonster(MonsterType.values()[tempMon], TileType.values()[tempPlace]); 
        CreateMonster(MonsterType.values()[tempMon2], TileType.values()[tempPlace2]);
        view.show_dialog(message);
    }

    public static void Ans18_1(Player player)
    {
        String message1="당신은 검은 정장의 사나이의 안으로 빨려들어가는 것을 느낍니다...";
        String message2="당신은 이 미친 거래에서 살아남았습니다. 사나이는 당신에게 힘을 주고 떠나갑니다. \"다음에 뵙겠습니다.\"";
        int tempNum=player.getMental();
        for(int i=0;i<tempNum;i++)
        {
            if(Dice()<4)
            player.setMental(player.getMental()-1);

            if(player.getMental()==0)
            {
                vi.view.show_dialog(message1);
                //player.setStatus(2);                                               //Status 2는 즉사 상태. 즉 즉사 체크 없이 즉사 처리함+status 구현 어떻게 되었는지??
                break;
            }
        }
        if(player.getMental()>0)
        {
            player.setPower(player.getPower()+1);
            player.setDexterity(player.getDexterity()+1);
            player.setMental(player.getMental()+1);
            vi.view.show_dialog(message2);
        }
    }
    public static void Ans18_2(Player player)
    {
        String message="\"안타깝군요. 다음에는 거래에 응해주시길.\"";
        view.show_dialog(message);
    }

    
    public static void Ans19_1(Player player)
    {
        String message="이는 사람의 짓이 아닙니다. 괴물이 빈민가에 풀려난 것 같습니다.";
        for(int i=0;i<3;i++)
        { 
            int tempMon=Math.floor(Math.random()*5);
            int tempPlace=Math.floor(Math.random()*13);
            CreateMonster(MonsterType.values()[tempMon], TileType.values()[tempPlace]);
        }

        view.show_dialog(message);
    }


    public static void Ans20_1(Player player)
    {
        String message="써도 괜찮은 물건일까요?";
        AddRandomItem(player);
        view.show_dialog(message);
    }

    public static void Ans21_1(Player player)
    {
        String message1="그를 향해 뛰어올라 그를 붙잡는 순간 사라집니다. 신비로운 힘이 당신을 휘감습니다.";
        String message2="그가 당신의 눈 앞에서 소멸됩니다.";
        int tempDice=Dice();
        if(player.getDexterity()>5&&tempDice>3)
        {
            player.setPower(player.getPower()+1);
            player.setDexterity(player.getDexterity()+1);
            player.setIntelligence(player.getIntelligence()+1);
            view.show_dialog(message1);
        }
        else
        {
            player.setHealth(player.getHealth()-tempDice);
            view.show_dialog(message2);
        }
    }
    public static void Ans21_2(Player player)
    {
        String message="정말 그는 당신이 모르는 사람일까요?";
        view.show_dialog(message);
    }
}