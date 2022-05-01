package com.practice.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.practice.dao.ProductImpl;
import com.practice.entity.Product;
import com.practice.utils.PPDA;
import com.practice.utils.URLData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * 从朴朴上获取并保存到数据库
 */
@WebServlet("/pupu")
public class GetPuPuService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取参数
        String page = req.getParameter("page").trim();
        String size = req.getParameter("size").trim();
        String menu = req.getParameter("menu").trim();

        PrintWriter writer = resp.getWriter();
        // 响应前端map
        Map<String, Object> map = new HashMap<>();
//        map.put("params", category_id + "/" + business_id + "/" + store_id + "/" + page + "/" + size + "/" + isSave);

        // 数据检查
        if ("".equals(page) || "".equals(size) || "".equals(menu)) {
            map.put("code", "-1");
            map.put("error", "参数异常");
            writer.write(JSON.toJSONString(map));
            writer.close();
        }

        // 获取地址
        String url = URLData.getURL(menu, page, size);
        if (url == null) {
            map.put("code", "-1");
            map.put("error", "获取地址失败");
            writer.write(JSON.toJSONString(map));
            writer.close();
        }

        // 请求数据
        Map<String, Object> mapGet = PPDA.getProductsData(url);

        // 请求结果检查
        if (mapGet == null) {
            map.put("code", "-1");
            map.put("error", "请求过程中出现了异常");
            writer.write(JSON.toJSONString(map));
            writer.close();
            return;
        }

        List<Product> list = (ArrayList) mapGet.get("products");

        // 商品数据为空
        if (list == null) {
            map.put("code", "0");
            map.put("error", "没有查询到任何结果");
            writer.write(JSON.toJSONString(map));
            writer.close();
            return;
        }
        int i = 0;

        // 保存数据
        i = new ProductImpl().addProduct(list);

        // 响应前端
        map.put("code", "1");
        map.put("error", "");
        map.put("saveCount", i);
        map.put("products", list);

        writer.write(JSONObject.toJSONString(map));
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
