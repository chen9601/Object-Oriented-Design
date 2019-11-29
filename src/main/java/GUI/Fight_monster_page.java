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

	JTextPane Dialog = new JTextPane();
	JLabel lblpower = new JLabel("power");
	JTextPane power_text = new JTextPane();
	JLabel lblhealth = new JLabel("health");
	JTextPane health_text = new JTextPane();
	JLabel lblmental = new JLabel("mental");
	JTextPane mental_text = new JTextPane();
	JLabel player_img = new JLabel("player img");
	JLabel player_nameimg = new JLabel("player name");


	JLabel monster_health = new JLabel("monsterhealth");
	JTextPane monster_health_txt = new JTextPane();



	JLabel monster_power = new JLabel("monsterpower");
	JTextPane monster_power_txt = new JTextPane();



	JLabel monster_img = new JLabel("monster img");
	JLabel monster_name = new JLabel("monster name");

	JButton status = new JButton("status");



	public static void main(String[] args) {

		Fight_monster_page frame = new Fight_monster_page();
		frame.setVisible(true);

	}

	public Fight_monster_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.white);
		setBounds(0, 0, 1200, 960);
		getContentPane().setLayout(null);


		Dialog.setBounds(459, 615, 709, 286);
		getContentPane().add(Dialog);


		lblpower.setBounds(223, 682, 79, 36);
		getContentPane().add(lblpower);


		power_text.setBounds(302, 682, 119, 36);
		getContentPane().add(power_text);


		lblhealth.setBounds(223, 747, 79, 36);
		getContentPane().add(lblhealth);


		health_text.setBounds(302, 747, 119, 36);
		getContentPane().add(health_text);


		lblmental.setBounds(223, 816, 79, 36);
		getContentPane().add(lblmental);


		mental_text.setBounds(302, 816, 119, 36);
		getContentPane().add(mental_text);


		player_img.setBounds(14, 635, 194, 165);
		getContentPane().add(player_img);


		player_nameimg.setBounds(14, 816, 194, 55);
		getContentPane().add(player_nameimg);


		monster_health.setBounds(957, 209, 79, 36);
		getContentPane().add(monster_health);


		monster_health_txt.setBounds(1032, 209, 119, 36);
		getContentPane().add(monster_health_txt);


		monster_power.setBounds(957, 278, 79, 36);
		getContentPane().add(monster_power);


		monster_power_txt.setBounds(1032, 278, 119, 36);
		getContentPane().add(monster_power_txt);


		monster_img.setBounds(708, 99, 212, 215);
		getContentPane().add(monster_img);


		monster_name.setBounds(957, 114, 194, 55);
		getContentPane().add(monster_name);


		status.setBounds(91, 38, 158, 45);
		getContentPane().add(status);







	}

	class show_player extends JPanel{

		show_player(){


		}

	}
}
