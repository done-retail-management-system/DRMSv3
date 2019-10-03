package com.drms.doneretail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager; // Help Store my list
import androidx.recyclerview.widget.RecyclerView;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList; // Create Arrays


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



    public void warehouse(View view) {
        //Toast.makeText(getApplicationContext(), "I work from WAREHOUSE", Toast.LENGTH_LONG).show();
        openWarehouse();
    }

    public void store(View view) {
        openStoreroom();
    }

    public void shelf(View view) {
        Intent shelfIntent = new Intent(this, list_Items.class);
        startActivity(shelfIntent);
        Toast.makeText(getApplicationContext(), "Welcome to Shelf Management", Toast.LENGTH_LONG).show();
    }

    public void pos(View view) {
        openPOS();
       // Toast.makeText(getApplicationContext(), "I work from POS", Toast.LENGTH_LONG).show();
    }

    public void openStoreroom()
    {
        Intent storeIntent = new Intent(this, storeroomDash.class);
        startActivity(storeIntent);
        Toast.makeText(getApplicationContext(), "Welcome to Storeroom Management", Toast.LENGTH_LONG).show();  
    }


    public void openPOS()
    {
        Intent POSIntent = new Intent(this, POS_Activity.class);
        startActivity(POSIntent);
        Toast.makeText(getApplicationContext(), "Welcome to Point Of Sale", Toast.LENGTH_LONG).show();
    }

    public void openWarehouse()
    {
        Intent wareIntent = new Intent(this, WarehouseActivity.class);
        startActivity(wareIntent);
        Toast.makeText(getApplicationContext(), "Welcome to Warehouse Management", Toast.LENGTH_LONG).show();
    }


}
