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
    Image img = new ImageIcon("src\\main\\java\\GUI\\imgaes\\backgroundImage.jpg").getImage();


    SetBoss_page() {
        setResizable(false);
        setBounds(0, 0, 1200, 960);
        getContentPane().setLayout(null);

        JPanel movetab = new JPanel();
        JButton next = new JButton(new ImageIcon("src\\main\\java\\GUI\\imgaes\\next.png"));
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

        prev.setBounds(78, 32, 180, 70);

        getContentPane().add(movetab);

        movetab.add(prev);


        String azartoth_win = "강림시 패배";
        String nyarlathotep_win = " 가면 괴물이 등장할 수 있다.";
        String chuthulu_win = "최대 정신력과 최대 체력이 1씩 줄어든다.";


        BossPanel Test1 = new BossPanel(BossType.AZATHOTH.getBoss_imgpath(), BossType.AZATHOTH, azartoth_win);
        BossPanel Test2 = new BossPanel(BossType.CHUTHULU.getBoss_imgpath(), BossType.CHUTHULU, chuthulu_win);
        BossPanel Test3 = new BossPanel(BossType.NYARLATHOTEP.getBoss_imgpath(), BossType.NYARLATHOTEP, nyarlathotep_win);

        JPanel boss1 = new JPanel();
        boss1.setBounds(0, 183, 394, 741);
        getContentPane().add(boss1);
        boss1.add(Test1);


        JPanel boss2 = new JPanel();
        boss2.setBounds(394, 183, 394, 741);
        getContentPane().add(boss2);
        boss2.add(Test2);

        JPanel boss3 = new JPanel();
        boss3.setBounds(788, 183, 394, 741);
        getContentPane().add(boss3);
        boss3.add(Test3);
    }

    class BossPanel extends JPanel {

        public BossPanel(String img_path, BossType bosstype, String boss_win) {
            JButton bossbtn = new JButton(bosstype.getName());
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
            JTextField bosstxt = new JTextField();
            bosstxt.setText(boss_win);
            bosstxt.setHorizontalAlignment(JTextField.CENTER);

            add(bossimg, BorderLayout.NORTH);
            add(bossbtn, BorderLayout.CENTER);
            add(bosstxt, BorderLayout.SOUTH);

        }

    }
}
