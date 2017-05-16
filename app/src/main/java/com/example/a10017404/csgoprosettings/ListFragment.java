package com.example.a10017404.csgoprosettings;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
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
    Button button;

    public interface ListClickListener{
        public void listEventHappened(Integer listItem);
        public void buttonEventHappened();
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
        View fragmentView = inflater.inflate(R.layout.fragment_list,container,false);
        list = getArguments().getParcelableArrayList("list");
        button = (Button)fragmentView.findViewById(R.id.yourSettingsButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallback.buttonEventHappened();
            }
        });
        ListAdapter listAdapter = new ListAdapter(getContext(), R.layout.list_layout, list);
        listView = (ListView) fragmentView.findViewById(R.id.listView);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mCallback.listEventHappened(i);
            }
        });

        return fragmentView;
    }

}
