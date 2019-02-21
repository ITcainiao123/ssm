package com.itheima.mapper;

import com.itheima.domain.Pojo;
import com.itheima.domain.Product;

import java.util.List;

public interface ProductMapper {
    List<Product> findAll();

    void add(Product product);

    void deleteByIds(String id);

    void open(String id);

    void close(String id);

    List<Product> funzzyQuery(Pojo pojo);

    Product compile(String id);

    void update(Product product);
    Product findById(String id);
}
