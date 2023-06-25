/*
 Navicat Premium Data Transfer

 Source Server         : mysql80
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : SpringBoot_Product1

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 09/05/2023 08:47:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cinema
-- ----------------------------
DROP TABLE IF EXISTS `cinema`;
CREATE TABLE `cinema`
(
    `c_id`      int NOT NULL COMMENT '影院主键',
    `c_name`    varchar(50) DEFAULT NULL COMMENT '影院名称',
    `c_phone`   varchar(50) DEFAULT NULL COMMENT '联系方式',
    `c_address` varchar(50) DEFAULT NULL COMMENT '影院地址',
    `c_date`    date        DEFAULT NULL COMMENT '首营业日期',
    PRIMARY KEY (`c_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of cinema
-- ----------------------------
BEGIN;
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`)
VALUES (1, '皇宫影院', '13812345678', '北京市海淀区中关村大街1号', '2020-01-01');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`)
VALUES (2, '星空电影城', '13698765432', '上海市浦东新区张江路88号', '2018-05-12');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`)
VALUES (3, '银光影城', '13987654321', '广州市天河区天河路789号', '2019-11-11');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`)
VALUES (4, '万达影城', '13788889999', '深圳市福田区华强北路168号', '2017-08-02');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`)
VALUES (5, '大地影院', '13512345678', '成都市锦江区春熙路99号', '2021-03-15');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`)
VALUES (6, '金逸国际影城', '15234567890', '南京市鼓楼区汉口路22号', '2015-10-10');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`)
VALUES (7, '橙天嘉禾影城', '13900001111', '武汉市江汉区解放大道666号', '2022-02-22');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`)
VALUES (8, 'UME国际影城', '15811112222', '重庆市渝北区龙头寺路8号', '2016-06-06');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`)
VALUES (9, '华夏星光', '13777778888', '天津市南开区鼓楼大街222号', '2018-09-09');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`)
VALUES (10, '百丽宫影城', '13866667777', '杭州市拱墅区和睦街99号', '2020-12-12');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`)
VALUES (11, '中影国际城', '13600002222', '厦门市思明区软件园二期88号', '2017-07-07');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`)
VALUES (12, '星美国际影城', '15011112222', '长沙市岳麓区麓谷街道麓山路66号', '2021-01-01');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`)
VALUES (13, '保利国际影城', '13855556666', '西安市雁塔区曲江文化新区雁南五路88号', '2019-04-20');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`)
VALUES (14, '幸福蓝海国际影城', '13944445555', '青岛市市北区辽阳西路66号', '2018-08-08');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`)
VALUES (15, '华谊兄弟影院', '15133334444', '福州市仓山区福新东路66号', '2022-03-30');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`)
VALUES (16, '耀莱成龙影城', '13711112222', '合肥市瑶海区临泉路8号', '2016-05-01');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`)
VALUES (17, '中影时代国际影城', '15922223333', '南昌市洪都北大道99号', '2019-12-25');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`)
VALUES (18, '博纳国际影城', '18866667777', '济南市历下区经十路66号', '2017-09-18');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`)
VALUES (19, '金逸珠江国际影城', '13722223333', '东莞市虎门镇轻轨站旁边', '2020-04-04');
INSERT INTO `cinema` (`c_id`, `c_name`, `c_phone`, `c_address`, `c_date`)
VALUES (20, 'SFC上影影城', '13933334444', '苏州市工业园区星海街88号', '2018-11-11');
COMMIT;

-- ----------------------------
-- Table structure for movie
-- ----------------------------
DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie`
(
    `m_id`      int NOT NULL COMMENT '电影主键',
    `m_name`    varchar(50) DEFAULT NULL COMMENT '电影名',
    `m_date`    date        DEFAULT NULL COMMENT '上映日期',
    `m_country` varchar(50) DEFAULT NULL COMMENT '上映国家',
    PRIMARY KEY (`m_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of movie
-- ----------------------------
BEGIN;
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`)
VALUES (1, '追梦高手', '2022-05-01', '中国');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`)
VALUES (2, '暴走玩家', '2023-01-15', '美国');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`)
VALUES (3, '无人生还', '2022-07-22', '英国');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`)
VALUES (4, '幸福咖啡馆', '2022-09-09', '韩国');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`)
VALUES (5, '神秘花园', '2023-02-18', '法国');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`)
VALUES (6, '魔法小精灵', '2022-11-11', '日本');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`)
VALUES (7, '旅行者', '2023-04-05', '德国');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`)
VALUES (8, '银河守卫队', '2022-08-28', '美国');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`)
VALUES (9, '古墓寻宝', '2023-05-20', '加拿大');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`)
VALUES (10, '超凡蜘蛛侠', '2022-12-25', '美国');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`)
VALUES (11, '森林之王', '2023-03-08', '俄罗斯');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`)
VALUES (12, '时光倒流机', '2022-10-13', '英国');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`)
VALUES (13, '太空冒险家', '2022-06-06', '美国');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`)
VALUES (14, '外星人入侵', '2023-01-01', '日本');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`)
VALUES (15, '红楼梦之梦', '2023-04-28', '中国');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`)
VALUES (16, '缤纷童话屋', '2022-08-08', '法国');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`)
VALUES (17, '快乐小熊维尼', '2022-09-22', '美国');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`)
VALUES (18, '魔法城堡', '2023-02-14', '英国');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`)
VALUES (19, '飞天战机', '2022-07-30', '日本');
INSERT INTO `movie` (`m_id`, `m_name`, `m_date`, `m_country`)
VALUES (20, '海底历险记', '2023-03-25', '澳大利亚');
COMMIT;

-- ----------------------------
-- Table structure for movie_cinema
-- ----------------------------
DROP TABLE IF EXISTS `movie_cinema`;
CREATE TABLE `movie_cinema`
(
    `mc_movie_id`  int DEFAULT NULL COMMENT '电影外键',
    `mc_cinema_id` int DEFAULT NULL COMMENT '影院外键'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of movie_cinema
-- ----------------------------
BEGIN;
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (1, 1);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (1, 2);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (1, 3);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (2, 3);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (2, 4);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (2, 5);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (3, 6);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (3, 7);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (4, 8);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (4, 9);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (4, 10);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (5, 11);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (5, 12);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (6, 13);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (6, 14);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (6, 15);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (7, 16);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (7, 17);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (8, 18);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (8, 19);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (9, 20);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (9, 1);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (10, 2);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (10, 3);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (11, 4);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (11, 5);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (12, 6);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (12, 7);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (12, 8);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (13, 9);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (13, 10);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (14, 11);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (14, 12);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (15, 13);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (15, 14);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (16, 15);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (16, 16);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (17, 17);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (17, 18);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (18, 19);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (18, 20);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (19, 1);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (19, 2);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (20, 3);
INSERT INTO `movie_cinema` (`mc_movie_id`, `mc_cinema_id`)
VALUES (20, 4);
COMMIT;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`
(
    `r_id`   int NOT NULL COMMENT '角色主键',
    `r_name` varchar(50) DEFAULT NULL COMMENT '角色名',
    PRIMARY KEY (`r_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` (`r_id`, `r_name`)
VALUES (1, '管理员');
INSERT INTO `role` (`r_id`, `r_name`)
VALUES (2, '游客');
COMMIT;

-- ----------------------------
-- Table structure for ticket
-- ----------------------------
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket`
(
    `t_id`     int NOT NULL AUTO_INCREMENT COMMENT '电影票主键',
    `t_movie`  int  DEFAULT NULL COMMENT '电影外键（getName）',
    `t_cinema` int  DEFAULT NULL COMMENT '电影院外键（getName）',
    `t_date`   date DEFAULT NULL COMMENT '购买时间',
    `t_user`   int  DEFAULT NULL COMMENT '购买者外键（getName）',
    PRIMARY KEY (`t_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 15
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of ticket
-- ----------------------------
BEGIN;
INSERT INTO `ticket` (`t_id`, `t_movie`, `t_cinema`, `t_date`, `t_user`)
VALUES (1, 5, 11, '2023-04-19', 2);
INSERT INTO `ticket` (`t_id`, `t_movie`, `t_cinema`, `t_date`, `t_user`)
VALUES (2, 11, 5, '2023-04-18', 12);
INSERT INTO `ticket` (`t_id`, `t_movie`, `t_cinema`, `t_date`, `t_user`)
VALUES (3, 13, 10, '2023-04-17', 6);
INSERT INTO `ticket` (`t_id`, `t_movie`, `t_cinema`, `t_date`, `t_user`)
VALUES (4, 2, 3, '2023-04-16', 20);
INSERT INTO `ticket` (`t_id`, `t_movie`, `t_cinema`, `t_date`, `t_user`)
VALUES (5, 8, 19, '2023-04-15', 14);
INSERT INTO `ticket` (`t_id`, `t_movie`, `t_cinema`, `t_date`, `t_user`)
VALUES (6, 19, 1, '2023-04-14', 1);
INSERT INTO `ticket` (`t_id`, `t_movie`, `t_cinema`, `t_date`, `t_user`)
VALUES (7, 1, 3, '2023-04-13', 9);
INSERT INTO `ticket` (`t_id`, `t_movie`, `t_cinema`, `t_date`, `t_user`)
VALUES (8, 20, 4, '2023-04-12', 3);
INSERT INTO `ticket` (`t_id`, `t_movie`, `t_cinema`, `t_date`, `t_user`)
VALUES (9, 7, 17, '2023-04-11', 17);
INSERT INTO `ticket` (`t_id`, `t_movie`, `t_cinema`, `t_date`, `t_user`)
VALUES (10, 16, 15, '2023-04-10', 5);
INSERT INTO `ticket` (`t_id`, `t_movie`, `t_cinema`, `t_date`, `t_user`)
VALUES (11, 6, 15, '2023-04-18', 4);
INSERT INTO `ticket` (`t_id`, `t_movie`, `t_cinema`, `t_date`, `t_user`)
VALUES (12, 15, 13, '2023-04-03', 8);
INSERT INTO `ticket` (`t_id`, `t_movie`, `t_cinema`, `t_date`, `t_user`)
VALUES (13, 6, 13, '2023-04-23', 3);
INSERT INTO `ticket` (`t_id`, `t_movie`, `t_cinema`, `t_date`, `t_user`)
VALUES (14, 2, 5, '2023-04-16', 7);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `u_id`       int NOT NULL AUTO_INCREMENT COMMENT '用户主键',
    `u_username` varchar(50) DEFAULT NULL COMMENT '用户名',
    `u_password` varchar(50) DEFAULT NULL COMMENT '密码',
    `u_phone`    varchar(50) DEFAULT NULL COMMENT '电话',
    `u_date`     date        DEFAULT NULL COMMENT '创建日期（不可修改）',
    `u_role_id`  int         DEFAULT NULL COMMENT '角色外键',
    PRIMARY KEY (`u_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 24
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`)
VALUES (1, '熊熊', '123456', '1899999666', '2001-09-04', 1);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`)
VALUES (2, '张三', '123456', '13800001111', '2021-01-01', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`)
VALUES (3, '李四', '654321', '13900002222', '2021-02-02', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`)
VALUES (4, '王五', '111111', '13700003333', '2021-03-03', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`)
VALUES (5, '赵六', '222222', '13600004444', '2021-04-04', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`)
VALUES (6, '钱七', '333333', '13500005555', '2021-05-05', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`)
VALUES (7, '孙八', '444444', '13400006666', '2021-06-06', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`)
VALUES (8, '周九', '555555', '13300007777', '2021-07-07', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`)
VALUES (9, '吴十', '666666', '13200008888', '2021-08-08', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`)
VALUES (10, '郑一', '777777', '13100009999', '2021-09-09', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`)
VALUES (11, '王二', '888888', '13000001000', '2021-10-10', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`)
VALUES (12, '张三丰', '999999', '13900001111', '2021-11-11', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`)
VALUES (13, '李逵', '000000', '13800002222', '2021-12-12', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`)
VALUES (14, '孙悟空', '111111', '13700003333', '2022-01-01', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`)
VALUES (15, '猪八戒', '222222', '13600004444', '2022-02-02', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`)
VALUES (16, '唐僧', '333333', '13500005555', '2022-03-03', 1);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`)
VALUES (17, '白骨精', '444444', '13400006666', '2022-04-04', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`)
VALUES (18, '黑熊精', '555555', '13300007777', '2022-05-05', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`)
VALUES (19, '红孩儿', '666666', '13200008888', '2022-06-06', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`)
VALUES (20, '观音菩萨', '777777', '13100009999', '2022-07-07', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`)
VALUES (21, '牛魔王', '888888', '13000001000', '2022-08-08', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`)
VALUES (22, '千一', '100001', '1000000001', '2023-04-21', 2);
INSERT INTO `user` (`u_id`, `u_username`, `u_password`, `u_phone`, `u_date`, `u_role_id`)
VALUES (23, '测试123', '112233', '112233445566', '2023-04-22', 2);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
