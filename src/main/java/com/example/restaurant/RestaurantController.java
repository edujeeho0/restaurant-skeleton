package com.example.restaurant;

import com.example.restaurant.dto.RestaurantDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
POST /restaurant -> 새로운 레스토랑 데이터 (CREATE)
GET  /restaurant -> 모든 레스토랑 데이터 (READ ALL)
GET  /restaurant/{id} -> id를 가진 레스토랑 데이터 (READ)
PUT  /restaurant/{id} -> id의 위치에 전달될 레스토랑 데이터 (UPDATE)
DELETE /restaurant/{id} -> id의 위치의 삭제할 레스토랑 데이터 (DELETE)
 */
@Slf4j
@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService service;

    @PostMapping
    public RestaurantDto create(
            @RequestBody
            RestaurantDto dto
    ) {
        return service.create(dto);
    }

    @GetMapping
    public List<RestaurantDto> readAll() {
        return service.readAll();
    }

    @GetMapping("/{id}")
    public RestaurantDto read(
            @PathVariable("id")
            Long id
    ) {
        return service.read(id);
    }

    @PutMapping("/{id}")
    public RestaurantDto update(
            @PathVariable("id")
            Long id,
            @RequestBody
            RestaurantDto dto
    ) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable("id")
            Long id
    ) {
        service.delete(id);
    }
}
