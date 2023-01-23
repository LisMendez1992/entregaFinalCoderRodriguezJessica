package com.entrega_final.entrega_final.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="Products")
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "product_id", columnDefinition = "integer(11)")
    private Long id;

    @NotNull(message = "El nombre del producto no puede ser null")
    @NotBlank(message = "El nombre del producto no puede estar vacío")
    private  String name;

    @Min(message = "El stock del producto no puede ser un número negativo", value = 0)
    private  Integer stock;
    @NotNull(message = "El precio del producto no puede ser null")
    @Min(message = "El precio del producto no puede ser un número negativo", value = 0)
    private  Double price;

 /*   @JsonManagedReference
    @OneToMany(mappedBy = "product",cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<ReceiptItem> lines;
*/

}