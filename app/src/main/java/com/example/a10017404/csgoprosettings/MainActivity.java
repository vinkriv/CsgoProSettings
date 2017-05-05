package com.example.a10017404.csgoprosettings;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFragment.ListClickListener{
    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        ListFragment listFragment = new ListFragment();
        fragmentTransaction.add(R.id.relativelayout_id,listFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void eventHappened() {
        fragmentTransaction = fragmentManager.beginTransaction();
        SettingsFragment settingsFragment = new SettingsFragment();
        fragmentTransaction.replace(R.id.relativelayout_id,settingsFragment);
        fragmentTransaction.commit();
    }
}