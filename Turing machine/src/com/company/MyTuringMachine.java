package com.company;

import java.util.ArrayList;
import java.util.List;

public class MyTuringMachine {
    private int head;
    private List<Character> symbols;
    MyTuringMachine(String text){
        head=0;
        symbols=new ArrayList<>();
        while(!text.isEmpty()){
            symbols.add(text.charAt(0));
            text=text.substring(1);
        }
        System.out.println(symbols);
    }
    public void getCurrentSymbol(){
        System.out.println( symbols.get(head));
        printSymbols();
    }
    public void changeValue(char newx){
        symbols.set(head,newx);
        printSymbols();
    }
    public void deleteValue(){
        changeValue('#');
        printSymbols();
    }
    public void changeHeadToLeft(){

        if(head==0) symbols.add(0,'#');
        else head--;
        printSymbols();
    }
    public void changeHeadToRight(){
        head++;
        if(head==symbols.size())  symbols.add('#');
        printSymbols();
    }
    public void printSymbols(){
        System.out.print("[");
        for(int i=0;i<symbols.size();i++){
            if(i==head) System.out.print(" ->"+symbols.get(i)+"<-  ");
            else if(i!=symbols.size()-1) System.out.print(symbols.get(i)+", ");
            else System.out.println(symbols.get(i)+"]");
        }
        System.out.println("head equals to "+head);
        System.out.println();
        System.out.println();
    }
}
