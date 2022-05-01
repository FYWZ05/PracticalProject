package com.practice.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.practice.entity.Product;

import java.util.*;

/**
 * PuPuDataAnalysis
 * 朴朴数据解析
 */
//https://j1.pupuapi.com/client/marketing/storeproduct/v2/search?
// category_id=100&business=scenes&business_id=100&store_id=7c1208da-907a-4391-9901-35a60096a3f9&page=2&&size=1
public class PPDA {
    /**
     * 处理数据并返回
     */
    public static Map<String, Object> getProductsData(String url){
        Map<String, Object> map = SendRequest.sendGet(url);
        if (map == null){
            return null;
        }
        Map<String, Object> resultMap = new HashMap<>();
        // 检查请求数据是否成功
        JSONObject respBody = JSONObject.parseObject(map.get("data").toString());
        String errcode = respBody.get("errcode").toString();
        String errmsg = respBody.get("errmsg").toString();
        resultMap.put("errcode",errcode);
        resultMap.put("errmsg",errmsg);
        if (!"0".equals(errcode)){// 请求不成功
            return resultMap;
        }

        // data 数据
        JSONObject dataJson = JSONObject.parseObject(respBody.get("data").toString());

        // data.count 记录数
        String count = dataJson.get("count").toString();

        // data.products 商品集
        JSONArray products = JSONArray.parseArray(dataJson.get("products").toString());
        List<Product> productList = new ArrayList<>();

        // 封装商品数据
        for (Object product : products) {
            Product p = new Product();
            JSONObject array = JSONObject.parseObject(product.toString());

            p.setProduct_id(array.get("product_id").toString());

            p.setName(array.get("name").toString());

            p.setPrice(Integer.parseInt(array.get("price").toString()));

            p.setSub_title(array.get("sub_title").toString());

            p.setMain_image("https://imgs.pupuapi.com/" + array.get("main_image").toString());

            Object spec = array.get("spec");
            p.setSpec(spec == null ? "" : spec.toString());

            Object origin = array.get("origin");
            p.setOrigin(origin == null ? "" : origin.toString());

            Object stock_quantity = array.get("stock_quantity");
            p.setStock_quantity(Integer.parseInt(stock_quantity == null ? "" : stock_quantity.toString()));

            Object discount_rate = array.get("discount_rate");
            p.setDiscount_rate(Double.parseDouble(discount_rate == null ? "" : discount_rate.toString()));
            productList.add(p);
        }
        // 最后map包含 errcode,errmsg,countproductList
        resultMap.put("count",count);
        resultMap.put("products",productList);

        return resultMap;
    }

}
