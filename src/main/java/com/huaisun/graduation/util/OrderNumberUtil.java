package com.huaisun.graduation.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author huaisun
 * @date 2019/3/5 15:49
 */
public class OrderNumberUtil {

    public static String getOrderNumber(String userId) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String format2 = format.format(new Date());
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV < 0) {
            //有可能是负数
            hashCodeV = - hashCodeV;
        }
        return userId+format2+String.format("%012d", hashCodeV);
    }
}
