package GUI;

import com.Monster;
import com.Player;
import com.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * boss나 monster와의 전투를 나타내는 페이지이다.
 */

public class Fight_monster_page extends JFrame {


    public static void main(String[] args) {

        Fight_monster_page frame = new Fight_monster_page();
        frame.setVisible(true);

    }

    public Fight_monster_page() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.white);
        setBounds(0, 0, 1200, 960);
        getContentPane().setLayout(null);

        JTextPane Dialog = new JTextPane();

        player_panel player_panel = new player_panel(Player.getPlayer(0));
        getContentPane().add(player_panel);
        player_panel.setVisible(true);

        monster_panel monsterPanel = new monster_panel();
        getContentPane().add(monsterPanel);

        JButton status = new JButton("status");

        Dialog.setBounds(459, 615, 709, 286);
        getContentPane().add(Dialog);

        status.setBounds(91, 38, 158, 45);
        getContentPane().add(status);


    }

    class player_panel extends JPanel {


        player_panel(Player player) {

            Player cur_player = player;
            JLabel lblpower = new JLabel("power");
            JLabel power_text = new JLabel(Integer.toString(cur_player.getPower()));
            JLabel lblhealth = new JLabel("health");
            JLabel health_text = new JLabel(Integer.toString(cur_player.getHealth()));
            JLabel lblmental = new JLabel("mental");
            JLabel mental_text = new JLabel(Integer.toString(cur_player.getMental()));

            String player_imgpath;
            String player_nameimgpath;

            if (player == Player.getPlayer(0)) {
                player_imgpath = "";
                player_nameimgpath = "";
            } else {
                player_imgpath = "";
                player_nameimgpath = "";
            }
            JLabel player_img = new JLabel(player_imgpath);
            JLabel player_nameimg = new JLabel(player_nameimgpath);

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

        }

    }

    class monster_panel extends JPanel {
        monster_panel() {
            Monster monster = Map.tiles[Player.getCurrentPlayer().getPos().ordinal()].getSummoned_monster();
            JLabel monster_health = new JLabel("Health");
            JLabel monster_health_txt = new JLabel(Integer.toString(monster.getHealth()));

            JLabel monster_power = new JLabel("power");
            JLabel monster_power_txt = new JLabel(Integer.toString(monster.getDamage()));

            JLabel monster_img = new JLabel(new ImageIcon(monster.getImagepath()));
            JLabel monster_name = new JLabel("monster name");

            {
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
            }

        }
    }
}