package com.example.restaurant;

import com.example.restaurant.dto.RestaurantDto;
import com.example.restaurant.entity.Restaurant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository repository;

    public RestaurantDto create(RestaurantDto dto) {
        Restaurant newRestaurant = new Restaurant(
                dto.getName(),
                dto.getCategory(),
                dto.getOpenHour(),
                dto.getCloseHour()
        );
        return RestaurantDto
                .fromEntity(repository.save(newRestaurant));
    }

    public List<RestaurantDto> readAll() {
        /*List<RestaurantDto> restaurantDtoList = new ArrayList<>();
        List<Restaurant> restaurantList = repository.findAll();
        for (Restaurant entity: restaurantList) {
            restaurantDtoList.add(RestaurantDto.fromEntity(entity));
        }
        return restaurantDtoList;*/
        // Stream API 활용
        return repository.findAll().stream()
                // .map(entity -> RestaurantDto.fromEntity(entity))
                .map(RestaurantDto::fromEntity)
                .collect(Collectors.toList());
    }

    public RestaurantDto read(Long id) {
        /*Optional<Restaurant> optionalRestaurant
                = repository.findById(id);
        if (optionalRestaurant.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return RestaurantDto.fromEntity(optionalRestaurant.get());*/
        // Optional.map(), Optional.orElseThrow()
        return repository.findById(id)
                // .map(entity -> RestaurantDto.fromEntity(entity))
                .map(RestaurantDto::fromEntity)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public RestaurantDto update(Long id, RestaurantDto dto) {
        Optional<Restaurant> optionalRestaurant
                = repository.findById(id);
        if (optionalRestaurant.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Restaurant target = optionalRestaurant.get();
        target.setName(dto.getName());
        target.setCategory(dto.getCategory());
        target.setOpenHours(dto.getOpenHour());
        target.setCloseHours(dto.getCloseHour());
        // target = repository.save(target);

        return RestaurantDto.fromEntity(repository.save(target));
    }

    public void delete(Long id) {
        if (!repository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        repository.deleteById(id);
    }
}
