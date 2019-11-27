package com;
import GUI.DialogPanel;
import lombok.Data;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Data
public class DialogPanelController {
    private DialogPanel dialog_panel = new DialogPanel();
    private JLabel lb_just_text = dialog_panel.getLb_just_text();
    private JButton selectbtn1 = dialog_panel.getSelectbtn1();
    private JButton selectbtn2 = dialog_panel.getSelectbtn2();
    private JButton selectbtn3 = dialog_panel.getSelectbtn3();

    public DialogPanelController(){
        generateGeneralDialogues();
    }
    // TODO : Clear의 의미를 재 정의 해야할 듯.. 뭔가 어떤 시점에서는 무조건 clear를 한다 이런거?
    void Clear(){
        lb_just_text.setText("");
        selectbtn1.setText("");
        selectbtn2.setText("");
        selectbtn3.setText("");

        lb_just_text.setVisible(false);
        selectbtn1.setVisible(false);
        selectbtn2.setVisible(false);
        selectbtn3.setVisible(false);
    }

    void generateGeneralDialogues(){
        Clear();
        // 플레이어가 맨 처음에 위치 이동, 랜덤 이벤트 실행, 턴 종료 총 세가지 이벤트를 처리할 수 있도록 기본적으로 출력되는 것을 세팅한다.

        JLabel lb_just_text = dialog_panel.getLb_just_text();
        JButton selectbtn1 = dialog_panel.getSelectbtn1();
        JButton selectbtn2 = dialog_panel.getSelectbtn2();
        JButton selectbtn3 = dialog_panel.getSelectbtn3();

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
                Clear();
            }
        });

        selectbtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 랜덤 이벤트 관련 메소드 호출
                Clear();
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
