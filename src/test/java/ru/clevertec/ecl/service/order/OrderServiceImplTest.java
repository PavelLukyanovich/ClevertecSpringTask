package ru.clevertec.ecl.service.order;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import ru.clevertec.ecl.model.entities.Order;
import ru.clevertec.ecl.model.entities.User;
import ru.clevertec.ecl.model.requests.order.OrderRequest;
import ru.clevertec.ecl.repository.certificate.CertificateRepository;
import ru.clevertec.ecl.repository.order.OrderRepository;
import ru.clevertec.ecl.repository.user.UserRepository;
import ru.clevertec.ecl.utils.mapper.OrderMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class OrderServiceImplTest {
    @Mock
    private OrderRepository orderRepository;
    @Mock
    private CertificateRepository certificateRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    @Test
    public void whenGetOrders_shouldReturnCorrectOrder() {

        List<Order> orders = new ArrayList<>();
        orders.add(new Order());
        when(orderRepository.findAll()).thenReturn(orders);
        assertEquals(orders, orderService.getOrders());
    }

    @Test
    public void GetUserOrderInformation_shouldReturnInformationAboutCorrectUserOrder() {

        Long id = 1L;
        Order order = new Order();
        when(orderRepository.findOrderInfoByUserId(id)).thenReturn(order);
        assertEquals(order, orderService.getUserOrderInformation(id));
    }

    @Test
    public void whenGetOrdersByUserId_shouldReturnUsersOrderWhereUserIdIsPassedId() {

        Long id = 1L;
        PageRequest of = PageRequest.of(0, 10);
        List<Order> orders = new ArrayList<>();
        orders.add(new Order());
        when(orderRepository.findAllByUserId(id)).thenReturn(orders);
        assertEquals(orders, orderService.getOrdersByUserId(id, of));
    }

    @Test
    public void whenCreateOrder_shouldReturnCreatedUser() {

        OrderRequest orderRequest = new OrderRequest();
        User user = new User();
        user.setId(1L);
        Order order = new Order();
        order.setUser(user);
        when(userRepository.existsById(user.getId())).thenReturn(true);
        when(userRepository.getReferenceById(user.getId())).thenReturn(user);
        when(orderRepository.save(order)).thenReturn(order);
        assertEquals(OrderMapper.INSTANCE.orderToOrderDto(order), orderService.createOrder(orderRequest));
    }

    @Test
    public void whenOrderCreateForNoExistUser_shouldReturnNoSuchElementException() {

        OrderRequest orderRequest = new OrderRequest();
        User user = new User();
        user.setId(1L);
        Order order = new Order();
        order.setUser(user);
        when(userRepository.existsById(user.getId())).thenReturn(false);
        assertThrows(NullPointerException.class, () -> {
            orderService.createOrder(orderRequest);
        });
    }
}