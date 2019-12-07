package GUI;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

@Getter
@Setter
public class DialogPanel extends JPanel {


    Image dialog;

    {
        try {
            dialog = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/DIALOG-PANEL.PNG"))).getImage();
        } catch (IOException e) {
            dialog = null;
            e.printStackTrace();
        }
    }

    JLabel lb_just_text = new JLabel("Mac morning");
    JButton selectbtn3 = new JButton("Example3");
    JButton selectbtn2 = new JButton("Example2");
    JButton selectbtn1 = new JButton("Example1");




    public DialogPanel() {
      setLayout(null);
//        add(turnEnd);
//        setLayout(new GridLayout(4, 1, 0, 20));

        lb_just_text.setBounds(35, 32, 497, 90);
        selectbtn1.setBounds(84, 177, 401, 45);
        selectbtn2.setBounds(84, 248, 401, 45);
        selectbtn3.setBounds(84, 315, 401, 45);

        add(lb_just_text);
        add(selectbtn1);
        add(selectbtn2);
        add(selectbtn3);

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(dialog, 0, 0, 569, 430, this);
    }

}
