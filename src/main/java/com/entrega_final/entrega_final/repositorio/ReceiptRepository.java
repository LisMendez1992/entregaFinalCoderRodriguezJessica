package com.entrega_final.entrega_final.repositorio;

import com.entrega_final.entrega_final.entidades.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository<Receipt,Long> {
}
