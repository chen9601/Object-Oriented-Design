package GUI;

import com.DialogPanelController;
import com.GameMaster;
import com.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/**
 * Dialog 창, map. 플레이어들의 간략화 된 스탯 및 token을 보여주는 클래스이다.
 */
public class MainGame_page extends JFrame {
    // TODO : 모든 경로를 아래와 같이 역슬래시 두개로 구분하는 방식으로 변경할 것!
    Image img = new ImageIcon("src\\main\\java\\GUI\\imgaes\\backgroundImage.jpg").getImage();
    /*
        TODO : 각 타일 위에 출력할 수 있어야 하는 목록
        플레이어 2명, 포탈 1개, 몬스터 1마리
        1. 타일을 키우고, 플레이어 simple stat을 줄여서, 타일을 키운다.
        2. 타일을 4분할
        3. 상점과 같은 이벤트가 원래 있는 타일은 디폴트 배경 색을 다르게 한다.
     */
    public MainGame_page() {
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
        JPanel dialog_panel = dialog_panel_controller.getDialog_panel();
        dialog_panel.setBounds(599, 165, 569, 430);
        dialog_panel.setLayout(null);
        getContentPane().add(dialog_panel);
        {

            JButton rdedot_0 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\reddot.png"));
            rdedot_0.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("test");
                }
            });
            rdedot_0.setFocusPainted(false);
            rdedot_0.setContentAreaFilled(false);
            rdedot_0.setBorderPainted(false);
            rdedot_0.setBounds(244, 315, 105, 54);
            getContentPane().add(rdedot_0);

            JButton reddot_1 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\reddot.png"));
            reddot_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            reddot_1.setFocusPainted(false);
            reddot_1.setContentAreaFilled(false);
            reddot_1.setBorderPainted(false);
            reddot_1.setBounds(244, 209, 105, 54);
            getContentPane().add(reddot_1);

            JButton reddot_2 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\reddot.png"));
            reddot_2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            reddot_2.setFocusPainted(false);
            reddot_2.setContentAreaFilled(false);
            reddot_2.setBorderPainted(false);
            reddot_2.setBounds(145, 268, 105, 54);
            getContentPane().add(reddot_2);

            JButton reddot_3 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\reddot.png"));
            reddot_3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            reddot_3.setFocusPainted(false);
            reddot_3.setContentAreaFilled(false);
            reddot_3.setBorderPainted(false);
            reddot_3.setBounds(145, 370, 105, 54);
            getContentPane().add(reddot_3);


            JButton reddot_4 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\reddot.png"));
            reddot_4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            reddot_4.setFocusPainted(false);
            reddot_4.setContentAreaFilled(false);
            reddot_4.setBorderPainted(false);
            reddot_4.setBounds(244, 431, 105, 54);
            getContentPane().add(reddot_4);

            JButton reddot_5 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\reddot.png"));
            reddot_5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                }
            });
            reddot_5.setFocusPainted(false);
            reddot_5.setContentAreaFilled(false);
            reddot_5.setBorderPainted(false);
            reddot_5.setBounds(355, 370, 105, 54);
            getContentPane().add(reddot_5);

            JButton reddot_6 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\reddot.png"));
            reddot_6.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            reddot_6.setFocusPainted(false);
            reddot_6.setContentAreaFilled(false);
            reddot_6.setBorderPainted(false);
            reddot_6.setBounds(355, 268, 105, 54);
            getContentPane().add(reddot_6);

            JButton reddot_7 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\reddot.png"));
            reddot_7.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            reddot_7.setFocusPainted(false);
            reddot_7.setContentAreaFilled(false);
            reddot_7.setBorderPainted(false);
            reddot_7.setBounds(399, 165, 105, 54);
            getContentPane().add(reddot_7);


            JButton reddot_8 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\reddot.png"));
            reddot_8.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            reddot_8.setFocusPainted(false);
            reddot_8.setContentAreaFilled(false);
            reddot_8.setBorderPainted(false);
            reddot_8.setBounds(114, 165, 105, 54);
            getContentPane().add(reddot_8);


            JButton reddot_9 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\reddot.png"));
            reddot_9.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            reddot_9.setFocusPainted(false);
            reddot_9.setContentAreaFilled(false);
            reddot_9.setBorderPainted(false);
            reddot_9.setBounds(14, 315, 105, 54);
            getContentPane().add(reddot_9);


            JButton reddot_10 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\reddot.png"));
            reddot_10.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            reddot_10.setFocusPainted(false);
            reddot_10.setContentAreaFilled(false);
            reddot_10.setBorderPainted(false);
            reddot_10.setBounds(114, 473, 105, 54);
            getContentPane().add(reddot_10);

            JButton reddot_11 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\reddot.png"));
            reddot_11.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            reddot_11.setFocusPainted(false);
            reddot_11.setContentAreaFilled(false);
            reddot_11.setBorderPainted(false);
            reddot_11.setBounds(399, 473, 105, 54);
            getContentPane().add(reddot_11);

            JButton reddot_12 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\reddot.png"));
            reddot_12.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            reddot_12.setFocusPainted(false);
            reddot_12.setContentAreaFilled(false);
            reddot_12.setBorderPainted(false);
            reddot_12.setBounds(501, 315, 105, 54);
            getContentPane().add(reddot_12);
        }
        {

            JButton city_btn_0 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\stage.png"));
            city_btn_0.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("test");
                }
            });
            city_btn_0.setFocusPainted(false);
            city_btn_0.setContentAreaFilled(false);
            city_btn_0.setBorderPainted(false);
            city_btn_0.setBounds(244, 315, 105, 54);
            getContentPane().add(city_btn_0);

            JButton city_btn_1 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\stage.png"));
            city_btn_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            city_btn_1.setFocusPainted(false);
            city_btn_1.setContentAreaFilled(false);
            city_btn_1.setBorderPainted(false);
            city_btn_1.setBounds(244, 209, 105, 54);
            getContentPane().add(city_btn_1);

            JButton city_btn_2 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\stage.png"));
            city_btn_2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            city_btn_2.setFocusPainted(false);
            city_btn_2.setContentAreaFilled(false);
            city_btn_2.setBorderPainted(false);
            city_btn_2.setBounds(145, 268, 105, 54);
            getContentPane().add(city_btn_2);

            JButton city_btn_3 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\stage.png"));
            city_btn_3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            city_btn_3.setFocusPainted(false);
            city_btn_3.setContentAreaFilled(false);
            city_btn_3.setBorderPainted(false);
            city_btn_3.setBounds(145, 370, 105, 54);
            getContentPane().add(city_btn_3);


            JButton city_btn_4 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\stage.png"));
            city_btn_4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            city_btn_4.setFocusPainted(false);
            city_btn_4.setContentAreaFilled(false);
            city_btn_4.setBorderPainted(false);
            city_btn_4.setBounds(244, 431, 105, 54);
            getContentPane().add(city_btn_4);

            JButton city_btn_5 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\stage.png"));
            city_btn_5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                }
            });
            city_btn_5.setFocusPainted(false);
            city_btn_5.setContentAreaFilled(false);
            city_btn_5.setBorderPainted(false);
            city_btn_5.setBounds(355, 370, 105, 54);
            getContentPane().add(city_btn_5);

            JButton city_btn_6 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\stage.png"));
            city_btn_6.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            city_btn_6.setFocusPainted(false);
            city_btn_6.setContentAreaFilled(false);
            city_btn_6.setBorderPainted(false);
            city_btn_6.setBounds(355, 268, 105, 54);
            getContentPane().add(city_btn_6);

            JButton city_btn_7 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\stage.png"));
            city_btn_7.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            city_btn_7.setFocusPainted(false);
            city_btn_7.setContentAreaFilled(false);
            city_btn_7.setBorderPainted(false);
            city_btn_7.setBounds(399, 165, 105, 54);
            getContentPane().add(city_btn_7);


            JButton city_btn_8 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\stage.png"));
            city_btn_8.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            city_btn_8.setFocusPainted(false);
            city_btn_8.setContentAreaFilled(false);
            city_btn_8.setBorderPainted(false);
            city_btn_8.setBounds(114, 165, 105, 54);
            getContentPane().add(city_btn_8);


            JButton city_btn_9 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\stage.png"));
            city_btn_9.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            city_btn_9.setFocusPainted(false);
            city_btn_9.setContentAreaFilled(false);
            city_btn_9.setBorderPainted(false);
            city_btn_9.setBounds(14, 315, 105, 54);
            getContentPane().add(city_btn_9);


            JButton city_btn_10 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\stage.png"));
            city_btn_10.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            city_btn_10.setFocusPainted(false);
            city_btn_10.setContentAreaFilled(false);
            city_btn_10.setBorderPainted(false);
            city_btn_10.setBounds(114, 473, 105, 54);
            getContentPane().add(city_btn_10);

            JButton city_btn_11 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\stage.png"));
            city_btn_11.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            city_btn_11.setFocusPainted(false);
            city_btn_11.setContentAreaFilled(false);
            city_btn_11.setBorderPainted(false);
            city_btn_11.setBounds(399, 473, 105, 54);
            getContentPane().add(city_btn_11);

            JButton city_btn_12 = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\stage.png"));
            city_btn_12.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            city_btn_12.setFocusPainted(false);
            city_btn_12.setContentAreaFilled(false);
            city_btn_12.setBorderPainted(false);
            city_btn_12.setBounds(501, 315, 105, 54);
            getContentPane().add(city_btn_12);
        }

		JLabel player1_img = new JLabel(new ImageIcon("src\\main\\java\\GUI\\imgaes\\player.png"));
		player1_img.setBounds(650, 620, 240, 163);
		getContentPane().add(player1_img);

		JLabel player1_name = new JLabel(new ImageIcon("src\\main\\java\\GUI\\imgaes\\player_name.png"));
		player1_name.setBounds(650, 780, 240, 61);
		getContentPane().add(player1_name);

        p_simplestat player1 = new p_simplestat();
        JPanel player1_temp = new JPanel();
        player1_temp.setBounds(290, 670, 318, 225);
        getContentPane().add(player1_temp);
        player1_temp.add(player1);

		JLabel player2_img = new JLabel(new ImageIcon("src\\main\\java\\GUI\\imgaes\\player.png"));
		player2_img.setBounds(41, 620, 240, 163);
		getContentPane().add(player2_img);

		JLabel player2_name = new JLabel(new ImageIcon("src\\main\\java\\GUI\\imgaes\\player_name.png"));
		player2_name.setBounds(41, 780, 240, 61);
		getContentPane().add(player2_name);

        p_simplestat player2 = new p_simplestat();
        JPanel player2_temp = new JPanel();
        player2_temp.setBounds(864, 670, 318, 225);
        getContentPane().add(player2_temp);
        player2_temp.add(player2);

    }

    public static void main(String[] args) {
        MainGame_page MainGame = new MainGame_page();
        MainGame.setVisible(true);
    }

    class p_simplestat extends JPanel {

        p_simplestat() {
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
            health_text.setText(Integer.toString(Player.getCurrentPlayer().getHealth()));
            health_text.setEditable(false);
            health_text.setPreferredSize(simplestat_dimension);


            JPanel mental_panel = new JPanel();
            JLabel mental = new JLabel("정신력");
            mental.setPreferredSize(new Dimension(40, 30));
            JTextPane mental_text = new JTextPane();
            mental_text.setText(Integer.toString(Player.getCurrentPlayer().getMental()));
            mental_text.setEditable(false);
            mental_text.setPreferredSize(simplestat_dimension);

            JPanel energy_panel = new JPanel();
            JLabel energy = new JLabel("행동치");
            energy.setPreferredSize(new Dimension(40, 30));
            JTextPane energy_text = new JTextPane();
            energy_text.setText(Integer.toString(Player.getCurrentPlayer().getEnergy()));
            energy_text.setEditable(false);
            energy_text.setPreferredSize(simplestat_dimension);

            JPanel money_panel = new JPanel();
            JLabel money = new JLabel("money");
            money.setPreferredSize(new Dimension(40, 30));
            JTextPane money_text = new JTextPane();
            money_text.setText(Integer.toString(Player.getCurrentPlayer().getMoney()));
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
