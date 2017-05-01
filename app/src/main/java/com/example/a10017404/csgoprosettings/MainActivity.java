package com.example.a10017404.csgoprosettings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Player> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list.add(new Player("Dev1ce",R.drawable.dev1ce));
        listView = (ListView)findViewById(R.id.listView);
        final CustomAdapter customAdapter = new CustomAdapter(this,0,list);
        listView.setAdapter(customAdapter);
    }
}
