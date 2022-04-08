package com.example.practial.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.practial.R;
import com.example.practial.database.AppDatabase;
import com.example.practial.entity.Product;

import java.util.List;


public class ListViewAdapter extends BaseAdapter {
    private List<Product> listFunctions;
    private Activity activity;
    Context ctx;
    AppDatabase db;

    public ListViewAdapter(List<Product> listFunctions, Activity activity) {
        this.listFunctions = listFunctions;
        this.activity = activity;
    }


    @Override
    public int getCount() {
        return listFunctions.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(R.layout.activity_product, parent, false);
            ViewHolder holder = new ViewHolder();
            holder.txtName = (TextView)convertView.findViewById(R.id.txtName);
            holder.txtQuantity = (TextView)convertView.findViewById(R.id.txtQuantity);
            holder.btnAdd = (Button)convertView.findViewById(R.id.btnAdd);
            holder.btnView = (Button)convertView.findViewById(R.id.btnView);

            convertView.setTag(holder);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        Product model = listFunctions.get(position);
        holder.txtName.setText(model.name);
        holder.txtQuantity.setText(String.valueOf(model.quantity));

        return convertView;
    }

    static class ViewHolder {
        public TextView txtName;
        TextView txtQuantity;

        Button btnAdd, btnView;
    }
}
