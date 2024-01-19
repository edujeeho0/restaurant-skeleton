package com.example.restaurant.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;


/*
table reservation {
  id int pk
  restaurant_id int [ref:> restaurant.id]
  date int
  reserve_hour int
  people int
  duration int
}
 */
@Getter
@Entity
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 다른 날임을 구분하기 위한 임의 데이터
    private Integer date;
    // 예약 시작 시작
    private Integer reserveHour;
    // 예약 인원 수
    private Integer people;
    // 총 머물 시간
    private Integer duration;

    @ManyToOne
    private Restaurant restaurant;

    public Reservation(
            Integer date,
            Integer reserveHour,
            Integer people,
            Integer duration,
            Restaurant restaurant
    ) {
        this.date = date;
        this.reserveHour = reserveHour;
        this.people = people;
        this.duration = duration;
        this.restaurant = restaurant;
    }
}
