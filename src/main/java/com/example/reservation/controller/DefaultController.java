package com.example.reservation.controller;

import com.example.reservation.dao.TicketMapper;
import com.example.reservation.pojo.Msg;
import com.example.reservation.pojo.Ticket;
import com.example.reservation.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.reservation.pojo.Ticket.maxReservation;

@Controller
public class DefaultController {
    @Autowired
    private TicketMapper ticketMapper;

    @Autowired
    @Qualifier("ticketService")
    private TicketService ticketService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/ticket")
    @ResponseBody
    public List<Ticket> getTicket() {
        List<Ticket> ticketList = ticketService.getAll();
        ticketList.forEach(ticket -> System.out.println(ticket));
        return ticketList;
    }

    @RequestMapping(value = "/addTicket")
    @ResponseBody
    public Msg addTicket() {
        System.out.println(1);
        int currentTicket = ticketService.getAllCounts();
        if (currentTicket < maxReservation) {
            Ticket ticket = new Ticket();
            ticketService.addTicket(ticket);
            Msg msg=new Msg(100,ticket);
            System.out.println(msg);
            return msg;
        } else {
            //输出提示信息
            Msg msg=new Msg(200,null);
            return msg;
        }
    }

    @RequestMapping(value = "/deleteTicket/{id}")
    @ResponseBody
    public void deleteTicket(@PathVariable("id") Integer id) {
        System.out.println(id);
        ticketService.deleteTicket(id);
    }

}
