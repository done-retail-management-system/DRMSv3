package com.drms.doneretail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import  android.annotation.SuppressLint;
import android.util.Log;
import android.os.StrictMode;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ScannerBarcode extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    ZXingScannerView scan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner_barcode);

        scan = new ZXingScannerView(this);
        setContentView(scan);

    }

    @Override
    public void handleResult(Result result) {
        POS_Activity.barcode = result.getText();
        onBackPressed();



    }

    @Override
    protected void onPause() {
        super.onPause();

        scan.stopCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();

        scan.setResultHandler(this);
        scan.startCamera();
    }

}
