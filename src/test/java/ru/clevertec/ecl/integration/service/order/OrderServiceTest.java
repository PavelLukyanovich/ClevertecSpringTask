package ru.clevertec.ecl.integration.service.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.clevertec.ecl.integration.BaseTest;
import ru.clevertec.ecl.model.entities.Order;
import ru.clevertec.ecl.service.order.OrderService;

import java.util.List;
import java.util.Map;

public class OrderServiceTest extends BaseTest {

    @Autowired
    private OrderService orderService;

    @Test
    void whenGetOrders_shouldReturnAllOrders() {

        int expectedAmount = 3;

        List<Order> actualList = orderService.getOrders();

        Assertions.assertThat(actualList).hasSize(expectedAmount);

    }

    @Test
    void whenGetUserOrderInformation_shouldReturnOnlyPriceAndDate() {
        List<Order> orders = orderService.getOrders();
        System.out.println(orders.size());
        Order order = orders.get(2);
        System.out.println(order.getOrderPrice());

        Map<Integer, String> expectedInfo = orderService.getUserOrderInformation(order.getUser().getId());
        System.out.println(expectedInfo);
        Assertions.assertThat(expectedInfo.get(300)).isEqualTo("2000-03-01");
    }
}
