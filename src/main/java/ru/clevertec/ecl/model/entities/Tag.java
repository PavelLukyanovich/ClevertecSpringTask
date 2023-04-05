package ru.clevertec.ecl.model.entities;

import lombok.*;

import javax.persistence.*;
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
    private List<GiftCertificate> certificateList = new ArrayList<>();

    public void addCertificate(GiftCertificate certificate) {
        certificate.setTagList(List.of(this));
        certificateList.add(certificate);
    }
}

