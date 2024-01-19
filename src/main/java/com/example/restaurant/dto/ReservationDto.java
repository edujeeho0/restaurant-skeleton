package com.example.restaurant.dto;


import com.example.restaurant.entity.Reservation;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {
    private Long id;
    @Setter
    private Integer date;
    @Setter
    private Integer reserveHour;
    @Setter
    private Integer people;
    @Setter
    private Integer duration;

    public static ReservationDto fromEntity(Reservation entity) {
        return new ReservationDto(
                entity.getId(),
                entity.getDate(),
                entity.getReserveHour(),
                entity.getPeople(),
                entity.getDuration()
        );
    }
}
