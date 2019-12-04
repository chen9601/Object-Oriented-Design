package GUI;

import com.Boss;
import com.BossType;
import com.GameMaster;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * 새로 게임을 생성할 때 보스를 설정하는 페이지이다.
 */
public class SetBoss_page extends JFrame {

    ImagePanel panel = new ImagePanel();
    Image boss_background = new ImageIcon("src\\main\\java\\GUI\\imgaes\\backgroundImage.jpg").getImage();

    SetBoss_page() {
        getContentPane().add(panel);
        panel.setLayout(null);
        setResizable(false);
        setBounds(0, 0, 1200, 960);

        JPanel movetab = new JPanel();

        JLabel help_text = new JLabel("Click the boss name you want");
        Font font = new Font("font",Font.ITALIC,30);
        help_text.setFont(font);
        movetab.add(help_text);

        JButton prev = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\prev.png"));


        movetab.setLayout(null);

        // startpage로 이동
        prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Start_page prev = new Start_page();
                prev.setVisible(true);
                dispose();
            }
        });
        movetab.setBounds(0, 0, 1182, 186);
        help_text.setBounds(480,32,800,70);
        prev.setBounds(78, 32, 180, 70);



        movetab.add(prev);
        panel.add(movetab);

        String azartoth_win = "강림시 패배";
        String nyarlathotep_win = "토큰 필요량 +3";
        String chuthulu_win = "전투 시 받는 데미지 +1";


        BossPanel Test1 = new BossPanel(BossType.AZATHOTH.getBoss_imgpath(), BossType.AZATHOTH, azartoth_win,"src\\main\\java\\GUI\\imgaes\\AZATOTH-NAME.PNG");
        BossPanel Test2 = new BossPanel(BossType.CHUTHULU.getBoss_imgpath(), BossType.CHUTHULU, chuthulu_win,"src\\main\\java\\GUI\\imgaes\\CTHULHU-NAME.PNG");
        BossPanel Test3 = new BossPanel(BossType.NYARLATHOTEP.getBoss_imgpath(), BossType.NYARLATHOTEP, nyarlathotep_win,"src\\main\\java\\GUI\\imgaes\\NYALA-NAME.PNG");

        JPanel boss1 = new JPanel();
        boss1.setBounds(0, 183, 394, 741);
        boss1.add(Test1);
        panel.add(boss1);

        JPanel boss2 = new JPanel();
        boss2.setBounds(394, 183, 394, 741);
        boss2.add(Test2);
        panel.add(boss2);

        JPanel boss3 = new JPanel();
        boss3.setBounds(788, 183, 394, 741);
        boss3.add(Test3);
        panel.add(boss3);
    }

    class BossPanel extends JPanel {

        public BossPanel(String img_path, BossType bosstype, String boss_win,String boss_name_imgpath) {
            ImageIcon bossbtn_image = new ImageIcon(boss_name_imgpath);
            JButton bossbtn = new JButton(bossbtn_image);

            bossbtn.setPreferredSize(new Dimension(170,70));
            bossbtn.setOpaque(false);
            bossbtn.setFocusPainted(false);
            bossbtn.setContentAreaFilled(false);

            bossbtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //TODO : boss test code지우고 수정 bosstype과 연동
                    GameMaster.setBoss(
                            Boss
                                    .builder()
                                    .type(bosstype)
                                    .health(bosstype.getHealth())
                                    .damage(bosstype.getDamage())
                                    .requireVal(bosstype.getRequireVal())
                                    .build()
                    );
                    System.out.println(GameMaster.current_boss.getRequireVal());

                    SetStatus_page next = new SetStatus_page();
                    next.setVisible(true);
                    dispose();
                }
            });
            setLayout(new BorderLayout());
            Image temp = new ImageIcon(img_path).getImage();
            Image temp_2 = temp.getScaledInstance(400, 500, java.awt.Image.SCALE_SMOOTH);

            ImageIcon real = new ImageIcon(temp_2);

            JLabel bossimg = new JLabel(real);
            JLabel bosstxt = new JLabel(boss_win);
            bosstxt.setPreferredSize(new Dimension(150, 50));


            bosstxt.setHorizontalAlignment(JTextField.CENTER);

            add(bossimg, BorderLayout.NORTH);
            add(bossbtn, BorderLayout.CENTER);
            add(bosstxt, BorderLayout.SOUTH);

        }

    }

    class ImagePanel extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(boss_background, 0, 0, 1200, 960, this);
        }
    }
}
