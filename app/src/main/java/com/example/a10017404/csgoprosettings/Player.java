package com.example.a10017404.csgoprosettings;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 10017404 on 5/1/2017.
 */

public class Player implements Parcelable{
    String name;
    int imageId;
    int teamId;
    String resolution;
    String stretched;
    String sens;
    String dpi;

    public Player(String name, int imageId, int teamId, String resolution, String stretched, String sens, String dpi){
        this.imageId=imageId;
        this.name=name;
        this.teamId=teamId;
        this.resolution=resolution;
        this.stretched=stretched;
        this.sens=sens;
        this.dpi=dpi;
    }

    protected Player(Parcel in) {
        name = in.readString();
        imageId = in.readInt();
        teamId = in.readInt();
        resolution = in.readString();
        stretched = in.readString();
        sens = in.readString();
        dpi = in.readString();
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }

    public int getTeamId(){
        return teamId;
    }

    public String getResolution(){
        return resolution;
    }

    public String getStretched(){
        return stretched;
    }

    public String getSens(){
        return sens;
    }

    public String getDpi(){
        return dpi;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(imageId);
        parcel.writeInt(teamId);
        parcel.writeString(resolution);
        parcel.writeString(stretched);
        parcel.writeString(sens);
        parcel.writeString(dpi);
    }
}

