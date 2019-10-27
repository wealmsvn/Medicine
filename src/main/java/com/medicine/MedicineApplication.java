package com.medicine;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.medicine.dao")
@EnableSwagger2
public class MedicineApplication {

    public static void main(String[] args) {

        SpringApplication.run(MedicineApplication.class, args);
    }

}
