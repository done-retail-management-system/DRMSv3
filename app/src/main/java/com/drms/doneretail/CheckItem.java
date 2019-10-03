package com.drms.doneretail;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class CheckItem{

    String check;
    Boolean suceeded;
    SqlConnection conn;
    Connection connect;


    //Toast.makeText(ScannerBarcode.this, "Item Successfully Added", Toast.LENGTH_LONG).show();

    public List<Map<String,String>> doInBackground() {

        List<Map<String,String>> data = null;
        data = new ArrayList<Map<String,String>>();

        try {
            conn = new SqlConnection();

            connect = conn.conn;

            if (connect == null){
                check = "Check your internet Access";
                suceeded = false;
            }
            else{

                String sqlQuery = "select * from salesTbl where barcodes = 5449000172167";
                Statement stmt = connect.createStatement();
                ResultSet set = stmt.executeQuery(sqlQuery);

                if (set.next()){
                    Map<String,String> data_type = new HashMap<String,String>();
                    data_type.put("Sales Number", set.getString("sales_ID"));
                    data_type.put("Date", set.getString("date"));
                    data_type.put("Total Price", set.getString("amount"));
                    data.add(data_type);

                    check = "Success";
                    suceeded = true;
                    connect.close();
                }
                else{
                    check = "item not found";
                    suceeded = false;
                }
            }
        }
        catch(Exception ex){
            suceeded = false;
            check = ex.getMessage();
        }
        return data;
    }
}
