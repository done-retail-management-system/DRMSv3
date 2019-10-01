package com.drms.doneretail;

import  android.annotation.SuppressLint;
import android.util.Log;
import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class SqlConnection {

    private String server_port, database,user,pass;
    public Connection conn ;
    String connURL ;

    public SqlConnection() {
        server_port = "drms.database.windows.net:1433";
        database = "DRMS";
        user = "adminDRMS@drms";
        pass = "Thapelo@05";

        conn = null;
        connURL = null;

        Conn();

    }

    @SuppressLint("NewApi")

    public void Conn(){

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        connURL = "jdbc:sqlserver://" + server_port +";databaseName=" + database + ";user=" + user + ";password=" + pass + ";encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            conn = DriverManager.getConnection(connURL);
        }
        catch (SQLException se ){
           se.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //return conn;
    }
}
