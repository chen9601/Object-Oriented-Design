package GUI;

import com.Player;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** boss나 monster와의 전투를 나타내는 페이지이다.*/

public class Fight_monster_page extends JFrame {

	public static void main(String[] args) {
		Fight_monster_page frame = new Fight_monster_page();
		frame.setVisible(true);
	}


	public Fight_monster_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.white);
		setBounds(0, 0, 1200, 960);
		getContentPane().setLayout(null);

		JTextPane Dialog = new JTextPane();
		Dialog.setBounds(424, 603, 744, 298);
		getContentPane().add(Dialog);

		JPanel player_panel = new JPanel();
		player_panel.setBounds(0, 603, 423, 298);
		getContentPane().add(player_panel);

		player_panel.setLayout(new FlowLayout(2,1,0));



		JPanel Monster_panel = new JPanel();
		Monster_panel.setBounds(650, 144, 532, 324);
		getContentPane().add(Monster_panel);

		JPanel tab_panel = new JPanel();
		tab_panel.setBounds(0, 0, 1182, 132);
		getContentPane().add(tab_panel);

		JButton status = new JButton("Status");
		status.setBounds(0, 0, 1182, 913);
		tab_panel.add(status);

		status.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});

		show_player hi3 = new show_player();
		getContentPane().add(hi3);

	}

	class show_player extends JPanel{

		show_player(){


		}

	}
}
