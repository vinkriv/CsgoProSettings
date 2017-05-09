package com.example.a10017404.csgoprosettings;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {
    ListClickListener mCallback;
    ArrayList<Player> list = new ArrayList<>();
    ListView listView;

    public interface ListClickListener{
        public void eventHappened();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (ListClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + "Not Working");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_settings,container,false);
        listView = (ListView) fragmentView.findViewById(R.id.listView);
        list.add(new Player("Dev1ce", R.drawable.dev1ce));
        list.add(new Player("Kjaerbye", R.drawable.kjaerbye));
        CustomAdapter customAdapter = new CustomAdapter(getActivity(), 0, list);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mCallback.eventHappened();
            }
        });
        return fragmentView;
    }

}
