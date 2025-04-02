package com.model;

import java.time.LocalDateTime;

public class Action {
    private LocalDateTime dateTime;
    private int amountMoved;
    
    public Action(LocalDateTime dateTime, int amountMoved) {
        this.dateTime = dateTime;
        this.amountMoved = amountMoved;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getAmountMoved() {
        return amountMoved;
    }

    public void setAmountMoved(int amountMoved) {
        this.amountMoved = amountMoved;
    }

    @Override
    public String toString() {
        return "Action [dateTime=" + dateTime + ", amountMoved=" + amountMoved + "]";
    }
}
