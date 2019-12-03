package GUI;

import com.*;
import lombok.Data;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/**
 * Dialog 창, map. 플레이어들의 간략화 된 스탯 및 token을 보여주는 클래스이다.
 */

@Data
public class MainGame_page extends JFrame {


    // TODO : 모든 경로를 아래와 같이 역슬래시 두개로 구분하는 방식으로 변경할 것!
    Image img = new ImageIcon("src\\main\\java\\GUI\\imgaes\\backgroundImage.jpg").getImage();
    //몬스터랑 포탈 출력가능하게 만들기
    MainGameTabPanel tab;
    ImageIcon city_img_icon = new ImageIcon("src\\main\\java\\GUI\\imgaes\\stage.png");
    JButton city_btn_array[];
    ImageIcon reddot_img_icon = new ImageIcon("src\\main\\java\\GUI\\imgaes\\reddot.png");
    JButton btn_reddot_array[];
    ImageIcon player1_Icon = new ImageIcon("src\\main\\java\\GUI\\imgaes\\player1_img.png");
    JLabel lb_player1_array[];
    ImageIcon player2_Icon = new ImageIcon("src\\main\\java\\GUI\\imgaes\\player2_img.png");
    JLabel lb_player2_array[];

    JLabel lb_player1;
    JLabel player1_name;
    PlayerStatusPanel player1_status_panel;
    JLabel lb_player2_img;
    JLabel lb_player2_name;
    PlayerStatusPanel player2_status_panel;


    ImageIcon portal_img = new ImageIcon("src\\main\\java\\GUI\\imgaes\\portal.png");
    JLabel portal_img_0 = new JLabel(portal_img);
    JLabel portal_img_1 = new JLabel(portal_img);
    JLabel portal_img_2 = new JLabel(portal_img);
    JLabel portal_img_3 = new JLabel(portal_img);
    JLabel portal_img_4 = new JLabel(portal_img);
    JLabel portal_img_5 = new JLabel(portal_img);
    JLabel portal_img_6 = new JLabel(portal_img);
    JLabel portal_img_7 = new JLabel(portal_img);
    JLabel portal_img_8 = new JLabel(portal_img);
    JLabel portal_img_9 = new JLabel(portal_img);
    JLabel portal_img_10 = new JLabel(portal_img);
    JLabel portal_img_11 = new JLabel(portal_img);
    JLabel portal_img_12 = new JLabel(portal_img);
    JLabel portal_array[] = {portal_img_0, portal_img_1, portal_img_2, portal_img_3, portal_img_4, portal_img_5,
            portal_img_6, portal_img_7, portal_img_8, portal_img_9, portal_img_10, portal_img_11, portal_img_12};

    JLabel monster_img_0 = new JLabel(new ImageIcon(get_monster_img_path()));
    JLabel monster_img_1 = new JLabel(new ImageIcon(get_monster_img_path()));
    JLabel monster_img_2 = new JLabel(new ImageIcon(get_monster_img_path()));
    JLabel monster_img_3 = new JLabel(new ImageIcon(get_monster_img_path()));
    JLabel monster_img_4 = new JLabel(new ImageIcon(get_monster_img_path()));
    JLabel monster_img_5 = new JLabel(new ImageIcon(get_monster_img_path()));
    JLabel monster_img_6 = new JLabel(new ImageIcon(get_monster_img_path()));
    JLabel monster_img_7 = new JLabel(new ImageIcon(get_monster_img_path()));
    JLabel monster_img_8 = new JLabel(new ImageIcon(get_monster_img_path()));
    JLabel monster_img_9 = new JLabel(new ImageIcon(get_monster_img_path()));
    JLabel monster_img_10 = new JLabel(new ImageIcon(get_monster_img_path()));
    JLabel monster_img_11 = new JLabel(new ImageIcon(get_monster_img_path()));
    JLabel monster_img_12 = new JLabel(new ImageIcon(get_monster_img_path()));

    JLabel monster_array[] = {monster_img_0, monster_img_1, monster_img_2, monster_img_3, monster_img_4, monster_img_5,
            monster_img_6, monster_img_7, monster_img_8, monster_img_9, monster_img_10, monster_img_11, monster_img_12};


    @Data
    public class MainGameTabPanel extends JPanel {
        JButton status = new JButton("Status");
        JLabel token = new JLabel("token");
        JTextPane token_text = new JTextPane();
        JLabel turn = new JLabel("Turn");
        JTextPane turn_text = new JTextPane();

        MainGameTabPanel() {
            status.setBounds(126, 36, 173, 53);
            status.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    final int FIRST_PLAYER_IDX = 0;
                    FightMonsterController temp = new FightMonsterController(MonsterType.Nightgaunt);
//                    temp.normalFight(Player.getCurrentPlayer(), temp.fight_monster_page.getMonster());

                    // 파이트 테스트를 위해 잠깐 꺼둠
//                    MainGamePlayerStatusDetail_page temp = new MainGamePlayerStatusDetail_page(Player.getPlayer(FIRST_PLAYER_IDX));

                }
            });

            token.setBounds(692, 36, 160, 45);

            token_text.setBounds(780, 36, 76, 45);
            token_text.setEditable(false);
            token_text.setText(Integer.toString(GameMaster.token));

            turn.setBounds(866, 40, 195, 36);

            turn_text.setBounds(938, 36, 123, 45);
            turn_text.setEditable(false);
            turn_text.setText(Integer.toString(GameMaster.turn));

            this.add(status);
            this.add(token);
            this.add(token_text);
            this.add(turn);
            this.add(turn_text);
        }

    }

    @Data
    public class PlayerStatusPanel extends JPanel {
        @Data
        public class Status_Components extends JPanel {
            JLabel lb_attribute_name;
            JTextPane attribute_textpane;

            Status_Components(Player player, Dimension player_status_dimension, String attribute_name) {
                lb_attribute_name = new JLabel(attribute_name);
                lb_attribute_name.setPreferredSize(player_status_dimension);
                attribute_textpane = new JTextPane();
                String text_data = null;
                // TODO : 플레이어의 status를 StatusType으로 재정의 및 리팩토링 하는게 맞는걸까?
                switch (attribute_name) {
                    case "체력":
                        text_data = Integer.toString(player.getHealth());
                        break;
                    case "힘":
                        text_data = Integer.toString(player.getPower());
                        break;
                    case "정신력":
                        text_data = Integer.toString(player.getMental());
                        break;
                    case "행동치":
                        text_data = Integer.toString(player.getEnergy());
                        break;
                }
                attribute_textpane.setText(text_data);
                attribute_textpane.setEditable(false);
                attribute_textpane.setPreferredSize(player_status_dimension);

                this.add(lb_attribute_name);
                this.add(attribute_textpane);
            }
        }

        Status_Components[] status_details;

        PlayerStatusPanel(Player player) {
            Dimension player_status_dimension = new Dimension(40, 30);
            status_details = new Status_Components[4];
            for (StatusType status_type : StatusType.values()) {
                status_details[status_type.ordinal()] = new Status_Components(player, player_status_dimension, status_type.getName());
                this.add(status_details[status_type.ordinal()]);
            }
            setLayout(new GridLayout(4, 2, 20, 0));
        }
    }

    public MainGame_page() {



        // 상단바
        {
            setResizable(false);
            setBounds(100, 100, 1200, 960);
            getContentPane().setLayout(null);

            tab = new MainGameTabPanel();
            tab.setBounds(0, 0, 1182, 140);
            tab.setLayout(null);
            getContentPane().add(tab);

            DialogPanelController dialog_panel_controller = new DialogPanelController();
            JPanel dialog_panel = dialog_panel_controller.dialog_panel;
            dialog_panel.setBounds(599, 165, 569, 430);
            dialog_panel.setLayout(null);
            getContentPane().add(dialog_panel);

        }
        // red dot 버튼
        {
            btn_reddot_array = new JButton[13];
            for (int i = 0; i < 13; i++) {
                btn_reddot_array[i] = new JButton(reddot_img_icon);
                btn_reddot_array[i].setVisible(false);
                btn_reddot_array[i].setFocusPainted(false);
                btn_reddot_array[i].setContentAreaFilled(false);
                btn_reddot_array[i].setBorderPainted(false);
                getContentPane().add(btn_reddot_array[i]);
            }
            btn_reddot_array[0].setBounds(244, 315, 105, 54);
            btn_reddot_array[1].setBounds(244, 209, 105, 54);
            btn_reddot_array[2].setBounds(145, 268, 105, 54);
            btn_reddot_array[3].setBounds(145, 370, 105, 54);
            btn_reddot_array[4].setBounds(244, 431, 105, 54);
            btn_reddot_array[5].setBounds(355, 370, 105, 54);
            btn_reddot_array[6].setBounds(355, 268, 105, 54);
            btn_reddot_array[7].setBounds(399, 165, 105, 54);
            btn_reddot_array[8].setBounds(114, 165, 105, 54);
            btn_reddot_array[9].setBounds(14, 315, 105, 54);
            btn_reddot_array[10].setBounds(114, 473, 105, 54);
            btn_reddot_array[11].setBounds(399, 473, 105, 54);
            btn_reddot_array[12].setBounds(501, 315, 105, 54);
        }

        // 몬스터 이미지
        {
            for (JLabel monster_img : monster_array) {
                monster_img.setVisible(false);
            }
            monster_img_0.setBounds(264, 315, 40, 50);
            getContentPane().add(monster_img_0);

            monster_img_1.setBounds(264, 209, 40, 50);
            getContentPane().add(monster_img_1);

            monster_img_2.setBounds(165, 268, 40, 50);
            getContentPane().add(monster_img_2);

            monster_img_3.setBounds(165, 370, 40, 50);
            getContentPane().add(monster_img_3);

            monster_img_4.setBounds(264, 431, 40, 50);
            getContentPane().add(monster_img_4);

            monster_img_5.setBounds(375, 370, 40, 50);
            getContentPane().add(monster_img_5);

            monster_img_6.setBounds(375, 268, 40, 50);
            getContentPane().add(monster_img_6);

            monster_img_7.setBounds(419, 165, 40, 50);
            getContentPane().add(monster_img_7);

            monster_img_8.setBounds(134, 165, 40, 50);
            getContentPane().add(monster_img_8);

            monster_img_9.setBounds(34, 315, 40, 50);
            getContentPane().add(monster_img_9);

            monster_img_10.setBounds(134, 473, 40, 50);
            getContentPane().add(monster_img_10);

            monster_img_11.setBounds(400, 473, 80, 54);
            getContentPane().add(monster_img_11);

            monster_img_12.setBounds(502, 315, 80, 54);
            getContentPane().add(monster_img_12);
        }
        // 포탈 이미지
        {
            for (JLabel portal_img : portal_array) {
                portal_img.setVisible(false);
            }

            portal_img_0.setBounds(284, 315, 40, 50);
            getContentPane().add(portal_img_0);
            portal_img_1.setBounds(284, 209, 40, 50);
            getContentPane().add(portal_img_1);
            portal_img_2.setBounds(185, 268, 40, 50);
            getContentPane().add(portal_img_2);
            portal_img_3.setBounds(185, 370, 40, 50);
            getContentPane().add(portal_img_3);
            portal_img_4.setBounds(284, 431, 40, 50);
            getContentPane().add(portal_img_4);
            portal_img_5.setBounds(395, 370, 40, 50);
            getContentPane().add(portal_img_5);
            portal_img_6.setBounds(395, 268, 40, 50);
            getContentPane().add(portal_img_6);
            portal_img_7.setBounds(440, 165, 40, 50);
            getContentPane().add(portal_img_7);
            portal_img_8.setBounds(154, 165, 40, 50);
            getContentPane().add(portal_img_8);
            portal_img_9.setBounds(57, 318, 40, 50);
            getContentPane().add(portal_img_9);
            portal_img_10.setBounds(154, 473, 40, 50);
            getContentPane().add(portal_img_10);
            portal_img_11.setBounds(439, 473, 40, 50);
            getContentPane().add(portal_img_11);
            portal_img_12.setBounds(541, 315, 40, 50);
            getContentPane().add(portal_img_12);
        }
        // player1 이미지
        {
            lb_player1_array = new JLabel[13];
            for (int i = 0; i < 13; i++) {
                lb_player1_array[i] = new JLabel(player1_Icon);
                getContentPane().add(lb_player1_array[i]);
            }
            lb_player1_array[0].setBounds(284, 315, 40, 50);
            lb_player1_array[1].setBounds(284, 209, 40, 50);
            lb_player1_array[2].setBounds(185, 268, 40, 50);
            lb_player1_array[3].setBounds(185, 370, 40, 50);
            lb_player1_array[4].setBounds(284, 431, 40, 50);
            lb_player1_array[5].setBounds(395, 370, 40, 50);
            lb_player1_array[6].setBounds(395, 268, 40, 50);
            lb_player1_array[7].setBounds(440, 165, 40, 50);
            lb_player1_array[8].setBounds(154, 165, 40, 50);
            lb_player1_array[9].setBounds(57, 318, 40, 50);
            lb_player1_array[10].setBounds(154, 473, 40, 50);
            lb_player1_array[11].setBounds(439, 473, 40, 50);
            lb_player1_array[12].setBounds(541, 315, 40, 50);
        }
        // player2 이미지
        {
            lb_player2_array = new JLabel[13];
            for (int i = 0; i < 13; i++) {
                lb_player2_array[i] = new JLabel(player2_Icon);
                getContentPane().add(lb_player2_array[i]);
            }
            lb_player2_array[0].setBounds(264, 315, 40, 50);
            lb_player2_array[1].setBounds(264, 209, 40, 50);
            lb_player2_array[2].setBounds(165, 268, 40, 50);
            lb_player2_array[3].setBounds(165, 370, 40, 50);
            lb_player2_array[4].setBounds(264, 431, 40, 50);
            lb_player2_array[5].setBounds(375, 370, 40, 50);
            lb_player2_array[6].setBounds(375, 268, 40, 50);
            lb_player2_array[7].setBounds(419, 165, 40, 50);
            lb_player2_array[8].setBounds(134, 165, 40, 50);
            lb_player2_array[9].setBounds(34, 315, 40, 50);
            lb_player2_array[10].setBounds(134, 473, 40, 50);
            lb_player2_array[11].setBounds(400, 473, 80, 54);
            lb_player2_array[12].setBounds(502, 315, 80, 54);
        }
        // 타일 버튼
        {
            city_btn_array = new JButton[13];
            for (int i = 0; i < 13; i++) {
                city_btn_array[i] = new JButton(city_img_icon);
                city_btn_array[i].setVisible(true);
                city_btn_array[i].setFocusPainted(false);
                city_btn_array[i].setContentAreaFilled(false);
                city_btn_array[i].setBorderPainted(false);
                getContentPane().add(city_btn_array[i]);
            }
            city_btn_array[0].setBounds(244, 315, 105, 54);
            city_btn_array[1].setBounds(244, 209, 105, 54);
            city_btn_array[2].setBounds(145, 268, 105, 54);
            city_btn_array[3].setBounds(145, 370, 105, 54);
            city_btn_array[4].setBounds(244, 431, 105, 54);
            city_btn_array[5].setBounds(355, 370, 105, 54);
            city_btn_array[6].setBounds(355, 268, 105, 54);
            city_btn_array[7].setBounds(399, 165, 105, 54);
            city_btn_array[8].setBounds(114, 165, 105, 54);
            city_btn_array[9].setBounds(14, 315, 105, 54);
            city_btn_array[10].setBounds(114, 473, 105, 54);
            city_btn_array[11].setBounds(399, 473, 105, 54);
            city_btn_array[12].setBounds(501, 315, 105, 54);
        }
        // 플레이어들의 스탯 요약
        {
            ImageIcon player1_img = new ImageIcon("src\\main\\java\\GUI\\imgaes\\player2-portrait.png");
            lb_player1 = new JLabel(player1_img);
            lb_player1.setBounds(650, 620, 240, 163);
            getContentPane().add(lb_player1);

            ImageIcon player1_name_img = new ImageIcon("src\\main\\java\\GUI\\imgaes\\player1_name.png");
            player1_name = new JLabel(player1_name_img);
            player1_name.setBounds(41, 780, 240, 61);
            getContentPane().add(player1_name);

            player1_status_panel = new PlayerStatusPanel(Player.getPlayer(0));
            player1_status_panel.setBounds(290, 670, 318, 225);
            getContentPane().add(player1_status_panel);

            lb_player2_img = new JLabel(new ImageIcon("src\\main\\java\\GUI\\imgaes\\player1-portrait.png"));
            lb_player2_img.setBounds(41, 620, 240, 163);
            getContentPane().add(lb_player2_img);

            lb_player2_name = new JLabel(new ImageIcon("src\\main\\java\\GUI\\imgaes\\player2_name.png"));
            lb_player2_name.setBounds(650, 780, 240, 61);
            getContentPane().add(lb_player2_name);

            player2_status_panel = new PlayerStatusPanel(Player.getPlayer(1));
            player2_status_panel.setBounds(864, 670, 318, 225);
            getContentPane().add(player2_status_panel);
        }


    }

    public void show_portals() {
        for (JLabel portal : portal_array) {
            portal.setVisible(true);
        }
    }

    //test코드용 메소드임
    public String get_monster_img_path() {
        double randomValue = Math.random();
        int intValue = (int) (randomValue * 5) + 1;

        if (intValue == 1) {
            return "src\\main\\java\\GUI\\imgaes\\monster\\BYAKEE2.png";
        } else if (intValue == 2) {
            return "src\\main\\java\\GUI\\imgaes\\monster\\dagon2.png";
        } else if (intValue == 3) {
            return "src\\main\\java\\GUI\\imgaes\\monster\\elder_thing.png";
        } else if (intValue == 4) {
            return "src\\main\\java\\GUI\\imgaes\\monster\\ghoul2.png";
        } else
            return "src\\main\\java\\GUI\\imgaes\\monster\\nightgaunt2.png";
    }
}
