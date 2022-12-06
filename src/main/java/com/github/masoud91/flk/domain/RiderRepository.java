package com.github.masoud91.flk.domain;

import java.util.List;

public interface RiderRepository {

    void save(Rider point);

    Rider findByRiderId(String riderId);

    List<Point> getMaxN(String riderId, Integer max);

}
