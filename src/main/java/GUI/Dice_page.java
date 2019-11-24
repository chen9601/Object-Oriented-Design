package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/** 전투시 주사위를 굴릴수 있는 프레임이다*/
public class Dice_page extends JFrame {

	String path;
	public static void main(String args[]) {
		Dice_page MainGame = new Dice_page();
		MainGame.setVisible(true);
	}

	public Dice_page() {
		setBounds(100, 100, 540, 442);
		getContentPane().setLayout(null);

		JButton click = new JButton("Click");
		click.setBounds(379, 327, 100, 35);
		getContentPane().add(click);

		path = "src\\main\\java\\GUI\\imgaes\\diceForRoll-export.gif";
		JLabel showDice = new JLabel(new ImageIcon(path));
		showDice.setBounds(14, 22, 494, 281);
		getContentPane().add(showDice);

		click.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				showDice.setIcon(new ImageIcon(DiceImage(Dice())));
			}
		});

	}

	public String DiceImage(int Dice_num){

		if (Dice_num == 1){return "src\\main\\java\\GUI\\imgaes\\diceForRoll-export.gif";}
		else if (Dice_num == 2){return "src\\main\\java\\GUI\\imgaes\\diceForRoll2-export.gif";}
		else if (Dice_num == 3){return "src\\main\\java\\GUI\\imgaes\\diceForRoll3-export.gif";}
		else if (Dice_num == 4){return "src\\main\\java\\GUI\\imgaes\\diceForRoll4-export.gif";}
		else if (Dice_num == 5){return "src\\main\\java\\GUI\\imgaes\\diceForRoll5-export.gif";}
		else return "src\\main\\java\\GUI\\imgaes\\diceForRoll6-export.gif";

	}
	public int Dice() {
		double randomValue = Math.random();
		int intValue = (int) (randomValue * 6) + 1;
		return intValue;
	}
}
