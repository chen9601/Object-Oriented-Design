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


/** Dialog 창, map. 플레이어들의 간략화 된 스탯 및 token을 보여주는 클래스이다. */
public class MainGame extends JFrame {
	ImagePanel panel = new ImagePanel();
	Image img = new ImageIcon("C:/Users/182899/eclipse-workspace/OrientedPG/src/images/backgroundImage.jpg").getImage();
	public static void main(String[] args) {
		MainGame MainGame = new MainGame();
		MainGame.setVisible(true);
	}

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
		button_1.setBorderPainted(false); button_1.setFocusPainted(false); button_1.setContentAreaFilled(false);
		button_1.setBounds(244, 209, 105, 54);
		getContentPane().add(button_1);
		
		
		
		JPanel Dialog = new JPanel();
		Dialog.setBounds(700, 175, 451, 414);
		getContentPane().add(Dialog);
		Dialog.setLayout(null);
		
		JPanel player1 = new JPanel();
		player1.setBounds(0, 654, 586, 259);
		getContentPane().add(player1);
		player1.setLayout(null);
		
		JLabel player_img = new JLabel("player_img");
		player_img.setBounds(61, 84, 62, 18);
		player1.add(player_img);
		
		JLabel player_1 = new JLabel("player_1");
		player_1.setBounds(61, 151, 62, 18);
		player1.add(player_1);
		
		JLabel health = new JLabel("\uCCB4\uB825");
		health.setBounds(218, 34, 62, 18);
		player1.add(health);
		
		JLabel mental = new JLabel("\uC815\uC2E0\uB825");
		mental.setBounds(218, 84, 62, 18);
		player1.add(mental);
		
		JLabel Doing = new JLabel("\uD589\uB3D9\uCE58");
		Doing.setBounds(218, 131, 62, 18);
		player1.add(Doing);
		
		JLabel money = new JLabel("money");
		money.setBounds(218, 181, 62, 18);
		player1.add(money);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(353, 12, 167, 39);
		player1.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(353, 63, 167, 39);
		player1.add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(353, 114, 167, 39);
		player1.add(textPane_2);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(353, 160, 167, 39);
		player1.add(textPane_3);
		
		JPanel player2 = new JPanel();
		player2.setLayout(null);
		player2.setBounds(590, 654, 592, 259);
		getContentPane().add(player2);
		
		JLabel label = new JLabel("player_img");
		label.setBounds(61, 84, 62, 18);
		player2.add(label);
		
		JLabel label_1 = new JLabel("player_1");
		label_1.setBounds(61, 151, 62, 18);
		player2.add(label_1);
		
		JLabel label_2 = new JLabel("\uCCB4\uB825");
		label_2.setBounds(218, 34, 62, 18);
		player2.add(label_2);
		
		JLabel label_3 = new JLabel("New label");
		label_3.setBounds(218, 84, 62, 18);
		player2.add(label_3);
		
		JLabel label_4 = new JLabel("New label");
		label_4.setBounds(218, 131, 62, 18);
		player2.add(label_4);
		
		JLabel label_5 = new JLabel("New label");
		label_5.setBounds(218, 181, 62, 18);
		player2.add(label_5);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setBounds(353, 12, 167, 39);
		player2.add(textPane_4);
		
		JTextPane textPane_5 = new JTextPane();
		textPane_5.setBounds(353, 63, 167, 39);
		player2.add(textPane_5);
		
		JTextPane textPane_6 = new JTextPane();
		textPane_6.setBounds(353, 114, 167, 39);
		player2.add(textPane_6);
		
		JTextPane textPane_7 = new JTextPane();
		textPane_7.setBounds(353, 160, 167, 39);
		player2.add(textPane_7);
		
		JButton button = new JButton(new ImageIcon("C:/Users/182899/eclipse-workspace/ORG/src/imgaes/stage.png"));
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBounds(244, 315, 105, 54);
		getContentPane().add(button);
		
		JButton button_2 = new JButton(new ImageIcon("C:/Users/182899/eclipse-workspace/ORG/src/imgaes/stage.png"));
		button_2.setFocusPainted(false);
		button_2.setContentAreaFilled(false);
		button_2.setBorderPainted(false);
		button_2.setBounds(244, 413, 105, 54);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton(new ImageIcon("C:/Users/182899/eclipse-workspace/ORG/src/imgaes/stage.png"));
		button_3.setFocusPainted(false);
		button_3.setContentAreaFilled(false);
		button_3.setBorderPainted(false);
		button_3.setBounds(125, 165, 105, 54);
		getContentPane().add(button_3);
		
		JButton button_4 = new JButton(new ImageIcon("C:/Users/182899/eclipse-workspace/ORG/src/imgaes/stage.png"));
		button_4.setFocusPainted(false);
		button_4.setContentAreaFilled(false);
		button_4.setBorderPainted(false);
		button_4.setBounds(125, 268, 105, 54);
		getContentPane().add(button_4);
		
		JButton button_5 = new JButton(new ImageIcon("C:/Users/182899/eclipse-workspace/ORG/src/imgaes/stage.png"));
		button_5.setFocusPainted(false);
		button_5.setContentAreaFilled(false);
		button_5.setBorderPainted(false);
		button_5.setBounds(125, 370, 105, 54);
		getContentPane().add(button_5);
		
		JButton button_6 = new JButton(new ImageIcon("C:/Users/182899/eclipse-workspace/ORG/src/imgaes/stage.png"));
		button_6.setFocusPainted(false);
		button_6.setContentAreaFilled(false);
		button_6.setBorderPainted(false);
		button_6.setBounds(125, 473, 105, 54);
		getContentPane().add(button_6);
		
		JButton button_7 = new JButton(new ImageIcon("C:/Users/182899/eclipse-workspace/ORG/src/imgaes/stage.png"));
		button_7.setFocusPainted(false);
		button_7.setContentAreaFilled(false);
		button_7.setBorderPainted(false);
		button_7.setBounds(382, 473, 105, 54);
		getContentPane().add(button_7);
		
		JButton button_8 = new JButton(new ImageIcon("C:/Users/182899/eclipse-workspace/ORG/src/imgaes/stage.png"));
		button_8.setFocusPainted(false);
		button_8.setContentAreaFilled(false);
		button_8.setBorderPainted(false);
		button_8.setBounds(382, 370, 105, 54);
		getContentPane().add(button_8);
		
		JButton button_9 = new JButton(new ImageIcon("C:/Users/182899/eclipse-workspace/ORG/src/imgaes/stage.png"));
		button_9.setFocusPainted(false);
		button_9.setContentAreaFilled(false);
		button_9.setBorderPainted(false);
		button_9.setBounds(382, 268, 105, 54);
		getContentPane().add(button_9);
		
		JButton button_10 = new JButton(new ImageIcon("C:/Users/182899/eclipse-workspace/ORG/src/imgaes/stage.png"));
		button_10.setFocusPainted(false);
		button_10.setContentAreaFilled(false);
		button_10.setBorderPainted(false);
		button_10.setBounds(382, 165, 105, 54);
		getContentPane().add(button_10);
		
		JButton button_11 = new JButton(new ImageIcon("C:/Users/182899/eclipse-workspace/ORG/src/imgaes/stage.png"));
		button_11.setFocusPainted(false);
		button_11.setContentAreaFilled(false);
		button_11.setBorderPainted(false);
		button_11.setBounds(501, 315, 105, 54);
		getContentPane().add(button_11);
		
		JButton button_12 = new JButton(new ImageIcon("C:/Users/182899/eclipse-workspace/ORG/src/imgaes/stage.png"));
		button_12.setFocusPainted(false);
		button_12.setContentAreaFilled(false);
		button_12.setBorderPainted(false);
		button_12.setBounds(14, 315, 105, 54);
		getContentPane().add(button_12);
	}
	class ImagePanel extends JPanel {

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, 1200, 960, this);

		}
	}
}
