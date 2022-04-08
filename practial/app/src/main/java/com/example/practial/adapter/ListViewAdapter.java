package com.example.practial.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practial.R;
import com.example.practial.entity.Product;

import java.util.List;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.ViewHolder> {

    Context currentContext;
    List<Product> products;

    public ListViewAdapter(Context currentContext, List<Product> products) {
        this.currentContext = currentContext;
        this.products = products;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(currentContext).inflate(R.layout.activity_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product currentProduct = products.get(position);
        holder.idView.setText(String.valueOf(currentProduct.getId()));
        holder.productNameView.setText(currentProduct.getName());
        holder.productQuantityView.setText(String.valueOf(currentProduct.getQuantity()));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView idView;
        TextView productNameView;
        TextView productQuantityView;

        public ViewHolder(View itemView) {
            super(itemView);
            idView = itemView.findViewById(R.id.product_id);
            productNameView = itemView.findViewById(R.id.product_name);
            productQuantityView = itemView.findViewById(R.id.product_quantity);
        }
    }
}