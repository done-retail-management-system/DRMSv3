package com.drms.doneretail;

import  android.annotation.SuppressLint;
import android.util.Log;
import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class SqlConnection {
    private static final String LOG = "DEBUG";
    private static String ip = "drms.database.windows.net";
    private static String port = "1433";
    private String class_ = "net.sourceforge.jtds.jdbc.Driver";
    private static String db = "DRMS";
    private static String user = "adminDRMS@drms";
    private static String password = "Thapelo@05";

    @SuppressLint("NewApi")
    public Connection Conn(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Connection conn = null;
        String connURL = null;

        try {
            Class.forName(class_);
            connURL = "jdbc:sqlserver://" + ip + ";" + "databaseName=" + db + ";user=" + user + ";password=" + password + ";";

            conn = DriverManager.getConnection(connURL);
        }
        catch (SQLException se ){
            Log.e("ERROR",se.getMessage());
        }
        catch (ClassNotFoundException e ){
            Log.e("ERROR",e.getMessage());
        }
        catch (Exception e){
            Log.e("ERROR",e.getMessage());
        }
        return conn;
    }
}
