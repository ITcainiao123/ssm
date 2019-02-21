package com.itheima.service.impl;

import com.itheima.domain.Product;
import com.itheima.domain.Pojo;
import com.itheima.mapper.ProductMapper;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> findAll() {
        return productMapper.findAll();
    }
    @Override
    public void deleteByIds(String[] ids) {
        for (String id : ids) {
            productMapper.deleteByIds(id);
        }

    }

    @Override
    public void open(String id) {
        productMapper.open(id);
    }

    @Override
    public void close(String id) {
        productMapper.close(id);
    }

    @Override
    public boolean judgeAdd(String productNum) {
        List<Product> list = findAll();
        for (Product product : list) {
            if (product.getProductNum().equals(productNum)){
                return false;
            }
        }
        return true;
    }

    @Override
    public void add(Product product) {
        productMapper.add(product);
    }

    @Override
    public List<Product> funzzyQuery(String productName) {
        Pojo poJo =new Pojo();
        poJo.setpName(productName);
        System.out.println(poJo.getpName());
        return productMapper.funzzyQuery(poJo);
    }

    @Override
    public Product compile(String id) {
        return productMapper.compile(id);
    }

    @Override
    public void update(Product product) {
        productMapper.update(product);
    }
}
