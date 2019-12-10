package com.example.bethedrop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoryItemAdapter extends BaseAdapter {
    private Context context;
    public CategoryItemAdapter( Context c)
    {
        context = c;

    }

    @Override
    public int getCount() {
        return CategoryItems.images.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.single_category_layout,null);
        ImageView imageView = convertView.findViewById(R.id.imageView);

        TextView textView = convertView.findViewById(R.id.CategoryTitle);
        textView.setText(CategoryItems.names[position]);
        imageView.setImageResource(CategoryItems.images[position]);
        return convertView;
    }
}
