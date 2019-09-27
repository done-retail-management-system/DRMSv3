package com.drms.doneretail;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AlertController;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DashCap extends RecyclerView.Adapter<DashCap.ViewHolder> {

    ArrayList<DataS> dashList;

    public DashCap(ArrayList<DataS> dashList) {
        this.dashList = dashList;
    }


    @NonNull
    @Override
    pub
}