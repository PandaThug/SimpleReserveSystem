package com.example.reservation.dao;

import com.example.reservation.pojo.Ticket;

import java.util.List;

public interface TicketMapper {

    /**
     * 查询所有的预订信息
     */
    List<Ticket> getAllTickets();

    /**
     * 查询总的预订数量
     */
    int getQuantityOfTicket();

    /**
     * 添加订单
     */
    int addTicket(Ticket ticket);

    /**
     * 删除订单
     */
    int deleteTicketById(Integer id);

}
