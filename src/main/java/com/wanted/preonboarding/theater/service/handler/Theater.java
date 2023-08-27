package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Theater {

    public void enter(Audience audience, Ticket ticket){
        if(!audience.getBag().hasTicket()) { //티켓 이미 갖고있으면 티켓 있다고 표시 추가로 안 해도 되니까
            audience.getBag().setTicket(ticket);
        }
    }

}
