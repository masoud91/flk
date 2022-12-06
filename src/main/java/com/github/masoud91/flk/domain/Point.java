package com.github.masoud91.flk.domain;

public class Point {

    private Double lat;
    private Double lng;


    public Point(Double lat, Double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLng() {
        return lng;
    }
}
