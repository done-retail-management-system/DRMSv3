package com.drms.doneretail;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.JsonObject;

public class POS_Activity extends AppCompatActivity{

    private static final String ROOT_URL = "http://localhost/API/";
    public  static final String URL_RETRIEVE = ROOT_URL + "CRUD.php";
    public static String barcode;
    ListView item_cart;
    FloatingActionButton scan_item;
    SimpleAdapter adapt;
    Button pay;
    ImageView searcher;
    ProgressDialog pd;
    TextView txtview;
    String itemName, category, expDate, price;
    public static EditText search;
    RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_pos_);

        item_cart = findViewById(R.id.list_Cart);
        scan_item = findViewById(R.id.btnScan);
        pay = findViewById(R.id.btnPayment);
        search = findViewById(R.id.txtSearch);
        searcher = findViewById(R.id.searchButton);
        txtview = findViewById(R.id.empl_name_surname);
        pd = new ProgressDialog(this);
        pd.setMessage("Loading......");

        queue = Volley.newRequestQueue(this);

        scan_item.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ScannerBarcode.class));
                // Toast.makeText(getApplicationContext(), search.getText(), Toast.LENGTH_LONG).show();
            }

        });
        searcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // getItem();
            }
        });
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Payment_Activity.class);
                startActivity(intent);
            }
        });
    }

    private void getItem(){
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, URL_RETRIEVE, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                pd.dismiss();
                txtview.setText("Response: " + response.toString());
            }
            },
                new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                pd.dismiss();
                Toast.makeText(
                        getApplicationContext(),
                        error.getMessage(),
                        Toast.LENGTH_LONG
                ).show();
            }
        });
        MySingleton.getInstance(POS_Activity.this).addToRequestque(getRequest);
    }

}
