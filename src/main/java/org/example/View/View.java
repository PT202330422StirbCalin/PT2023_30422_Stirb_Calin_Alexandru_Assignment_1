package org.example.View;

import javax.swing.*;

public class View{
    private static JTextField poly1,poly2;
    private static JComboBox operations;
    private static JPanel panel;
    private static JLabel p1,p2,result;
    private static JFrame frame;
    private static JButton calculateButton;

    public View(){
        String[] op ={"","Add","Subtract","Multiply"};
        frame = new JFrame();
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Polynomial Calculator");
        frame.setVisible(true);

        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        p1 = new JLabel("Polynomial 1:");
        p1.setBounds(10,20,80,25);
        panel.add(p1);

        poly1 = new JTextField(165);
        poly1.setBounds(100,20,250,25);
        panel.add(poly1);

        p2 = new JLabel("Polynomial 2:");
        p2.setBounds(10,80,80,25);
        panel.add(p2);

        poly2 = new JTextField(165);
        poly2.setBounds(100,80,250,25);
        panel.add(poly2);

        operations = new JComboBox<>(op);
        operations.setBounds(10,140,100,25);
        panel.add(operations);

        calculateButton = new JButton("Calculate");
        calculateButton.setBounds(120,140,100,25);
        panel.add(calculateButton);

        result = new JLabel("Result:");
        result.setBounds(10,180,250,25);
        panel.add(result);

    }

}
