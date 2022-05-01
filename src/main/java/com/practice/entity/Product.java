package com.practice.entity;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class Product {
    private String product_id;// 商品id
    private String name;// 商品名称
    private int price;// 商品价格
    private String sub_title;// 商品标题
    private String main_image;// 商品图片URL
    private String spec;// 商品规格
    private String origin;// 商品产地
    private int stock_quantity;// 商品库存
    private double discount_rate;// 商品折扣率

    public Product() {

    }

    public Product(String product_id, String name, int price, String sub_title, String main_image, String spec, String origin, int stock_quantity, double discount_rate) {
        this.product_id = product_id;
        this.name = name;
        this.price = price;
        this.sub_title = sub_title;
        this.main_image = main_image;
        this.spec = spec;
        this.origin = origin;
        this.stock_quantity = stock_quantity;
        this.discount_rate = discount_rate;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
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

    public String getSub_title() {
        return sub_title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }

    public String getMain_image() {
        return this.main_image;
    }

    public void setMain_image(String main_image) {
           this.main_image = main_image;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public double getDiscount_rate() {
        return discount_rate;
    }

    public void setDiscount_rate(double discount_rate) {
        this.discount_rate = discount_rate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id='" + product_id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", sub_title='" + sub_title + '\'' +
                ", main_image='" + main_image + '\'' +
                ", spec='" + spec + '\'' +
                ", origin='" + origin + '\'' +
                ", stock_quantity=" + stock_quantity +
                ", discount_rate=" + discount_rate +
                '}';
    }
}
