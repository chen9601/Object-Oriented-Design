package GUI;

import GUI.music.Mainmusic_thread;
import com.GameMaster;
import com.Player;

import javax.swing.*;
import java.awt.*;

/** boss나 monster와의 전투를 나타내는 페이지이다.*/

public class Fight_boss_page extends JFrame {

	public static void main(String[] args) {
		Fight_boss_page frame = new Fight_boss_page();
		frame.setVisible(true);
	}


	public Fight_boss_page() {

		Mainmusic_thread.thread.close();
		Mainmusic_thread music_thread = new Mainmusic_thread("src\\main\\java\\GUI\\music\\boss_fight.mp3", true);
		music_thread.start();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 960);
		getContentPane().setLayout(null);



		JPanel BossHealthPanel = new JPanel();
		BossHealthPanel.setBounds(0, 0, 1182, 153);
		getContentPane().add(BossHealthPanel);
		BossHealthPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel boss_temphealth = new JLabel(GameMaster.current_boss.getType().getBoss_imgpath());
		BossHealthPanel.add(boss_temphealth);

		//플레이어들의 스테이터스
		{

			ImageIcon player1_img = new ImageIcon("src\\main\\java\\GUI\\imgaes\\player2-portrait.png");
			JLabel lb_player1 = new JLabel(player1_img);
			lb_player1.setBounds(650, 620, 240, 163);
			getContentPane().add(lb_player1);

			ImageIcon player1_name_img = new ImageIcon("src\\main\\java\\GUI\\imgaes\\player1_name.png");
			JLabel player1_name = new JLabel(player1_name_img);
			player1_name.setBounds(41, 780, 240, 61);
			getContentPane().add(player1_name);

			MainGame_page.PlayerStatusPanel player1_status_panel = new MainGame_page.PlayerStatusPanel(Player.getPlayer(0));
			player1_status_panel.setBounds(290, 670, 318, 225);
			getContentPane().add(player1_status_panel);

			JLabel lb_player2_img = new JLabel(new ImageIcon("src\\main\\java\\GUI\\imgaes\\player1-portrait.png"));
			lb_player2_img.setBounds(41, 620, 240, 163);
			getContentPane().add(lb_player2_img);

			JLabel lb_player2_name = new JLabel(new ImageIcon("src\\main\\java\\GUI\\imgaes\\player2_name.png"));
			lb_player2_name.setBounds(650, 780, 240, 61);
			getContentPane().add(lb_player2_name);

			MainGame_page.PlayerStatusPanel player2_status_panel = new MainGame_page.PlayerStatusPanel(Player.getPlayer(1));
			player2_status_panel.setBounds(864, 670, 318, 225);
			getContentPane().add(player2_status_panel);
		}
		//
		JLabel boss_panel = new JLabel(new ImageIcon(GameMaster.current_boss.getType().getBoss_imgpath()));
		boss_panel.setBounds(75, 120,1100 , 480);
		getContentPane().add(boss_panel);


	}
}
