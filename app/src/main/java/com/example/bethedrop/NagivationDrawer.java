package com.example.bethedrop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class NagivationDrawer extends AppCompatActivity {


    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nagivation_drawer);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool);
        setSupportActionBar(toolbar);


        dl = (DrawerLayout)findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView)findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.profile:
                        Toast.makeText(NagivationDrawer.this, "Donor Profile",Toast.LENGTH_SHORT).show();break;
                    case R.id.DonationHistory:
                        Toast.makeText(NagivationDrawer.this, "Donation History",Toast.LENGTH_SHORT).show();break;
                    case R.id.DonationRequest:
                        Toast.makeText(NagivationDrawer.this, "Donation request",Toast.LENGTH_SHORT).show();break;
                    case R.id.About:
                        Toast.makeText(NagivationDrawer.this, "About",Toast.LENGTH_SHORT).show();break;
                    case R.id.logout:
                        Toast.makeText(NagivationDrawer.this, "logout",Toast.LENGTH_SHORT).show();break;

                    default:
                        return true;
                }


                return true;

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
}
