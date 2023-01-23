package com.entrega_final.entrega_final.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ReceiptItemDTO {

    private Long id_item;
    private Long productId;

    private String product_name;

    private Double product_price;

    private int quantity;
    private Double totalItem;


}
