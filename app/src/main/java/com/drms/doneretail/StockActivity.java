package com.drms.doneretail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabItem;


import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class StockActivity extends AppCompatActivity {
    TabLayout tabLayout;
    TabItem tabStockOnHand;
    TabItem tabReturned;
    TabItem tabSummary;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);

        tabLayout = findViewById(R.id.tabLayout);
        tabStockOnHand = findViewById(R.id.tabStockOnHand);
        tabSummary = findViewById(R.id.tabSummary);
        tabReturned = findViewById(R.id.tabReturned);
        viewPager = findViewById(R.id.viewPager);

        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));



    }
}
