package day20.ListenerLearn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFramDemo {
    public static void main(String[] args) {

        JFrame jFrame = new JFrame();
        jFrame.setSize(300,200);
        jFrame.setLocation(200,200);
        jFrame.setLayout(new FlowLayout());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton jButton = new JButton("确实");

        jFrame.add(jButton);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hello");
            }
        });

        jFrame.setVisible(true);
    }
}
