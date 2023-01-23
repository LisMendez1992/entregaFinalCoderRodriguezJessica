package com.entrega_final.entrega_final.servicio;

import com.entrega_final.entrega_final.dto.ReceiptDTO;
import com.entrega_final.entrega_final.entidades.Client;
import com.entrega_final.entrega_final.entidades.Product;
import com.entrega_final.entrega_final.entidades.Receipt;
import com.entrega_final.entrega_final.entidades.ReceiptItem;
import com.entrega_final.entrega_final.repositorio.ClientRepository;
import com.entrega_final.entrega_final.repositorio.ReceiptItemRepository;
import com.entrega_final.entrega_final.repositorio.ReceiptRepository;
import com.entrega_final.entrega_final.repositorio.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

@Service
@Transactional
public class ReceiptService {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ReceiptRepository receiptRepository;
    @Autowired
    ReceiptItemRepository receiptItemRepository;

    @Autowired
    ClientService clientService;

    @Autowired
    ProductService productService;

    @Autowired
    WorldClockService worldClockService;

    private Double totalReceipt;

    public Client findClient(Long id) {
        return clientService.getClientById(id);
    }

    public Product findProduct(Long id) {
        return productService.getProductById(id);
    }


    public Receipt buildReceipt(ReceiptDTO receiptRequest) {
        Client cli = findClient(receiptRequest.getClientId());
        ZonedDateTime currentDate = worldClockService.getCurrentDateTime();
        Receipt r = Receipt.builder()
                .items(buildReceiptItem(receiptRequest))
                .client(cli)
                .createAt(currentDate)
                .total(totalReceipt)
                .build();
        return receiptRepository.save(r);
    }

    public ArrayList<ReceiptItem> buildReceiptItem(ReceiptDTO receiptRequest) {
        ArrayList<ReceiptItem> items = new ArrayList<>();
        this.totalReceipt = 0.0;
        for (int i = 0; i < receiptRequest.getItems().size(); i++) {
            Product prod = findProduct(receiptRequest.getItems().get(i).getProductId());
            if (prod.getStock() >= receiptRequest.getItems().get(i).getQuantity()) {
                ReceiptItem item = ReceiptItem.builder()
                        .product(prod)
                        .detail(prod.getName())
                        .quantity(receiptRequest.getItems().get(i).getQuantity())
                        .totalItem(prod.getPrice() * receiptRequest.getItems().get(i).getQuantity())
                        .build();
                receiptItemRepository.save(item);
                Double totalItem = prod.getPrice() * receiptRequest.getItems().get(i).getQuantity();
                this.totalReceipt = totalReceipt + totalItem;
                items.add(item);
                productService.discountStock(prod, receiptRequest.getItems().get(i).getQuantity());
            } else {
                throw new RuntimeException("No hay stock");
            }

        }

        return items;
    }


    public Receipt getReceiptById(Long id) {
        return receiptRepository.findById(id).orElseThrow(() -> new RuntimeException("No existe un comprobante con ID: " + id));
    }

    public void deleteReceipt(Long id) {
        receiptRepository.deleteById(id);
    }



}


