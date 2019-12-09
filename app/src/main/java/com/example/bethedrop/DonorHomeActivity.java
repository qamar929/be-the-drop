package com.example.bethedrop;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DonorHomeActivity extends AppCompatActivity {
    private DrawerLayout drawer;

    Spinner spinner;
    private ImageView imageView;
    Button selectPhoto;
    RadioGroup radioGroupCondition;
    RadioButton selectedButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_home);

       /// Toolbar toolbar = (Toolbar) findViewById(R.id.Donortoolbar);
    //   setSupportActionBar(toolbar);


        //drawer = findViewById(R.id.drawer_layout);

       // ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
      //          R.string.navigation_drawer_open, R.string.navigation_drawer_close);
     //   drawer.addDrawerListener(toggle);
     //   toggle.syncState();

        addCategoryiesOnSpinner();

       Toast.makeText(DonorHomeActivity.this,
                "OnClickListener : " +
                        "\nSpinner 1 : "+ String.valueOf(spinner.getSelectedItem()),
                Toast.LENGTH_SHORT).show();


        imageView = (ImageView) findViewById(R.id.my_avatar);
        selectPhoto = (Button) findViewById(R.id.selectPhoto);

        selectPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage(v.getContext());
            }
        });

        SelectCondition();

    }
    private void selectImage(Context context) {
        final CharSequence[] options = { "Take Photo", "Choose from Gallery","Cancel" };

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Choose your profile picture");

        builder.setItems(options, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int item) {

                if (options[item].equals("Take Photo")) {
                    Intent takePicture = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(takePicture, 0);

                } else if (options[item].equals("Choose from Gallery")) {
                    Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(pickPhoto , 1);

                } else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        if(resultCode != RESULT_CANCELED) {
            switch (requestCode) {
                case 0:
                    if (resultCode == RESULT_OK && data != null) {
                        Bitmap selectedImage = (Bitmap) data.getExtras().get("data");
                        imageView.setImageBitmap(selectedImage);
                    }

                    break;
                case 1:
                    if (resultCode == RESULT_OK && data != null) {
                        Uri selectedImage =  data.getData();
                        String[] filePathColumn = {MediaStore.Images.Media.DATA};
                        if (selectedImage != null) {
                            Cursor cursor = getContentResolver().query(selectedImage,
                                    filePathColumn, null, null, null);
                            if (cursor != null) {
                                cursor.moveToFirst();

                                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                                String picturePath = cursor.getString(columnIndex);
                                imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
                                cursor.close();
                            }
                        }

                    }
                    break;
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    public void addCategoryiesOnSpinner() {

        spinner = (Spinner) findViewById(R.id.CategorySpinner);
        List<String> list = new ArrayList<String>();
        list.add("Garments");
        list.add("Books");
        list.add("sports");
        list.add("shoes");
        list.add("other");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }


    public void SelectCondition() {

        radioGroupCondition = (RadioGroup) findViewById(R.id.radioCondition);

        int selectedId = radioGroupCondition.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        selectedButton = (RadioButton) findViewById(selectedId);
        Toast.makeText(DonorHomeActivity.this,
                selectedButton.getText(), Toast.LENGTH_SHORT).show();


    }

}
