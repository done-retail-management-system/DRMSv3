package com.drms.doneretail;

public class product_warehouse {
    private int barcode;
    private int quantity;
    private String category;
    private  String type;
    private String weight;
    private String manufacture_name;
    private String expire_date;
    private String location;
    private String fragile;
    private String perishable;

    public product_warehouse(int barcode, int quantity, String category, String type, String weight, String manufacture_name, String expire_date, String location, String fragile, String perishable) {
        this.barcode = barcode;
        this.quantity = quantity;
        this.category = category;
        this.type = type;
        this.weight = weight;
        this.manufacture_name = manufacture_name;
        this.expire_date = expire_date;
        this.location = location;
        this.fragile = fragile;
        this.perishable = perishable;
    }
    public int getBarcode() {
        return barcode;
    }
    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
    public String getManufacture_name() {
        return manufacture_name;
    }
    public void setManufacture_name(String manufacture_name) {
        this.manufacture_name = manufacture_name;
    }
    public String getExpire_date() {
        return expire_date;
    }
    public void setExpire_date(String expire_date) {
        this.expire_date = expire_date;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getFragile() {
        return fragile;
    }
    public void setFragile(String fragile) {
        this.fragile = fragile;
    }
    public String getPerishable() {
        return perishable;
    }
    public void setPerishable(String perishable) {
        this.perishable = perishable;
    }
}
