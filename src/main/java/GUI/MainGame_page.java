package GUI;

import com.*;
import lombok.Data;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;


/**
 * Dialog 창, map. 플레이어들의 간략화 된 스탯 및 token을 보여주는 클래스이다.
 */

@Data
public class MainGame_page extends JFrame {

    // TODO : 모든 경로를 아래와 같이 역슬래시 두개로 구분하는 방식으로 변경할 것!
    Image img = new ImageIcon("src\\main\\java\\GUI\\imgaes\\backgroundImage.jpg").getImage();
    //몬스터랑 포탈 출력가능하게 만들기
    ImageIcon city_img_icon = new ImageIcon("src\\main\\java\\GUI\\imgaes\\stage.png");
    JButton city_btn_array[];
    ImageIcon reddot_img_icon = new ImageIcon("src\\main\\java\\GUI\\imgaes\\reddot.png");
    JButton btn_reddot_array[];
    ImageIcon player1_Icon = new ImageIcon("src\\main\\java\\GUI\\imgaes\\player1_img.png");
    JLabel lb_player1_array[];
    ImageIcon player2_Icon = new ImageIcon("src\\main\\java\\GUI\\imgaes\\player2_img.png");
    JLabel lb_player2_array[];

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
                    MainGamePlayerStatusDetail_page temp = new MainGamePlayerStatusDetail_page(Player.getPlayer(FIRST_PLAYER_IDX));
                    temp.setVisible(true);
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

    public MainGame_page() {
        //상단바
        {
            setResizable(false);
            setBounds(100, 100, 1200, 960);
            getContentPane().setLayout(null);

            MainGameTabPanel tab = new MainGameTabPanel();
            tab.setBounds(0, 0, 1182, 140);
            tab.setLayout(null);
            getContentPane().add(tab);

            DialogPanelController dialog_panel_controller = new DialogPanelController();
            JPanel dialog_panel = dialog_panel_controller.dialog_panel;
            dialog_panel.setBounds(599, 165, 569, 430);
            dialog_panel.setLayout(null);
            getContentPane().add(dialog_panel);
        }
        // reddot 버튼
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
        //player1 이미지
        {
            lb_player1_array = new JLabel[13];
            for(int i = 0; i < 13; i++){
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
        //player2 이미지
        {
            lb_player2_array = new JLabel[13];
            for(int i = 0; i < 13; i++){
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
            JLabel lb_player1_array = new JLabel(new ImageIcon("src\\main\\java\\GUI\\imgaes\\player.png"));
            lb_player1_array.setBounds(650, 620, 240, 163);
            getContentPane().add(lb_player1_array);

            JLabel player1_name = new JLabel(new ImageIcon("src\\main\\java\\GUI\\imgaes\\player1_name.png"));
            player1_name.setBounds(41, 780, 240, 61);
            getContentPane().add(player1_name);


            p_simplestat player1 = new p_simplestat(Player.getPlayer(0));
            JPanel player1_temp = new JPanel();
            player1_temp.setBounds(290, 670, 318, 225);
            getContentPane().add(player1_temp);
            player1_temp.add(player1);

            JLabel lb_player2_array = new JLabel(new ImageIcon("src\\main\\java\\GUI\\imgaes\\player.png"));
            lb_player2_array.setBounds(41, 620, 240, 163);
            getContentPane().add(lb_player2_array);

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
