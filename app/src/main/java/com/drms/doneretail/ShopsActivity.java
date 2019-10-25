package com.drms.doneretail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

public class ShopsActivity extends AppCompatActivity {

    private ListView listView;
    private String[] designPatterns;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shops);

        // Find the list view
        this.listView = (ListView) findViewById(R.id.list_shops);

        // Create the arrays
        this.designPatterns = getResources().getStringArray(R.array.design_patterns);

        // Create an array adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, designPatterns);
        listView.setAdapter(adapter);



    }
}
