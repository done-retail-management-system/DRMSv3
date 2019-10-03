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
        recyclerView = findViewById(R.id.rcyl);

        dashList = new ArrayList<>(); // set the Dashboard CardView
        String top[] = {"Stock On Hand", "Shelf Management", "o"};
        int pic[] = {R.drawable.instock, R.drawable.on_shelf, R.drawable.outofstock};

        for(int i = 0; i < top.length; i++)
        {
            DataS dataModel = new DataS();
            dataModel.setTop(top[i]);
            dataModel.setPic(pic[i]);
            dashList.add(dataModel);
        }// Loop for items on the dash

        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        cap = new DashCap();
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(cap);
    }


    public void warehouse(View view) {
        Toast.makeText(getApplicationContext(), "I work from WAREHOUSE", Toast.LENGTH_LONG).show();
    }

    public void store(View view) {
        openStoreroom();
    }

    public void shelf(View view) {
        Toast.makeText(getApplicationContext(), "I work from SHELF", Toast.LENGTH_LONG).show();
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
