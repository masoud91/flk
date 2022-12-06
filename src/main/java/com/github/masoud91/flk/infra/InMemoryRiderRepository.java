package com.github.masoud91.flk.infra;

import com.github.masoud91.flk.domain.Point;
import com.github.masoud91.flk.domain.Rider;
import com.github.masoud91.flk.domain.RiderRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class InMemoryRiderRepository implements RiderRepository {

    Map<String, Rider> storage = new HashMap<>();

    @Override
    public void save(Rider rider) {
        Collections.reverse(rider.getPoints());
        storage.put(rider.getRiderId(), rider);
    }

    @Override
    public Rider findByRiderId(String riderId) {
        return storage.get(riderId);
    }

    @Override
    public List<Point> getMaxN(String riderId, Integer max) {
        Rider rider = storage.get(riderId);
        return rider.getPoints().stream().limit(max).collect(Collectors.toList());
    }
}
