package jfSpringBoot.service;

import jfSpringBoot.Model.Product;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Lazy
@Service
@ConditionalOnProperty(name= "service.products", havingValue = "list")

public class ProductsServiceImpl implements ProductService {

    public ProductsServiceImpl()
    {
        System.out.println("Instancia de la clase ");
    }

    List<Product> products = new ArrayList<>(Arrays.asList(
        new Product(1, "laptop", 2633.99, 2),
        new Product(2, "asus", 522.90, 2),
        new Product(3, "tablet", 684.00, 2),
        new Product(4, "telefono", 452.00, 2)
    ));

    @Override
    public List<Product> getProducts()
    {
        return products;
    }
}
