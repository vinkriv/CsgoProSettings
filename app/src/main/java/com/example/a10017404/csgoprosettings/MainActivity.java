package com.example.a10017404.csgoprosettings;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Player> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list.add(new Player("Dev1ce", R.drawable.dev1ce));
        list.add(new Player("Kjaerbye", R.drawable.kjaerbye));
        listView = (ListView) findViewById(R.id.listView);
        final CustomAdapter customAdapter = new CustomAdapter(this, 0, list);
        listView.setAdapter(customAdapter);
        final FragmentTransaction fragmentTransaction;
        final FragmentManager fragmentManager;
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SettingsFragment settingsFragment = new SettingsFragment();
                fragmentTransaction.replace(R.id.activity_main,settingsFragment);
                fragmentTransaction.commit();
            }
        });
    }
}