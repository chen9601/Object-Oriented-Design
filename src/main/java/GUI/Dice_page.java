package GUI;

import lombok.Getter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * 전투시 주사위를 굴릴수 있는 프레임이다
 */
public class Dice_page extends JFrame {
 @Getter
    private int savedDice_num;

    String path;

    public static void main(String args[]) {
        Dice_page MainGame = new Dice_page();
        MainGame.setVisible(true);
    }

    public Dice_page() {
        setBounds(100, 100, 550, 600);
        getContentPane().setLayout(null);
        setUndecorated(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((dim.width/2)-(getWidth()/2), (dim.height/2)-(getHeight()/2));



        출처: https://selfinvestfriends.tistory.com/15 [self invest]
//
//        JButton click = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\click.png"));
//        click.setBounds(379, 522, 100, 35);
//        getContentPane().add(click);

        path = "src\\main\\java\\GUI\\imgaes\\diceForRoll-export.gif";
        JLabel showDice = new JLabel(new ImageIcon(path));
        showDice.setBounds(14, 22, 500, 500);
        getContentPane().add(showDice);

//        click.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                showDice.setIcon(new ImageIcon(DiceImage(select_Dicenum())));
//
//            }
//        });
        savedDice_num = select_Dicenum();
        System.out.println(savedDice_num);
        System.out.println("Dice_page select_Dicenum");
        showDice.setIcon(new ImageIcon(DiceImage(savedDice_num)));
    }



    public String DiceImage(int Dice_num) {
        setResizable(false);
        if (Dice_num == 1) {
            return "src\\main\\java\\GUI\\imgaes\\diceForRoll-export.gif";
        } else if (Dice_num == 2) {
            return "src\\main\\java\\GUI\\imgaes\\diceForRoll2-export.gif";
        } else if (Dice_num == 3) {
            return "src\\main\\java\\GUI\\imgaes\\diceForRoll3-export.gif";
        } else if (Dice_num == 4) {
            return "src\\main\\java\\GUI\\imgaes\\diceForRoll4-export.gif";
        } else if (Dice_num == 5) {
            return "src\\main\\java\\GUI\\imgaes\\diceForRoll5-export.gif";
        } else return "src\\main\\java\\GUI\\imgaes\\diceForRoll6-export.gif";

    }

    public int select_Dicenum() {
        double randomValue = Math.random();
        int intValue = (int) (randomValue * 6) + 1;
        return intValue;
    }

}
