package ru.clevertec.ecl.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tag")
public class Tag implements BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tagid", nullable = false)
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "tagList", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<GiftCertificate> certificateList = new ArrayList<>();

}

