package com.company;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public EnterTextPage enterTextPage;
    public TuringMechanismPage turingMechanismPage;
    public MainFrame() throws InterruptedException {
        setSize(700,500);
        setLayout(null);
        setTitle("Simple Turing Machine");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        enterTextPage=new EnterTextPage();
        enterTextPage.setVisible(true);
        add(enterTextPage);

        turingMechanismPage=new TuringMechanismPage();
        turingMechanismPage.setVisible(false);
        add(turingMechanismPage);

    }

}
