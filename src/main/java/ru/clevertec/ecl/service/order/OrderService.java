package ru.clevertec.ecl.service.order;

import org.springframework.data.domain.PageRequest;
import ru.clevertec.ecl.model.dtos.OrderDto;
import ru.clevertec.ecl.model.entities.Order;
import ru.clevertec.ecl.model.entities.Tag;
import ru.clevertec.ecl.model.requests.order.OrderRequest;

import java.util.List;
import java.util.Map;

public interface OrderService {

    List<Order> getOrders();

    Map<Integer, String> getUserOrderInformation(Long id);

    List<Order> getOrdersByUserId(Long id, PageRequest of);

    OrderDto createOrder(OrderRequest orderRequest);

    Tag getMostWidelyUsedTag(Long id);
}
