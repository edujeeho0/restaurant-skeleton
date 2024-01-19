package com.example.restaurant;

import com.example.restaurant.dto.ReservationDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/restaurant/{restId}/reservation")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService service;

    @PostMapping
    public ReservationDto create(
            @PathVariable("restId")
            Long restId,
            @RequestBody
            ReservationDto dto
    ) {
        return service.create(restId, dto);
    }

    @GetMapping
    public List<ReservationDto> readAll(
            @PathVariable("restId")
            Long restId
    ) {
        return service.readAll(restId);
    }
}










