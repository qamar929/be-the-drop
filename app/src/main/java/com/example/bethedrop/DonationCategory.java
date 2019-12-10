package com.example.bethedrop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import java.util.Locale;

public class DonationCategory extends AppCompatActivity {

    public GridView gridView;

    public static  int CategoryImages[] = {R.drawable.garments,R.drawable.book,R.drawable.toys,R.drawable.blanket};
    public static  String CategoriesName[] = {"Garments" , "Books" , "Toys" , "Winter"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_category);
        Toolbar toolbar = (Toolbar) findViewById(R.id.categoryToolbar);
        setSupportActionBar(toolbar);


        gridView = findViewById(R.id.categoryGridView);

    CategoryAdapter adapter = new CategoryAdapter(this);
    gridView.setAdapter(adapter);

    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(DonationCategory.this,"Category name" + CategoriesName[position],Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(DonationCategory.this,CategoryItems.class);

            startActivity(intent);
        }
    });
    }
}
