package ru.clevertec.ecl.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order implements BaseEntity<Long> {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id", insertable = false, updatable = false)
    Long userId;
    @Column(name = "certificate_id")
    Long certificateId;
    @Column(name = "order_price")
    Integer orderPrice;
    @Column(name = "order_date")
    LocalDate orderDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
}
