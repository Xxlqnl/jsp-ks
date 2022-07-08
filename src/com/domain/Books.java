package com.domain;

public class Books {
    private int id;
    private String img;//图片地址
    private String name;//图书姓名
    private int price;//价格
    private String classly;//分类
    private String detail;//简介

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getClassly() {
        return classly;
    }

    public void setClassly(String classly) {
        this.classly = classly;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
