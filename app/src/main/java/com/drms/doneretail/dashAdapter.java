package com.drms.doneretail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class dashAdapter extends RecyclerView.Adapter<dashAdapter.ViewHolder> {

    ArrayList<modelData> dashModelArrayList;

    public dashAdapter(ArrayList<modelData> dashModelArrayList) {
        this.dashModelArrayList = dashModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String ret_head = dashModelArrayList.get(position).getHead();
        holder.setHeader(ret_head);
    }

    @Override
    public int getItemCount() {
        return dashModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView head;
        ImageView images;
        View myView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myView = itemView;
        }

        public void setHeader(String h)
        {
            head = myView.findViewById(R.id.header);
            head.setText(h);
        }

        public void setImage(int i)
        {
            images = myView.findViewById(R.id.image_id);
            images.setImageResource(i);
        }
    }
}
