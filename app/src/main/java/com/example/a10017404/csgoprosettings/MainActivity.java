package com.example.a10017404.csgoprosettings;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFragment.ListClickListener, SettingsFragment.BackClickListener, YourSettingsFragment.BackClickListener{
    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;
    ListFragment listFragment = new ListFragment();
    SettingsFragment settingsFragment = new SettingsFragment();
    YourSettingsFragment yourSettingsFragment = new YourSettingsFragment();
    ArrayList<Player> list = new ArrayList<>();
    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list.add(new Player("Dev1ce", R.drawable.dev1ce, R.drawable.astralis, "1024x768","No (Black Bars)","2.3","400"));
        list.add(new Player("Kjaerbye", R.drawable.kjaerbye, R.drawable.astralis, "1440x900","No (Black Bars)","1.8","400"));
        list.add(new Player("Xyp9x", R.drawable.xyp9x, R.drawable.astralis, "1680×1050","No (Black Bars)","1","800"));
        list.add(new Player("Gla1ve", R.drawable.gla1ve, R.drawable.astralis, "1280×960","Yes","2.2","400"));
        list.add(new Player("Dupreeh", R.drawable.dupreeh, R.drawable.astralis, "1280×800","Yes","1.8","400"));
        list.add(new Player("N0thing", R.drawable.n0thing, R.drawable.c9, "1024×768","No (Black Bars)","1.7","400"));
        list.add(new Player("Shroud", R.drawable.shroud, R.drawable.c9, "1920×1080","No","2.1","400"));
        list.add(new Player("Stewie2K", R.drawable.stew, R.drawable.c9, "1024×768","No (Black Bars)","1.85","450"));
        list.add(new Player("Autimatic", R.drawable.auti, R.drawable.c9, "1280×960","Yes","1.9","400"));
        list.add(new Player("Skadoodle", R.drawable.ska, R.drawable.c9, "1024×768","No (Black Bars)","1.4","800"));
        bundle.putParcelableArrayList("list",list);
        listFragment.setArguments(bundle);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.relativelayout_id,listFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void listEventHappened(Integer listIndex) {
        fragmentTransaction = fragmentManager.beginTransaction();
        bundle.putInt("index",listIndex);
        settingsFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.relativelayout_id,settingsFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void buttonEventHappened() {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.relativelayout_id,yourSettingsFragment);
        fragmentTransaction.commit();
    }


    @Override
    public void settingsEventHappened() {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.relativelayout_id,listFragment);
        fragmentTransaction.commit();
    }

}
