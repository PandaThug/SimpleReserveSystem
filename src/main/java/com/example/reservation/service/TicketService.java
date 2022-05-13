package com.example.reservation.service;

import com.example.reservation.dao.TicketMapper;
import com.example.reservation.pojo.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketMapper ticketMapper;

    /**
     * 查询所有预订信息
     */
    public List<Ticket> getAll() {
        return ticketMapper.getAllTickets();
    }

    /**
     * 查询订单条数
     */
    public int getAllCounts() {
        return ticketMapper.getQuantityOfTicket();
    }

    /**
     * 删除订单
     */
    public void deleteTicket(Integer id) {
        ticketMapper.deleteTicketById(id);
    }

    /**
     * 增加订单
     */
    public void addTicket(Ticket ticket) {
        ticketMapper.addTicket(ticket);
    }

}
