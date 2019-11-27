package com;
import GUI.DialogPanel;
import lombok.Data;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Data
public class DialogPanelController {
    static public DialogPanel dialog_panel;
    static private JLabel lb_just_text;
    static private JButton selectbtn1;
    static private JButton selectbtn2;
    static private JButton selectbtn3;

    public DialogPanelController(){
        dialog_panel = new DialogPanel();
        lb_just_text = dialog_panel.getLb_just_text();
        selectbtn1 = dialog_panel.getSelectbtn1();
        selectbtn2 = dialog_panel.getSelectbtn2();
        selectbtn3 = dialog_panel.getSelectbtn3();
        generateGeneralDialogues();
    }
    // TODO : Clear의 의미를 재 정의 해야할 듯.. 뭔가 어떤 시점에서는 무조건 clear를 한다 이런거?
    static void Clear(){
        lb_just_text.setText("");
        selectbtn1.setText("");
        selectbtn2.setText("");
        selectbtn3.setText("");

        // TODO : 테스트 중
        if(selectbtn1.getActionListeners().length > 0)
            selectbtn1.removeActionListener(selectbtn1.getActionListeners()[0]);
        if(selectbtn2.getActionListeners().length > 0)
            selectbtn2.removeActionListener(selectbtn2.getActionListeners()[0]);
        if(selectbtn3.getActionListeners().length > 0)
            selectbtn3.removeActionListener(selectbtn3.getActionListeners()[0]);
    }

    static void generateGeneralDialogues(){
        Clear();
        // 플레이어가 맨 처음에 위치 이동, 랜덤 이벤트 실행, 턴 종료 총 세가지 이벤트를 처리할 수 있도록 기본적으로 출력되는 것을 세팅한다.

        StringBuilder sb = new StringBuilder();
        sb.append(Player.idx_of_cur_player + 1);
        sb.append("번째 플레이어 차례 입니다.");
        lb_just_text.setText(sb.toString());

        selectbtn1.setText("플레이어 위치 이동");
        selectbtn2.setText("현 위치에서 랜덤 이벤트 발생");
        selectbtn3.setText("이대로 턴 종료");

        selectbtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 플레이어 위치 이동 관련 메소드 타일에서 클릭 가능하게 하는 메소드 호출 이후,
                // 현재 플레이어가 갈 수 있는 위치 출력하는 메소드 출력 등등
                GUI.MainGame_page.show_reddot();
                Clear();
            }
        });

        selectbtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 랜덤 이벤트 관련 메소드 호출
                Clear();
                ConstantEventHandler.generateRandomEvent(Player.getCurrentPlayer());
            }
        });
        selectbtn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 턴 종료 관련 메소드 호출
                Clear();
            }
        });

        lb_just_text.setVisible(true);
        selectbtn1.setVisible(true);
        selectbtn2.setVisible(true);
        selectbtn3.setVisible(true);
    }

    static public void show_dialog(String s){
        lb_just_text.setText(s);
        lb_just_text.setVisible(true);

        dialog_panel.revalidate();
        dialog_panel.repaint();
    };

    // TODO : Refactoring
    static public void show_dialog_answer1(Answer answer){
        selectbtn1.setText(answer.getMessage());
        selectbtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RandomEventAnswer.AnswerIndicator(Player.getCurrentPlayer(), answer);
                dialog_panel.revalidate();
                dialog_panel.repaint();
            }
        });
        selectbtn1.setVisible(true);
    };
    static public void show_dialog_answer2(Answer answer){
        selectbtn2.setText(answer.getMessage());
        selectbtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RandomEventAnswer.AnswerIndicator(Player.getCurrentPlayer(), answer);
                dialog_panel.revalidate();
                dialog_panel.repaint();
            }
        });
        selectbtn2.setVisible(true);
    };
    static public void show_dialog_answer3(Answer answer){
        selectbtn3.setText(answer.getMessage());
        selectbtn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RandomEventAnswer.AnswerIndicator(Player.getCurrentPlayer(), answer);
                dialog_panel.revalidate();
                dialog_panel.repaint();
            }
        });
        selectbtn3.setVisible(true);
    };

    static public int Dice(){
        double randomValue = Math.random();
        int intValue=(int)(randomValue * 6)+1;
        return intValue;
    }

    /*
    @Deprecated
     */
    class SelectBtnListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            Clear();
        }
    }

}
