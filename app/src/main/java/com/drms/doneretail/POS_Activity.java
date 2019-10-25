package com.drms.doneretail;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

import android.net.Uri;
import android.view.Window;
import android.view.WindowManager;

import java.util.Locale;
import java.util.Random;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ArrayAdapter;


import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
//import com.google.gson.JsonObject;

public class POS_Activity extends AppCompatActivity{

    private static final String KEY_SUCCESS = "success";
    private static final String KEY_DATA = "data";
    private static final String KEY_BARCODE = "barcode";
    private static final String KEY_NAME = "name";
    private static final String KEY_LOCATION = "location";
    private static final String KEY_TYPE = "type";
    private static final String KEY_ESTIMATED_SHELFLIFE = "est_shelf";
    private static final String KEY_WEIGHT= "weight";
    private static final String KEY_MANUFACTURE_DATE = "manu_date";
    private static final String KEY_EXPIRE_DATE = "exp_date";
    private static final String KEY_FRAGILE = "fragile";
    private static final String KEY_PERISHABLE = "perish";
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_QUANTITY = "quant";
    private static final String KEY_PRODUCT_IMAGE = "image";
    private static final String ROOT_URL = "http://196.252.124.45/API/";
    private ArrayList<HashMap<String, String>> list_item;
    //public  static final String URL_RETRIEVE = ROOT_URL + "get_all_products.php";
    //public static String barcode;
    ListView item_cart;
    FloatingActionButton scan_item;
    SimpleAdapter adapt;
    Button pay;
    ImageView searcher;
    ProgressDialog pDialog;
    TextView txtview;
    ArrayList products;
    String itemName, category, expDate, price;
    public static EditText search;
  //  RequestQueue queue;
    ImageView stombe;
    TextView timer;
    TextView name;
    String personName;
    TextView tillPoint;
    TextView itemName2, itemCategory, itemExp, itemPrice;
    ImageView cart;
    Uri personPhoto;
    private static final long START_TIMER_MILLI_SEC = 14400000;
    private long timeLeft = START_TIMER_MILLI_SEC;
    private CountDownTimer timeCounter;
    private boolean timer_running;
    public String[] itemsblock;

    Products items;
    ArrayList<Products> listItem = new ArrayList<Products>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_pos_);
        itemName2 = findViewById(R.id.txtItemName);
        itemCategory = findViewById(R.id.txtCategory);
        itemExp = findViewById(R.id.txtExpiry);
        itemPrice = findViewById(R.id.txtPrice);
        cart = findViewById(R.id.imgItem);
        timer = findViewById(R.id.txtHours);
        tillPoint = findViewById(R.id.txtTill);
        stombe = findViewById(R.id.imageView2);
        name = findViewById(R.id.empl_name_surname);
        item_cart = findViewById(R.id.list_Cart);
        scan_item = findViewById(R.id.btnScan);
        pay = findViewById(R.id.btnPayment);
        search = findViewById(R.id.txtSearch);
        searcher = findViewById(R.id.searchButton);
        txtview = findViewById(R.id.empl_name_surname);
        pDialog = new ProgressDialog(this);
       // pD.setMessage("Loading......");


        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            personName = acct.getDisplayName();
            personPhoto = acct.getPhotoUrl();
            //Toast.makeText(getApplicationContext(),"Welcome to Done Retail " + personName ,Toast.LENGTH_LONG).show();
            Glide.with(this).load(personPhoto).into(stombe);
            name.setText(personName);

        }
        startTimer();
        tillPoint.setText("Till Number: " + new Random().nextInt(10));
        //queue = Volley.newRequestQueue(this);

        scan_item.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ScannerBarcode.class));
                TextView txt14 = findViewById(R.id.textView14);
                TextView txt15 = findViewById(R.id.textView15);
                TextView txt21 = findViewById(R.id.textView21);
                TextView txt22 = findViewById(R.id.textView22);
                ImageView image = findViewById(R.id.imageView4);

                txt14.setVisibility(View.GONE);
                txt15.setVisibility(View.GONE);
                txt21.setVisibility(View.GONE);
                txt22.setVisibility(View.GONE);
                image.setVisibility(View.GONE);

                itemCategory.setVisibility(View.VISIBLE);
                itemExp.setVisibility(View.VISIBLE);
                itemName2.setVisibility(View.VISIBLE);
                itemPrice.setVisibility(View.VISIBLE);
                cart.setVisibility(View.VISIBLE);
                TextView text11 = findViewById(R.id.textView11);
                TextView text10 = findViewById(R.id.textView10);
                EditText editText = findViewById(R.id.editText);
                text11.setVisibility(View.VISIBLE);
                text10.setVisibility(View.VISIBLE);
                editText.setVisibility(View.VISIBLE);

                // Toast.makeText(getApplicationContext(), search.getText(), Toast.LENGTH_LONG).show();
            }

        });
        searcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Payment_Activity.class);
                startActivity(intent);
              //  getItem();
                //txtview.setText(itemName);

              //  new FetchMoviesAsyncTask().execute();
            }
        });


    }
    public void searchArray(ArrayList<Products> products, Products items){
        for(Products p: products){
            if(p.equals(items)){
                itemName2.setText(p.getName());
                itemCategory.setText(p.getCategory());
                itemExp.setText(p.getExp_date());
                String price = "R"+ p.getPrice();
                itemPrice.setText(price);
            }
        }
    }
    public void startTimer(){
        timeCounter= new CountDownTimer(timeLeft, 1000) {
            @Override
            public void onTick(long secUntilFinish) {
                timeLeft = secUntilFinish;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timer_running = false;

            }
        }.start();

        timer_running = true;
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeft / 1000) / 60;
        int seconds = (int) (timeLeft / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        timer.setText(timeLeftFormatted);
    }

    private class FetchMoviesAsyncTask extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Display progress bar
            pDialog = new ProgressDialog(POS_Activity.this);
            pDialog.setMessage("Loading movies. Please wait...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            JSONParcer httpJsonParser = new JSONParcer();
            java.lang.String bar = "9002490218638";
            JSONObject jsonObject = httpJsonParser.makeHttpRequest(
                    ROOT_URL + "get_all_products", "GET", null);
            try {
                int success = jsonObject.getInt(KEY_SUCCESS);
                JSONArray prod_items;
                if (success == 1) {
                    products = new ArrayList<>();
                    prod_items = jsonObject.getJSONArray(KEY_DATA);
                    //Iterate through the response and populate prod_items list
                    for (int i = 0; i < prod_items.length(); i++) {
                        JSONObject movie = prod_items.getJSONObject(i);
                        String barcode = movie.getString(KEY_BARCODE);
                        String name = movie.getString(KEY_NAME);
                        String loca = movie.getString(KEY_LOCATION);
                        String type = movie.getString(KEY_TYPE);
                        String est = movie.getString(KEY_ESTIMATED_SHELFLIFE);
                        String weight = movie.getString(KEY_MANUFACTURE_DATE);
                        String manu = movie.getString(KEY_MANUFACTURE_DATE);
                        String exp = movie.getString(KEY_EXPIRE_DATE);
                        String fra = movie.getString(KEY_FRAGILE);
                        String per = movie.getString(KEY_PERISHABLE);
                        String quan = movie.getString(KEY_QUANTITY);
                        String img = movie.getString(KEY_PRODUCT_IMAGE);
                        HashMap<String, String> map = new HashMap<String, String>();
                        map.put(KEY_BARCODE, barcode);
                        map.put(KEY_NAME, name);
                        map.put(KEY_LOCATION, loca);
                        map.put(KEY_TYPE, type);
                        map.put(KEY_ESTIMATED_SHELFLIFE, est);
                        map.put(KEY_WEIGHT, weight);
                        map.put(KEY_MANUFACTURE_DATE, manu);
                        map.put(KEY_EXPIRE_DATE, exp);
                        map.put(KEY_FRAGILE, fra);
                        map.put(KEY_PERISHABLE, per);
                        map.put(KEY_QUANTITY, quan);
                        map.put(KEY_PRODUCT_IMAGE, img);


                        products.add(map);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(String result) {
            pDialog.dismiss();
            runOnUiThread(new Runnable() {
                public void run() {
                    populateMovieList();
                }
            });
        }

    }

    /**
     * Updating parsed JSON data into ListView
     * */
    private void populateMovieList() {
        ListAdapter adapter = new SimpleAdapter(
                POS_Activity.this, list_item,
                R.layout.list_item, new String[]{KEY_BARCODE,
                KEY_NAME, KEY_LOCATION, KEY_TYPE, KEY_ESTIMATED_SHELFLIFE, KEY_WEIGHT, KEY_MANUFACTURE_DATE, KEY_EXPIRE_DATE, KEY_FRAGILE, KEY_PERISHABLE, KEY_QUANTITY, KEY_PRODUCT_IMAGE},
                new int[]{R.id.bar, R.id.name, R.id.pos, R.id.type, R.id.est, R.id.weight, R.id.bar, R.id.manu, R.id.exp, R.id.fra, R.id.per, R.id.quan, R.id.img});
        // updating listview
        item_cart.setAdapter(adapter);
        //Call MovieUpdateDeleteActivity when a movie is clicked
        item_cart.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (CheckNetworkStatus.isNetworkAvailable(getApplicationContext())) {
                    String movieId = ((TextView) view.findViewById(R.id.bar))
                            .getText().toString();
                    Intent intent = new Intent(getApplicationContext(),
                            POS_Activity.class);
                    intent.putExtra(KEY_BARCODE, movieId);
                    startActivityForResult(intent, 20);

                } else {
                    Toast.makeText(POS_Activity.this,
                            "Unable to connect to internet",
                            Toast.LENGTH_LONG).show();

                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 20) {
            // If the result code is 20 that means that
            // the user has deleted/updated the movie.
            // So refresh the movie listing
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }
    }

    /*private void getItem(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_RETRIEVE, new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {
                pd.dismiss();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("product");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject jo = array.getJSONObject(i);
                        itemName = jo.getString("Name");
                        category = jo.getString("Category");
                        expDate = jo.getString("Expiry_Date");
                        price = jo.getString("Quantity");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                error.getMessage();
            }

        });
        MySingleton.getInstance(this).addToRequestque(stringRequest);
        Toast.makeText(getApplicationContext(), search.getText(), Toast.LENGTH_LONG).show();
    }*/

}
