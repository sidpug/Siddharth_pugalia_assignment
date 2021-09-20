package com.sidpug.siddharth_pugalia.data;

public class data_model {
    private String time;
    private int lat,lon;
    private int temp;
    private String weather;

    public data_model(String time, int lat, int lon, int temp, String weather) {
        this.time = time;
        this.lat = lat;
        this.lon = lon;
        this.temp = temp;
        this.weather = weather;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getLon() {
        return lon;
    }

    public void setLon(int lon) {
        this.lon = lon;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }



}
