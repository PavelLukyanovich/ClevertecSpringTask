package ru.clevertec.ecl.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.clevertec.ecl.exceptions.NoSuchElementsException;
import ru.clevertec.ecl.model.dtos.OrderDto;
import ru.clevertec.ecl.model.dtos.TagDto;
import ru.clevertec.ecl.model.entities.Order;
import ru.clevertec.ecl.model.requests.order.OrderRequest;
import ru.clevertec.ecl.repository.user.UserRepository;
import ru.clevertec.ecl.service.order.OrderService;
import ru.clevertec.ecl.utils.mapper.TagMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final UserRepository userRepository;

    @PostMapping
    public OrderDto createOrder(@RequestBody OrderRequest createOrderRequest) {

        return orderService.createOrder(createOrderRequest);
    }

    @GetMapping("info/{id}")
    public Map<Integer, String> getUsersOrderInformation(@PathVariable Long id) {

        return orderService.getUserOrderInformation(id);
    }

    @GetMapping("/users/{id}")
    public List<Order> getOrdersByUserId(@RequestParam(required = false, defaultValue = "0") int page,
                                         @RequestParam(required = false, defaultValue = "2") int size,
                                         @PathVariable Long id) {

        if (!userRepository.existsById(id)) {
            throw new NoSuchElementsException(id);
        }
        return orderService.getOrdersByUserId(id, PageRequest.of(page, size));
    }

    @GetMapping(value = "/widely/{id}")
    public TagDto mostWidelyUsedTag(@PathVariable Long id) {

        return TagMapper.INSTANCE.tagToTagDto(orderService.getMostWidelyUsedTag(id));
    }

}

