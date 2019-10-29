package com.medicine.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class mybatisPage {

    @Bean
    public PaginationInterceptor paginationInterceptor() {

        return new PaginationInterceptor();

    }
}
