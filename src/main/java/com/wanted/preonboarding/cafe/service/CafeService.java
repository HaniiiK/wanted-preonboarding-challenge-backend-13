package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.Cashier;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import com.wanted.preonboarding.cafe.service.handler.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.Keymap;
import java.util.*;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;

    public String orderFrom(Order order){

        HashMap<String, Integer> menu = new HashMap<>();
        menu.put("AMERICANO", 3);
        menu.put("LATTE", 3);
        menu.put("MOCHA", 3);

        Cashier cashier = new Cashier(wantedCafe);

        Set<Map.Entry<String, Integer>> entries = menu.entrySet();
        Iterator<Map.Entry<String, Integer>> iters = entries.iterator();

        Map<String, Integer> myOrders = new HashMap<>();
        while (iters.hasNext()) {
            if(iters.next().getKey().equals(order.getDrinks())) {
                myOrders.put(order.getDrinks(), order.getNumbers());

                Customer c1 = new Customer("Card", myOrders);
                return c1.buyCoffee(cashier);
            }
        }

        return "해당 음료는 주문할 수 없습니다.";
    }
}
