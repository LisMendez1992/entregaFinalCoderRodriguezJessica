package com.entrega_final.entrega_final.entidades;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="Clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", columnDefinition = "integer(11)")
    private Long id;
    @NotNull(message = "El nombre no puede ser null")
    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;
    @NotBlank(message = "El apellido no puede estar vacío")
    @NotNull(message = "El apellido no puede ser null")
    private String surname;

    @NotBlank(message = "El email no puede estar vacío")
    @NotNull(message = "El email no puede ser null")
    @Email(message = "El email es invalido")
    private String email;

    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "client", cascade = CascadeType.PERSIST)
    private List<Receipt> receipts;




}