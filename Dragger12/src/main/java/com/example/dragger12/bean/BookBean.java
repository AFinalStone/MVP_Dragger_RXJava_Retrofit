package com.example.dragger12.bean;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/11/14.
 */

public class BookBean {

    public String bookName;
    public int pages;

    @Inject
    public BookBean() {
        this.bookName = "一千零一夜";
        this.pages = 100;
    }

    @Override
    public String toString() {
        return "BookBean{" +
                "bookName='" + bookName + '\'' +
                ", pages=" + pages +
                '}';
    }
}
