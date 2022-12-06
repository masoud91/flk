package com.github.masoud91.flk.presentation;

import com.github.masoud91.flk.application.PointService;
import com.github.masoud91.flk.domain.Point;
import com.github.masoud91.flk.presentation.dto.MaxNResponseDto;
import com.github.masoud91.flk.presentation.dto.PositionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/location")
public class LocationController {

    private final PointService pointService;

    public LocationController(PointService pointService) {
        this.pointService = pointService;
    }

    @PostMapping("/{rider_id}/now")
    ResponseEntity<Object> submitLocation(@RequestBody PositionDto positionDto, @PathVariable String rider_id) {
        // TODO: handle errors and validation from application
        pointService.recordPosition(rider_id, positionDto);
        return ResponseEntity
                .status(HttpStatus.OK).build();
    }


    @GetMapping("/{rider_id}")
    ResponseEntity<MaxNResponseDto> getMaxNLocations(@PathVariable String rider_id, @RequestParam Integer max) {
        List<Point> points = pointService.getMaxNPositions(rider_id, max);

        MaxNResponseDto responseDto = new MaxNResponseDto(rider_id, points);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseDto);
    }

}
