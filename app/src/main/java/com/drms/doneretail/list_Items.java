package com.drms.doneretail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class list_Items  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);
    }



    public void checkIn(View view) {
        Intent instock_intent  = new Intent(this, in_stock.class);
        startActivity(instock_intent);
        Toast.makeText(getApplicationContext(), "Showing ALL Products in Stock", Toast.LENGTH_LONG).show();
    }

    public void orders(View view) {
        Intent out_intent  = new Intent(this, out_of_stock.class);
        startActivity(out_intent);
        Toast.makeText(getApplicationContext(), "Showing ALL Products Out of Stock", Toast.LENGTH_LONG).show();
    }

    public void stock(View view) {
        Intent on_shelf  = new Intent(this, on_shelf.class);
        startActivity(on_shelf);
        Toast.makeText(getApplicationContext(), "Showing ALL Products on the SHELF", Toast.LENGTH_LONG).show();
    }
}
