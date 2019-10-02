package com.drms.doneretail;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

//import androidx.appcompat.app.AlertController;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class DashCap extends RecyclerView.Adapter<DashCap.ViewHolder> {

    ArrayList<DataS> dashlist;

    

    public DashCap(ArrayList<DataS> dashList) {
        this.dashlist = dashlist;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_items, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String ret_head = dashlist.get(position).getTop();
        holder.setHeader(ret_head);

        int ret_img = dashlist.get(position).getPic();
        holder.setImage(ret_img);
    }

    @Override
    public int getItemCount() {
        return dashlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView top;
        ImageView pic;
        View myView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myView = itemView;
        }

        public void setHeader(String h)
        {
            top = myView.findViewById(R.id.header);
            top.setText(h);
        }

        public void setImage(int i)
        {
            pic = myView.findViewById(R.id.image_id);
            pic.setImageResource(i);
        }
    }
}
