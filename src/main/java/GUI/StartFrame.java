package GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


/** New Game Load Game EXIT 3개의 버튼으로 게임 시작 및 종료를 담당하는 페이지이다.*/
public class StartFrame extends JFrame {
	public StartFrame(){
		this.setTitle("Thulu Thulu");
		setBounds(0, 0, 1200, 960);
		StartView startview = new StartView();
		getContentPane().add(startview);
		startview.setLayout(null);
		startview.btnNewGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SetBossView setbossview = new SetBossView();
				getContentPane().removeAll();
				getContentPane().add(setbossview);
				revalidate();
				repaint();
//				test.setVisible(true);
//				dispose();
			}
		});
		// TODO : Loadgaembtn 액션리스너
		startview.btnLoadGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		startview.add(startview.btnNewGame);
		startview.add(startview.btnLoadGame);
		startview.add(startview.btnExitGame);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
