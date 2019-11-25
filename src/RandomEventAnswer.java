/**
 * RandomEventHandler에 의해 생성된 선택지를 클릭 시 ActionListener에 의해 실행될 각각의 선택지들에 대한 결과를 정리한 클래스
 * @author Chanho Park
 */

public class RandomEventAnswer{
    /**
     * 이벤트를 진행할 플레이어와 클릭한 선택지에 해당하는 지칭자로 알맞은 메소드를 호출하는 메소드
     * @param indicator
     *        메소드 지칭자
     * @param player_num
     *        이벤트를 진행하는 플레이어
     */
public void AnswerIndicator(String indicator, int player_num) 
    {
        switch(indicator)
        {
            case "1_1":
            Ans1_1(player_num);
            break;
            case "1_1_1":
            Ans1_1_1(player_num);
            break;
            case "1_1_2":
            Ans1_1_2(player_num);
            break;
            case "1_2":
            Ans1_2(player_num);
            break;
            case "2_1":
            Ans2_1(player_num);
            break;
            case "2_2":
            Ans2_2(player_num);
            break;
            case "3_1":
            Ans3_1(player_num);
            break;
            case "3_2":
            Ans3_2(player_num);
            break;
            case "4_1":
            Ans4_1(player_num);
            break;
            case "4_2":
            Ans4_2(player_num);
            break;
            case "4_3":
            Ans4_3(player_num);
            break;
            case "5_1":
            Ans5_1(player_num);
            break;
            case "6_1":
            Ans6_1(player_num);
            break;
            case "6_2":
            Ans6_2(player_num);
            break;
            case "7_1":
            Ans7_1(player_num);
            break;
            case "7_2":
            Ans7_2(player_num);
            break;
            case "8_1":
            Ans8_1(player_num);
            break;
            case "8_2":
            Ans8_2(player_num);
            break;
            case "9_1":
            Ans9_1(player_num);
            break;
            case "9_2":
            Ans9_2(player_num);
            break;
            case "10_1":
            Ans10_1(player_num);
            break;
            case "10_2":
            Ans10_2(player_num);
            break;
            case "11_1":
            Ans11_1(player_num);
            break;
            case "12_1":
            Ans12_1(player_num);
            break;
            case "12_2":
            Ans12_2(player_num);
            break;
            case "13_1":
            Ans13_1(player_num);
            break;
            case "14_1":
            Ans14_1(player_num);
            break;
            case "14_2":
            Ans14_2(player_num);
            break;
            case "15_1":
            Ans15_1(player_num);
            break;
            case "16_1":
            Ans16_1(player_num);
            break;
            case "17_1":
            Ans17_1(player_num);
            break;
            case "18_1":
            Ans18_1(player_num);
            break;
            case "18_2":
            Ans18_2(player_num);
            break;
            case "19_1":
            Ans19_1(player_num);
            break;
            case "20_1":
            Ans20_1(player_num);
            break;
            case "21_1":
            Ans21_1(player_num);
            break;
            case "21_2":
            Ans21_2(player_num);
            break;

        }
    }

    public void Ans1_1(int player_num)
    {
        String message="당신은 집회에 가보기로 했습니다.";
        ShowDialog(message);
        Rev1_Sub1(player_num);
    }
    public void Ans1_1_1(int player_num)
    {
        String message="\"고통을 받아들여라.\" 교주가 당신에게 낙인을 찍습니다.";
        ShowDialog(message);
        int tempHealth=getCurrentPlayer().getHealth();
        int tempMental=getCurrentPlayer().getMental();
        getCurrentPlayer().setHealth(tempHealth-2);
        getCurrentPlayer().setMental(tempMental+2);
    }
    public void Ans1_1_2(int player_num)
    {
        String message="\"때로는 피할 수 없는 고통도 있는 법이지.\" 교주가 당신에게 저주를 날립니다.";
        ShowDialog(message);
        int tempHealth=getCurrentPlayer().getHealth();
        getCurrentPlayer().setHealth(tempHealth-1);
        int tempMental=getCurrentPlayer().getMental();
        getCurrentPlayer().setMental(tempMental-1);
    }
    public void Ans1_2(int player_num)
    {
        String message="위험해보입니다. 그런 곳은 가지 않는 것이 상책입니다.";
        ShowDialog(message);
    }
    public void Ans2_1(int player_num)
    {
        String message1="민첩 판정 성공//소리가 닿지 않는 곳으로 성공적으로 피했습니다.";
        String message2="민첩 판정 실패//메아리 소리에 정신이 아득해졌습니다.";
        if(getCurrentPlayer().getDexterity()<3)
        {
            int tempMental=getCurrentPlayer().getMental();
            getCurrentPlayer().setMental(tempMental-2);
            ShowDialog(message2);
        }
        else
        ShowDialog(message1);
    }
    public void Ans2_2(int player_num)
    {
        String message="소리를 내는 기괴한 생물체를 발견했습니다.";
        ShowDialog(message);
        GenerateFight(player_num, 1);                   //나이트건트에 해당하는 몬스터 번호 입력(추후 수정)
    }
    public void Ans3_1(int player_num)
    {
        String message1="힘 판정 성공//당신은 훌륭하게 적을 꺾었고, 파이트 머니를 얻었습니다.";
        String message2="힘 판정 실패//당신은 처참하게 적에게 패배했고, 그들은 당신을 내버려둔채 떠났습니다.";
        if(getCurrentPlayer().getPower()<6)
        {
            getCurrentPlayer().setHealth(getCurrentPlayer().getHealth()-2);
            getCurrentPlayer().setMental(getCurrentPlayer().getMental()-1);
            ShowDialog(message2);
        }
        else
        {
            ShowDialog(message1);
            getCurrentPlayer().setMoney(getCurrentPlayer().getMoney()+5);
        }
    }
    public void Ans3_2(int player_num)
    {
        String message="회원들이 당신에게 겁쟁이라고 욕했지만, 당신은 아랑곳하지 않고 자리를 떠났습니다.";
        ShowDialog(message);
    }
    public void Ans4_1(int player_num)
    {
        String message1="그가 망토 속에서 기이한 물건 하나를 꺼내 당신에게 건네줍니다.";
        String message2="그는 갑자기 망토 속에서 독을 바른 칼날을 꺼내 당신을 찌릅니다.";
        int tempDice=RollDice();
        if(tempDice>4)
        {
            ShowDialog(message1);
            AddRandomItem(player_num);
        }
        else
        {
            ShowDialog(message2);
            getCurrentPlayer().setHealth(getCurrentPlayer().getHealth()-tempDice);
        }
    }
    public void Ans4_2(int player_num)
    {
        getCurrentPlayer().setMental(getCurrentPlayer().getMental()-1);
        String message="우연히 그와 눈이 마주치자 당신의 영혼의 일부가 손실된 것처럼 허전해집니다.";
        ShowDialog(message);
    }
    public void Ans4_3(int player_num)
    {
        String message="불길한 사람입니다. 자리에서 떠납니다.";
        ShowDialog(message);
    }
    public void Ans5_1(int player_num)
    {
        String message1="당신을 가격하는 몽둥이를 피했습니다.";
        String message2="당신을 가격하는 몽둥이를 피하지 못했습니다. 눈앞이 캄캄해집니다.";
        if(RollDice()>2 && getCurrentPlayer().getDexterity()>2)
        ShowDialog(message1);
        else
        {
            ShowDialog(message2);
            RandomTeleport(player_num);
            GenerateRandomEvent(player_num);
        }
    }
    public void Ans6_1(int player_num)
    {
        String message1="조각상 안에 숨겨져 있던 주문을 해제하는 것을 성공했습니다. 알 수 없는 힘이 온 몸을 휘감습니다.";
        String message2="으스스한 공포가 온 몸을 휘감습니다.";
        if(getCurrentPlayer().getIntelligence()>5)
        {
            getCurrentPlayer().setDexterity(getCurrentPlayer().getDexterity()+1);
            ShowDialog(message1);
        }
        else
        {
            getCurrentPlayer().setPower(getCurrentPlayer().getPower()-1);
            getCurrentPlayer().setDexterity(getCurrentPlayer().getDexterity()-1);
            ShowDialog(message2);
        }
    }
    public void Ans6_2(int player_num)
    {
        String message="불길한 소문입니다. 무시합니다.";
        ShowDialog(message);
    }


    public void Ans7_1(int player_num)
    {
        String message1="상자를 열고 신비로운 힘이 느껴지는 물건을 얻었습니다.";
        String message2="상자를 여는 것을 경비원에게 들켰습니다.";
        if(getCurrentPlayer().getDexterity()>2&&RollDice()>3)
        {
            AddRandomItem(player_num);
            ShowDialog(message1);
        }
        else
        {
            RandomTeleport(player_num);
            ShowDialog(message2);
        }
    }
    
    public void Ans7_2(int player_num)
    {
        String message="호기심이 고양이를 죽이는 법입니다.";
        ShowDialog(message);
    }
    public void Ans8_1(int player_num)
    {
        String message1="이야기를 제보하고 5$를 받습니다.";
        String message2="할 이야기가 없습니다.";
        if(getToken()>2)
        {
            getCurrentPlayer().setMoney(getCurrentPlayer().getMoney()+5);
            ShowDialog(message1);
        }
        else
        {
            ShowDialog(message2);
        }
    }
    public void Ans8_2(int player_num)
    {
        String message="이런 이야기는 사람들에게 알려져서는 안됩니다. 제보하지 않습니다.";
        ShowDialog(message);
    }

    public void Ans9_1(int player_num)
    {
        String message1="당신은 이제 자랑스러운 파이트 클럽의 회원입니다.";
        String message2="충분한 돈이 없습니다.";
        String message3="\"돈도 없으면서 허세를 부린건가?\" 회원들에게 흠씬 맞고 문밖으로 내던져집니다.";
        if(getCurrentPlayer().getMoney()>2)
        {
            getCurrentPlayer().setMoney(getCurrentPlayer().getMoney()-3);
            getCurrentPlayer().setPower(getCurrentPlayer().getPower()+2);
            ShowDialog(message1);
        }
        else
        {
            if(getCurrentPlayer().getPower()>2)
            ShowDialog(message2);
            else
            {
                getCurrentPlayer().setHealth(getCurrentPlayer().getHealth()-3);
                ShowDialog(message3);
            }
        }
    }
    public void Ans9_2(int player_num)
    {
        String message1="그런 조직에 쓸 시간도, 돈도 없습니다.";
        String message2="\"우리 조직을 무시하다니.\" 회원들에게 흠씬 맞고 문밖으로 내던져집니다.";
        if(getCurrentPlayer().getPower()>2)
        ShowDialog(message1);
        else
        {
            getCurrentPlayer().setHealth(getCurrentPlayer().getHealth()-3);
            ShowDialog(message2);
        }
    }
    public void Ans10_1(int player_num)
    {
        String message1="그를 향해 뛰어올라 그를 붙잡는 순간 사라집니다. 신비로운 힘이 당신을 휘감습니다.";
        String message2="그가 당신의 눈 앞에서 소멸됩니다.";
        int tempDice=RollDice();
        if(getCurrentPlayer().getDexterity()>5&&tempDice>3)
        {
            getCurrentPlayer().setPower(getCurrentPlayer().getPower()+1);
            getCurrentPlayer().setDexterity(getCurrentPlayer().getDexterity()+1);
            getCurrentPlayer().setIntelligence(getCurrentPlayer().getIntelligence()+1);
            ShowDialog(message1);
        }
        else
        {
            getCurrentPlayer().setHealth(getCurrentPlayer().getHealth()-tempDice);
            ShowDialog(message2);
        }
    }
    public void Ans10_2(int player_num)
    {
        String message="정말 그는 당신이 모르는 사람일까요?";
        ShowDialog(message);
    }
    public void Ans11_1(int player_num)
    {
        String message="그의 연주를 듣고 있으니 마음 한구석이 치유되는 것 같습니다.";
        getCurrentPlayer().setMental(getCurrentPlayer().getMental()+2);
    }
    public void Ans12_1(int player_num)
    {
        String message1="\"거래 고맙네.\" 노인은 갑자기 사라졌고, 당신은 주머니가 허전해짐과 동시에 손에 정체모를 램프가 들려있는 것을 발견합니다.";
        String message2="\"이런..3달러도 없단 말인가?\" 노인이 갑자기 사라집니다.";
        int tempDice=RollDice();
        if(getCurrentPlayer().getMoney()>2)
        {
            AddItem(player_num, 10); 
            ShowDialog(message1);
        }
        else
        {
            ShowDialog(message2);
        }
    }
    public void Ans12_2(int player_num)
    {
        String message="\"존중할줄 아는 자세가 필요하겠군.\" 노인이 갑자기 사라지고 당신은 현기증을 느낍니다.";
        getCurrentPlayer().setMental(getCurrentPlayer().getMental()-1);
        ShowDialog(message);
    }

    public void Ans13_1(int player_num)
    {
        String message="공포가 당신을 휘감습니다.";
        getCurrentPlayer().setMental(getCurrentPlayer().getMental()-1);
        ShowDialog(message);
    }

    public void Ans14_1(int player_num)
    {
        String message1="\"안타깝네, 뒤...\" 당신은 날렵한 손놀림으로 도박사가 다른 동전을 빼돌리는 것을 막습니다. \"지만 참가상품도 있으니까!\"";
        String message2="\"안타깝네, 뒤야.\"";
        if(getCurrentPlayer().getDexterity()>5)
        {
            AddRandomItem(player_num);
            ShowDialog(message1);
        }
        else
        {
            getCurrentPlayer().setMoney(getCurrentPlayer().getMoney()-2);
            ShowDialog(message2);
        }
    }

    public void Ans14_2(int player_num)
    {
        String message1="\"안타깝네, 앞...\" 당신은 날렵한 손놀림으로 도박사가 다른 동전을 빼돌리는 것을 막습니다. \"이지만 참가상품도 있으니까!\"";
        String message2="\"안타깝네, 앞이야.\"";
        if(getCurrentPlayer().getDexterity()>5)
        {
            AddRandomItem(player_num);
            ShowDialog(message1);
        }
        else
        {
            getCurrentPlayer().setMoney(getCurrentPlayer().getMoney()-2);
            ShowDialog(message2);
        }
    }

    public void Ans15_1(int player_num)
    {
        String message="당신은 오싹한 기분을 느낍니다.";
        getCurrentPlayer().setMental(getCurrentPlayer().getMental()-1);
        ShowDialog(message);
    }

    public void Ans16_1(int player_num)
    {
        String message="정신이 아득해지는 것을 느꼈지만, 단서 또한 얻었습니다.";
        getCurrentPlayer().setMental(getCurrentPlayer().getMental()-1);
        setToken(getToken()+1);
        ShowDialog(message);
    }

    public void Ans17_1(int player_num)
    {
        String message="유령선이라...철 지난 농담같군요.";
        int tempPlace=Math.floor(Math.random()*13);
        int tempPlace2=Math.floor(Math.random()*13);
        CreateMonster(3, tempPlace);                                                            //추후 구현, 이거 내가 구현해야하나?
        CreateMonster(5, tempPlace2);
        ShowDialog(message);
    }

    public void Ans18_1(int player_num)
    {
        String message1="당신은 검은 정장의 사나이의 안으로 빨려들어가는 것을 느낍니다...";
        String message2="당신은 이 미친 거래에서 살아남았습니다. 사나이는 당신에게 힘을 주고 떠나갑니다. \"다음에 뵙겠습니다.\"";
        int tempNum=getCurrentPlayer().getMental();
        for(int i=0;i<tempNum;i++)
        {
            if(RollDice()<4)
            getCurrentPlayer().setMental(getCurrentPlayer().getMental()-1);

            if(getCurrentPlayer().getMental()==0)
            {
                vi.ShowDialog(message1);
                getCurrentPlayer().setStatus(2);                                               //Status 2는 즉사 상태. 즉 즉사 체크 없이 즉사 처리함
                break;
            }
        }
        if(getCurrentPlayer().getMental()>0)
        {
            getCurrentPlayer().setPower(getCurrentPlayer().getPower()+1);
            getCurrentPlayer().setDexterity(getCurrentPlayer().getDexterity()+1);
            getCurrentPlayer().setMental(getCurrentPlayer().getMental()+1);
            vi.ShowDialog(message2);
        }
    }
    public void Ans18_2(int player_num)
    {
        String message="\"안타깝군요. 다음에는 거래에 응해주시길.\"";
        ShowDialog(message);
    }

    
    public void Ans19_1(int player_num)
    {
        String message="이는 사람의 짓이 아닙니다. 괴물이 빈민가에 풀려난 것 같습니다.";
        CreateMonster(1, 1);
        CreateMonster(1, 2);
        CreateMonster(1, 3);
        ShowDialog(message);
    }


    public void Ans20_1(int player_num)
    {
        String message="써도 괜찮은 물건일까요?";
        AddRandomItem(player_num);
        ShowDialog(message);
    }

    public void Ans21_1(int player_num)
    {
        String message1="그를 향해 뛰어올라 그를 붙잡는 순간 사라집니다. 신비로운 힘이 당신을 휘감습니다.";
        String message2="그가 당신의 눈 앞에서 소멸됩니다.";
        int tempDice=RollDice();
        if(getCurrentPlayer().getDexterity()>5&&tempDice>3)
        {
            getCurrentPlayer().setPower(getCurrentPlayer().getPower()+1);
            getCurrentPlayer().setDexterity(getCurrentPlayer().getDexterity()+1);
            getCurrentPlayer().setIntelligence(getCurrentPlayer().getIntelligence()+1);
            ShowDialog(message1);
        }
        else
        {
            getCurrentPlayer().setHealth(getCurrentPlayer().getHealth()-tempDice);
            ShowDialog(message2);
        }
    }
    public void Ans21_2(int player_num)
    {
        String message="정말 그는 당신이 모르는 사람일까요?";
        ShowDialog(message);
    }
}