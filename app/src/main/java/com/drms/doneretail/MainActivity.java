package com.drms.doneretail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<modelData> dashModelArrayList;
    RecyclerView recyclerView;
    dashAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvl);

        dashModelArrayList = new ArrayList<>();
        String heads[] = {"Warehouse Management", "Store Room Management", "Shelf Management", "Point of Sale", "Settings"};
        int Images[] = {R.drawable.warehousing, R.drawable.stock, R.drawable.shelf, R.drawable.pos, R.drawable.logo};

        for(int i = 0; i < heads.length; i++)
        {
            modelData dataModel = new modelData();
            dataModel.setHead(heads[i]);
            dataModel.setImage(Images[i]);
            dashModelArrayList.add(dataModel);
        }

        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        adapter = new dashAdapter(dashModelArrayList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }
}
