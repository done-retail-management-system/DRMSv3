package com.drms.doneretail;

import androidx.appcompat.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import android.os.Bundle;

public class POS_Activity extends AppCompatActivity {

    String path = "jdbc:sqlserver://drms.database.windows.net:1433;database=DRMS;user=adminDRMS@drms;password=Thapelo@05;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_pos_);
    }
}
