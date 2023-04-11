package ru.clevertec.ecl.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order implements BaseEntity<Long> {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "user_id")
    Long userId;
    @Column(name = "certificate_id")
    Long certificateId;
    @Column(name = "order_date")
    LocalDate orderDate;
}
