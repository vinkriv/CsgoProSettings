package com.example.a10017404.csgoprosettings;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 10017404 on 5/1/2017.
 */

public class ListAdapter extends ArrayAdapter<Player> {
    ArrayList<Player> list;
    Context context;
    LayoutInflater inflater;
    int resourceId;

    public ListAdapter (Context context, int resourceId, ArrayList<Player> list){
        super(context,resourceId,list);
        this.context=context;
        this.resourceId=resourceId;
        this.list=list;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(resourceId,null);
        ImageView image=(ImageView)view.findViewById(R.id.listimg);
        TextView name=(TextView) view.findViewById(R.id.textView);
        image.setImageResource(list.get(position).getImageId());
        name.setBackgroundResource(list.get(position).getTeamId());
        name.setText("     "+list.get(position).getName());
        if (list.get(position).getTeamId()==R.drawable.astralis){
            name.setTextColor(Color.WHITE);
        }
        if (list.get(position).getTeamId()==R.drawable.c9){
            name.setTextColor(Color.BLACK);
        }
        return view;
    }
}
