package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/** 각각의 플레이어들의 초기 스탯 분배하는 페이지이다.*/
public class SetStatus extends JFrame {
	ImagePanel panel = new ImagePanel();
	Image img = new ImageIcon("C:/Users/182899/eclipse-workspace/ORG/src/imgaes/backgroundImage.jpg").getImage();

	SetStatus() {
		
		getContentPane().setLayout(null);
		setBounds(0, 0, 1200, 960);
		
		
		
		JPanel movetab = new JPanel();
		JButton next = new JButton("next");
		JButton prev = new JButton("prev");
		
		movetab.setBackground(Color.white);
		
		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				MainGame next = new MainGame();
				next.setVisible(true);
				dispose();
			}
		});

		prev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				SetBoss prev = new SetBoss();
				prev.setVisible(true);
				dispose();
			}
		});
		
		getContentPane().add(movetab);
		movetab.setLayout(null);
		movetab.setBounds(0, 0, 1182, 146);
		
		next.setBounds(935, 32, 180, 70);
		prev.setBounds(78, 32, 180, 70);
		
		movetab.add(next);
		movetab.add(prev);



		JLabel lblNewLabel = new JLabel(new ImageIcon("C:/Users/182899/eclipse-workspace/ORG/src/imgaes/player_name.png"));
		lblNewLabel.setBounds(121, 566, 365, 155);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon("C:/Users/182899/eclipse-workspace/ORG/src/imgaes/player.png"));
		lblNewLabel_1.setBounds(128, 216, 358, 356);
		getContentPane().add(lblNewLabel_1);

		perstatus_set perstatus1 = new perstatus_set("C:/Users/182899/eclipse-workspace/ORG/src/imgaes/1.png");
		JPanel perstatus = new JPanel();
		perstatus.setBounds(592, 206, 590, 82);
		getContentPane().add(perstatus);
		perstatus.add(perstatus1);
		
		perstatus_set perstatus2 = new perstatus_set("C:/Users/182899/eclipse-workspace/ORG/src/imgaes/2.png");
		JPanel perstatus_1 = new JPanel();
		perstatus_1.setBounds(592, 477, 590, 82);
		getContentPane().add(perstatus_1);
		perstatus_1.add(perstatus2);
		
		perstatus_set perstatus3 = new perstatus_set("C:/Users/182899/eclipse-workspace/ORG/src/imgaes/3.png");
		JPanel perstatus_2 = new JPanel();
		perstatus_2.setBounds(592, 345, 590, 82);
		getContentPane().add(perstatus_2);
		perstatus_2.add(perstatus3);
		
		perstatus_set perstatus4 = new perstatus_set("C:/Users/182899/eclipse-workspace/ORG/src/imgaes/4.png");
		JPanel perstatus_3 = new JPanel();
		perstatus_3.setBounds(592, 602, 590, 82);
		getContentPane().add(perstatus_3);
		perstatus_3.add(perstatus4);
		
		perstatus_set perstatus5 = new perstatus_set("C:/Users/182899/eclipse-workspace/ORG/src/imgaes/5.png");
		JPanel perstatus_4 = new JPanel();
		perstatus_4.setBounds(592, 728, 590, 82);
		getContentPane().add(perstatus_4);
		perstatus_4.add(perstatus5);
		
		
		
		
		

	}

	class perstatus_set extends JPanel {
		
		perstatus_set(String path) {
			JLabel status_name = new JLabel(new ImageIcon(path));
			JButton plus = new JButton("plus");
			JButton minus = new JButton("minus");

			add(status_name);
			add(plus);
			add(minus);

		}

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
