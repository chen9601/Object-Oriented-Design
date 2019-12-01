package GUI;

import com.*;
import lombok.Data;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

/**
 * boss나 monster와의 전투를 나타내는 페이지이다.
 *  TODO : 파이트 페이지 맘대로 못 나가게 x버튼 제거
 */

@Data
public class Fight_monster_page extends JFrame {


//    public static void main(String[] args) {
//        Fight_monster_page frame = new Fight_monster_page();
//        frame.setVisible(true);
//    }
    FightDialogPanelController fight_dialog_panel_controller;
    MonsterPanel monsterPanel;
    PlayerPanel player_panel;
    Monster monster;
    public Fight_monster_page(Monster monster) {
        this.monster = monster;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.white);
        setBounds(0, 0, 1200, 960);
        getContentPane().setLayout(null);

        fight_dialog_panel_controller = new FightDialogPanelController();
        JPanel dialog_panel = FightDialogPanelController.dialog_panel;
        dialog_panel.setBounds(459, 615, 709, 300);
        getContentPane().add(dialog_panel);

        player_panel = new PlayerPanel(Player.getCurrentPlayer());
        getContentPane().add(player_panel);
        player_panel.setVisible(true);

        monsterPanel = new MonsterPanel(this.monster);
        getContentPane().add(monsterPanel);


//        JButton status = new JButton("status");
//        status.setBounds(91, 38, 158, 45);
//        getContentPane().add(status);
    }


    public class PlayerPanel extends JPanel {
        PlayerPanel(Player player) {
            JLabel lblpower = new JLabel("power");
            JLabel power_text = new JLabel(Integer.toString(player.getPower()));
            JLabel lblhealth = new JLabel("health");
            JLabel health_text = new JLabel(Integer.toString(player.getHealth()));
            JLabel lblmental = new JLabel("mental");
            JLabel mental_text = new JLabel(Integer.toString(player.getMental()));

            ImageIcon player_imgpath;
            ImageIcon player_nameimgpath;

            if (player == Player.getPlayer(0)) {
                player_imgpath = new ImageIcon("src\\main\\java\\GUI\\imgaes\\player1-portrait.png");
                player_nameimgpath = new ImageIcon("src\\main\\java\\GUI\\imgaes\\player1_name.png");
            } else {
                player_imgpath = new ImageIcon("src\\main\\java\\GUI\\imgaes\\player2-portrait.png");
                player_nameimgpath = new ImageIcon("src\\main\\java\\GUI\\imgaes\\player2_img.png");
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
    public class MonsterPanel extends JPanel {
        MonsterPanel(Monster monster) {
//            Monster monster = Map.tiles[Player.getCurrentPlayer().getPos().ordinal()].getSummoned_monster();
            // 테스트를 위해 아래 코드 삽입 항상 다곤과 싸운다.

            JLabel monster_health = new JLabel("Health");
            JLabel monster_health_txt = new JLabel(Integer.toString(monster.getHealth()));

            JLabel monster_power = new JLabel("power");
            JLabel monster_power_txt = new JLabel(Integer.toString(monster.getDamage()));

            JLabel monster_img = new JLabel(new ImageIcon(monster.getImagepath()));
            JLabel monster_name = new JLabel(monster.getMonster_type().getName());

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