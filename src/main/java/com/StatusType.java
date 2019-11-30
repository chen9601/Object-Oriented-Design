package com;

public enum StatusType {
    HEALTH("체력"),
    POWER("힘"),
    MENTAL("정신력"),
    ENERGY("행동치");

    final private String name;
    StatusType(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
