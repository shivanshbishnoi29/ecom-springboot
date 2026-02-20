package com.example.Ecom.repository;

import com.example.Ecom.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product,Integer> {
public List<Product> findByName(String x);
public  long count();
public Boolean existsById(int id);

@Query(value = "SELECT * FROM products_table WHERE NAME!='string' and NAME=:name",nativeQuery = true)
public List<Product> CustomMethod(@Param("name") String name);
}