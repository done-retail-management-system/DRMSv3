package com.drms.doneretail;

public class modelData {
    private String head;
    private int image;

    public modelData() {

    }

    public modelData(String head, int image) {
        this.head = head;
        this.image = image;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
