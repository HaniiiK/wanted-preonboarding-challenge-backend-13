package com.wanted.preonboarding.theater.controller;

import com.wanted.preonboarding.theater.service.TheaterService;
import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theater")
@RequiredArgsConstructor
public class TheaterController {
    private final TheaterService theaterService;

    @GetMapping("hello")
    public String welcomeMessage(){
        return "Welcome to The Wanted Theater";
    }

    @GetMapping("enter")
    public String enter(@RequestParam Long money){
        String answer = "";
        TicketSeller ticketSeller = new TicketSeller(new TicketOffice(20000L, new Ticket(100L)));

        //초대권 있음
//        answer = theaterService.enter(new Audience(new Bag(new Invitation(), money)), ticketSeller);

        //초대권 없음
        answer = theaterService.enter(new Audience(new Bag(money)), ticketSeller);

        return answer;
    }
}
