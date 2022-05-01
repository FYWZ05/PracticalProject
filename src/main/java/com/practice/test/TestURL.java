package com.practice.test;

import com.practice.utils.PPDA;
import com.practice.utils.URLData;
import org.junit.Test;

import java.util.Map;

public class TestURL {

    @Test
    public void test(){
        String url = URLData.getURL("肉禽蛋", "1", "5");
        Map<String, Object> productsData = PPDA.getProductsData(url);
        System.out.println(url);
        if (productsData != null){
            System.out.println(productsData.toString());
        }else{
            System.out.println("null");
        }
    }
}
