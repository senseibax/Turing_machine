package com.company;

public class ConditionForMachine {
    private char curr;
    private char newValue;
    private boolean moveRight;
    private boolean moveLeft;

    public ConditionForMachine(char curr, char newValue, boolean moveRight,boolean moveLeft) {
        this.curr = curr;
        this.newValue = newValue;
        this.moveRight = moveRight;
        this.moveLeft = moveLeft;
    }

    public char getCurr() {
        return curr;
    }

    public char getNewValue() {
        return newValue;
    }

    public boolean isMoveRight() {
        return moveRight;
    }

    public boolean isMoveLeft() {
        return moveLeft;
    }
}
