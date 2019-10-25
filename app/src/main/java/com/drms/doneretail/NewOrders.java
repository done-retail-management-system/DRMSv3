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
public class NewOrders extends Fragment {

    private static String[] Orders = {"ORDERS","", "Order 506","Order 507","Order 508","Order 509", "Order 510", "Order 511", "Order 512"};
    private static String[] PendingOrders = {"PENDING","", "Order 413","Order 301","Order 400","Order 322", "Order 333"};
    public NewOrders() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_new_orders, container, false);
        ListView listView = (ListView) view.findViewById(R.id.list_new_orders);
        ListView listView1 = (ListView) view.findViewById(R.id.list_pending);
        listView.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,Orders));
        listView1.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,PendingOrders));
        return view;
    }

}
