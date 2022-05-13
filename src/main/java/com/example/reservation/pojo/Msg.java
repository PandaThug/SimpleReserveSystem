package com.example.reservation.pojo;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Msg {

    //状态码   100-成功  200-失败
    private int status;
    //提示信息
    private Ticket ticket;

}
