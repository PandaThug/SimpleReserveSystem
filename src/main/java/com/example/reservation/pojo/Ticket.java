package com.example.reservation.pojo;

import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Ticket {

    private Integer id;
//    private Date reserveTime;
//    private LocalDateTime reserveTime;
    private Timestamp reserveTime;

    public static Integer maxReservation = 10;

    public Ticket(){
        reserveTime=Timestamp.valueOf(LocalDateTime.now());
    }

}
