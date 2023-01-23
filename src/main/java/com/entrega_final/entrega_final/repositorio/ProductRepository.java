package com.entrega_final.entrega_final.repositorio;

import com.entrega_final.entrega_final.entidades.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
