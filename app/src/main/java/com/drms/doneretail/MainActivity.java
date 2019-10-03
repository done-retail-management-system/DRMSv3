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

    ArrayList<DataS>dashList;
    RecyclerView recyclerView;
    DashCap cap; // an instance from the DashCap class
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        }


    public void warehouse(View view) {
        Toast.makeText(getApplicationContext(), "I work from WAREHOUSE", Toast.LENGTH_LONG).show();
    }

    public void store(View view) {
        openStoreroom();
    }

    public void shelf(View view) {
        Intent shelfIntent = new Intent(this, list_Items.class);
        startActivity(shelfIntent);
        Toast.makeText(getApplicationContext(), "Welcome to SHELF Management", Toast.LENGTH_LONG).show();
    }

    public void pos(View view) {
        Toast.makeText(getApplicationContext(), "I work from POS", Toast.LENGTH_LONG).show();
    }

    public void openStoreroom()
    {
        Intent storeIntent = new Intent(this, storeroomDash.class);
        startActivity(storeIntent);
        Toast.makeText(getApplicationContext(), "Welcome to Storeroom Management", Toast.LENGTH_LONG).show();  
    }

}
