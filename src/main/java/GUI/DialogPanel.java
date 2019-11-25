package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class DialogPanel extends JPanel {
    JLabel showLabel = new JLabel("Mac morning");
    JButton turnEnd = new JButton("Turn End");
    JButton selectbtn3 = new JButton("Example3");
    JButton selectbtn2 = new JButton("Example2");
    JButton selectbtn1 = new JButton("Example1");
    public DialogPanel() {
        add(turnEnd);
        add(showLabel);
        add(selectbtn1);
        add(selectbtn2);
        add(selectbtn3);

        showLabel.setBounds(35, 32, 497, 90);
        selectbtn1.setBounds(84, 177, 401, 45);
        selectbtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clear();
            }
        });

        selectbtn2.setBounds(84, 248, 401, 45);
        selectbtn3.setBounds(84, 315, 401, 45);
        turnEnd.setBounds(418, 315, 114, 36);
        turnEnd.setVisible(false);
    }

    void Clear(){
        showLabel.setText("");
        turnEnd.setVisible(true);
        selectbtn1.setVisible(false);
        selectbtn2.setVisible(false);
        selectbtn3.setVisible(false);
    }

    public static void main(String args[]) {
        DialogPanel hi = new DialogPanel();
        hi.setVisible(true);
    }
}
