package com.drms.doneretail;

public class Products {
    private String barcode;
    private String name;
    private String category;
    private String exp_date;
    private double price;
    private String prod_img;

    public Products(String barcode, String name, String category, String exp_date, double price, String prod_img) {
        this.barcode = barcode;
        this.name = name;
        this.category = category;
        this.exp_date = exp_date;
        this.price = price;
        this.prod_img = prod_img;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getExp_date() {
        return exp_date;
    }

    public void setExp_date(String exp_date) {
        this.exp_date = exp_date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProd_img() {
        return prod_img;
    }

    public void setProd_img(String prod_img) {
        this.prod_img = prod_img;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}
