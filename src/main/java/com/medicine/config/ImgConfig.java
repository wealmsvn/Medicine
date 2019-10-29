//package com.medicine.config;
//
//
//import lombok.Data;
//import org.mybatis.logging.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//
//import java.util.logging.Logger;
//
//@Configuration
//@PropertySource(value = "info.properties")
//@Data
//public class ImgConfig {
//
//    @Value("${IMG_URL}")
//    private String imgUrl;
//    @Value("${IMG_PATH}")
//    private String imgPath;
//
////    @Value("${spring.redis.host}")
//    private String host;
//
////    @Value("${spring.redis.port}")
////    private int port;
////
////    @Bean
////    public JedisPool getJedisPool() {
////        log.info("==>初始化jedis连接池");
////        JedisPoolConfig config = new JedisPoolConfig();
////        JedisPool pool = new JedisPool(config, host, port);
////        return pool;
//}
//
