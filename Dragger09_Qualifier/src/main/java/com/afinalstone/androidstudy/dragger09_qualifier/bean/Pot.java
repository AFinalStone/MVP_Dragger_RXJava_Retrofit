package com.afinalstone.androidstudy.dragger09_qualifier.bean;

import com.afinalstone.androidstudy.dragger09_qualifier.di.qualifier.RoseFlower;

import javax.inject.Inject;

public class Pot {

    private Flower flower;

//    @Inject
//    public Pot(@RoseFlower Flower flower) {
//        this.flower = flower;
//    }

  @Inject
    public Pot(@RoseFlower Flower flower) {
        this.flower = flower;
    }

    public String show() {
        return flower.whisper();
    }

    @Override
    public String toString() {
        return "Pot{" +
                "flower=" + flower +
                '}';
    }
}