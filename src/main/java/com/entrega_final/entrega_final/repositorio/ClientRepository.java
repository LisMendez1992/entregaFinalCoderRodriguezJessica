package com.entrega_final.entrega_final.repositorio;

import com.entrega_final.entrega_final.entidades.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
