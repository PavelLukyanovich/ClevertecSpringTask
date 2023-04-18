package ru.clevertec.ecl.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.clevertec.ecl.model.entities.Order;
import ru.clevertec.ecl.model.entities.Tag;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, PagingAndSortingRepository<Order, Long> {

    List<Order> findAllByUserId(Long id);

    Order findOrderInfoByUserId(Long id);

    @Query(value = "SELECT t.name AS tag_name\n" +
            "FROM tag t\n" +
            "JOIN certificate_tag ct ON t.tagid = ct.tag_id\n" +
            "JOIN gift_certificate gc ON ct.certificate_id = gc.certificateid\n" +
            "JOIN orders o ON gc.certificateid = o.certificate_id\n" +
            "JOIN users u ON o.user_id = u.user_id\n" +
            "WHERE u.user_id = :id\n" +
            "GROUP BY t.name, o.order_price\n" +
            "ORDER BY o.order_price DESC, COUNT(*) DESC\n" +
            "LIMIT 1", nativeQuery = true)
    Tag mostWidelyUsedTag(@Param("id") Long id);
}
