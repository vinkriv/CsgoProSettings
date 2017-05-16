package com.example.a10017404.csgoprosettings;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 10017404 on 5/1/2017.
 */

public class Player implements Parcelable{
    String name;
    int imageId;

    public Player(String name, int imageId){
        this.imageId=imageId;
        this.name=name;
    }

    protected Player(Parcel in) {
        name = in.readString();
        imageId = in.readInt();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(imageId);
    }
}

