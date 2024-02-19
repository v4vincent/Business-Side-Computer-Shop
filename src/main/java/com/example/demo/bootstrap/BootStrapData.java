package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;
    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository = outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Check if the sample inventory is already loaded
        if (productRepository.count() == 0 && partRepository.count() == 0) {
            loadSampleInventory();
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products: " + productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts: " + partRepository.count());
        System.out.println(partRepository.findAll());
    }

    private void loadSampleInventory() {
        // Add sample products
        productRepository.save(new Product("Apple Laptop", 1599.99, 10));
        productRepository.save(new Product("Apple Desktop", 1999.99, 10));
        productRepository.save(new Product("Windows Laptop", 999.99, 10));
        productRepository.save(new Product("Gaming PC", 2499.99, 20));
        productRepository.save(new Product("Office Desktop", 1299.99, 30));


        // Add sample parts
        partRepository.save(new Part("Monitor", 129.99, 10, 5, 15)); // minInv, maxInv added
        partRepository.save(new Part("Keyboard", 49.99, 20, 10, 30));
        partRepository.save(new Part("Mouse", 19.99, 30, 15, 45));
        partRepository.save(new Part("RAM (8GB)", 79.99, 50, 25, 75));
        partRepository.save(new Part("Hard Drive (1TB)", 99.99, 40, 20, 60));


    }
}