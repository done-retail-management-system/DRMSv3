package com.drms.doneretail;

public class product_shop {
    private int barcode;
    private String name;
    private String category;
    private String type;
    private String weight;
    private String manufacture_date;
    private String expiry_date;
    private String perishable;
    private String fragile;
    private double price;

    public product_shop(int barcode, String name, String category, String type, String weight, String manufacture_date, String expiry_date, String perishable, String fragile) {
        this.barcode = barcode;
        this.name = name;
        this.category = category;
        this.type = type;
        this.weight = weight;
        this.manufacture_date = manufacture_date;
        this.expiry_date = expiry_date;
        this.perishable = perishable;
        this.fragile = fragile;
    }
    public int getBarcode() {
        return barcode;
    }
    public void setBarcode(int barcode) {
        this.barcode = barcode;
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
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getWeight() {
        return weight;
    }
    public void setWeight(String weight) {
        this.weight = weight;
    }
    public String getManufacture_date() {
        return manufacture_date;
    }
    public void setManufacture_date(String manufacture_date) {
        this.manufacture_date = manufacture_date;
    }
    public String getExpiry_date() {
        return expiry_date;
    }
    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }
    public String getPerishable() {
        return perishable;
    }
    public void setPerishable(String perishable) {
        this.perishable = perishable;
    }
    public String getFragile() {
        return fragile;
    }
    public void setFragile(String fragile) {
        this.fragile = fragile;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
