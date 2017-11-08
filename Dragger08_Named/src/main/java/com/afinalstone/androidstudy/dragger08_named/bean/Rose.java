package com.afinalstone.androidstudy.dragger08_named.bean;

public class Rose extends Flower{

    private String msgRose;

    public Rose(String msgRose){
        this.msgRose = msgRose;
    }

    public String whisper()  {
        return "热恋的红玫瑰";
    }

    @Override
    public String toString() {
        return "Rose{" +
                "msgRose='" + msgRose + '\'' +
                '}';
    }
}