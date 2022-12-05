package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnterTextPage extends Container {
    JTextField textField;
    JLabel label;
    JButton button;
    EnterTextPage(){
        setSize(700,500);
        setLayout(null);

        textField=new JTextField("1%$10%");
        textField.setBounds(200,100,250,30);
        add(textField);

        label=new JLabel("enter your values as text:");
        label.setBounds(200,70,150,30);
        add(label);
         button=new JButton("next");
         button.setBounds(275,140,100,40);
         button.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 String tmp=textField.getText();
                 while(tmp.length()<9){
                     tmp+="#";
                 }
                 tmp="####"+tmp;
                 TuringMechanismPage.text=tmp;

                 Main.showTuringMechanismPage();

             }
         });
         add(button);
    }
}
