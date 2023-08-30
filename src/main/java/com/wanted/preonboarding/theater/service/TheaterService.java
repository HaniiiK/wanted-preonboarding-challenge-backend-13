package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {

    private final Theater theater;

    public String enter(Audience audience, TicketSeller ticketSeller){
        Ticket ticket = ticketSeller.getTicketOffice().getTicket(); //티켓 정보 가져옴

        if(!audience.getBag().hasInvitation() || !audience.getBag().hasTicket()) {
            audience.getBag().minusAmount(ticket.getFee());
            if(audience.getBag().getAmount()<0) { //돈이 부족한 경우
                audience.getBag().plusAmount(ticket.getFee());
                return "not enough money.";
            }
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
        }

        theater.enter(audience, ticket);
        return "Have a good time.";
    }
}
