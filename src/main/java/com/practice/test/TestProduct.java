package com.practice.test;

import com.practice.dao.ProductDAO;
import com.practice.dao.ProductImpl;
import com.practice.entity.Product;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestProduct {
    private final ProductDAO productDAO = new ProductImpl();
    @Test
    public void testInsertProduct(){

        // Product product = new Product("test11","test",100,"test","test","test","test",999,0.5);

        List<Product> productList = new ArrayList<>();
         Product product1 = new Product("test22","test",102,"test","test","test","test",999,0.5);
        productList.add(product1);

//        for (int i = 0; i < 100; i++) {
//            productList.add(new Product("test5" + i,"name",999,"title","images","spec","orgin",100 + i,9.00));
//        }
        int i = productDAO.addProduct(productList);

        System.out.println(i);
    }

    @Test
    public void testSelectCount(){
        System.out.println(productDAO.getCount());
    }

    @Test
    public void testSelectProduct(){
        List<Product> productList = productDAO.selectProduct(1, 10);
        productList.forEach(System.out::println);
    }


    @Test
    public void testDeleteProduct(){
        List<String> list = new ArrayList<>();
        list.add("test1");
        list.add("test3");
        System.out.println(productDAO.deleteProduct(list));
    }

}
