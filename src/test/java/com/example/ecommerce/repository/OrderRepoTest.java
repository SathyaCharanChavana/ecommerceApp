package com.example.ecommerce.repository;

import com.example.ecommerce.model.Customer;
import com.example.ecommerce.model.Order;
import com.example.ecommerce.model.OrderItem;
import com.example.ecommerce.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class OrderRepoTest {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderItemRepository orderItemrepository;
    @Test
    void createOrder(){
        Order order=new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setOrderItems(getOrderItems());
        order.setCustomer(createCustomer());
        orderRepository.save(order);
    }
    private List<OrderItem> getOrderItems(){
        List<OrderItem> orderItems=new ArrayList<>();
        orderItems.add(createIphoneOrderItem());
        return orderItems;
    }
    private Customer createCustomer(){
      Customer customer= new Customer();
      customer.setName("Sathya");
      customer.setEmail("sathya@gmail.com");
      customer.setPhoneNumber("7166044792");
      Customer savedCustomer=customerRepository.save(customer);
      return savedCustomer;
    }
    private OrderItem createIphoneOrderItem(){
        OrderItem orderItem=new OrderItem();
        orderItem.setProduct(createProduct());
        return orderItem;
    }
    private Product createProduct(){
        Product product=new Product();
        product.setCategory(categoryRepository.findById(1L).get());
        product.setDescription("new Product");
        product.setName("Iphone");
        product.setStock(new BigInteger("1"));
        product.setPrice(new BigDecimal("1000.00"));
        Product newProduct=productRepository.save(product);
        return newProduct;
    }


}
