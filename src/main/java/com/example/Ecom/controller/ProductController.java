package com.example.Ecom.controller;

import com.example.Ecom.dto.CreateProductDto;
import com.example.Ecom.model.Product;
import com.example.Ecom.repository.IProductRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/product")
public class ProductController {
    public IProductRepository productRepository;

    public ProductController(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public String AddProduct( @Valid @RequestBody CreateProductDto product) {

        Product newProduct= new Product();
        newProduct.name=product.name;
        newProduct.isActive=true;

        productRepository.save(newProduct);
        return "Product created successfully!";
    }

    @GetMapping
    public List<Product> GetAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("custom")
    public List<Product> GetAllCustomProducts(@RequestParam String name) {
        return  productRepository.CustomMethod(name);
    }

    @GetMapping("byname")
    public ResponseEntity<List<Product>> GetProductByName(@RequestParam String Name)
    {
        List<Product> product= productRepository.findByName(Name);

        return  ResponseEntity.ok(product);
    }

    @GetMapping("{id}")
    public Optional<Product> GetProductById(@PathVariable Integer id) {
        return productRepository.findById(id);
    }

    @GetMapping("countproduct")
    public  ResponseEntity<Long> CountProduct(){
        return ResponseEntity.ok(productRepository.count());
    }

    @DeleteMapping("{id}")
    public String DeleteProduct(@PathVariable Integer id) {
        Boolean isProductExists=productRepository.existsById(id);

        if(!isProductExists){
            return "Product not found!";
        }

        productRepository.deleteById(id);
        return "Product deleted successfully!";
    }


    @PutMapping("{id}")
    public ResponseEntity<String> UpdateProduct(@PathVariable Integer id, @RequestBody Product product) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (!existingProduct.isPresent()) {
            return ResponseEntity.badRequest().body("Product not found!");
        } else {
            existingProduct.get().name = product.name;
            productRepository.save(existingProduct.get());

            return ResponseEntity.ok("Product updated successfully!");
        }
    }
}
