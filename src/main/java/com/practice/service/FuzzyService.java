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
import java.util.*;

/**
 * 模糊查询
 */
@WebServlet("/fuzzy")
public class FuzzyService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        Map<String, Object> map = new HashMap<>();

        String word = req.getParameter("word").trim();

        if ("".equals(word)){
            map.put("code", "-1");
            map.put("error", "关键字为空");
            map.put("word", word);
            writer.write(JSON.toJSONString(map));
            writer.close();
        }

        String[] words = word.split("#");
        List<String> wordList = Arrays.asList(words);

        ProductDAO productDAO = new ProductImpl();
        List<Product> productList = productDAO.selectProduct(wordList);
        int count = productList == null ? 0 : productList.size();
        map.put("code", "1");
        map.put("error", "");
        map.put("count", count);
        map.put("products", productList);
        writer.write(JSON.toJSONString(map));
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
