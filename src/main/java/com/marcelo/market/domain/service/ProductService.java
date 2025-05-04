package com.marcelo.market.domain.service;

import com.marcelo.market.domain.Product;
import com.marcelo.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service    //Agrega una diferenciacion semantica de que es esta clase. Es un servicio de nuestra logica de negocio
public class ProductService {
    @Autowired
    private ProductRepository productRepository;        //Inyecta la interfaz ProductRepository

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId) {
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public boolean delete(int productId) {
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}
