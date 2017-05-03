package com.example.a10017404.csgoprosettings;

/**
 * Created by 10017404 on 5/1/2017.
 */

public class Player {
    String name;
    int imageId;

    public Player(String name, int imageId){
        this.imageId=imageId;
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }
}

