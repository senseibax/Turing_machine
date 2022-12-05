package com.company;


import java.util.Scanner;

public class Main
    {
        private static MainFrame mainFrame;
        public static void main(String[] args) throws InterruptedException {
            Scanner in=new Scanner(System.in);
            mainFrame=new MainFrame();
            mainFrame.setVisible(true);
        }
        public static void showEnterTextPage(){
            mainFrame.turingMechanismPage.setVisible(false);
            mainFrame.enterTextPage.setVisible(true);
        }

        public static void showTuringMechanismPage()  {
            mainFrame.enterTextPage.setVisible(false);
            mainFrame.turingMechanismPage.setVisible(true);
        }
    }


