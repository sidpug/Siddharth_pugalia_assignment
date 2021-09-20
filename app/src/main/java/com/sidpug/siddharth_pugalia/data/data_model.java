package com.sidpug.siddharth_pugalia.data;

public class data_model {
    private String time;
    private Long lat,lon;
    private int temp;
    private String weather;

    public data_model(String time, Long lat, Long lon, int temp, String weather) {
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

    public Long getLat() {
        return lat;
    }

    public void setLat(Long lat) {
        this.lat = lat;
    }

    public Long getLon() {
        return lon;
    }

    public void setLon(Long lon) {
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
