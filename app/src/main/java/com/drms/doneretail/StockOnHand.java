package com.drms.doneretail;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.text.format.DateFormat;
import java.text.SimpleDateFormat;


/**
 * A simple {@link Fragment} subclass.
 */
public class StockOnHand extends Fragment {


    public StockOnHand() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stock_on_hand, container, false);

    }

}
