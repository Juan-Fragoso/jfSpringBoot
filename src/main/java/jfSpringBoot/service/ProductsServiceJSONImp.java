package jfSpringBoot.service;

import jfSpringBoot.Model.Product;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;
import java.util.List;

@Service
@ConditionalOnProperty(name= "service.products", havingValue = "json")
public class ProductsServiceJSONImp implements ProductService {

    @Override
    public List<Product> getProducts() {
        List<Product> products;

        products = new ObjectMapper().readValue(this.getClass().getResourceAsStream("/products.json"),
                new TypeReference<List<Product>>() {});

        return products;
    }
}
