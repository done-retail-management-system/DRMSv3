package com.drms.doneretail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

public class SuppliersActivity extends AppCompatActivity {


    private ListView listView;
    private String[] designPatterns;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suppliers);


        // Find the list view
        this.listView = (ListView) findViewById(R.id.list_suppliers);

        // Create the arrays
        this.designPatterns = getResources().getStringArray(R.array.supplier_base);

        // Create an array adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, designPatterns);
        listView.setAdapter(adapter);


    }
}
