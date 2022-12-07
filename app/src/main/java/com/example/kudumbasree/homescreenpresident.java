package com.example.kudumbasree;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class homescreenpresident extends AppCompatActivity  {
    DrawerLayout drawer;
    ImageView menu, Notifi;
    AlertDialog.Builder builder;
    DatabaseReference databaseReference;
    ArrayList<DisplayPresidentDetails> list;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreenpresident);
        drawer = findViewById(R.id.drawer_id);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, R.string.drawer_open, R.string.drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        auth=FirebaseAuth.getInstance();
        menu = findViewById(R.id.nav);
        Notifi = findViewById(R.id.notifi);

        list=new ArrayList<>();

        Notifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 =new Intent(homescreenpresident.this,Notificationxmljava.class);
                startActivity(intent4);
            }
        });
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.nav_view);

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);

        Fragment fr=home.newInstance("dd","ss");
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,fr);
        fragmentTransaction.commit();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.memberlist) {
                  Intent inte = new Intent(homescreenpresident.this,MemberList.class);
                  startActivity(inte);
                }
                else if (itemId == R.id.loan) {
                    Intent intent1 = new Intent(homescreenpresident.this,Loanlist.class);
                    startActivity(intent1);
                }
                else if (itemId == R.id.report) {
                    Intent intent2 = new Intent(homescreenpresident.this,Reportsubmission.class);
                    startActivity(intent2);
                }
                else if (itemId == R.id.expense) {
                    Intent intent3 = new Intent(homescreenpresident.this,Expense.class);
                    startActivity(intent3);
                }
                else if (itemId == R.id.jobalert) {
                    Intent intent4 = new Intent(homescreenpresident.this,JobAlertPresident.class);
                    startActivity(intent4);
                }
                else if (itemId == R.id.logout) {
                    auth.signOut();
                    Toast.makeText(homescreenpresident.this, "Signed Out", Toast.LENGTH_SHORT).show();
                    Intent intent5 = new Intent(homescreenpresident.this, MainActivity.class);
                    startActivity(intent5);
                }
                else if (itemId == R.id.ffound) {
                    Intent intent6 = new Intent(homescreenpresident.this,FestivalFound.class);
                }


                return false;
            }
        });



        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    selectedFragment = new home();
                }
                else if (itemId == R.id.search) {
                    selectedFragment = new search();
                } else if (itemId == R.id.profile) {
                    selectedFragment = new profile();
                } else if (itemId == R.id.settings) {
                    selectedFragment = new settings();
                }
                // It will help to replace the
                // one fragment to other.
                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, selectedFragment).commit();
                }
                return false;
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {drawer.openDrawer(GravityCompat.START);}
        });
    }

    private void replaceFragment(Fragment fragment) {


            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame,fragment);
            fragmentTransaction.commit();


    }


}