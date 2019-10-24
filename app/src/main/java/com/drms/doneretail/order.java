package com.drms.doneretail;

public class order {
    private int order_id;
    private int shop_id;
    private int product_id;
    private int quantity;
    private String date_of_order;

    public order(int order_id, int shop_id, int product_id, int quantity, String date_of_order) {
        this.order_id = order_id;
        this.shop_id = shop_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.date_of_order = date_of_order;
    }
    public int getOrder_id() {
        return order_id;
    }
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
    public int getShop_id() {
        return shop_id;
    }
    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }
    public int getProduct_id() {
        return product_id;
    }
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getDate_of_order() {
        return date_of_order;
    }
    public void setDate_of_order(String date_of_order) {
        this.date_of_order = date_of_order;
    }
}
