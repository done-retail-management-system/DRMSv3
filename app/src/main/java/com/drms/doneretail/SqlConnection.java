package com.drms.doneretail;

import  android.annotation.SuppressLint;
import android.util.Log;
import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {

    String server_port, database,user,pass;

    @SuppressLint("NewApi")
    public Connection Conn(){
        server_port = "drms.database.windows.net";
        database = "DRMS";
        user = "adminDRMS@drms";
        pass = "Thapelo@05";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Connection conn = null;
        String connURL = null;

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            connURL = "jdbc:jtds:sqlserver://" + server_port +";databaseName=" + database + ";user=" + user + ";password=" + pass + ";";

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
