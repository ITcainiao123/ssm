package com.itheima.service;

import com.itheima.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void deleteByIds(String[] ids);

    void open(String id);

    void close(String id);
    boolean judgeAdd(String productNum);

    void add(Product product);

    List<Product> funzzyQuery(String productName);

    Product compile(String id);

    void update(Product product);
}
