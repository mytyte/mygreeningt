package com.example.myapplication02;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductdAdapter extends  RecyclerView.Adapter<ProductdAdapter.ViewHolder> implements OnProductItemClickListener{
    ArrayList<Productmain> items = new ArrayList<Productmain>();
    OnProductItemClickListener listener;

    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.product_item, parent, false);
        return new ViewHolder(itemView, this);
    }

    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Productmain item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }   // getItemCount() - 전체 데이터 갯수 리턴.
    public void addItem(Productmain item){
        items.add(item);
    }
    public void setItems(ArrayList<Productmain> items){
        this.items = items;
    }
    public Productmain getItem(int position){
        return items.get(position);
    }
    public void setItem(int position,Productmain item){
        items.set(position,item);
    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if(listener != null){
            listener.onItemClick(holder, view, position);
        }
    }
    public void setOnItemClickListener(OnProductItemClickListener listener){
        this.listener = listener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textName;
        TextView textCost;

        public ViewHolder(View itemView, final OnProductItemClickListener listener){
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textName = itemView.findViewById(R.id.textName);
            textCost = itemView.findViewById(R.id.textCost);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if(listener != null){
                        listener.onItemClick(ViewHolder.this, view,position);
                    }
                }
            });
        }
        public void setItem(Productmain item){
            textName.setText(item.getName());
            textCost.setText(item.getCost());
            imageView.setImageResource(item.getPic());
        }
    }
}
