package GUI;

import com.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;


/**
 * Dialog 창, map. 플레이어들의 간략화 된 스탯 및 token을 보여주는 클래스이다.
 */


public class MainGame_page extends JFrame {


    // TODO : 모든 경로를 아래와 같이 역슬래시 두개로 구분하는 방식으로 변경할 것!
    Image img = new ImageIcon("src\\main\\java\\GUI\\imgaes\\backgroundImage.jpg").getImage();
    //버튼이랑 라벨들 리팩토링
    //몬스터랑 포탈 출력가능하게 만들기
    //
    static ImageIcon reddot_img_icon = new ImageIcon("src\\main\\java\\GUI\\imgaes\\reddot.png");
    static JButton reddot_0 = new JButton(reddot_img_icon);
    static JButton reddot_1 = new JButton(reddot_img_icon);
    static JButton reddot_2 = new JButton(reddot_img_icon);
    static JButton reddot_3 = new JButton(reddot_img_icon);
    static JButton reddot_4 = new JButton(reddot_img_icon);
    static JButton reddot_5 = new JButton(reddot_img_icon);
    static JButton reddot_6 = new JButton(reddot_img_icon);
    static JButton reddot_7 = new JButton(reddot_img_icon);
    static JButton reddot_8 = new JButton(reddot_img_icon);
    static JButton reddot_9 = new JButton(reddot_img_icon);
    static JButton reddot_10 = new JButton(reddot_img_icon);
    static JButton reddot_11 = new JButton(reddot_img_icon);
    static JButton reddot_12 = new JButton(reddot_img_icon);
    static JButton dot_array[] = {reddot_0, reddot_1, reddot_2, reddot_3, reddot_4, reddot_5, reddot_6, reddot_7, reddot_8, reddot_9, reddot_10, reddot_11, reddot_12};
//    static JButton dot_array[] = new JButton[13];

    ImageIcon city_img_icon = new ImageIcon("src\\main\\java\\GUI\\imgaes\\stage.png");
    JButton city_btn_0 = new JButton(city_img_icon);
    JButton city_btn_1 = new JButton(city_img_icon);
    JButton city_btn_2 = new JButton(city_img_icon);
    JButton city_btn_3 = new JButton(city_img_icon);
    JButton city_btn_4 = new JButton(city_img_icon);
    JButton city_btn_5 = new JButton(city_img_icon);
    JButton city_btn_6 = new JButton(city_img_icon);
    JButton city_btn_7 = new JButton(city_img_icon);
    JButton city_btn_8 = new JButton(city_img_icon);
    JButton city_btn_9 = new JButton(city_img_icon);
    JButton city_btn_10 = new JButton(city_img_icon);
    JButton city_btn_11 = new JButton(city_img_icon);
    JButton city_btn_12 = new JButton(city_img_icon);
    JButton city_array[] = {city_btn_0, city_btn_1, city_btn_2, city_btn_3, city_btn_4, city_btn_5, city_btn_6, city_btn_7, city_btn_8, city_btn_9, city_btn_10, city_btn_11, city_btn_12};

    static ImageIcon player1_Icon = new ImageIcon("src\\main\\java\\GUI\\imgaes\\player1_img.png");

    static JLabel player1_img_0 = new JLabel(player1_Icon);
    static JLabel player1_img_1 = new JLabel(player1_Icon);
    static JLabel player1_img_2 = new JLabel(player1_Icon);
    static JLabel player1_img_3 = new JLabel(player1_Icon);
    static JLabel player1_img_4 = new JLabel(player1_Icon);
    static JLabel player1_img_5 = new JLabel(player1_Icon);
    static JLabel player1_img_6 = new JLabel(player1_Icon);
    static JLabel player1_img_7 = new JLabel(player1_Icon);
    static JLabel player1_img_8 = new JLabel(player1_Icon);
    static JLabel player1_img_9 = new JLabel(player1_Icon);
    static JLabel player1_img_10 = new JLabel(player1_Icon);
    static JLabel player1_img_11 = new JLabel(player1_Icon);
    static JLabel player1_img_12 = new JLabel(player1_Icon);
    static JLabel player1_array[] = {player1_img_0, player1_img_1, player1_img_2, player1_img_3, player1_img_4, player1_img_5,
            player1_img_6, player1_img_7, player1_img_8, player1_img_9, player1_img_10, player1_img_11, player1_img_12};

    static ImageIcon player2_Icon = new ImageIcon("src\\main\\java\\GUI\\imgaes\\player2_img.png");

    static JLabel player2_img_0 = new JLabel(player2_Icon);
    static JLabel player2_img_1 = new JLabel(player2_Icon);
    static JLabel player2_img_2 = new JLabel(player2_Icon);
    static JLabel player2_img_3 = new JLabel(player2_Icon);
    static JLabel player2_img_4 = new JLabel(player2_Icon);
    static JLabel player2_img_5 = new JLabel(player2_Icon);
    static JLabel player2_img_6 = new JLabel(player2_Icon);
    static JLabel player2_img_7 = new JLabel(player2_Icon);
    static JLabel player2_img_8 = new JLabel(player2_Icon);
    static JLabel player2_img_9 = new JLabel(player2_Icon);
    static JLabel player2_img_10 = new JLabel(player2_Icon);
    static JLabel player2_img_11 = new JLabel(player2_Icon);
    static JLabel player2_img_12 = new JLabel(player2_Icon);

    static JLabel player2_array[] = {player2_img_0, player2_img_1, player2_img_2, player2_img_3, player2_img_4, player2_img_5,
            player2_img_6, player2_img_7, player2_img_8, player2_img_9, player2_img_10, player2_img_11, player2_img_12};

    /*
        TODO : 각 타일 위에 출력할 수 있어야 하는 목록
        플레이어 2명, 포탈 1개, 몬스터 1마리
        1. 타일을 키우고, 플레이어 simple stat을 줄여서, 타일을 키운다.
        2. 타일을 4분할
        3. 상점과 같은 이벤트가 원래 있는 타일은 디폴트 배경 색을 다르게 한다.
     */
    public MainGame_page() {
        ImageIcon img_icon;
        try {
            img_icon = new ImageIcon("src\\main\\java\\GUI\\imgaes\\stage.png");
        }
        catch (Exception e){
            System.out.println(e);
            img_icon = null;
        }
        JButton city_btn_0 = new JButton(img_icon);
        JButton city_btn_1 = new JButton(img_icon);
        JButton city_btn_2 = new JButton(img_icon);
        JButton city_btn_3 = new JButton(img_icon);
        JButton city_btn_4 = new JButton(img_icon);
        JButton city_btn_5 = new JButton(img_icon);
        JButton city_btn_6 = new JButton(img_icon);
        JButton city_btn_7 = new JButton(img_icon);
        JButton city_btn_8 = new JButton(img_icon);
        JButton city_btn_9 = new JButton(img_icon);
        JButton city_btn_10 = new JButton(img_icon);
        JButton city_btn_11 = new JButton(img_icon);
        JButton city_btn_12 = new JButton(img_icon);
        JButton city_array[] = {city_btn_0, city_btn_1, city_btn_2, city_btn_3, city_btn_4, city_btn_5, city_btn_6, city_btn_7, city_btn_8, city_btn_9, city_btn_10, city_btn_11, city_btn_12};
//        JButton city_array[] = new JButton[13];
//        for(int i = 0; i < 13; i++){
//            city_array[i] = new JButton(img_icon);
//        }

        //상단바
        {
            setResizable(false);
            setBounds(100, 100, 1200, 960);
            getContentPane().setLayout(null);

            JPanel tab = new JPanel();
            tab.setBounds(0, 0, 1182, 140);
            getContentPane().add(tab);
            tab.setLayout(null);

            JButton status = new JButton("Status");
            status.setBounds(126, 36, 173, 53);
            tab.add(status);

            status.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    final int FIRST_PLAYER_IDX = 0;
                    MainGamePlayerStatusDetail_page temp = new MainGamePlayerStatusDetail_page(Player.getPlayer(FIRST_PLAYER_IDX));
                    temp.setVisible(true);
                }
            });

            JLabel token = new JLabel("token");
            token.setBounds(692, 36, 160, 45);
            tab.add(token);

            JTextPane token_text = new JTextPane();
            token_text.setBounds(780, 36, 76, 45);
            token_text.setEditable(false);
            token_text.setText(Integer.toString(GameMaster.token));
            tab.add(token_text);

            JLabel turn = new JLabel("Turn");
            turn.setBounds(866, 40, 195, 36);
            tab.add(turn);

            JTextPane turn_text = new JTextPane();
            turn_text.setBounds(938, 36, 123, 45);
            turn_text.setEditable(false);
            turn_text.setText(Integer.toString(GameMaster.turn));
            tab.add(turn_text);

            DialogPanelController dialog_panel_controller = new DialogPanelController();
            JPanel dialog_panel = dialog_panel_controller.dialog_panel;
            dialog_panel.setBounds(599, 165, 569, 430);
            dialog_panel.setLayout(null);
            getContentPane().add(dialog_panel);
        }
        //player2 이미지
        {

            player2_img_0.setBounds(264, 315, 40, 50);
            getContentPane().add(player2_img_0);

            player2_img_1.setBounds(264, 209, 40, 50);
            getContentPane().add(player2_img_1);

            player2_img_2.setBounds(165, 268, 40, 50);
            getContentPane().add(player2_img_2);

            player2_img_3.setBounds(165, 370, 40, 50);
            getContentPane().add(player2_img_3);

            player2_img_4.setBounds(264, 431, 40, 50);
            getContentPane().add(player2_img_4);

            player2_img_5.setBounds(375, 370, 40, 50);
            getContentPane().add(player2_img_5);

            player2_img_6.setBounds(375, 268, 40, 50);
            getContentPane().add(player2_img_6);

            player2_img_7.setBounds(419, 165, 40, 50);
            getContentPane().add(player2_img_7);

            player2_img_8.setBounds(134, 165, 40, 50);
            getContentPane().add(player2_img_8);

            player2_img_9.setBounds(34, 315, 40, 50);
            getContentPane().add(player2_img_9);

            player2_img_10.setBounds(134, 473, 40, 50);
            getContentPane().add(player2_img_10);

            player2_img_11.setBounds(400, 473, 80, 54);
            getContentPane().add(player2_img_11);

            player2_img_12.setBounds(502, 315, 80, 54);
            getContentPane().add(player2_img_12);

        }
        //player1 이미지
        {

            player1_img_0.setBounds(284, 315, 40, 50);
            getContentPane().add(player1_img_0);

            player1_img_1.setBounds(284, 209, 40, 50);
            getContentPane().add(player1_img_1);

            player1_img_2.setBounds(185, 268, 40, 50);
            getContentPane().add(player1_img_2);

            player1_img_3.setBounds(185, 370, 40, 50);
            getContentPane().add(player1_img_3);

            player1_img_4.setBounds(284, 431, 40, 50);
            getContentPane().add(player1_img_4);

            player1_img_5.setBounds(395, 370, 40, 50);
            getContentPane().add(player1_img_5);

            player1_img_6.setBounds(395, 268, 40, 50);
            getContentPane().add(player1_img_6);

            player1_img_7.setBounds(440, 165, 40, 50);
            getContentPane().add(player1_img_7);

            player1_img_8.setBounds(154, 165, 40, 50);
            getContentPane().add(player1_img_8);

            player1_img_9.setBounds(57, 318, 40, 50);
            getContentPane().add(player1_img_9);

            player1_img_10.setBounds(154, 473, 40, 50);
            getContentPane().add(player1_img_10);

            player1_img_11.setBounds(439, 473, 40, 50);
            getContentPane().add(player1_img_11);

            player1_img_12.setBounds(541, 315, 40, 50);
            getContentPane().add(player1_img_12);
            show_players();
        }


        {

            for (JButton button : dot_array) {
                button.setVisible(false);
                button.setFocusPainted(false);
                button.setContentAreaFilled(false);
                button.setBorderPainted(false);
            }
            reddot_0.setBounds(244, 315, 105, 54);
            getContentPane().add(reddot_0);

            reddot_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            reddot_1.setBounds(244, 209, 105, 54);
            getContentPane().add(reddot_1);

            reddot_2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            reddot_2.setBounds(145, 268, 105, 54);
            getContentPane().add(reddot_2);

            reddot_3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            reddot_3.setBounds(145, 370, 105, 54);
            getContentPane().add(reddot_3);


            reddot_4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            reddot_4.setBounds(244, 431, 105, 54);
            getContentPane().add(reddot_4);


            reddot_5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                }
            });
            reddot_5.setBounds(355, 370, 105, 54);
            getContentPane().add(reddot_5);


            reddot_6.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            reddot_6.setBounds(355, 268, 105, 54);
            getContentPane().add(reddot_6);


            reddot_7.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            reddot_7.setBounds(399, 165, 105, 54);
            getContentPane().add(reddot_7);


            reddot_8.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            reddot_8.setBounds(114, 165, 105, 54);
            getContentPane().add(reddot_8);


            reddot_9.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            reddot_9.setBounds(14, 315, 105, 54);
            getContentPane().add(reddot_9);


            reddot_10.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            reddot_10.setBounds(114, 473, 105, 54);
            getContentPane().add(reddot_10);


            reddot_11.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            reddot_11.setBounds(399, 473, 105, 54);
            getContentPane().add(reddot_11);


            reddot_12.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            reddot_12.setBounds(501, 315, 105, 54);
            getContentPane().add(reddot_12);


        }
        // 타일 버튼
        {
            for (JButton button_city : city_array) {
                button_city.setVisible(true);
                button_city.setFocusPainted(false);
                button_city.setContentAreaFilled(false);
                button_city.setBorderPainted(false);
            }

            city_btn_0.setBounds(244, 315, 105, 54);
            getContentPane().add(city_btn_0);


            city_btn_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });

            city_btn_1.setBounds(244, 209, 105, 54);
            getContentPane().add(city_btn_1);


            city_btn_2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });

            city_btn_2.setBounds(145, 268, 105, 54);
            getContentPane().add(city_btn_2);


            city_btn_3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });

            city_btn_3.setBounds(145, 370, 105, 54);
            getContentPane().add(city_btn_3);


            city_btn_4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });

            city_btn_4.setBounds(244, 431, 105, 54);
            getContentPane().add(city_btn_4);


            city_btn_5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                }
            });
            ;
            city_btn_5.setBounds(355, 370, 105, 54);
            getContentPane().add(city_btn_5);

            city_btn_6.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });

            city_btn_6.setBounds(355, 268, 105, 54);
            getContentPane().add(city_btn_6);


            city_btn_7.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });

            city_btn_7.setBounds(399, 165, 105, 54);
            getContentPane().add(city_btn_7);


            city_btn_8.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });

            city_btn_8.setBounds(114, 165, 105, 54);
            getContentPane().add(city_btn_8);


            city_btn_9.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });

            city_btn_9.setBounds(14, 315, 105, 54);
            getContentPane().add(city_btn_9);


            city_btn_10.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });

            city_btn_10.setBounds(114, 473, 105, 54);
            getContentPane().add(city_btn_10);


            city_btn_11.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });

            city_btn_11.setBounds(399, 473, 105, 54);
            getContentPane().add(city_btn_11);


            city_btn_12.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });

            city_btn_12.setBounds(501, 315, 105, 54);
            getContentPane().add(city_btn_12);
        }
        // 플레이어들의 스탯 요약
        {
            JLabel player1_img = new JLabel(new ImageIcon("src\\main\\java\\GUI\\imgaes\\player.png"));
            player1_img.setBounds(650, 620, 240, 163);
            getContentPane().add(player1_img);

            JLabel player1_name = new JLabel(new ImageIcon("src\\main\\java\\GUI\\imgaes\\player1_name.png"));
            player1_name.setBounds(41, 780, 240, 61);
            getContentPane().add(player1_name);


            p_simplestat player1 = new p_simplestat(Player.getPlayer(0));
            JPanel player1_temp = new JPanel();
            player1_temp.setBounds(290, 670, 318, 225);
            getContentPane().add(player1_temp);
            player1_temp.add(player1);

            JLabel player2_img = new JLabel(new ImageIcon("src\\main\\java\\GUI\\imgaes\\player.png"));
            player2_img.setBounds(41, 620, 240, 163);
            getContentPane().add(player2_img);

            JLabel player2_name = new JLabel(new ImageIcon("src\\main\\java\\GUI\\imgaes\\player2_name.png"));
            player2_name.setBounds(650, 780, 240, 61);
            getContentPane().add(player2_name);

            p_simplestat player2 = new p_simplestat(Player.getPlayer(1));
            JPanel player2_temp = new JPanel();
            player2_temp.setBounds(864, 670, 318, 225);
            getContentPane().add(player2_temp);
            player2_temp.add(player2);
        }
    }

    public static void main(String[] args) {
        MainGame_page MainGame = new MainGame_page();
        MainGame.setVisible(true);
    }

    public static void show_reddot() {
        ArrayList<TileType> tiles = Map.getMovableTiles(Player.getCurrentPlayer());
        for (TileType tile : tiles) {
            dot_array[tile.ordinal()].setVisible(true);
            dot_array[tile.ordinal()].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Clicked");
                    Player.getCurrentPlayer().setPos(tile);
                    // 모든 빨간 점을 보이지 않게 만들기
                    for(JButton reddot : dot_array){
                        reddot.setVisible(false);
                    }
                    show_players();
                    DialogPanelController.Clear();
                    DialogPanelController.generateGeneralDialogues();
                }
            });
        }
    }

    public static void show_players() {
        for (JLabel label : player2_array) {
            label.setVisible(false);
        }
        for (JLabel label : player1_array) {
            label.setVisible(false);
        }
        player1_array[Player.getPlayer(0).getPos().ordinal()].setVisible(true);
        player2_array[Player.getPlayer(1).getPos().ordinal()].setVisible(true);
    }

    class p_simplestat extends JPanel {

        p_simplestat(Player player) {
            /*
             * 테스트 코드
             * test temp = new test(); JPanel temp1 = new JPanel();
             * temp1.setBounds(0, 183, 394, 741); getContentPane().add(temp1);
             * temp1.add(temp);
             */

            Dimension simplestat_dimension = new Dimension(40, 30);
            JPanel health_panel = new JPanel();
            JLabel health = new JLabel("체력");
            health.setPreferredSize(simplestat_dimension);
            JTextPane health_text = new JTextPane();
            health_text.setText(Integer.toString(player.getHealth()));
            health_text.setEditable(false);
            health_text.setPreferredSize(simplestat_dimension);


            JPanel mental_panel = new JPanel();
            JLabel mental = new JLabel("정신력");
            mental.setPreferredSize(new Dimension(40, 30));
            JTextPane mental_text = new JTextPane();
            mental_text.setText(Integer.toString(player.getMental()));
            mental_text.setEditable(false);
            mental_text.setPreferredSize(simplestat_dimension);

            JPanel energy_panel = new JPanel();
            JLabel energy = new JLabel("행동치");
            energy.setPreferredSize(new Dimension(40, 30));
            JTextPane energy_text = new JTextPane();
            energy_text.setText(Integer.toString(player.getEnergy()));
            energy_text.setEditable(false);
            energy_text.setPreferredSize(simplestat_dimension);

            JPanel money_panel = new JPanel();
            JLabel money = new JLabel("money");
            money.setPreferredSize(new Dimension(40, 30));
            JTextPane money_text = new JTextPane();
            money_text.setText(Integer.toString(player.getMoney()));
            money_text.setEditable(false);
            money_text.setPreferredSize(simplestat_dimension);

            Player.toggleCurrentPlayer();

            health_panel.add(health);
            health_panel.add(health_text);
            add(health_panel);

            mental_panel.add(mental);
            mental_panel.add(mental_text);
            add(mental_panel);

            energy_panel.add(energy);
            energy_panel.add(energy_text);
            add(energy_panel);

            money_panel.add(money);
            money_panel.add(money_text);
            add(money_panel);

            setLayout(new GridLayout(4, 2, 20, 0));
        }
    }
}
