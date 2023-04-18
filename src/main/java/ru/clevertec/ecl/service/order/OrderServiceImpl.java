package ru.clevertec.ecl.service.order;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.clevertec.ecl.exceptions.NoSuchElementsException;
import ru.clevertec.ecl.model.dtos.OrderDto;
import ru.clevertec.ecl.model.entities.Order;
import ru.clevertec.ecl.model.entities.Tag;
import ru.clevertec.ecl.model.entities.User;
import ru.clevertec.ecl.model.requests.order.OrderRequest;
import ru.clevertec.ecl.repository.certificate.CertificateRepository;
import ru.clevertec.ecl.repository.order.OrderRepository;
import ru.clevertec.ecl.repository.user.UserRepository;
import ru.clevertec.ecl.utils.mapper.OrderMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ru.clevertec.ecl.utils.DateTime.getDate;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    private final CertificateRepository certificateRepository;

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Map<Integer, String> getUserOrderInformation(Long id) {
        Order order = orderRepository.findOrderInfoByUserId(id);
        Map<Integer, String> info = new HashMap<>();
        info.put(order.getOrderPrice(), order.getOrderDate());
        return info;
    }

    @Override
    public List<Order> getOrdersByUserId(Long id, PageRequest of) {
        return orderRepository.findAllByUserId(id);
    }

    @Override
    public OrderDto createOrder(OrderRequest orderRequest) {

        Order order = new Order();
        order.setCertificate(certificateRepository.getReferenceById(orderRequest.getCertificateId()));
        order.setUser(userRepository.getReferenceById(orderRequest.getUserId()));
        order.setOrderDate(getDate());
        order.setOrderPrice(order.getCertificate().getPrice());


        if (userRepository.existsById(order.getUser().getId())) {
            User userById = userRepository.getReferenceById(order.getUser().getId());
            userById.getOrderList().add(order);
            userRepository.save(userById);
        } else {
            throw new NoSuchElementsException(order.getId());
        }

        orderRepository.save(order);

        OrderDto orderDto = OrderMapper.INSTANCE.orderToOrderDto(order);
        orderDto.setPrice(order.getCertificate().getPrice());
        orderDto.setCertificateId(order.getCertificate().getId());
        orderDto.setUserId(order.getUser().getId());

        return orderDto;
    }

    @Override
    public Tag getMostWidelyUsedTag(Long id) {

        return orderRepository.mostWidelyUsedTag(id);
    }
}
