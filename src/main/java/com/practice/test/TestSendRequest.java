package com.practice.test;

import com.practice.utils.SendRequest;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class TestSendRequest {

    @Test
    public void testPost() {
        Map<String, Object> map = new HashMap<>();
        map.put("pn", "1");
        map.put("size", "1");
        Map<String, Object> postRespMap = SendRequest.sendPost("http://localhost:8080/products", map);
        if (postRespMap != null) {
            postRespMap.forEach((key, value) -> {
                System.out.println(key);
                System.out.println(value);
            });
        }
    }


    @Test
    public void testGet() {
        Map<String, Object> postRespMap = SendRequest.sendGet("http://localhost:8080/products?pn=1&size=5");
        if (postRespMap != null) {
            postRespMap.forEach((key, value) -> {
                System.out.println(key);
                System.out.println(value);
            });
        }
    }

//    @Test
//    public void testSendExport() {
//        Map<String, Object> map = new HashMap<>();
//        Map<String, String> context = new HashMap<>();
//        Map<String, String> device = new HashMap<>();
//
//        context.put("connect_duration", "276000");
//        context.put("dns_duration", "0");
//        context.put("duration", "375000");
//        context.put("error_msg", "");
//        context.put("req_pkg_len", "1144");
//        context.put("request_method", "POST");
//        context.put("request_url", "https://bwy1.pupuapi.com/datareport/report");
//        context.put("rsp_pkg_len", "42");
//        context.put("span_id", "9e6b15d98fee3f10");
//        context.put("status_code", "POST");
//        context.put("tore_id", "7c1208da-907a-4391-9901-35a60096a3f9");
//        context.put("timestamp", String.valueOf(System.currentTimeMillis()));
//        context.put("trace_id", "c6f4e9e6bf094250");
//        context.put("tsl_handshake_duration", "163000");
//
//        device.put("app_version=", "3.5.6");
//        device.put("device_id=", "d9c2e4d3ac31b6a893cdb002f97b0fc8");
//        device.put("device_manufacturer=", "samsung");
//        device.put("device_model=", "SM-G9810");
//        device.put("network", "wifi");
//        device.put("os_version", "10.0.0");
//        device.put("platform", "android");
//
//        map.put("app_id", "1000000");
//        map.put("context", context);
//        map.put("device", device);
//        map.put("when", String.valueOf(System.currentTimeMillis()));
//        map.put("what", "network_performance");
//
//        Map<String, Object> resultMap = SendRequest.sendPost("https://bwy1.pupuapi.com/datareport/report", map);
//        if (resultMap != null) {
//            System.out.println(resultMap.toString());
//        }
//    }
}
