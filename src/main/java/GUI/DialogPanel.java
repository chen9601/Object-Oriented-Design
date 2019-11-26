package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class DialogPanel extends JPanel {

    private JLabel lb_just_text = new JLabel("Mac morning");
    ArrayList<JButton> btn_options;
//    JButton turnEnd = new JButton("Turn End");
//    JButton selectbtn3 = new JButton("Example3");
//    JButton selectbtn2 = new JButton("Example2");
//    JButton selectbtn1 = new JButton("Example1");
    public DialogPanel() {
//        add(turnEnd);
        AddComponents();

        // TODO : 레이아웃 적용해서 동적으로 위치 선정할 수 있게 변경하기
//        showLabel.setBounds(35, 32, 497, 90);
//        selectbtn1.setBounds(84, 177, 401, 45);
//        selectbtn2.setBounds(84, 248, 401, 45);
//        selectbtn3.setBounds(84, 315, 401, 45);
//        turnEnd.setBounds(418, 315, 114, 36);

//        selectbtn1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Clear();
//                // 다른 다이얼로그가 출력되도록 해야 함.
//            }
//        });

    }
    // https://fora.tistory.com/31 여기 나온 것처럼 이 패널의 controller 만들어서 관리 해야 하나? 아니면 MainGame_page의 패널 만들어서 관리해야 하려나.. 고민해봐야 할 듯

    void AddComponents(){
        this.add(lb_just_text); // TODO : 버튼만 있는 것도 있을 수 있으니 그거 고려해야 할 듯!
        for (JButton btn : btn_options) {
            this.add(btn);
        }
    }

    void Clear(){
        lb_just_text.setVisible(false);
        for (JButton btn : btn_options) {
            btn.setVisible(false); // TODO : 해당 항목 다 지우고 repaint하는 걸로 변경할 것!
        }
    }

    public static void main(String args[]) {
        DialogPanel hi = new DialogPanel();
        hi.setVisible(true);
    }
}
