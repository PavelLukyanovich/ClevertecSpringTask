package ru.clevertec.ecl.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class GiftCertificate {

    private int id;
    private String name;
    private String description;
    private int price;
    private String duration;
    private String createDate;
    private String lastUpdateDate;

}
