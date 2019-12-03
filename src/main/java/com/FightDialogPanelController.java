package com;

import GUI.DialogPanel;
import lombok.Builder;
import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Data
public class FightDialogPanelController extends DialogPanelController{
    class FightDialog extends DialogPanel {
        FightDialog(){
            setLayout(new GridLayout(4, 1, 0, 20));
        }
    }

    static JLabel lb_just_text;
    static JButton selectbtn1;
    static JButton selectbtn2;
    static JButton selectbtn3;
    static Monster monster;
    public static FightDialog dialog_panel;
    public FightDialogPanelController(Monster monster) {
        this.monster = monster;
        dialog_panel = new FightDialog();
        lb_just_text = dialog_panel.getLb_just_text();
        selectbtn1 = dialog_panel.getSelectbtn1();
        selectbtn2 = dialog_panel.getSelectbtn2();
        selectbtn3 = dialog_panel.getSelectbtn3();
        Clear();

        StringBuilder message=new StringBuilder();
        message.append(monster.getMonster_type().getName());
        message.append("와(과) 마주쳤다!");
        show_dialog(message.toString());
        show_dialog_answer1(new Answer("몬스터를 공격한다.", "attack"));
        show_dialog_answer2(new Answer("도망친다.","run"));
    }

    public static void Clear(){
        lb_just_text.setText("");
        selectbtn1.setText("");
        selectbtn2.setText("");
        selectbtn3.setText("");

        if(selectbtn1.getActionListeners().length > 0)
            selectbtn1.removeActionListener(selectbtn1.getActionListeners()[0]);
        if(selectbtn2.getActionListeners().length > 0)
            selectbtn2.removeActionListener(selectbtn2.getActionListeners()[0]);
        if(selectbtn3.getActionListeners().length > 0)
            selectbtn3.removeActionListener(selectbtn3.getActionListeners()[0]);
    }

    public static void show_dialog(String message){
        lb_just_text.setText(message);
        lb_just_text.setVisible(true);

        dialog_panel.revalidate();
        dialog_panel.repaint();
    }

    public static void show_dialog_answer1(Answer answer){
        selectbtn1.setText(answer.getMessage());
        selectbtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RandomEventAnswer.AnswerIndicator(Player.getCurrentPlayer(), answer);
                selectbtn1.revalidate();
                selectbtn1.repaint();
                if(Player.getCurrentPlayer().getHealth()<1||FightDialogPanelController.monster.getHealth()<1)
                {
                    FightMonsterController.fight_monster_page.dispose();
                }
            }
        });
        selectbtn1.setVisible(true);
    }

    public static void show_dialog_answer2(Answer answer){
        selectbtn2.setText(answer.getMessage());
        selectbtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RandomEventAnswer.AnswerIndicator(Player.getCurrentPlayer(), answer);
                selectbtn2.revalidate();
                selectbtn2.repaint();
            }
        });
        selectbtn2.setVisible(true);
    }
    public static void getplayerAttackDialog(){

    }
}
