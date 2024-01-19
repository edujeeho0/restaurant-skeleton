package com.example.restaurant;

import com.example.restaurant.dto.MenuDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/restaurant/{restId}/menu")
@RequiredArgsConstructor
public class MenuController {
    private final MenuService service;

    @PostMapping
    public MenuDto create(
            @PathVariable("restId")
            Long restId,
            @RequestBody
            MenuDto dto
    ) {
        return service.create(restId, dto);
    }

    @GetMapping
    public List<MenuDto> readAll(
            @PathVariable("restId")
            Long restId
    ) {
        return service.readAll(restId);
    }

    @GetMapping("/{menuId}")
    public MenuDto read(
            @PathVariable("restId")
            Long restId,
            @PathVariable("menuId")
            Long menuId
    ) {
        return service.read(restId, menuId);
    }

    @PutMapping("/{menuId}")
    public MenuDto update(
            @PathVariable("restId")
            Long restId,
            @PathVariable("menuId")
            Long menuId,
            @RequestBody
            MenuDto dto
    ) {
        return service.update(restId, menuId, dto);
    }

    @DeleteMapping("/{menuId}")
    public void delete(
            @PathVariable("restId")
            Long restId,
            @PathVariable("menuId")
            Long menuId
    ) {
        service.delete(restId, menuId);
    }
}
