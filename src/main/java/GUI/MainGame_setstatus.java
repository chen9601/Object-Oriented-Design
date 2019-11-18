package GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/** 게임을 진행하면서 바뀌는 플레이어의 현재 스테이터스와 아이템을 보여주는 페이지이다.*/

public class MainGame_setstatus extends JFrame {
	ImagePanel panel = new ImagePanel();
	Image img = new ImageIcon("C:/Users/182899/eclipse-workspace/ORG/src/imgaes/backgroundImage.jpg").getImage();

	MainGame_setstatus() {
		getContentPane().setLayout(null);
		setBounds(0, 0, 1200, 960);

		JPanel movetab = new JPanel();
		JButton prev = new JButton("prev");

		prev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				MainGame temp = new MainGame();
				temp.setVisible(true);
				dispose();
			}
		});



		getContentPane().add(movetab);
		movetab.setLayout(null);
		movetab.setBounds(0, 0, 1182, 146);
		prev.setBounds(40, 32, 180, 70);
		movetab.add(prev);
		JButton player1 = new JButton("player1");

		player1.setBounds(297, 40, 160, 54);

		movetab.add(player1);

		JButton player2 = new JButton("player2");
		player2.setBounds(494, 40, 144, 54);
		movetab.add(player2);

		JLabel lblMoney = new JLabel("money");
		lblMoney.setBounds(694, 58, 62, 18);
		movetab.add(lblMoney);

		JLabel lblToken = new JLabel("token");
		lblToken.setBounds(892, 58, 62, 18);
		movetab.add(lblToken);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(770, 58, 98, 18);
		movetab.add(textPane);

		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(968, 58, 124, 24);
		movetab.add(textPane_1);

		JLabel lblNewLabel = new JLabel("\uD798");
		lblNewLabel.setBounds(546, 282, 116, 39);
		getContentPane().add(lblNewLabel);

		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(622, 282, 164, 39);
		getContentPane().add(textPane_2);

		JLabel label = new JLabel("\uBBFC\uCCA9");
		label.setBounds(546, 365, 116, 39);
		getContentPane().add(label);

		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(622, 365, 164, 39);
		getContentPane().add(textPane_3);

		JLabel label_1 = new JLabel("\uC9C0\uB2A5");
		label_1.setBounds(546, 457, 116, 39);
		getContentPane().add(label_1);

		JTextPane textPane_4 = new JTextPane();
		textPane_4.setBounds(622, 457, 164, 39);
		getContentPane().add(textPane_4);

		JLabel label_2 = new JLabel("\uC815\uC2E0\uB825");
		label_2.setBounds(546, 544, 116, 39);
		getContentPane().add(label_2);

		JTextPane textPane_5 = new JTextPane();
		textPane_5.setBounds(622, 544, 164, 39);
		getContentPane().add(textPane_5);

		JLabel label_3 = new JLabel("\uCCB4\uB825");
		label_3.setBounds(870, 282, 116, 39);
		getContentPane().add(label_3);

		JTextPane textPane_6 = new JTextPane();
		textPane_6.setBounds(946, 282, 164, 39);
		getContentPane().add(textPane_6);

		JLabel label_4 = new JLabel("Item");
		label_4.setBounds(870, 365, 240, 39);
		getContentPane().add(label_4);

		JTextPane textPane_7 = new JTextPane();
		textPane_7.setBounds(865, 410, 245, 173);
		getContentPane().add(textPane_7);
		
		JLabel label_5 = new JLabel(new ImageIcon("C:/Users/182899/eclipse-workspace/ORG/src/imgaes/player_name.png"));
		label_5.setBounds(113, 559, 365, 155);
		getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel(new ImageIcon("C:/Users/182899/eclipse-workspace/ORG/src/imgaes/player.png"));
		label_6.setBounds(120, 209, 358, 356);
		getContentPane().add(label_6);

	}

	class ImagePanel extends JPanel {

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, 1200, 960, this);
		}
	}

	public static void main(String[] args) {

		SetStatus frame = new SetStatus();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
