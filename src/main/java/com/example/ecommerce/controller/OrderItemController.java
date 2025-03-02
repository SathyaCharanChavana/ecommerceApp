package com.example.ecommerce.controller;

import com.example.ecommerce.model.OrderItem;
import com.example.ecommerce.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping
    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem orderItem) {
        OrderItem created = orderItemService.createOrderItem(orderItem);
        return new ResponseEntity<>(created, HttpStatus.CREATED); // 201
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable Long id) {
        OrderItem orderItem = orderItemService.getOrderItemById(id);
        if (orderItem != null) {
            return new ResponseEntity<>(orderItem, HttpStatus.OK); // 200
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404
    }

    @GetMapping
    public ResponseEntity<List<OrderItem>> getAllOrderItems() {
        List<OrderItem> orderItems = orderItemService.getAllOrderItems();
        return new ResponseEntity<>(orderItems, HttpStatus.OK); // 200
    }
    @PutMapping("/{id}")
    public ResponseEntity<OrderItem> updateOrderItem(@PathVariable Long id, @RequestBody OrderItem orderItem) {
        OrderItem updated = orderItemService.updateOrderItem(id, orderItem);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK); // 200
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id) {
        boolean deleted = orderItemService.deleteOrderItem(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404
    }
}