package ru.clevertec.ecl.model.requests.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    private Long certificateId;
    private Long userId;
}
