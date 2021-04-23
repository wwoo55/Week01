package priv.xy.week01.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @projectName: Week01
 * @className: DateTimeUtils
 * @description: 时间工具类
 * @author: xy
 * @time: 2021/4/22 14:46
 */
public class DateTimeUtils {

    /**
     * 时间格式常量
     */
    public static final String COMMON_PATTERN       = "yyyy-MM-dd HH:mm:ss";

    /**
     * Date类型日期转字符串格式化输出
     *
     * @param date    待格式化的日期
     * @return
     */
    public static String formatDateToString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(COMMON_PATTERN);
        return dateFormat.format(date);
    }

    /**
     * 字符串转Date类型日期格式化输出
     *
     * @param str    待解析的字符串
     * @return
     */
    public static Date formatStringToDate(String str) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(COMMON_PATTERN);
        return dateFormat.parse(str);
    }
}
