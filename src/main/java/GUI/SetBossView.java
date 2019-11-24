package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


class BossImageView extends JPanel {

    public BossImageView(String img_path, String name) {
        JButton bossbtn = new JButton(name);
        setLayout(new BorderLayout());
        Image img = new ImageIcon(img_path).getImage().
                getScaledInstance(400, 500, java.awt.Image.SCALE_SMOOTH);

        ImageIcon real = new ImageIcon(img);
        JLabel bossimg = new JLabel(real);
        JTextArea bosstxt = new JTextArea();

        add(bossimg, BorderLayout.NORTH);
        add(bossbtn, BorderLayout.CENTER);
        add(bosstxt, BorderLayout.SOUTH);
    }
}

/**
 * 새로 게임을 생성할 때 보스를 설정하는 페이지이다.
 */
public class SetBossView extends JPanel {
    Image bgimg = new ImageIcon("src/images/backgroundImage.jpg").getImage();
    JButton btnNext = new JButton(new ImageIcon("src/imgaes/next.png"));
    JButton btnPrev = new JButton(new ImageIcon("src/imgaes/prev.png"));

    public SetBossView() {
        setLayout(new BorderLayout());
        add(btnNext, BorderLayout.NORTH);
        add(btnPrev, BorderLayout.NORTH);
//        // setstatus페이지로 이동
//        next.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                SetStatus_page next = new SetStatus_page();
//                next.setVisible(true);
//                dispose();
//            }
//        });
//        // startpage로 이동
//        prev.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                StartView prev = new StartView();
//                prev.setVisible(true);
//                dispose();
//            }
//        });
        btnNext.setBounds(935, 32, 180, 70);
        btnPrev.setBounds(78, 32, 180, 70);


        BossImageView[] bossimages = new BossImageView[3];
        bossimages[0] = new BossImageView("src\\main\\java\\GUI\\imgaes\\azatoth.png", "아자투스");
        bossimages[1] = new BossImageView("src\\main\\java\\GUI\\imgaes\\azatoth.png", "크툴루");
        bossimages[2] = new BossImageView("src\\main\\java\\GUI\\imgaes\\azatoth.png", "고범수");

        add(bossimages[0]);

//        JPanel boss1 = new JPanel();
//        boss1.setBounds(0, 183, 394, 741);
////        getContentPane().add(boss1);
//        boss1.add(bossimages[0]);
//
//
//        JPanel boss2 = new JPanel();
//        boss2.setBounds(394, 183, 394, 741);
////        getContentPane().add(boss2);
//        boss2.add(bossimages[1]);
//
//        JPanel boss3 = new JPanel();
//        boss3.setBounds(788, 183, 394, 741);
////        getContentPane().add(boss3);
//        boss3.add(bossimages[2]);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bgimg, 0, 0, 1200, 960, this);
    }

//    public static void main(String[] args) {
//
//        SetBossView frame = new SetBossView();
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
}
