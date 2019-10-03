package com.drms.doneretail;

public class DataS {
    private String top;
    private int pic;

    public DataS(){

    } // default  Constructor



    public DataS(String top, int pic){
        this.top = top;
        this.pic = pic;
    }// Class Constructor

    public void setTop(String top) {
        this.top = top;
    }//set top
    public String getTop() {
        return top;
    }// return top

    public void setPic(int pic) {
        this.pic = pic;
    }//set pic
    public int getPic() {
        return pic;
    }//return pic
}
