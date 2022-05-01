package com.practice.dao;

import com.practice.entity.Product;

import java.util.List;

public interface ProductDAO {
    // 添加商品
    int addProduct(List<Product> products);
    // 查询商品
    List<Product> selectProduct(int pn, int size);
    List<Product> selectProduct(List<String> words);
    int getCount();
    // 删除商品
    int deleteProduct(List<String> ids);
}
