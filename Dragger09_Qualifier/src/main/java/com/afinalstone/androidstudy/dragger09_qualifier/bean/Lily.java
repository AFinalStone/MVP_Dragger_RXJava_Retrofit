package com.afinalstone.androidstudy.dragger09_qualifier.bean;

public class Lily extends Flower {

    private String msgLily;

    public Lily(String msgLily) {
        this.msgLily = msgLily;
    }

    @Override
    public String whisper() {
        return "纯洁的百合花";
    }

    @Override
    public String toString() {
        return "Lily{" +
                "msgLily='" + msgLily + '\'' +
                '}';
    }
}