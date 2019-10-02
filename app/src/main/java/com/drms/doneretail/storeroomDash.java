package com.drms.doneretail;

import androidx.appcompat.app.AppCompatActivity;

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
        Toast.makeText(getApplicationContext(),"I span",Toast.LENGTH_LONG).show();

    }
}
