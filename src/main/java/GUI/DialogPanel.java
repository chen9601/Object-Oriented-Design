package GUI;

import lombok.Data;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

@Data
public class DialogPanel extends JPanel {

    JLabel lb_just_text = new JLabel("Mac morning");
    JButton selectbtn3 = new JButton("Example3");
    JButton selectbtn2 = new JButton("Example2");
    JButton selectbtn1 = new JButton("Example1");
    public DialogPanel() {
//        add(turnEnd);
//        setLayout(new GridLayout(4, 1, 0, 20));
        setLayout(null);
        lb_just_text.setBounds(35, 32, 497, 90);
        selectbtn1.setBounds(84, 177, 401, 45);
        selectbtn2.setBounds(84, 248, 401, 45);
        selectbtn3.setBounds(84, 315, 401, 45);

        add(lb_just_text);
        add(selectbtn1);
        add(selectbtn2);
        add(selectbtn3);

    }
}
