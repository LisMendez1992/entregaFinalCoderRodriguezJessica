package com.entrega_final.entrega_final.repositorio;

import com.entrega_final.entrega_final.entidades.ReceiptItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptItemRepository extends JpaRepository<ReceiptItem,Long> {
}
