package com.practice.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class URLData {
    public static final Map<String, String> urlMap = new HashMap<>();
    static {
        urlMap.put("蔬菜", "https://j1.pupuapi.com/client/marketing/storeproduct/v2/search?category_id=110&business=scenes&business_id=110&store_id=7c1208da-907a-4391-9901-35a60096a3f9&${page}&p=1&${size}&sort=0&name=&tag=-1&in_stock=-1&accuracy=0");
        urlMap.put("水果", "https://j1.pupuapi.com/client/marketing/storeproduct/v2/search?category_id=100&business=scenes&business_id=100&store_id=7c1208da-907a-4391-9901-35a60096a3f9&${page}&p=1&${size}&sort=0&name=&tag=-1&in_stock=-1&accuracy=0");
        urlMap.put("肉禽蛋", "https://j1.pupuapi.com/client/marketing/storeproduct/v2/search?category_id=120&business=scenes&business_id=120&store_id=7c1208da-907a-4391-9901-35a60096a3f9&${page}&p=1&${size}&sort=0&name=&tag=-1&in_stock=-1&accuracy=0");
        urlMap.put("海鲜水产", "https://j1.pupuapi.com/client/marketing/storeproduct/v2/search?category_id=130&business=scenes&business_id=130&store_id=7c1208da-907a-4391-9901-35a60096a3f9&${page}&p=1&${size}&sort=0&name=&tag=-1&in_stock=-1&accuracy=0");
        urlMap.put("粮油调味", "https://j1.pupuapi.com/client/marketing/storeproduct/v2/search?category_id=400&business=scenes&business_id=400&store_id=7c1208da-907a-4391-9901-35a60096a3f9&${page}&p=1&${size}&sort=0&name=&tag=-1&in_stock=-1&accuracy=0");
        urlMap.put("方便菜", "https://j1.pupuapi.com/client/marketing/storeproduct/v2/search?category_id=95e3fa2f-d62e-407b-9bf4-5c5b2af42706&business=scenes&business_id=95e3fa2f-d62e-407b-9bf4-5c5b2af42706&store_id=7c1208da-907a-4391-9901-35a60096a3f9&${page}&p=1&${size}&sort=0&name=&tag=-1&in_stock=-1&accuracy=0");
        urlMap.put("熟食卤味", "https://j1.pupuapi.com/client/marketing/storeproduct/v2/search?category_id=140&business=scenes&business_id=140&store_id=7c1208da-907a-4391-9901-35a60096a3f9&${page}&p=1&${size}&sort=0&name=&tag=-1&in_stock=-1&accuracy=0");
        urlMap.put("冰品面点", "https://j1.pupuapi.com/client/marketing/storeproduct/v2/search?category_id=410&business=scenes&business_id=410&store_id=7c1208da-907a-4391-9901-35a60096a3f9&${page}&p=1&${size}&sort=0&name=&tag=-1&in_stock=-1&accuracy=0");
        urlMap.put("乳品烘培", "https://j1.pupuapi.com/client/marketing/storeproduct/v2/search?category_id=420&business=scenes&business_id=420&store_id=7c1208da-907a-4391-9901-35a60096a3f9&${page}&p=1&${size}&sort=0&name=&tag=-1&in_stock=-1&accuracy=0");
        urlMap.put("酒水冲饮", "https://j1.pupuapi.com/client/marketing/storeproduct/v2/search?category_id=430&business=scenes&business_id=430&store_id=7c1208da-907a-4391-9901-35a60096a3f9&${page}&p=1&${size}&sort=0&name=&tag=-1&in_stock=-1&accuracy=0");
        urlMap.put("休闲零食", "https://j1.pupuapi.com/client/marketing/storeproduct/v2/search?category_id=440&business=scenes&business_id=440&store_id=7c1208da-907a-4391-9901-35a60096a3f9&${page}&p=1&${size}&sort=0&name=&tag=-1&in_stock=-1&accuracy=0");
        urlMap.put("日用清洁", "https://j1.pupuapi.com/client/marketing/storeproduct/v2/search?category_id=450&business=scenes&business_id=450&store_id=7c1208da-907a-4391-9901-35a60096a3f9&${page}&p=1&${size}&sort=0&name=&tag=-1&in_stock=-1&accuracy=0");
        urlMap.put("美妆护理", "https://j1.pupuapi.com/client/marketing/storeproduct/v2/search?category_id=460&business=scenes&business_id=460&store_id=7c1208da-907a-4391-9901-35a60096a3f9&${page}&p=1&${size}&sort=0&name=&tag=-1&in_stock=-1&accuracy=0");
        urlMap.put("母婴", "https://j1.pupuapi.com/client/marketing/storeproduct/v2/search?category_id=470&business=scenes&business_id=470&store_id=7c1208da-907a-4391-9901-35a60096a3f9&${page}&p=1&${size}&sort=0&name=&tag=-1&in_stock=-1&accuracy=0");
        urlMap.put("烧烤", "https://j1.pupuapi.com/client/marketing/storeproduct/v2/search?category_id=5cfd0467-91d4-45ff-866e-b5ac43875ff2&business=scenes&business_id=5cfd0467-91d4-45ff-866e-b5ac43875ff2&store_id=7c1208da-907a-4391-9901-35a60096a3f9&${page}&p=1&${size}&sort=0&name=&tag=-1&in_stock=-1&accuracy=0");
    }

    public static String getURL(String clazz, String page, String size) {
        String s = urlMap.get(clazz);
        if (s == null){
            return null;
        }else{
            return s.replaceAll("\\$\\{page\\}", "page=" + page).replaceAll("\\$\\{size\\}", "size=" + size);
        }
    }

    public static Set<String> getMenu(){
        return urlMap.keySet();
    }
}
