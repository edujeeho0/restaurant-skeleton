package com.example.restaurant;

import com.example.restaurant.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository
        extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByRestaurantId(Long id);
    List<Reservation> findAllByRestaurantIdAndDate(Long restId, Integer date);
}
