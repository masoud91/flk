package com.github.masoud91.flk.application;

import com.github.masoud91.flk.domain.Rider;
import com.github.masoud91.flk.domain.RiderRepository;
import com.github.masoud91.flk.domain.Point;
import com.github.masoud91.flk.presentation.dto.PositionDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultPointService implements PointService {

    private final RiderRepository repository;

    public DefaultPointService(RiderRepository repository) {
        this.repository = repository;
    }

    @Override
    public void recordPosition(String riderId, PositionDto positionDto) {
        Point point = new Point(positionDto.getLat(), positionDto.getLng());
        Rider rider = repository.findByRiderId(riderId);
        if (rider == null) {
            rider = new Rider(riderId);
        }
        rider.addNewPoint(point);
        repository.save(rider);
    }

    @Override
    public List<Point> getMaxNPositions(String riderId, Integer max) {
        return repository.getMaxN(riderId, max);
    }

}
