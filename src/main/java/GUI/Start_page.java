package GUI;

import GUI.music.Mainmusic_thread;
import com.GameMaster;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * New Game Load Game EXIT 3개의 버튼으로 게임 시작 및 종료를 담당하는 페이지이다.
 */
public class Start_page extends JFrame {

    ImagePanel panel = new ImagePanel();
    Image img = new ImageIcon("src\\main\\java\\GUI\\imgaes\\main_title.png").getImage();

    JButton newgame = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\NewGame.png"));
    JButton loadgame = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\Loadgame.png"));
    JButton exitgame = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\EXIT.png"));

    public Start_page() {



        setResizable(false);
        getContentPane().add(panel);
        panel.setLayout(null);
        setBounds(0, 0, 1200, 960);

        newgame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameMaster.initiateGame();
                SetBoss_page test = new SetBoss_page();
                test.setVisible(true);
                dispose();
            }
        });
        loadgame.addActionListener(new ActionListener() {
            // 아직 Load기능이 구현되지 않아 냄겨둡니다.
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }


        });
        exitgame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(newgame);
        panel.add(loadgame);
        panel.add(exitgame);

        newgame.setBounds(500, 480, 200, 70);
        loadgame.setBounds(500, 600, 200, 70);
        exitgame.setBounds(500, 720, 200, 70);



        Mainmusic_thread music = new Mainmusic_thread("src\\main\\java\\GUI\\music\\Main.mp3",true);
        music.start();
    }

    static public void Start_pageView() {
        Start_page frame = new Start_page();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * To paint background
     */
    class ImagePanel extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, 1200, 960, this);
        }
    }




    }
