/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80027
Source Host           : localhost:3306
Source Database       : db_practice

Target Server Type    : MYSQL
Target Server Version : 80027
File Encoding         : 65001

*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_product
-- ----------------------------
DROP TABLE IF EXISTS `tb_product`;
CREATE TABLE `tb_product` (
  `product_id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `sub_title` varchar(255) DEFAULT NULL,
  `main_image` text CHARACTER SET gb2312 COLLATE gb2312_chinese_ci,
  `spec` varchar(255) DEFAULT NULL,
  `origin` varchar(255) DEFAULT NULL,
  `stock_quantity` int DEFAULT NULL,
  `discount_rate` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_product
-- ----------------------------
INSERT INTO `tb_product` VALUES ('2fd8e5b6-7494-4137-8438-5fd0c530dff5', '周黑鸭卤鸭脖【趣享】锁鲜120g', '1390', '入口微甜，越吃越辣，越吃越麻，鲜香回味，“欲罢不能”。', 'https://imgs.pupuapi.com/STORE_PRODUCT/4e25b040929a47c5917a3d2f2086f456/1644995345133.png?x-oss-process=image/format,jpg,image/resize,h_720/watermark,image_TUlOSUFQUF9RUkNPREUvN2UyZmNkNDA0MjA0NDIwZThjZmNlNmVmMjBjOTQzMWMvMTY0OTczMzA2NjQyNS5wbmc_eC1vc3MtcHJvY2Vzcz1pbWFnZS9yZXNpemUsUF8xMDA,t_100,g_center,x_0,y_0#', '120g/份', '广东省东莞市', '7', '1');
INSERT INTO `tb_product` VALUES ('316be644-1346-46f9-980e-efd36e33608c', '如意三宝蜜汁烤五花216g', '1680', '经典港式风味，辅以现代科学腌制工艺，密封腌制后低温慢烤，外焦里嫩、肥而不腻；', 'https://imgs.pupuapi.com/STORE_PRODUCT/ec29a07ccbb5451b9fb46b71f2a38057/1640327640826.png?x-oss-process=image/format,jpg,image/resize,h_720/watermark,image_TUlOSUFQUF9RUkNPREUvYjFkZjA3NDNjOTk0NDdmZTgyYThhMTg4NTZjYWEzOTMvMTY0OTg0OTM0ODYzOS5wbmc_eC1vc3MtcHJvY2Vzcz1pbWFnZS9yZXNpemUsUF8xMDA,t_100,g_center,x_0,y_0#', '216g/份', '福建省厦门市', '17', '1');
INSERT INTO `tb_product` VALUES ('57d20208-9470-4a3b-b431-94b7cd1ff38a', '洪小拳酱鸭200g', '1112', '新鲜选材，加热更美味', 'https://imgs.pupuapi.com/STORE_PRODUCT/7e2fcd404204420e8cfce6ef20c9431c/1631258199599.png', '200g/盒', '福州省福州市', '3', '1');
INSERT INTO `tb_product` VALUES ('5c1cd5d2-b4ae-4e46-a33c-4de5817d975f', '圃美多汤用豆腐400g', '690', '白嫩细滑 弹嫩鲜爽 豆香浓郁', 'https://imgs.pupuapi.com/STORE_PRODUCT/5866008ac48d47298dc3ea88b549f732/1644390236653.png', '400g/份', '北京平谷', '5', '1');
INSERT INTO `tb_product` VALUES ('62706b6e-9ce1-4483-8ae0-ae41f030114d', '素天下日式福棉冻豆腐350g', '990', '含大豆蛋白 口感绵软，豆香浓郁', 'https://imgs.pupuapi.com/STORE_PRODUCT/8b934c5c11a94ced9f675724e92502b7/1649242587226.png', '350g/包', '福建省福州市', '17', '1');
INSERT INTO `tb_product` VALUES ('63ea3a5a-61dd-4466-ad3f-d656086b8188', '蓉妈妈米糕（芝麻）260g/盒', '690', '传统工艺自然发酵，米香悠长，酸甜易消化，（自带发酵后醋酸味，介意慎拍）', 'https://imgs.pupuapi.com/STORE_PRODUCT/a241ea1579eb4958a291b398e20768b8/1637197852670.png', '260g/盒', '福建省福清市', '3', '1');
INSERT INTO `tb_product` VALUES ('867b521f-eedd-4eac-aa16-c04cf5da48fd', '火锅三秒铃铃卷豆腐卷（进口）120g', '1390', '香酥软嫩，三秒即食，火锅伴侣', 'https://imgs.pupuapi.com/STORE_PRODUCT/4e25b040929a47c5917a3d2f2086f456/1648631127599.png', '120g/包', '马来西亚', '10', '1');
INSERT INTO `tb_product` VALUES ('8966840b-7187-467f-be70-bfcea49340dd', '必品阁韩式炸鸡 500g/盒', '3880', '外脆里嫩，口感酥脆', 'https://imgs.pupuapi.com/STORE_PRODUCT/a3d844176f6c416f86ffd8d6eda5d02a/1649300714583.png?x-oss-process=image/format,jpg,image/resize,h_720/watermark,image_TUlOSUFQUF9RUkNPREUvN2UyZmNkNDA0MjA0NDIwZThjZmNlNmVmMjBjOTQzMWMvMTY0OTczMjA2Mzc5MC5wbmc_eC1vc3MtcHJvY2Vzcz1pbWFnZS9yZXNpemUsUF8xMDA,t_100,g_center,x_0,y_0#', '500g/盒', '山东省聊城市', '8', '1');
INSERT INTO `tb_product` VALUES ('93a04980-0d58-43f7-a048-6b1acbb358fb', '真味肉包180g（两个装）', '459', '口味地道，馅大量足，实惠不贵', 'https://imgs.pupuapi.com/STORE_PRODUCT/4e25b040929a47c5917a3d2f2086f456/1647424285250.png', '180g/袋', '福建省福州市', '4', '1');
INSERT INTO `tb_product` VALUES ('a78fc870-aa47-46d0-894b-734cf647963a', '凤祥优形沙拉鸡胸肉（新奥尔良味）100g', '1380', '低温即食，经典奥尔良风味', 'https://imgs.pupuapi.com/STORE_PRODUCT/cdc41a95115f4fdab25c4bf36a554162/1647584511891.png?x-oss-process=image/format,jpg,image/resize,h_720/watermark,image_TUlOSUFQUF9RUkNPREUvN2UyZmNkNDA0MjA0NDIwZThjZmNlNmVmMjBjOTQzMWMvMTY0OTczMzA2NjQyNS5wbmc_eC1vc3MtcHJvY2Vzcz1pbWFnZS9yZXNpemUsUF8xMDA,t_100,g_center,x_0,y_0#', '100g/袋', '山东省聊城市', '20', '1');
INSERT INTO `tb_product` VALUES ('abdaf069-bcc8-4c6f-850c-b92c3dc17d47', '祥广记猪肉菌菇鲜饺240g', '1097', '采用新鲜的猪肉，面皮爽滑劲道，猪肉加上菌菇肉馅，口味浓郁', 'https://imgs.pupuapi.com/STORE_PRODUCT/5866008ac48d47298dc3ea88b549f732/1650001565372.png', '240g/份', '福建省福州市', '2', '1');
INSERT INTO `tb_product` VALUES ('b36f63b9-a650-40b0-8441-2f26e9e3b202', '爪不同小龙虾（十三香味）250g', '2556', '开盒即食，微波口感更佳 ', 'https://imgs.pupuapi.com/STORE_PRODUCT/4e25b040929a47c5917a3d2f2086f456/1650793043905.png?x-oss-process=image/format,jpg,image/resize,h_720/watermark,image_TUlOSUFQUF9RUkNPREUvN2UyZmNkNDA0MjA0NDIwZThjZmNlNmVmMjBjOTQzMWMvMTY0OTczMzA2NjQyNS5wbmc_eC1vc3MtcHJvY2Vzcz1pbWFnZS9yZXNpemUsUF8xMDA,t_100,g_center,x_0,y_0#', '250g/盒', '福建省福州市', '1', '1');
INSERT INTO `tb_product` VALUES ('bd829581-1d86-451b-a290-add5e2d70ef3', '洪小拳香酥花生100g', '590', '新鲜选材，香酥可口', 'https://imgs.pupuapi.com/STORE_PRODUCT/7e2fcd404204420e8cfce6ef20c9431c/1636450655697.png', '100g/盒', '福建省福州市', '6', '1');
INSERT INTO `tb_product` VALUES ('cbba396f-bf7c-4616-bbcd-7ff9f1b1c60a', '周黑鸭卤鸭锁骨【趣享】锁鲜120g', '1390', '入口有点甜，后味带麻辣', 'https://imgs.pupuapi.com/STORE_PRODUCT/4e25b040929a47c5917a3d2f2086f456/1644992695153.png', '120g', '广东省东莞市', '7', '1');
INSERT INTO `tb_product` VALUES ('d549a908-d11f-4df3-877a-40d70da3a06e', '洪湖渔家麻辣小龙虾800g', '3380', '肉满黄肥，麻辣鲜香，活虾烧制，大厨配方，食用方便', 'https://imgs.pupuapi.com/STORE_PRODUCT/cdc41a95115f4fdab25c4bf36a554162/1647574061982.png', '800g/份', '湖北省荆州市', '8', '1');
INSERT INTO `tb_product` VALUES ('d9ba9c85-35d7-461e-b995-b1ae36e97a10', '洪小拳卤鸡爪原味150g', '1390', '新鲜选材，加热更美味', 'https://imgs.pupuapi.com/STORE_PRODUCT/7e2fcd404204420e8cfce6ef20c9431c/1631258245389.png', '150g/盒', '福州省福州市', '5', '1');
INSERT INTO `tb_product` VALUES ('e6a092ae-dc87-4e03-bac7-277c80accf6c', '郎阿姆烧仙草（果蔬燕麦）322g', '1280', '入口爽滑 清凉美味', 'https://imgs.pupuapi.com/STORE_PRODUCT/4e25b040929a47c5917a3d2f2086f456/1646209039182.png', '322g/碗', '福建省厦门市', '6', '1');
INSERT INTO `tb_product` VALUES ('fbc67144-525f-4194-b7ee-c9662b46ee4c', '如意三宝五香卤牛肉200g', '3680', '解冻切片即食，操作简便，不含大豆蛋白', 'https://imgs.pupuapi.com/STORE_PRODUCT/a241ea1579eb4958a291b398e20768b8/1648197216800.png', '200g/包', '福建省厦门市', '11', '1');
INSERT INTO `tb_product` VALUES ('fcc60574-ea7e-4ef7-b750-8ba1cd3ae0d5', '品胜葱油拌面（两份装）250g', '499', '爽口弹牙 口感筋道', 'https://imgs.pupuapi.com/STORE_PRODUCT/ec29a07ccbb5451b9fb46b71f2a38057/1632533148580.png?x-oss-process=image/format,jpg,image/resize,h_720/watermark,image_TUlOSUFQUF9RUkNPREUvYjFkZjA3NDNjOTk0NDdmZTgyYThhMTg4NTZjYWEzOTMvMTY0NjAzMDE1NjU1NS5wbmc_eC1vc3MtcHJvY2Vzcz1pbWFnZS9yZXNpemUsUF8xMDA,t_100,g_center,x_0,y_0#', '250g/袋（含料包）', '福建省福州市', '17', '0');
