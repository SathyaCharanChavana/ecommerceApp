package com.example.ecommerce.service;

import com.example.ecommerce.model.OrderItem;
import com.example.ecommerce.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
    public OrderItem getOrderItemById(Long id) {
        Optional<OrderItem> orderItem = orderItemRepository.findById(id);
        return orderItem.orElse(null);
    }

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public OrderItem updateOrderItem(Long id, OrderItem updatedOrderItem) {
        Optional<OrderItem> existingOrderItem = orderItemRepository.findById(id);
        if (existingOrderItem.isPresent()) {
            OrderItem orderItem = existingOrderItem.get();
            orderItem.setQuantity(updatedOrderItem.getQuantity());
            orderItem.setProduct(updatedOrderItem.getProduct());
            return orderItemRepository.save(orderItem);
        }
        return null;
    }

    public boolean deleteOrderItem(Long id) {
        Optional<OrderItem> orderItem = orderItemRepository.findById(id);
        if (orderItem.isPresent()) {
            orderItemRepository.delete(orderItem.get());
            return true;
        }
        return false;
    }
}