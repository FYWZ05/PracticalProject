package com.practice.service;

import com.alibaba.fastjson.JSON;
import com.practice.dao.ProductDAO;
import com.practice.dao.ProductImpl;
import com.practice.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 从数据库获取数据
 */
@WebServlet("/products")
public class SearchDbService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 参数
        String pnStr = req.getParameter("pn");
        String sizeStr = req.getParameter("size");

        Map<String,Object> map = new HashMap<>();
        PrintWriter writer = resp.getWriter();
        // 处理参数
        if(pnStr.length() < 1 || sizeStr.length() < 1){
            // 空值异常
            map.put("code", "0");
            map.put("error", "参数异常");
            map.put("pn", pnStr);
            map.put("size", sizeStr);
            writer.write(JSON.toJSONString(map));
            writer.close();
            return;
        }

        int pn = Integer.parseInt(pnStr);
        int size = Integer.parseInt(sizeStr);

        if (pn < 1 || size < 1){
            // 数值异常
            map.put("code", "-1");
            map.put("error", "参数异常");
            map.put("pn", pn);
            map.put("size", size);
            writer.write(JSON.toJSONString(map));
            writer.close();
            return;
        }

        // 获取信息
        ProductDAO productDAO = new ProductImpl();
        List<Product> productList = productDAO.selectProduct(pn, size);

        map.put("code", "1");
        map.put("products", productList);
        // 返回信息
        writer.write(JSON.toJSONString(map));
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
