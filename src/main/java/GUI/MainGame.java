package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;


/**
 * Dialog 창, map. 플레이어들의 간략화 된 스탯 및 token을 보여주는 클래스이다.
 */
public class MainGame extends JFrame {
    Image img = new ImageIcon("C:/Users/182899/eclipse-workspace/OrientedPG/src/images/backgroundImage.jpg").getImage();



    public MainGame() {
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
                MainGame_setstatus temp = new MainGame_setstatus();
                dispose();
                temp.setVisible(true);
            }
        });

        JLabel token = new JLabel("token");
        token.setBounds(692, 36, 160, 45);
        tab.add(token);

        JLabel turn = new JLabel("Turn");
        turn.setBounds(866, 40, 195, 36);
        tab.add(turn);

        JTextPane textPane_8 = new JTextPane();
        textPane_8.setBounds(780, 36, 76, 45);
        tab.add(textPane_8);

        JTextPane textPane_9 = new JTextPane();
        textPane_9.setBounds(938, 36, 123, 45);
        tab.add(textPane_9);


        JButton button_1 = new JButton(new ImageIcon("C:/Users/182899/eclipse-workspace/ORG/src/imgaes/stage.png"));
        button_1.setBorderPainted(false);
        button_1.setFocusPainted(false);
        button_1.setContentAreaFilled(false);
        button_1.setBounds(355, 209, 105, 54);
        getContentPane().add(button_1);


        JPanel Dialog = new JPanel();
        Dialog.setBounds(599, 165, 569, 430);
        getContentPane().add(Dialog);
        Dialog.setLayout(null);


        JButton city_btn_0 = new JButton(new ImageIcon("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\stage.png"));
        city_btn_0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        city_btn_0.setFocusPainted(false);
        city_btn_0.setContentAreaFilled(false);
        city_btn_0.setBorderPainted(false);
        city_btn_0.setBounds(244, 315, 105, 54);
        getContentPane().add(city_btn_0);

		JButton city_btn_1 = new JButton(new ImageIcon("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\stage.png"));
		city_btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		city_btn_1.setFocusPainted(false);
		city_btn_1.setContentAreaFilled(false);
		city_btn_1.setBorderPainted(false);
		city_btn_1.setBounds(244, 209, 105, 54);
		getContentPane().add(city_btn_1);

		JButton city_btn_2 = new JButton(new ImageIcon("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\stage.png"));
		city_btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		city_btn_2.setFocusPainted(false);
		city_btn_2.setContentAreaFilled(false);
		city_btn_2.setBorderPainted(false);
		city_btn_2.setBounds(145, 268, 105, 54);
		getContentPane().add(city_btn_2);

		JButton city_btn_3 = new JButton(new ImageIcon("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\stage.png"));
		city_btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		city_btn_3.setFocusPainted(false);
		city_btn_3.setContentAreaFilled(false);
		city_btn_3.setBorderPainted(false);
		city_btn_3.setBounds(145, 370, 105, 54);
		getContentPane().add(city_btn_3);


		JButton city_btn_4 = new JButton(new ImageIcon("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\stage.png"));
		city_btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		city_btn_4.setFocusPainted(false);
		city_btn_4.setContentAreaFilled(false);
		city_btn_4.setBorderPainted(false);
		city_btn_4.setBounds(244, 431, 105, 54);
		getContentPane().add(city_btn_4);

		JButton city_btn_5 = new JButton(new ImageIcon("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\stage.png"));
		city_btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		city_btn_5.setFocusPainted(false);
		city_btn_5.setContentAreaFilled(false);
		city_btn_5.setBorderPainted(false);
		city_btn_5.setBounds(355, 370, 105, 54);
		getContentPane().add(city_btn_5);

		JButton city_btn_6 = new JButton(new ImageIcon("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\stage.png"));
		city_btn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		city_btn_6.setFocusPainted(false);
		city_btn_6.setContentAreaFilled(false);
		city_btn_6.setBorderPainted(false);
		city_btn_6.setBounds(355, 268, 105, 54);
		getContentPane().add(city_btn_6);

		JButton city_btn_7 = new JButton(new ImageIcon("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\stage.png"));
		city_btn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		city_btn_7.setFocusPainted(false);
		city_btn_7.setContentAreaFilled(false);
		city_btn_7.setBorderPainted(false);
		city_btn_7.setBounds(399, 165, 105, 54);
		getContentPane().add(city_btn_7);


		JButton city_btn_8 = new JButton(new ImageIcon("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\stage.png"));
        city_btn_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        city_btn_8.setFocusPainted(false);
        city_btn_8.setContentAreaFilled(false);
        city_btn_8.setBorderPainted(false);
        city_btn_8.setBounds(114, 165, 105, 54);
        getContentPane().add(city_btn_8);


		JButton city_btn_9 = new JButton(new ImageIcon("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\stage.png"));
		city_btn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		city_btn_9.setFocusPainted(false);
		city_btn_9.setContentAreaFilled(false);
		city_btn_9.setBorderPainted(false);
		city_btn_9.setBounds(14, 315, 105, 54);
		getContentPane().add(city_btn_9);


		JButton city_btn_10 = new JButton(new ImageIcon("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\stage.png"));
        city_btn_10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        city_btn_10.setFocusPainted(false);
        city_btn_10.setContentAreaFilled(false);
        city_btn_10.setBorderPainted(false);
        city_btn_10.setBounds(114, 473, 105, 54);
        getContentPane().add(city_btn_10);

        JButton city_btn_11 = new JButton(new ImageIcon("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\stage.png"));
        city_btn_11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        city_btn_11.setFocusPainted(false);
        city_btn_11.setContentAreaFilled(false);
        city_btn_11.setBorderPainted(false);
        city_btn_11.setBounds(399, 473, 105, 54);
        getContentPane().add(city_btn_11);

        JButton city_btn_12 = new JButton(new ImageIcon("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\stage.png"));
        city_btn_12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        city_btn_12.setFocusPainted(false);
        city_btn_12.setContentAreaFilled(false);
        city_btn_12.setBorderPainted(false);
        city_btn_12.setBounds(501, 315, 105, 54);
        getContentPane().add(city_btn_12);

        JPanel player_2 = new JPanel();
        player_2.setLayout(null);
        player_2.setBounds(582, 654, 586, 259);
        getContentPane().add(player_2);

        JLabel label = new JLabel("player_img");
        label.setBounds(61, 84, 62, 18);
        player_2.add(label);

        JLabel label_1 = new JLabel("player_2");
        label_1.setBounds(61, 151, 62, 18);
        player_2.add(label_1);

        JLabel label_2 = new JLabel("체력");
        label_2.setBounds(218, 34, 62, 18);
        player_2.add(label_2);

        JLabel label_3 = new JLabel("정신력");
        label_3.setBounds(218, 84, 62, 18);
        player_2.add(label_3);

        JLabel label_4 = new JLabel("행동치");
        label_4.setBounds(218, 131, 62, 18);
        player_2.add(label_4);

        JLabel label_5 = new JLabel("money");
        label_5.setBounds(218, 181, 62, 18);
        player_2.add(label_5);

        JTextPane textPane_4 = new JTextPane();
        textPane_4.setBounds(353, 12, 167, 39);
        player_2.add(textPane_4);

        JTextPane textPane_5 = new JTextPane();
        textPane_5.setBounds(353, 63, 167, 39);
        player_2.add(textPane_5);

        JTextPane textPane_6 = new JTextPane();
        textPane_6.setBounds(353, 114, 167, 39);
        player_2.add(textPane_6);

        JTextPane textPane_7 = new JTextPane();
        textPane_7.setBounds(353, 160, 167, 39);
        player_2.add(textPane_7);
    }

	public static void main(String[] args) {
		MainGame MainGame = new MainGame();
		MainGame.setVisible(true);
	}

    class p_stat extends JPanel {
        p_stat() {
            /*
             * 테스트 코드
             * test temp = new test(); JPanel temp1 = new JPanel();
             * temp1.setBounds(0, 183, 394, 741); getContentPane().add(temp1);
             * temp1.add(temp);
             */
            JLabel health = new JLabel("체력");
            JTextPane health_text = new JTextPane();

            JLabel mental = new JLabel("정신력");
            JTextPane mental_text = new JTextPane();

            JLabel energy = new JLabel("행동치");
            JTextPane energy_text = new JTextPane();

            JLabel money = new JLabel("money");
            JTextPane money_text = new JTextPane();

            add(health);
            add(health_text);
            add(mental);
            add(mental_text);
            add(energy);
            add(energy_text);
            setLayout(new GridLayout(3, 2));
        }
    }
}
