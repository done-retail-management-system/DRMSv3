package com.drms.doneretail;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class StockOnHand extends Fragment {

    private static String[] MOBILE_MODELS = {"REFRESHMENTS","", "Fanta, Flavoured Drink, 440ml, shelf 6","Milk, Dairy, 1L, shelf 5","Redbull, Energy Drink, 473 ml, shelf 6","Coca cola, Flavoured Drink, 2L, shelf 6","Yogi Sip, Flavoured Dairy Drink, 500ml, shelf 5","Monster, Energy Drink, 500ml, shelf 6"};
    Button button;
    private ListView listView;
    private String[] designPatterns;

    public StockOnHand() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_stock_on_hand, container, false);

        ListView listView = (ListView) view.findViewById(R.id.stock_list_view);

        listView.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,MOBILE_MODELS));



        Button addNew = (Button) view.findViewById(R.id.add_new);
        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),AddNewStock.class);
                startActivity(intent);
            }
        });


        return view;
    }

}
