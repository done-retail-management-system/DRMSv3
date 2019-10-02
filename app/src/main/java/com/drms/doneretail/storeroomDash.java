package com.drms.doneretail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class storeroomDash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storeroom_dash);
    }


    public void checkIn(View view) {
        Toast.makeText(getApplicationContext(),"Starting Check-in process",Toast.LENGTH_LONG).show();

        startActivity(new Intent(getApplicationContext(), ScannerBarcode.class));



    }

    public void orders(View view) {
        Toast.makeText(getApplicationContext(),"I work from Orders",Toast.LENGTH_LONG).show();
    }

    public void stock(View view) {
        Toast.makeText(getApplicationContext(),"I work from stock",Toast.LENGTH_LONG).show();
    }
}
