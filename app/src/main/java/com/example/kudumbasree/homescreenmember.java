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
import android.widget.Spinner;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class homescreenmember extends AppCompatActivity {

    DrawerLayout drawer;
    ImageView menum, notifim;
    Button mviewat;
    String[] district = {"Trivardrum","Kottayam","Ernakulam","Thrissur","Idukkki","Palakkad","Wayanad"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreenmember);

        drawer = findViewById(R.id.drawer_idmem);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, R.string.drawer_open, R.string.drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        menum = findViewById(R.id.navmem);
        notifim = findViewById(R.id.notifimem);
        mviewat=findViewById(R.id.matv);
        NavigationView navigationView = findViewById(R.id.nav_viewmem);
        navigationView.setCheckedItem(R.id.nav_viewmem);
        BottomNavigationView bottomNavmem = findViewById(R.id.bottomNavigationViewmem);

        Spinner spin = findViewById(R.id.spinner);


        Fragment fr=homemem.newInstance("aa","bb");
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framemem,fr);
        fragmentTransaction.commit();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();



                 if (itemId == R.id.memberlistmem) {
                    Intent intent1 = new Intent(homescreenmember.this,MListForMember.class);
                    startActivity(intent1);
                }

                else if (itemId == R.id.loanmem) {
                    Intent intent2 = new Intent(homescreenmember.this, LoanViewByMember.class);
                    startActivity(intent2);
                }
                else if (itemId == R.id.reportmem) {
                    Intent intent3 = new Intent(homescreenmember.this,ReportByMem.class);
                    startActivity(intent3);
                }
                else if (itemId == R.id.expensemem) {
                    Intent intent4 = new Intent(homescreenmember.this,ExpenseViewByMember.class);
                    startActivity(intent4);
                }
                else if (itemId == R.id.jobalertmem) {
                    Intent intent5  = new Intent(homescreenmember.this,jobalertm.class);
                    startActivity(intent5);
                }
                else if (itemId == R.id.logoutmem) {

                    Intent intent6  = new Intent(homescreenmember.this,MainActivity.class);
                    startActivity(intent6);
                }
                return false;
            }
        });

        bottomNavmem.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                Fragment selectedFragment = null;
                int itemId = item.getItemId();
                if (itemId == R.id.homemem) {
                    selectedFragment = new homemem();
                }
                else if (itemId == R.id.searchmem) {
                    selectedFragment = new searchmem();
                } else if (itemId == R.id.profilemem) {
                    selectedFragment = new profilemem();
                } else if (itemId == R.id.settingsmem) {
                    selectedFragment = new settingsmem();
                }
                // It will help to replace the
                // one fragment to other.
                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.framemem, selectedFragment).commit();
                }
                return false;
            }
        });

        notifim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentnotify=new Intent(new Intent(homescreenmember.this,Notificationxmljava.class));
                startActivity(intentnotify);
            }
        });





        menum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);
            }
        });
    }


    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framemem, fragment);
        fragmentTransaction.commit();
    }
}