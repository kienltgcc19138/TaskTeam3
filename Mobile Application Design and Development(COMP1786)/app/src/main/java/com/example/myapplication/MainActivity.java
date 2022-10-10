package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.myapplication.fragment.ExpenseFragment;
import com.example.myapplication.fragment.HomeFragment;
import com.example.myapplication.fragment.TripFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private static final int FRAGMENT_HOME = 0;
    private static final int FRAGMENT_TRIP = 1;
    private static final int FRAGMENT_EXPENSE = 2;

    private int CurrentFragment = FRAGMENT_HOME;

    private DrawerLayout DrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,DrawerLayout,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        DrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        replaceFragment(new HomeFragment());
        navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_home){
            if (CurrentFragment != FRAGMENT_HOME){
                replaceFragment(new HomeFragment());
                CurrentFragment = FRAGMENT_HOME;
            }

        }else if(id == R.id.nav_trip){
            if (CurrentFragment != FRAGMENT_TRIP){
                replaceFragment(new TripFragment());
                CurrentFragment = FRAGMENT_TRIP;
            }
        }else if(id == R.id.nav_expense){
            if (CurrentFragment != FRAGMENT_EXPENSE){
                replaceFragment(new ExpenseFragment());
                CurrentFragment = FRAGMENT_EXPENSE;
            }

        }

        DrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {

        if(DrawerLayout.isDrawerOpen(GravityCompat.START)){
            DrawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    private void replaceFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment);
        transaction.commit();
    }
}