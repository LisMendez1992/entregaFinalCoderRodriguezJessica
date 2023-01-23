package com.entrega_final.entrega_final.dto;

import com.entrega_final.entrega_final.entidades.Receipt;
import com.entrega_final.entrega_final.entidades.ReceiptItem;
import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor


public class ReceiptDTO  {


    private Long id;
    private Long clientId;

    private LocalDate createAt;
    private List<ReceiptItemDTO> items;
    private Double total;







}
