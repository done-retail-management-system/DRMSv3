package com.drms.doneretail;


import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.Fragment;

public class PageAdapter extends FragmentPagerAdapter {


    private int numOfTabs;

    //PageAdapter constructor is use to communicate between this class and stockActivity.java.
    public PageAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }


    //getItem is where you will initialize the fragments for Android Tablayout
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new StockOnHand();
            case 1:
                return new ReturnedStock();
            default:
                return null;
        }
    }

    //getCount Will return the number of tabs that will appear in Android Tablayout
    @Override
    public int getCount() {
        return numOfTabs;
    }

}
