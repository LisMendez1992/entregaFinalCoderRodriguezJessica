package com.entrega_final.entrega_final.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "receipt")
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receipt_id", columnDefinition = "integer(11)")
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", columnDefinition = "integer(11)")
    @JsonIgnore
    private Client client;


    @OneToMany(mappedBy = "receipt")
    @JsonManagedReference
    private List<ReceiptItem> items;


    @Column(name = "create_at", columnDefinition = "datetime")
    private ZonedDateTime createAt;


    @Column(name = "total")
    private Double total;





}
