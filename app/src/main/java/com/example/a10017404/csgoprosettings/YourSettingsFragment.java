package com.example.a10017404.csgoprosettings;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class YourSettingsFragment extends Fragment {
    SettingsFragment.BackClickListener mCallback;
    ArrayList<String> resolutionarr = new ArrayList<>();
    EditText res1;
    EditText res2;
    TextView resolution;
    OutputStreamWriter outputStreamWriter;
    BufferedWriter writer;
    Switch stretched;
    EditText sens;
    EditText dpi;
    Button save;

    public interface BackClickListener{
        public void settingsEventHappened();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (SettingsFragment.BackClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + "Not Working");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_your_settings, container, false);
        resolutionarr.add("640x480");
        resolutionarr.add("800x600");
        resolutionarr.add("1024x768");
        resolutionarr.add("1280x720");
        resolutionarr.add("1280x960");
        resolutionarr.add("1280x1024");
        resolutionarr.add("1440x900");
        resolutionarr.add("1440x1080");
        resolutionarr.add("1600x900");
        resolutionarr.add("1680x1050");
        resolutionarr.add("1920x1080");
        resolutionarr.add("2560x1080");
        resolutionarr.add("2560x1440");
        resolutionarr.add("3440x1440");
        Button backbutton = (Button)view.findViewById(R.id.backbutton);
        res1 = (EditText)view.findViewById(R.id.res1);
        res2 = (EditText)view.findViewById(R.id.res2);
        resolution = (TextView)view.findViewById(R.id.resolution);
        stretched = (Switch)view.findViewById(R.id.switch1);
        sens = (EditText)view.findViewById(R.id.sensitivity);
        dpi = (EditText)view.findViewById(R.id.dpi);
        save = (Button)view.findViewById(R.id.save);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getContext().openFileInput("config.txt")));
            res1.setText(reader.readLine());
            res2.setText(reader.readLine());
            stretched.setChecked(Boolean.parseBoolean(reader.readLine()));
            sens.setText(reader.readLine());
            dpi.setText(reader.readLine());
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    OutputStreamWriter writer = new OutputStreamWriter(getContext().openFileOutput("config.txt", Context.MODE_PRIVATE));
                    writer.write(String.valueOf(res1.getText())+"\n");
                    writer.write(String.valueOf(res2.getText())+"\n");
                    writer.write(stretched.isChecked()+"\n");
                    writer.write(sens.getText()+"\n");
                    writer.write(dpi.getText()+"\n");
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.settingsEventHappened();
            }
        });
        return view;
    }

}
