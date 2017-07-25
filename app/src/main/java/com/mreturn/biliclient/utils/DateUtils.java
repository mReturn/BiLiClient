package com.mreturn.biliclient.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mReturn
 * on 2017/7/25.
 */

public class DateUtils {

    private static final int YEAR = 365 * 24 * 60 * 60;// 年
    private static final int MONTH = 30 * 24 * 60 * 60;// 月
    private static final int DAY = 24 * 60 * 60;// 天
    private static final int HOUR = 60 * 60;// 小时
    private static final int MINUTE = 60;// 分钟


    /**
     * 根据时间计算对应的中文描述（如 1天前 刚刚）
     * @param time 时间
     * @return
     */
    public static String getDescFromTimeStamp(long time){
        long currentTime = System.currentTimeMillis();
        //计算差值（秒）
        long dTiem = (currentTime - time)/1000;
        String timeStr;
        if (dTiem>YEAR){
            timeStr = dTiem/YEAR+"年前";
        }else if (dTiem>MONTH){
            timeStr = dTiem/MONTH+"个月前";
        }else if (dTiem>MONTH){
            timeStr = dTiem/DAY+"个月前";
        }else if (dTiem>DAY){
            timeStr = dTiem/MONTH+"天前";
        }else if (dTiem>HOUR) {
            timeStr = dTiem / HOUR + "小时前";
        }else if (dTiem>MINUTE) {
            timeStr = dTiem / MINUTE + "分钟前";
        }else {
            timeStr = "刚刚";
        }
        return timeStr;
    }

    /**
     * String转换为Long类型
     * @param timeStr 时间
     * @param formatType 转换格式
     * @return
     */
    public static long stringToLong(String timeStr,String formatType){
        Date date = stringToDate(timeStr,formatType);
        if (date ==null){
            return 0;
        }else {
            return dateToLong(date);
        }
    }

    /**
     * Date转换为Long类型
     * @param date
     * @return
     */
    public static long dateToLong(Date date){
        return date.getTime();
    }

    /**
     * String转换为Date类型
     * @param timeStr 时间
     * @param fomatType 要转换的格式
     * @return
     */
    public static Date stringToDate(String timeStr,String fomatType){
        SimpleDateFormat format = new SimpleDateFormat(fomatType);
        Date date = null;
        try {
            date = format.parse(timeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
