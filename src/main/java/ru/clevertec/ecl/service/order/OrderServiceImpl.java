package ru.clevertec.ecl.service.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.clevertec.ecl.model.entities.Order;
import ru.clevertec.ecl.repository.order.OrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrder(Long id) {
        return null;
    }

    @Override
    public List<Order> getOrdersByUserId(Long id) {
        return orderRepository.findAllByUserId(id);
    }
}
