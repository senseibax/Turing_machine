package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class TuringMechanismPage extends Container implements Runnable {
    public ArrayList<ConditionForMachine> conditions=new ArrayList<>();
    private Thread thread;
    JButton left;
    JButton right;
    JButton back;
    JButton changeCurrent;
    JButton deleteCurrent;
    JTextField forChange;
    JButton start;
    public static String text="";
    public int startx=100;
    public int y=180;
    public int ind=4;
    public boolean isLeft=true;
    void init(){
        conditions.add(new ConditionForMachine('%','0',true,false));
        conditions.add(new ConditionForMachine('$','0',true,false));
        conditions.add(new ConditionForMachine('0','0',true,false));
        conditions.add(new ConditionForMachine('1','1',true,false));
        conditions.add(new ConditionForMachine('#','#',false,false));
    }

    TuringMechanismPage() throws InterruptedException {
        thread=new Thread(this);
        init();
        setSize(700, 500);
        setLayout(null);

        left=new JButton("left");
        left.setBounds(50,250,100,50);
        left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leftMoveOperation();
            }
        });
        add(left);

        start =new JButton("start");
        start.setBounds(50,310,100,50);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thread.start();
            }
        });
        add(start);
        right=new JButton("right");
        right.setBounds(170,250,100,50);
        right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rightMoveOperation();
            }
        });
        add(right);

        back=new JButton("back");
        back.setBounds(170,310,100,50);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.showEnterTextPage();;
            }
        });
        add(back);

        deleteCurrent=new JButton("delete current");
        deleteCurrent.setBounds(290,250,100,50);
        deleteCurrent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               deleteOperation();
            }
        });
        add(deleteCurrent);

        forChange=new JTextField("#");
        forChange.setBounds(410,310,100,50);
        add(forChange);

        changeCurrent=new JButton("change current");
        changeCurrent.setBounds(410,250,100,50);
        changeCurrent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               changeOperation();
            }
        });
        add(changeCurrent);
        repaint();

    }

    public void paint(Graphics g){
        super.paint(g);
        int x=startx;
        for(int i=0;i<9;i++){
            g.drawString(String.valueOf(text.charAt(i+ind-4)),x, y);
            x += 50;
        }
        g.drawLine(303,160,303,80);
        g.drawLine(303,160,293,150);
        g.drawLine(303,160,313,150);
        left.setVisible(true);
        right.setVisible(true);
    }


    public void run()  {
        int temp=ind;
        while(true) {
            if(text.charAt(ind)=='#') break;
            boolean notExist=true;
            for (int i = 0; i < conditions.size(); i++) {
                if (conditions.get(i).getCurr()==text.charAt(ind)){
                    changeOperation(conditions.get(i).getNewValue());
                    if(conditions.get(i).isMoveRight()) rightMoveOperation();
                    if(conditions.get(i).isMoveLeft()) leftMoveOperation();
                    notExist=false;
                    break;
                }
            }
            if(notExist) break;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            repaint();
        }
        while(temp!=ind){
            if(temp>ind) rightMoveOperation();
            else leftMoveOperation();
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            repaint();
        }
    }

    public void leftMoveOperation(){
        if(ind!=4)ind--;
        else text="#"+text;
        repaint();
    }

    public void rightMoveOperation(){
        ind++;
        text+="#";
        repaint();
    }

    public void deleteOperation(){
        text=text.substring(0,ind)+'#'+text.substring(ind+1);
        repaint();
    }

    public void changeOperation(){
        if(forChange.getText().length()>0)
            text=text.substring(0,ind)+ forChange.getText().charAt(0)+text.substring(ind+1);
        else text=text.substring(0,ind)+'#'+text.substring(ind);

        repaint();
    }

    public void changeOperation(char val){
        if(forChange.getText().length()>0)
            text=text.substring(0,ind)+ val+text.substring(ind+1);
        else text=text.substring(0,ind)+'#'+text.substring(ind+1);

        repaint();
    }
}
