package ru.clevertec.ecl.service.order;

import ru.clevertec.ecl.model.entities.Order;

import java.util.List;

public interface OrderService {

    List<Order> getOrders();

    Order getOrder(Long id);

    List<Order> getOrdersByUserId(Long id);
}
