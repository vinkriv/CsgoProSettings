package com.example.a10017404.csgoprosettings;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {
    SettingsFragment.ListClickListener mCallback;
    ArrayList<Player> list = new ArrayList<>();

    public interface ListClickListener{
        public void settingsEventHappened();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (SettingsFragment.ListClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + "Not Working");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_settings,container,false);
        Integer index = getArguments().getInt("index");
        list = getArguments().getParcelableArrayList("list");
        ImageView imageView = (ImageView)fragmentView.findViewById(R.id.fragimgview_id);
        imageView.setImageResource(list.get(index).getImageId());
        Button backbutton = (Button)fragmentView.findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.settingsEventHappened();
            }
        });
        return fragmentView;
    }

}
