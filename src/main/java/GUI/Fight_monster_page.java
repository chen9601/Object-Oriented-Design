package GUI;

import GUI.music.Mainmusic_thread;
import com.*;
import lombok.Data;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.Fight_boss_controller.*;

/**
 * boss나 monster와의 전투를 나타내는 페이지이다.
 * TODO : 파이트 페이지 맘대로 못 나가게 x버튼 제거
 */

@Data
public class Fight_monster_page extends JFrame {


    //    public static void main(String[] args) {
//        Fight_monster_page frame = new Fight_monster_page();
//        frame.setVisible(true);
//    }
    static FightDialogPanelController fight_dialog_panel_controller;
    MonsterPanel monsterPanel;
    PlayerPanel player_panel;
    static Monster monster;
    public int turn = 0;

    public Fight_monster_page(Monster monster) {
        Mainmusic_thread.thread.close();
        Mainmusic_thread music_thread = new Mainmusic_thread("src\\main\\java\\GUI\\music\\monster_fight.mp3", true);
        music_thread.start();
        this.monster = monster;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.white);
        setBounds(0, 0, 1200, 960);
        getContentPane().setLayout(null);

//        fight_dialog_panel_controller = new FightDialogPanelController(this.monster);
//        JPanel dialog_panel = FightDialogPanelController.dialog_panel;
//        dialog_panel.setBounds(459, 615, 709, 300);
//        getContentPane().add(dialog_panel);

        player_panel = new PlayerPanel(Player.getCurrentPlayer());
        getContentPane().add(player_panel);
        player_panel.setVisible(true);

        monsterPanel = new MonsterPanel(this.monster);
        getContentPane().add(monsterPanel);

        JButton fight = new JButton("싸움시작");
        getContentPane().add(fight);
        fight.setBounds(459, 615, 709, 300);
        fight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turn % 2 == 0) {
                    attackedMonsterByPlayer();
                    System.out.println(Player.getCurrentPlayer());
                    System.out.println("플레이어가 공격했음");
                    turn++;
                } else if (turn % 2 == 1) {
                    attackedPlayerByMonster();
                    System.out.println("몬스터가 플레이어 공격했음");
                    turn++;
                }
                checkWhoWin();
            }
        });


//        JButton status = new JButton("status");
//        status.setBounds(91, 38, 158, 45);
//        getContentPane().add(status);
    }

    private void attackedPlayerByMonster() {
        Player player = Player.getCurrentPlayer();
        int dice_value = ConstantEventHandler.Dice();
        if (dice_value > monster.getRequireVal()) {
            if (monster.getDamageType() == 1) {
                player.setHealth(player.getHealth() - monster.getDamage());
                player_panel.getHealth_text().setText(Integer.toString(player.getHealth()));
            } else if (monster.getDamageType() == 2) {
                player.setMental(player.getMental() - monster.getDamage());
                player_panel.getMental_text().setText(Integer.toString(player.getHealth()));
            }
        }
    }

    private void attackedMonsterByPlayer() {
        int dice_value = ConstantEventHandler.Dice();
        if (dice_value > monster.getRequireVal()) {
            monster.setHealth(monster.getHealth() - (dice_value - monster.getRequireVal()));
            FightMonsterController.fight_monster_page.monsterPanel.getMonster_health_txt().setText(Integer.toString(monster.getHealth()));
        }
    }

    public static void checkWhoWin() {
        if (Player.getCurrentPlayer().getHealth() < 1) {
            System.out.println("플레이어 패배");
            //TODO : 여기에 패배 창 띄우기
            Player.getCurrentPlayer().setStatus(Player.DEAD);
            MainGamePageController.show_players();
            FightMonsterController.fight_monster_page.dispose();
            DialogPanelController.Clear();
            DialogPanelController.generateGeneralDialogues();
            Mainmusic_thread.thread.close();
            Mainmusic_thread music_thread = new Mainmusic_thread("src\\main\\java\\GUI\\music\\Main.mp3", true);
            music_thread.start();
        } else if (monster.getHealth() < 1) {
            // TODO : 여기서 현재 창 모두다 끄고, win 창 띄우기
            System.out.println("몬스터 패배");
            Map.tiles[Player.getCurrentPlayer().getPos().ordinal()].setSummoned_monster(null);
            MainGamePageController.show_monsters();
            FightMonsterController.fight_monster_page.dispose();
            DialogPanelController.Clear();
            DialogPanelController.generateGeneralDialogues();
            Mainmusic_thread.thread.close();
            Mainmusic_thread music_thread = new Mainmusic_thread("src\\main\\java\\GUI\\music\\Main.mp3", true);
            music_thread.start();
        }
    }

    @Getter
    public class PlayerPanel extends JPanel {

        JLabel health_text;
        JLabel mental_text;

        PlayerPanel(Player player) {

            JLabel lblhealth = new JLabel("health");
            health_text = new JLabel(Integer.toString(player.getHealth()));
            JLabel lblmental = new JLabel("mental");
            mental_text = new JLabel(Integer.toString(player.getMental()));

            ImageIcon player_imgpath;
            ImageIcon player_nameimgpath;

            if (player == Player.getPlayer(0)) {
                player_imgpath = new ImageIcon("src\\main\\java\\GUI\\imgaes\\player1-portrait.png");
                player_nameimgpath = new ImageIcon("src\\main\\java\\GUI\\imgaes\\player1_name.png");
            } else {
                player_imgpath = new ImageIcon("src\\main\\java\\GUI\\imgaes\\player2-portrait.png");
                player_nameimgpath = new ImageIcon("src\\main\\java\\GUI\\imgaes\\player2_name.png");
            }


            Image player_tempimg = player_imgpath.getImage();
            Image player_changedimg = player_tempimg.getScaledInstance(194,165,Image.SCALE_SMOOTH);
            JLabel player_img = new JLabel(new ImageIcon(player_changedimg));
            JLabel player_nameimg = new JLabel(player_nameimgpath);




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

    @Getter
    public class MonsterPanel extends JPanel {
        JLabel monster_health_txt;
        JLabel monster_power_txt;
        JLabel monster_name;

        MonsterPanel(Monster monster) {
//            Monster monster = Map.tiles[Player.getCurrentPlayer().getPos().ordinal()].getSummoned_monster();
            // 테스트를 위해 아래 코드 삽입 항상 다곤과 싸운다.

            JLabel monster_health = new JLabel("Health");
            monster_health_txt = new JLabel(Integer.toString(monster.getHealth()));
            JLabel monster_power = new JLabel("power");
            monster_power_txt = new JLabel(Integer.toString(monster.getDamage()));


            ImageIcon monster_originimg = new ImageIcon(monster.getImagepath2());
            JLabel monster_img = new JLabel(monster_originimg);
            monster_name = new JLabel(monster.getMonster_type().getName());

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