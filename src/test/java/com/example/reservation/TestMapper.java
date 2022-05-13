package com.example.reservation;

import com.example.reservation.dao.TicketMapper;
import com.example.reservation.pojo.Ticket;
import com.example.reservation.service.TicketService;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestMapper {

    @Autowired
    TicketMapper ticketMapper;

    @Autowired
    SqlSession sqlSession;

    @Autowired
    TicketService ticketService;

    @Test
    public void testAdd() {
//        TicketMapper mapper = sqlSession.getMapper(TicketMapper.class);
//        mapper.addTicket(new Ticket(null, Timestamp.valueOf(LocalDateTime.now())));
//        List<Ticket> allTickets = mapper.getAllTickets();
//        allTickets.forEach(ticket -> System.out.println(ticket));
        Ticket ticket = new Ticket();
        ticketService.addTicket(ticket);
        System.out.println(ticket.getId());
    }

    @Test
    public void testDelete() {
        TicketMapper mapper = sqlSession.getMapper(TicketMapper.class);
        mapper.deleteTicketById(2);
        List<Ticket> allTickets = mapper.getAllTickets();
        allTickets.forEach(ticket -> System.out.println(ticket));
    }

    @Test
    public void testGetQuantityOfTicket() {
        TicketMapper mapper = sqlSession.getMapper(TicketMapper.class);
        int quantityOfTicket = mapper.getQuantityOfTicket();
        System.out.println(quantityOfTicket);
    }
}
