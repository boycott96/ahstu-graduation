package com.huaisun.graduation.util;

/**
 * @author huaisun
 * @date 2019/2/22 21:56
 */
public class Tools {

    /**
     * 判断一个对象是否为空
     *
     * @param object 对象
     * @return boolean
     */
    public static boolean isEmpty(Object object) {
        return object == "" || object == null;
    }

    public static boolean isNotEmpty(Object object) {
        return !isEmpty(object);
    }
}
