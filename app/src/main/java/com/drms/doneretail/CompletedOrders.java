package com.drms.doneretail;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CompletedOrders extends Fragment {


    public CompletedOrders() {
        // Required empty public constructor
    }

    private static String[] CompletedOrders = {"No orders completed yet"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_completed_orders, container, false);

        ListView listView = (ListView) view.findViewById(R.id.comp_orders_list);
        listView.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,CompletedOrders));
        return view;
    }

}
