package com.practice.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.practice.dao.ProductDAO;
import com.practice.dao.ProductImpl;
import com.practice.entity.Product;
import com.practice.utils.PPDA;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户自定义的接口请求朴朴数据
 */
@WebServlet("/custom")
public class CustomPuPuService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,Object> map = new HashMap<>();
        PrintWriter writer = resp.getWriter();
        String url = req.getParameter("url").trim();
        if ("".equals(url) || (!url.contains("http:") && !url.contains("https:"))){
            // 空值异常
            map.put("code", "0");
            map.put("error", "参数异常");
            map.put("url", url);
            writer.write(JSON.toJSONString(map));
            writer.close();
            return;
        }

        // 数据处理
        Map<String, Object> productsData = PPDA.getProductsData(url);
        if (productsData == null){
            map.put("code", "-1");
            map.put("error", "没有查询到任何商品");
            map.put("url", url);
            writer.write(JSON.toJSONString(map));
            writer.close();
            return;
        }
        List<Product> list = (ArrayList) productsData.get("products");

        if (list != null){
            ProductImpl product = new ProductImpl();
            map.put("count", product.addProduct(list));
        }
        // 响应前端
        map.put("code", "1");
        map.put("error", "");
        map.put("products", list);
        writer.write(JSON.toJSONString(map));
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
