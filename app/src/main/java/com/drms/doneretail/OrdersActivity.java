package com.drms.doneretail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class OrdersActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem tabNewOrders;
    TabItem tabCompleted;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        tabLayout = findViewById(R.id.tabLayout2);
        tabNewOrders = findViewById(R.id.newOrder);
        tabCompleted = findViewById(R.id.completeOrders);
        viewPager = findViewById(R.id.viewPager2);

        OrderPageAdapter PA = new OrderPageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(PA);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}
