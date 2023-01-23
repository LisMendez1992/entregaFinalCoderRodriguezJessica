package com.entrega_final.entrega_final.controller;

import com.entrega_final.entrega_final.dto.ReceiptDTO;
import com.entrega_final.entrega_final.dto.ReceiptItemDTO;
import com.entrega_final.entrega_final.entidades.Client;
import com.entrega_final.entrega_final.entidades.Product;
import com.entrega_final.entrega_final.entidades.Receipt;
import com.entrega_final.entrega_final.entidades.ReceiptItem;
import com.entrega_final.entrega_final.servicio.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/receipt")
public class ReceiptController {

    @Autowired
    ReceiptService receiptService;


    @PostMapping(value = "/add", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> createClient(@RequestBody @Valid ReceiptDTO receipt) {
        try {
            return new ResponseEntity<>(receiptService.buildReceipt(receipt), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Receipt> findReceiptById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(receiptService.getReceiptById(id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        Receipt receipt = receiptService.getReceiptById(id);
        if (receipt != null) {
            receiptService.deleteReceipt(id);
            return ResponseEntity.ok("Se elimino el comprobante correctamente");
        } else {
            throw new RuntimeException();
        }


    }

}
