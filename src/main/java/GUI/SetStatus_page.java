package GUI;

import com.GameMaster;
import com.Player;
import lombok.Data;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 각각의 플레이어들의 초기 스탯 분배하는 페이지이다.
 */
public class SetStatus_page extends JFrame {
    ImagePanel panel = new ImagePanel();
    Image img = new ImageIcon("src\\main\\java\\GUI\\imgaes\\backgroundImage.jpg").getImage();
    int distributable_point = 20;
    JLabel lb_distributable_point = new JLabel(Integer.toString(distributable_point));
    JPanel movetab = new JPanel();
    JButton next = new JButton("next");
    JButton prev = new JButton("prev");
    SetStatus_page() {
        getContentPane().setLayout(null);
        setBounds(0, 0, 1200, 960);

        movetab.setBackground(Color.white);

        getContentPane().add(movetab);
        movetab.setLayout(null);
        movetab.setBounds(0, 0, 1182, 146);

        next.setBounds(935, 32, 180, 70);
        prev.setBounds(78, 32, 180, 70);
        lb_distributable_point.setBounds(600,32,180, 70);

        movetab.add(next);
        movetab.add(lb_distributable_point);
        movetab.add(prev);

        // TODO : player name을 이미지로 해버리면 나중에 어떻게 바꿀 방법이 있나?
        JLabel player_name = new JLabel(new ImageIcon("src\\main\\java\\GUI\\imgaes\\player_name.png"));
        player_name.setBounds(121, 566, 365, 155);
        getContentPane().add(player_name);

        JLabel player_img = new JLabel(new ImageIcon("src\\main\\java\\GUI\\imgaes\\player.png"));
        player_img.setBounds(128, 216, 358, 356);
        getContentPane().add(player_img);

        perstatus_set status_power = new perstatus_set("src\\main\\java\\GUI\\imgaes\\1.png");
        JPanel perstatus = new JPanel();
        perstatus.setBounds(592, 206, 590, 82);
        getContentPane().add(perstatus);
        perstatus.add(status_power);

        perstatus_set status_dex = new perstatus_set("src\\main\\java\\GUI\\imgaes\\2.png");
        JPanel perstatus_1 = new JPanel();
        perstatus_1.setBounds(592, 477, 590, 82);
        getContentPane().add(perstatus_1);
        perstatus_1.add(status_dex);

        perstatus_set status_intelligence = new perstatus_set("src\\main\\java\\GUI\\imgaes\\3.png");
        JPanel perstatus_2 = new JPanel();
        perstatus_2.setBounds(592, 345, 590, 82);
        getContentPane().add(perstatus_2);
        perstatus_2.add(status_intelligence);

        perstatus_set status_mental = new perstatus_set("src\\main\\java\\GUI\\imgaes\\4.png");
        JPanel perstatus_3 = new JPanel();
        perstatus_3.setBounds(592, 602, 590, 82);
        getContentPane().add(perstatus_3);
        perstatus_3.add(status_mental);

        perstatus_set statuts_health = new perstatus_set("src\\main\\java\\GUI\\imgaes\\5.png");
        JPanel perstatus_4 = new JPanel();
        perstatus_4.setBounds(592, 728, 590, 82);
        getContentPane().add(perstatus_4);
        perstatus_4.add(statuts_health);

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] total_value = {
                        status_power.value,
                        status_dex.value,
                        status_intelligence.value,
                        status_mental.value,
                        statuts_health.value
                };
                GameMaster.setInitializePlayerStats(total_value);
                Player.toggleCurrentPlayer();
                JFrame nextPage = null;
                if (doesNextPlayerStatusSetted())
                    nextPage = new MainGame_page();
                else
                nextPage = new SetStatus_page();
                nextPage.setVisible(true);
                dispose();
            }
        });

        prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SetBoss_page prev = new SetBoss_page();
                prev.setVisible(true);
                dispose();
            }
        });
    }

    private boolean doesNextPlayerStatusSetted() {
        return Player.getCurrentPlayer().getPower() != null;
    }

    @Data
    class perstatus_set extends JPanel {
        private int value = 0;
        perstatus_set(String path) {
            JLabel status_name = new JLabel(new ImageIcon(path));
            JLabel status_value = new JLabel(Integer.toString(value));
            JButton plus = new JButton("plus");
            JButton minus = new JButton("minus");

            plus.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(value >= 0 && distributable_point >= 1){
                        distributable_point--;
                        value++;
                    }
                    status_value.setText(Integer.toString(value));
                    lb_distributable_point.setText(Integer.toString(distributable_point));
                }
            });
            minus.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(value >= 1){
                        distributable_point++;
                        value--;
                    }
                    status_value.setText(Integer.toString(value));
                    lb_distributable_point.setText(Integer.toString(distributable_point));
                }
            });
            add(status_name);
            add(status_value);
            add(plus);
            add(minus);
        }
    }
    class ImagePanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, 1200, 960, this);
        }
    }

    public static void main(String[] args) {
        SetStatus_page frame = new SetStatus_page();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
