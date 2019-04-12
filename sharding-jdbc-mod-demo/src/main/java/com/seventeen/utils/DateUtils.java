package com.seventeen.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author seventeen
 * @date 2018/11/26
 */

public class DateUtils {

    public static final String[] DATE_FORMATS = new String[] {
            "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM-dd", "yyyy-MM",
            "yyyy-MM-dd HH:mm:ss.S" ,"yyyy年MM月dd日","yyyy年MM月dd日 HH:mm","yyyyMMdd",
            "yyyy年MM月dd日 HH:mm:ss", "MM.dd","MM - dd","MM月dd日",
            "yyyy.MM.dd", "M.d", "M月d日 HH:mm","M月d日",
            "yyyyMMddHH","yyyy-MM-dd'T'HH:mm:ss'Z'", "yyyy-MM-dd'T'HH:mm" ,"MM-dd HH:mm"};

    /**
     * 将日期字符串转为日期
     */
    public static Date parseDate(String dateStr) {
        return parseDate(dateStr, DATE_FORMATS[0]);
    }

    /**
     * 将日期字符串转为指定格式的日期
     */
    public static Date parseDate(String dateStr, String format) {
        return parseDate(dateStr, new String[] { format });
    }

    private static Date parseDate(String dateStr, String[] parsePatterns) {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate(dateStr, parsePatterns);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将传入的日期转化为"yyyy-MM-dd"形式的字符串
     */
    public static String formatDateYMD(Date dt) {
        return formatDate(dt, DATE_FORMATS[2]);
    }

    /**
     * 将传入的日期转化为"yyyy-MM-dd HH:mm"形式的字符串
     */
    public static String formatDateYMDHM(Date dt) {
        return formatDate(dt, DATE_FORMATS[1]);
    }

    /**
     * 将传入的日期转化为"yyyy-MM-dd HH:mm:ss"形式的字符串
     */
    public static String formatDateYMDHMS(Date dt) {
        return formatDate(dt, DATE_FORMATS[0]);
    }

    /**
     * 将传入的日期以指定格式转成字符串
     */
    public static String formatDate(Date dt, String format) {
        if (dt == null) {
            return "";
        }
        if(StringUtils.isBlank(format)){
            format = "yyyy-MM-dd";
        }

        SimpleDateFormat fmt = new SimpleDateFormat(format);
        return fmt.format(dt);
    }

    /**
     * 获得某天的零点时刻0:0:0
     */
    public static Date getDayBegin(Date date) {
        if (date == null) {
            return null;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获得某天的截至时刻23:59:59
     */
    public static Date getDayEnd(Date date) {
        if (date == null) {
            return null;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    /**
     * 返回两个时间直接的分钟数
     */
    public static int getMinuteBetween(Date d1, Date d2) {
        if(d1==null || d2==null) {
            return 0;
        }

        long m = d1.getTime();
        long n = d2.getTime();
        return (int) ((m - n) / 60000);
    }

    /**
     * 两个时间直接的秒数(d1 - d2)
     */
    public static long getSecondBetween(Date d1, Date d2) {
        if(d1==null || d2==null) {
            return 0;
        }

        return (d1.getTime() - d2.getTime()) / 1000;
    }


    /**
     * 计算两个日期间相隔的小时
     */
    public static int getHourBetween(Date d1, Date d2) {
        if(d1==null || d2==null) {
            return 0;
        }

        long m = d1.getTime();
        long n = d2.getTime();
        return (int) ((m - n) / 3600000);
    }

    /**
     * 返回两个日期之间天数，不计时分秒(d1 - d2)
     */
    public static int getDaysBetween(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(getDayBegin(d1));
        Calendar c2 = Calendar.getInstance();
        c2.setTime(getDayBegin(d2));
        return (int) ((c1.getTimeInMillis() - c2.getTimeInMillis()) / 86400000);
    }

    /**
     * 得到传入日期n天后的日期,如果传入日期为null，则表示当前日期n天后的日期
     * @param days  可以为任何整数，负数表示前days天，正数表示后days天
     */
    public static Date getAddDayDate(Date dt, int days) {
        Calendar cal = Calendar.getInstance();
        if(dt!=null){
            cal.setTime(dt);
        }
        cal.add(Calendar.DAY_OF_MONTH, days);
        return cal.getTime();
    }

    /**
     * 给定的时间再加上指定秒数
     *
     */
    public static Date getAddSecondDate(Date dt, int second) {
        if (dt == null) {
            dt = new Date(System.currentTimeMillis());
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        cal.add(Calendar.SECOND, second);

        return cal.getTime();
    }

    /**
     * 给定的时间再加上指定分钟数
     */
    public static Date getAddMinuteDate(Date dt, int minutes) {
        if (dt == null) {
            dt = new Date(System.currentTimeMillis());
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        cal.add(Calendar.MINUTE, minutes);

        return cal.getTime();
    }

    /**
     * 给定的时间再加上指定小时数,如果传入日期为null，能以当前时间计算
     */
    public static Date getAddHourDate(Date dt, int hours) {
        if (dt == null) {
            dt = new Date(System.currentTimeMillis());
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        cal.add(Calendar.HOUR, hours);

        return cal.getTime();
    }

    /**
     * 获取日期的中国式星期几（1-7分别代表周一至周日）
     */
    public static int getDayOfWeek(Date date){
        if(date==null){
            date = new Date();
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return getDayOfWeek(cal);
    }

    /**
     * 获得本日星期数,星期一:1,星期日:7
     * 如果传入null则默认为本日
     * @return
     */
    private static int getDayOfWeek(Calendar calendar){
        int today;
        if(calendar!=null){
            today=calendar.get(Calendar.DAY_OF_WEEK);
        }else{
            today = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        }
        if(today==1) {
            return 7;
        } else {
            return today-1;
        }
    }

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(DateUtils.getAddSecondDate(date, 30 * 24 * 60 * 60));
    }
}
