package com.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Action {
    private LocalDate date;
    private LocalTime hour;
    private int amountMoved;

    public Action(LocalDate date, LocalTime hour, int amountMoved) {
        this.date = date;
        this.hour = hour;
        this.amountMoved = amountMoved;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getHour() {
        return hour;
    }

    public int getAmountMoved() {
        return amountMoved;
    }
}
