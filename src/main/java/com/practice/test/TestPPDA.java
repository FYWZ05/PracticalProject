package com.practice.test;

import com.practice.utils.PPDA;
import com.practice.utils.URLData;
import org.junit.Test;

import java.time.Instant;
import java.util.Map;

public class TestPPDA {
    //https://j1.pupuapi.com/client/marketing/storeproduct/v2/search?
// category_id=100&business=scenes&business_id=100&store_id=7c1208da-907a-4391-9901-35a60096a3f9&page=2&&size=1
    @Test
    public void testGetProductsData(){
        String url = "https://j1.pupuapi.com/client/marketing/storeproduct/v2/search?category_id=100&business=scenes&business_id=100&store_id=7c1208da-907a-4391-9901-35a60096a3f9&page=2&&size=5";
        Map<String, Object> productsData = PPDA.getProductsData(url);
        if (productsData != null) {
            productsData.forEach((key, value) -> {
                System.out.println(key);
                System.out.println(value);
            });
        }

    }
//    GET https://j1.pupuapi.com/client/search/search_box/products?page=1&
//    place_id=ee25e658-9737-4e8b-a4e8-a1b463bf8175&place_zip=350102&search_term=%E6%B0%B4%E6%9E%9C
//    &search_term_from=20&size=20&sort=0&store_id=7c1208da-907a-4391-9901-35a60096a3f9 HTTP/1.1

    @Test
    public void testSearchPuPu(){
        String url = "https://j1.pupuapi.com/client/search/search_box/products?page=1&" +
                "place_id=ee25e658-9737-4e8b-a4e8-a1b463bf8175&place_zip=350102&search_term=%E6%B0%B4%E6%9E%9C" +
                "&search_term_from=20&size=20&sort=0&store_id=7c1208da-907a-4391-9901-35a60096a3f9";
        Map<String, Object> productsData = PPDA.getProductsData(url);
        if (productsData != null) {
            productsData.forEach((key, value) -> {
                System.out.println(key);
                System.out.println(value);
            });
        }
    }

    @Test
    public void testTime(){
        System.out.println(System.currentTimeMillis());

//        System.out.println(URLData.getURL("你好", "1", "1") == null);
    }
}
