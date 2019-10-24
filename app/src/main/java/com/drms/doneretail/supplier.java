package com.drms.doneretail;

public class supplier {
    private int supp_id;
    private String supplier_name;
    private String category;
    private String address;
    private String contact_number;
    private String contact_person;

    public supplier(int supp_id, String supplier_name, String category, String address, String contact_number, String contact_person) {
        this.supp_id = supp_id;
        this.supplier_name = supplier_name;
        this.category = category;
        this.address = address;
        this.contact_number = contact_number;
        this.contact_person = contact_person;
    }

    public int getSupp_id() {
        return supp_id;
    }

    public void setSupp_id(int supp_id) {
        this.supp_id = supp_id;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}
