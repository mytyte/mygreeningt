package com.example.myapplication02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.CustomViewHolder> {

    private ArrayList<Productmain> arrayList;
    private Context context;

    public ProductAdapter(ArrayList<Productmain> arrayList, MainhomeActivity mainhomeActivity) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getProfile())
                .into(holder.iv_profile);
        holder.productName.setText(arrayList.get(position).getProductName());
        holder.tv_cost.setText(String.valueOf(arrayList.get(position).getCost()));


    }

    @Override
    public int getItemCount() {
        //삼합연산자
        return (arrayList !=null ? arrayList.size() :0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_profile;
        TextView productName;
        TextView tv_cost;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_profile = itemView.findViewById(R.id.iv_profile);
            this.productName = itemView.findViewById(R.id.productName);
            this.tv_cost = itemView.findViewById(R.id.tv_cost);
        }
    }
}
