package GUI;

import javax.swing.*;
import java.awt.*;

public class Game_resultPage extends JFrame {

    public static void main(String args[]){
        Game_resultPage hi = new Game_resultPage("win");
        hi.setVisible(true);
    }


    public Game_resultPage(String result){
        setResizable(false);
        setBounds(100, 100, 600, 480);



        if(result == "win"){
            Image win_img = new ImageIcon("src\\main\\java\\GUI\\imgaes\\Victory.png").getImage();
            Image win_tempimg = win_img.getScaledInstance(600,480,Image.SCALE_SMOOTH);
            JLabel win = new JLabel(new ImageIcon(win_tempimg));
            getContentPane().add(win);
            win.setVisible(true);
        }
        else if(result == "defeat"){}


        Image defeat_img = new ImageIcon("src\\main\\java\\GUI\\imgaes\\Defeat.png").getImage();
        Image defeat_tempimg = defeat_img.getScaledInstance(600,480,Image.SCALE_SMOOTH);
        JLabel defeat = new JLabel(new ImageIcon(defeat_tempimg));
        getContentPane().add(defeat);
        defeat.setVisible(true);

    }





}
