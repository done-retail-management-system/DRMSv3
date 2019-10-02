package com.drms.doneretail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager; // Help Store my list
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList; // Create Arrays
public class MainActivity extends AppCompatActivity implements DashCap.onDashListner {

    ArrayList<DataS>dashList;
    RecyclerView recyclerView;
    DashCap cap; // an instance from the DashCap class
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rcyl);

        dashList = new ArrayList<>(); // set the Dashboard CardView
        String top[] = {"Products In-Stock", "Products On Shelf", "Products Out-Of-Stock"};
        int pic[] = {R.drawable.instock, R.drawable.on_shelf, R.drawable.outofstock};

        for(int i = 0; i < top.length; i++)
        {
            DataS dataModel = new DataS();
            dataModel.setTop(top[i]);
            dataModel.setPic(pic[i]);
            dashList.add(dataModel);
        }// Loop for items on the dash

        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        cap = new DashCap(dashList, this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(cap);
    }

    @Override
    public void OnActClick(int position) {
        dashList.get(position);
        Intent intent = new Intent();
        startActivity(intent);
    }
}
