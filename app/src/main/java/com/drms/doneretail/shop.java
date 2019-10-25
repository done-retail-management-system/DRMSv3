package com.drms.doneretail;

public class shop {
    private int shop_id;
    private String shop_name;
    private String contact_number;
    private String contact_person;
    private String address;

    public shop(int shop_id, String shop_name, String contact_number, String contact_person, String address) {
        this.shop_id = shop_id;
        this.shop_name = shop_name;
        this.contact_number = contact_number;
        this.contact_person = contact_person;
        this.address = address;
    }
    public int getShop_id() {
        return shop_id;
    }
    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }
    public String getShop_name() {
        return shop_name;
    }
    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }
    public String getContact_number() {
        return contact_number;
    }
    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }
    public String getContact_person() {
        return contact_person;
    }
    public void setContact_person(String contact_person) {
        this.contact_person = contact_person;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
