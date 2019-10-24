package com.drms.doneretail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager; // Help Store my list
import androidx.recyclerview.widget.RecyclerView;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList; // Create Arrays


public class MainActivity extends AppCompatActivity {

    String personName;
    String personGivenName;
    String personFamilyName;
    String personEmail;
    String personId;
    Uri personPhoto;
    ImageView image;
    ImageButton logout;
    GoogleSignInClient mGoogleSignInClient;
    GoogleSignInOptions gso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // image = findViewById(R.id.imageView6);
        logout = findViewById(R.id.logout);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
              personName = acct.getDisplayName();
              personGivenName = acct.getGivenName();
              personFamilyName = acct.getFamilyName();
             personEmail = acct.getEmail();
             personId = acct.getId();
             personPhoto = acct.getPhotoUrl();
             Toast.makeText(getApplicationContext(),"Welcome to Done Retail " + personName ,Toast.LENGTH_LONG).show();
            //Glide.with(this).load(personPhoto).into(image);
        }

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

       logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.logout:
                        signOut();
                        break;
                }
            }
        });

    }

    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(getApplicationContext(),"Signing" + personName + " out of Done Retail" ,Toast.LENGTH_LONG).show();
                        finish();
                    }
                });
    }

    public void warehouse(View view) {

        Toast.makeText(getApplicationContext(), "I work from WAREHOUSE", Toast.LENGTH_LONG).show();
        Intent wareIntent = new Intent(this, WarehouseActivity.class);
        startActivity(wareIntent);
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


    public void userProfile(View view) {
        Intent userIntent = new Intent(this, userProfile.class);
        startActivity(userIntent);
    }

}
