package com;

import GUI.DialogPanel;
import lombok.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Data
public class FightDialogPanelController extends DialogPanelController{
    class FightDialog extends DialogPanel {
        FightDialog(){
            setLayout(new GridLayout(4, 1, 0, 0));
            add(lb_just_text);
            add(selectbtn1);
            add(selectbtn2);
            add(selectbtn3);
        }
    }
    public FightDialogPanelController(){
        dialog_panel = new FightDialog();
        lb_just_text = dialog_panel.getLb_just_text();
        selectbtn1 = dialog_panel.getSelectbtn1();
        selectbtn2 = dialog_panel.getSelectbtn2();
        selectbtn3 = dialog_panel.getSelectbtn3();
        getplayerAttackDialog();
    }

    public static void show_dialog_answer1(String message){
        selectbtn1.setText(message);
        selectbtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clear();
                FightDialogPanelController.show_dialog("데미지를 입히지 못했습니다.");
                dialog_panel.revalidate();
                dialog_panel.repaint();
            }
        });
        selectbtn1.setVisible(true);
    }

    public static void getplayerAttackDialog(){
        FightDialogPanelController.Clear();
        FightDialogPanelController.show_dialog("플레이어 턴!");
        FightDialogPanelController.show_dialog_answer1(new Answer("몬스터를 공격한다.", "attack_monster"));
    }


}
