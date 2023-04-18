package ru.clevertec.ecl.model.requests.order;

import lombok.Data;

@Data
public class OrderRequest {

    private Long certificateId;
    private Long userId;
}
