package com.example.bethedrop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoryAdapter extends BaseAdapter {


     private Context context;
    public CategoryAdapter( Context c)
    {
        context = c;

    }

    @Override
    public int getCount() {
        return DonationCategory.CategoryImages.length;
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
        textView.setText(DonationCategory.CategoriesName[position]);
        imageView.setImageResource(DonationCategory.CategoryImages[position]);
        return convertView;
    }
}
