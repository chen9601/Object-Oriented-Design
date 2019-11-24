package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Show_DialogPanel extends JFrame {
    JLabel showLabel = new JLabel("Mac morning");
    JButton turnEnd = new JButton("Turn End");
    JButton selectbtn3 = new JButton("Example3");
    JButton selectbtn2 = new JButton("Example2");
    JButton selectbtn1 = new JButton("Example1");

    public Show_DialogPanel() {
        setBounds(100, 100, 569, 430);
        getContentPane().setLayout(null);

        showLabel.setBounds(35, 32, 497, 90);
        getContentPane().add(showLabel);

        selectbtn1.setBounds(84, 177, 401, 45);
        getContentPane().add(selectbtn1);
        selectbtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Clear();
            }
        });

        selectbtn2.setBounds(84, 248, 401, 45);
        getContentPane().add(selectbtn2);

        selectbtn3.setBounds(84, 315, 401, 45);
        getContentPane().add(selectbtn3);

        turnEnd.setBounds(418, 315, 114, 36);
        getContentPane().add(turnEnd);
        turnEnd.setVisible(false);

    }

    public void Clear() {
        showLabel.setText("");
        turnEnd.setVisible(true);
        selectbtn1.setVisible(false);
        selectbtn2.setVisible(false);
        selectbtn3.setVisible(false);
    }

    public static void main(String args[]) {
        Show_DialogPanel hi = new Show_DialogPanel();
        hi.setVisible(true);

    }
}
