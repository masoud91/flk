package com.github.masoud91.flk.presentation.dto;

public class PositionDto {

    Double lat;
    Double lng;

    public PositionDto(Double lat, Double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public PositionDto() {
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
