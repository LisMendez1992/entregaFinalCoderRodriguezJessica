package com.entrega_final.entrega_final.servicio;

import com.entrega_final.entrega_final.entidades.Client;
import com.entrega_final.entrega_final.entidades.Product;
import com.entrega_final.entrega_final.repositorio.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        Optional<Product> prod = productRepository.findById(id);
        try {
            return prod.get();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("No existe un producto con ID: " + id);
        }
    }


    public Product save(Product productoRequest) {
        Product product = Product.builder()
                .name(productoRequest.getName())
                .stock(productoRequest.getStock())
                .price(productoRequest.getPrice())
                .build();
        return productRepository.save(product);


    }

    public void discountStock (Product product,Integer stock){
        Integer newStock = product.getStock() - stock;
        product.setStock(newStock);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }


}
