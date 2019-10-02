package com.drms.doneretail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Payment_Activity extends AppCompatActivity {

    TabLayout tab;
    TabItem item1, item2;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_);

        tab = findViewById(R.id.paymentTab);
        item1 = findViewById(R.id.tabQR);
        item2 = findViewById(R.id.tabCredit);
        pager = findViewById(R.id.viewPayment_Method);

        Adapter_Pager adapter = new Adapter_Pager(getSupportFragmentManager(),tab.getTabCount());
        pager.setAdapter(adapter);
        pager.addOnAdapterChangeListener((ViewPager.OnAdapterChangeListener) new TabLayout.TabLayoutOnPageChangeListener(tab));
    }
}
