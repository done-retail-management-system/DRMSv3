package com.drms.doneretail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

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
