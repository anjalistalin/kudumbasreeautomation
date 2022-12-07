package com.example.kudumbasree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class ADSHomescreen extends AppCompatActivity {

    DrawerLayout drawerads;
    ImageView menuads, notifia;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adshomescreen);

        drawerads = findViewById(R.id.drawer_adsid);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerads, R.string.drawer_open, R.string.drawer_close);
        drawerads.addDrawerListener(toggle);
        toggle.syncState();
        menuads = findViewById(R.id.navads);
        notifia = findViewById(R.id.notifiads);
        auth=FirebaseAuth.getInstance();
        NavigationView navigationView = findViewById(R.id.nav_viewads);
        navigationView.setCheckedItem(R.id.nav_viewads);
        BottomNavigationView bottomNavads = findViewById(R.id.bottomNavigationViewads);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

               /* if (itemId == R.id.adsmemberlist) {
                    Intent intent = new Intent(ADSHomescreen.this, MeberListForads.class);
                    startActivity(intent);
                } else */ if (itemId == R.id.adsloan) {
                    Intent intent1 = new Intent(ADSHomescreen.this, LoanForADS.class);
                    startActivity(intent1);
                } else if (itemId == R.id.adsreport) {
                    Intent intent2 = new Intent(ADSHomescreen.this, ViewReportADS.class);
                    startActivity(intent2);
                } else if (itemId == R.id.adsexpense) {
                    Intent intent3 = new Intent(ADSHomescreen.this,ExpenseViewBYADS.class);
                    startActivity(intent3);
                } else if (itemId == R.id.adsjobalert) {
                    Intent intent4 = new Intent(ADSHomescreen.this, JobAlert.class);
                    startActivity(intent4);
                } else if (itemId == R.id.adslogout) {


                    auth.signOut();
                    Toast.makeText(ADSHomescreen.this, "Signed Out", Toast.LENGTH_SHORT).show();
                    Intent intent5 = new Intent(ADSHomescreen.this, MainActivity.class);
                    startActivity(intent5);
                } else if (itemId == R.id.ffound) {
                    Intent intent6 = new Intent(ADSHomescreen.this, FestivalFound.class);
                }
                return false;
            }
        });

                bottomNavads.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        int itemId = item.getItemId();
                        if (itemId == R.id.homeads) {
                            selectedFragment = new adshome();
                        } else if (itemId == R.id.searchads) {
                            selectedFragment = new adssearch();
                        } else if (itemId == R.id.profileads) {
                            selectedFragment = new adsprofile();
                        }
                        // It will help to replace the
                        // one fragment to other.
                        if (selectedFragment != null) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.frameads, selectedFragment).commit();
                        }
                        return false;
                    }
                });
        menuads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerads.openDrawer(GravityCompat.START);
            }

        });
        notifia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentnotifia=new Intent(ADSHomescreen.this,Notificationxmljava.class);
                startActivity(intentnotifia);
            }
        });
    }
    private void replaceFragment(Fragment fragment) {


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();

        }

    }
