package com.example.dragger11_subcomponent.bean;

public class Pot {

    private Flower flower;

    public Pot(Flower flower) {
        this.flower = flower;
    }

    public String show() {
        return flower.whisper();
    }
}