package com.github.masoud91.flk.application;

import com.github.masoud91.flk.domain.Point;
import com.github.masoud91.flk.presentation.dto.PositionDto;

import java.util.List;

public interface PointService {

    void recordPosition(String riderId, PositionDto positionDto);

    List<Point> getMaxNPositions(String riderId, Integer max);

}
