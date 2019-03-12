package com.huaisun.graduation;

import com.huaisun.graduation.util.OrderNumberUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AhstuGraduationApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println(OrderNumberUtil.getOrderNumber("admin"));
    }

}
