package com.afinalstone.androidstudy.dragger08_named.bean;

public class Pot {

    private Flower mFlower;

    public Pot(Flower mFlower) {
        this.mFlower = mFlower;
    }

    public String show() {
        return mFlower.whisper();
    }

    @Override
    public String toString() {
        return "Pot{" +
                "mFlower=" + mFlower +
                '}';
    }
}
