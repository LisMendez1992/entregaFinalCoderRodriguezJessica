package com.entrega_final.entrega_final.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "receipt_items")
public class ReceiptItem {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receipt_items_id", columnDefinition = "integer(11)")
    private  Long id_item;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_id", columnDefinition = "integer(11)")
    @JsonIgnore
    private Product product;

    @Column(name = "detail", columnDefinition = "varchar(255)")
    private String detail;
    @Column(name = "quantity", columnDefinition = "integer(11)")
    private Integer quantity;

    @Column(name = "total_item", columnDefinition = "integer(11)")
    private Double totalItem;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "receipt_id", columnDefinition = "integer(11)")
    @JsonIgnore
    Receipt receipt;







}
