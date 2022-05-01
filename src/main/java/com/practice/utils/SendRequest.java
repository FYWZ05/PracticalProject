package com.practice.utils;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.*;

/**
 * 发送请求工具类
 * 包含两个方法 发送POST请求和GET请求
 */
public class SendRequest {

//    private static final Map<String, String> headerMap = new HashMap<>();

//    static {
//        headerMap.put("pp-version", "2021062503");
//        headerMap.put("pp_storeid", "7c1208da-907a-4391-9901-35a60096a3f9");
//        headerMap.put("sign", "cd94b38c2c2e9d7a268b1d2afb45ce07");
//        headerMap.put("pp-placeid", "ee25e658-9737-4e8b-a4e8-a1b463bf8175");
//        headerMap.put("pp-os", "10");
//        headerMap.put("Content-Type", "application/json; charset=utf-8");
//        headerMap.put("Host", "j1.pupuapi.com");
//        headerMap.put("X-B3-TraceId", "84eb045f6e288aa0");
//        headerMap.put("X-B3-SpanId", "a4daf7c5606276e0");
//        headerMap.put("User-Agent", "Pupumall/3.5.6;Android/10.0.0;d9c2e4d3ac31b6a893cdb002f97b0fc8");
//        headerMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
//    }

    public static Map<String, Object> sendGet(String url) {
        Map<String, Object> map = new HashMap<>();
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 添加头信息
        HttpGet httpGet = new HttpGet(url);
//        headerMap.entrySet().iterator().forEachRemaining(i -> {
//            httpGet.addHeader(new BasicHeader(i.getKey(),i.getValue()));
//        });

        // 处理
        try (CloseableHttpResponse httpResponse = httpclient.execute(httpGet)) {
            map.put("status", httpResponse.getStatusLine());
            HttpEntity entity1 = httpResponse.getEntity();
            map.put("data", EntityUtils.toString(entity1));
            EntityUtils.consume(entity1);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return map;
    }

    public static Map<String, Object> sendPost(String url, Map<String, Object> params) {

        Map<String, Object> map = new HashMap<>();

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        // 键值参数
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        Iterator<Map.Entry<String, Object>> iterator = params.entrySet().iterator();
        iterator.forEachRemaining((entry) -> {
            nameValuePairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
        });

        try {
            // 执行请求
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            CloseableHttpResponse httpResponse = httpclient.execute(httpPost);
            // 响应状态
            map.put("status", httpResponse.getStatusLine());// HTTP/1.1 200
            // 数据处理
            HttpEntity entity = httpResponse.getEntity();
            map.put("data", EntityUtils.toString(entity));
            // 关闭流
            EntityUtils.consume(entity);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return map;
    }
}
