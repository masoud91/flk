package com.github.masoud91.flk.domain;

import java.util.ArrayList;
import java.util.List;

public class Rider {

    private String riderId;
    private final List<Point> points = new ArrayList<>();

    public Rider(String riderId) {
        this.riderId = riderId;
    }

    public String getRiderId() {
        return riderId;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void addNewPoint(Point point) {
        points.add(point);
    }
}
