package com.example.bethedrop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class CategoryItems extends AppCompatActivity {

static  final String KEY_NAME="name";
static  final String KEY_IMG="image";
    GridView gridView;
    public static  int images[] = {R.drawable.jacket,R.drawable.shirt,R.drawable.blanket};
    public  static  String names[] = {"Jackets","Shirts","Blanket"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_items);

gridView = findViewById(R.id.categoryitemGridView);


        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        final SharedPreferences.Editor editor = pref.edit();
CategoryItemAdapter adapter = new CategoryItemAdapter(this);
gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CategoryItems.this,"Category name" + names[position],Toast.LENGTH_SHORT).show();
                editor.putString(KEY_NAME, names[position]); // Storing string
                editor.putInt(KEY_IMG, images[position]); // Storing integer
                editor.commit();
                Intent intent = new Intent(CategoryItems.this,DonorHomeActivity.class);

                startActivity(intent);
            }
        });

    }
}
