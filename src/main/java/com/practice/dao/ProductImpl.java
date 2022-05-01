package com.practice.dao;

import com.practice.entity.Product;
import com.practice.utils.Connector;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class ProductImpl implements ProductDAO {
    private final Connector conUtil = new Connector();

    /**
     * 增加一个或者多个商品
     *
     * @param products 商品集
     * @return 添加的记录数
     */
    @Override
    public int addProduct(List<Product> products) {

        Connection conn = conUtil.getConnection();
        PreparedStatement ps = null;
        if (conn == null) {
            return -1;
        }
        try {
            // 添加 存在即更新价格
            ps = conn.prepareStatement("insert into tb_product values (?,?,?,?,?,?,?,?,?) on duplicate key update price = ?");
            // 添加成功的个数
            int count = 0;
            for (Product product : products) {
                // 给占位符赋值
                ps.setString(1, product.getProduct_id());
                ps.setString(2, product.getName());
                ps.setInt(3, product.getPrice());
                ps.setString(4, product.getSub_title());
                ps.setString(5, product.getMain_image());
                ps.setString(6, product.getSpec());
                ps.setString(7, product.getOrigin());
                ps.setInt(8, product.getStock_quantity());
                ps.setDouble(9, product.getDiscount_rate());
                ps.setInt(10, product.getPrice());
                count += ps.executeUpdate();
            }
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            // 资源关闭
            conUtil.close(null, ps, conn);
        }
    }

    /**
     * @param pn   页码
     * @param size 页长度
     * @return 商品列表
     */
    @Override
    public List<Product> selectProduct(int pn, int size) {
        int count = getCount();
        if (count == 0) {
            return null;
        }
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            conn = conUtil.getConnection();
            ps = conn.prepareStatement("select * from tb_product limit ?,?");
            ps.setInt(1, (pn - 1) * size);
            ps.setInt(2, pn * size);
            rs = ps.executeQuery();
            List<Product> productList = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setProduct_id(rs.getString("product_id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getInt("price"));
                product.setSub_title(rs.getString("sub_title"));
                product.setMain_image(rs.getString("main_image"));
                product.setSpec(rs.getString("spec"));
                product.setOrigin(rs.getString("origin"));
                product.setStock_quantity(rs.getInt("stock_quantity"));
                product.setDiscount_rate(rs.getDouble("discount_rate"));
                productList.add(product);
            }
            return productList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conUtil.close(rs, ps, conn);
        }
    }

    /**
     * @param idList 商品id 可以是多个id的ArrayList
     * @return 删除记录数
     */
    @Override
    public int deleteProduct(List<String> idList) {
        Connection conn;
        PreparedStatement ps;
        try {
            conn = conUtil.getConnection();
            int count = 0;
            for (String id : idList) {
                ps = conn.prepareStatement("delete from tb_product where product_id = ?");
                ps.setString(1, id);
                count += ps.executeUpdate();
            }
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * @return 商品总数量
     */
    @Override
    public int getCount() {
        Connection conn = conUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = conn.prepareStatement("select count(*) from tb_product");
            resultSet = ps.executeQuery();
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            conUtil.close(resultSet, ps, conn);
        }
    }

}
