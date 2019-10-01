package com.drms.doneretail;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentManager;



public class OrderPageAdapter extends FragmentPagerAdapter {

    private int numberOfTabs;

    //PageAdapter constructor is use to communicate between this class and stockActivity.java.
    public OrderPageAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new NewOrders();
            case 1:
                return new CompletedOrders();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
