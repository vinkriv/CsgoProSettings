package com.example.a10017404.csgoprosettings;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFragment.ListClickListener, SettingsFragment.ListClickListener{
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
        list.add(new Player("Dev1ce", R.drawable.dev1ce));
        list.add(new Player("Kjaerbye", R.drawable.kjaerbye));
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
