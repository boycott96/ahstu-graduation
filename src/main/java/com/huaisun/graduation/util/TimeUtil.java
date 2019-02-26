package com.huaisun.graduation.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author huaisun
 * @date 2019/2/25 21:28
 */
public class TimeUtil {

    /**
     * 计算当前周的周一时间
     *
     * @return date
     */
    public static Date getNowWeekStart() {
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - (dayWeek == 1 ? 8 : dayWeek));
        return cal.getTime();
    }

    /**
     * 计算上一周的周一时间
     *
     * @return date
     */
    public static Date getLastWeekStart() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getNowWeekStart());
        cal.add(Calendar.DATE, -7);
        return cal.getTime();
    }

    /**
     * 计算上一周的周日时间
     *
     * @return date
     */
    public static Date getLastWeekEnd() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getNowWeekStart());

        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }
}
