package com.practice.service;

import com.alibaba.fastjson.JSON;
import com.practice.dao.ProductDAO;
import com.practice.dao.ProductImpl;

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
 * 删除数据服务
 */
@WebServlet("/delete")
public class DeleteService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id").trim();
        PrintWriter writer = resp.getWriter();
        Map<String,String> map = new HashMap<>();
        if ("".equals(id)){
            map.put("code", "0");
            map.put("error", "参数为空");
            writer.write(JSON.toJSONString(map));
            writer.close();
        }

        List<String> idList = new ArrayList<>();
        idList.add(id);
        ProductDAO productDAO = new ProductImpl();
        int i = productDAO.deleteProduct(idList);

        map.put("code", "1");
        map.put("error", "");
        map.put("count", String.valueOf(i));
        writer.write(JSON.toJSONString(map));
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
