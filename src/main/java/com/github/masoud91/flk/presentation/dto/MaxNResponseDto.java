package com.github.masoud91.flk.presentation.dto;

import com.github.masoud91.flk.domain.Point;

import java.util.ArrayList;
import java.util.List;

public class MaxNResponseDto {

    String rider_id;

    List<Point> history = new ArrayList<Point>();

    public MaxNResponseDto() {
    }

    public MaxNResponseDto(String rider_id, List<Point> history) {
        this.rider_id = rider_id;
        this.history = history;
    }

    public String getRider_id() {
        return rider_id;
    }

    public void setRider_id(String rider_id) {
        this.rider_id = rider_id;
    }

    public List<Point> getHistory() {
        return history;
    }

    public void setHistory(List<Point> history) {
        this.history = history;
    }

}
