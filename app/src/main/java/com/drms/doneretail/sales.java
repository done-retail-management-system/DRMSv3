package com.drms.doneretail;

public class sales {

    private int sales_id;
    private String date;
    private String barcode;
    private String transaction_type;
    private double amount;

    public sales(int sale, String date, String bc, String transact, double amm) {
        this.sales_id= sale;
        this.date = date;
        this.barcode = bc;
        this.transaction_type = transact;
        this.amount = amm;
    }

    public int getSales_id() {
        return sales_id;
    }
    public void setSales_id(int sales_id) {
        this.sales_id = sales_id;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getBarcode() {
        return barcode;
    }
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
    public String getTransaction_type() {
        return transaction_type;
    }
    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
