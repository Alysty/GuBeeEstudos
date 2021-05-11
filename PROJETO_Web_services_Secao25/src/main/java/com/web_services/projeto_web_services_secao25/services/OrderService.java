package com.web_services.projeto_web_services_secao25.services;

import com.web_services.projeto_web_services_secao25.entities.Order;
import com.web_services.projeto_web_services_secao25.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> order = orderRepository.findById(id);
        return order.get();
    }
}
