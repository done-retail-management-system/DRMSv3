package com.drms.doneretail;

import com.google.gson.annotations.SerializedName;

public class product_warehouse {

    @SerializedName("barcode")
    private String barcode;

    @SerializedName("quantity")
    private int quantity;

    @SerializedName("category")
    private String category;

    @SerializedName("type")
    private  String type;

    @SerializedName("weight")
    private String weight;

    @SerializedName("manufacture_name")
    private String manufacture_name;

    @SerializedName("expiry_date")
    private String expire_date;

    @SerializedName("location")
    private String location;

    @SerializedName("fragile")
    private String fragile;

    @SerializedName("perishable")
    private String perishable;

    @SerializedName("manufacture_date")
    private String manufacture_date;

    public product_warehouse(String barcode, int quantity, String category, String type, String weight, String manufacture_name, String expire_date, String location, String fragile, String perishable, String manufacture_date) {
        this.barcode = barcode;
        this.quantity = quantity;
        this.category = category;
        this.type = type;
        this.weight = weight;
        this.manufacture_name = manufacture_name;
        this.manufacture_date = manufacture_date;
        this.expire_date = expire_date;
        this.location = location;
        this.fragile = fragile;
        this.perishable = perishable;
    }
    public String getBarcode() {
        return barcode;
    }
    public void setBarcode(String barcode) {
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

    public String getManufacture_date() {
        return manufacture_date;
    }

    public void setManufacture_date(String manufacture_date) {
        this.manufacture_date = manufacture_date;
    }
}
