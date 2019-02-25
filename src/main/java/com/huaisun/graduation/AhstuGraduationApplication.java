package com.huaisun.graduation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 项目启动类
 *
 * @author huaisun
 * @date 2019/2/18 22:56
 */
@SpringBootApplication(scanBasePackages = "com.huaisun.*")
@EnableSwagger2
@MapperScan({"com.huaisun.graduation.auto.mapper"})
public class AhstuGraduationApplication {

    public static void main(String[] args) {
        SpringApplication.run(AhstuGraduationApplication.class, args);
    }

}
