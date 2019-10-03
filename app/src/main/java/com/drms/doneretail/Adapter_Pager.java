package com.drms.doneretail;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Adapter_Pager extends FragmentPagerAdapter {

    private int tabNum;
    public Adapter_Pager(FragmentManager fm, int numTab) {
        super(fm);
        this.tabNum = numTab;

    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new QR_PaytypeFragment();
            case 1:
                return new CreditCardFragment();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return tabNum;
    }
}
