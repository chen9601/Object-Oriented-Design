package GUI;

import javax.swing.*;
import java.awt.*;

public class StartView extends JPanel{
        Image bgimg = new ImageIcon("src\\main\\java\\GUI\\imgaes\\main_title.png").getImage();
        JButton btnNewGame = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\btnnewgame.png"));
        JButton btnLoadGame = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\btnloadgame.png"));
        JButton btnExitGame = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\EXIT.png"));

        public StartView() {
            btnNewGame.setBounds(500, 480, 200, 70);
            btnLoadGame.setBounds(500, 600, 200, 70);
            btnExitGame.setBounds(500, 720, 200, 70);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(bgimg, 0, 0, 1200, 960, this);
        }

}
