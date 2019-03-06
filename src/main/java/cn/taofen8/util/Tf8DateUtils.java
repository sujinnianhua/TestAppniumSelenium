package cn.taofen8.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.ConversionServiceFactory;
import org.springframework.core.convert.support.GenericConversionService;


/**
 * DateUtils工具类
 * 
 */
public class Tf8DateUtils {
    private static final Log log = LogFactory.getLog(Tf8DateUtils.class);

    /**
     * 英文简写(默认) 如2008-08-08 08:08:08,精确到秒
     */
    public static final String FORMAT_FOR_SECOND = "yyyy-MM-dd HH:mm:ss";

    /**
     * 英文简写 如2008-08-08 08:08，精确到分
     */
    public static final String FORMAT_FOR_MINUTE = "yyyy-MM-dd HH:mm";

    /**
     * 英文简写 如2008-08-08，精确到天
     */
    public static final String FORMAT_FOR_DAY = "yyyy-MM-dd";

    /**
     * 中文简写 如2008年08月08日 08时08分08秒，精确到秒
     */
    public static final String FORMAT_FOR_SECOND_CN = "yyyy年MM月dd日 HH时mm分ss秒";

    /**
     * 中文简写 如2008年08月08日，精确到天
     */
    public static final String FORMAT_FOR_DAY_CN = "yyyy年MM月dd日";

    /**
     * 一天的毫秒数
     */
    public static final long ONE_DAY_TIME_MILLIS = 24 * 60 * 60 * 1000L;

    private static ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(FORMAT_FOR_SECOND);
        }
    };


    /**
     * 可以把日期转换成处理过的日期 如patter=yyyy-MM-dd 处理后的date的时分秒就变为0了
     * 
     * @return
     */
    public static Date getNowDate(String pattern) {
        return getDate(new Date(), pattern);
    }
    
    /**
     * 可以把日期转换成处理过的日期 如patter=yyyy-MM-dd 处理后的date的时分秒就变为0了
     * @param date
     * @param format
     * @return
     */
    public static Date getDate(Date date,String pattern) {
        formatter.get().applyPattern(pattern);
        String dateString = formatter.get().format(date);
        ParsePosition pos = new ParsePosition(0);
        Date currentTime_2 = formatter.get().parse(dateString, pos);
        return currentTime_2;
    }

    /**
     * 方法描述：对字段时间叠加
     * 
     * @version: 1.0
     * @author: Administrator
     * @version: Mar 21, 2011 2:21:34 PM
     */
    public static Date getDate(Date date, int fileds, int interval) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(fileds, interval);
        return calendar.getTime();
    }

    /**
     * 以 yyyy-MM-dd HH:mm:ss,yyyy-MM-dd,yyyy-MM-dd HH:mm，顺序解析dateStr 有可能返回null
     * 
     * @param dateStr
     * @return
     */
	public static Date mutiPatternParse(String dateStr) {
		Date date = null;
		if (org.apache.commons.lang.StringUtils.isBlank(dateStr)) {
			return date;
		}
		try {
			formatter.get().applyPattern(Tf8DateUtils.FORMAT_FOR_SECOND);
			date = formatter.get().parse(dateStr);
		} catch (Exception e) {
		}
		if (date == null) {
			try {
				formatter.get().applyPattern(Tf8DateUtils.FORMAT_FOR_MINUTE);
				date = formatter.get().parse(dateStr);
			} catch (ParseException e) {
			}
		}
		if (date == null) {
			try {
				formatter.get().applyPattern(Tf8DateUtils.FORMAT_FOR_DAY);
				date = formatter.get().parse(dateStr);
			} catch (ParseException e) {
			}
		}
		return date;
	}

    /**
     * 将字符串dateStr格式化成pattern时间格式
     * 
     * @param pattern 时间格式
     * @param dateStr 时间文本
     * @return
     * @throws ParseException
     */
    public static Date parseDate(String pattern, String dateStr) throws ParseException {
        formatter.get().applyPattern(pattern);
        return formatter.get().parse(dateStr);
    }

    /**
     * 判断当前日期，在一年中的天数是不是奇数
     * 
     * @return
     */
    public static boolean isOdd() {
        int day = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
        return (day & 1) == 1;
    }


    /**
     * 时间运算 返回date在某时间单位上加减amount数值后的date的pattern格式的字符串形式
     * 
     * @param date
     * @param amount 时间单位加减的数量
     * @param field 时间单位 : Calendar.MINUTE Calendar.DAY_OF_MONTH etc
     * @param pattern
     * @return
     */
    public static String dateCalcu(Date date, int amount, int field, String pattern) {
        formatter.get().applyPattern(pattern);
        String s_date = formatter.get().format(Tf8DateUtils.dateCalcu(date, amount, field));
        return s_date;
    }


    /**
     * 时间运算 返回date在某时间单位上加减amount数值后的date
     * 
     * @param date
     * @param amount 时间单位加减的数量
     * @param field 时间单位 : Calendar.MINUTE Calendar.DAY_OF_MONTH etc
     * @return
     */
    public static Date dateCalcu(Date date, int amount, int field) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(field, amount);
        return calendar.getTime();
    }
    
    
    /**
     * 返回距离今天amount那天后的最后时分 Date类型(23:59:59)
     * @param amount
     * @return
     */
    public static  Date getEndTimeAfterDays(int amount){
        Calendar  calendar  = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, amount);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        return calendar.getTime();
    }

    /**
     * 返回pattern格式的当前时间的字符串形式
     * 
     * @param pattern
     * @return
     */
    public static String getCurrentDateStr(String pattern) {
        Date currentTime = new Date();
        formatter.get().applyPattern(pattern);
        String dateString = formatter.get().format(currentTime);
        return dateString;
    }

    /**
     * 按照patter指定的格式返回date的字符串形式
     * @param date
     * @param pattern
     * @return
     */
    public static String getFormatByPattern(Date date,String pattern){
        if (date == null || Tf8StringUtils.isEmpty(pattern)) {
            return null;
        }
        formatter.get().applyPattern(pattern);
        return formatter.get().format(date);
    }
    
    /**
     * 以yyyy-MM-dd HH:mm:ss格式化date
     * 
     * @param date
     * @return
     */
    public static String getFormatForSecond(Date date) {
        formatter.get().applyPattern(Tf8DateUtils.FORMAT_FOR_SECOND);
        return date == null ? "" : formatter.get().format(date);
    }

    /**
     * 以yyyy-MM-dd HH:mm格式化date
     * 
     * @param date
     * @return
     */
    public static String getFormatForMinute(Date date) {
        if (date == null) {
            return null;
        }
        formatter.get().applyPattern(Tf8DateUtils.FORMAT_FOR_MINUTE);
        return formatter.get().format(date);
    }

    /**
     * 以yyyy-MM-dd格式化date
     * 
     * @param date
     * @return
     */
    public static String getFormatForDay(Date date) {
        if (date == null) {
            return null;
        }
        formatter.get().applyPattern(Tf8DateUtils.FORMAT_FOR_DAY);
        return formatter.get().format(date);
    }

    /**
     * 以MM月dd日HH:mm格式格式化date
     * 
     * @param date
     * @return
     */
    public static final String formatMMDDHHmm(Date date) {
        if (date == null) {
            return null;
        }
        formatter.get().applyPattern("MM月dd日HH:mm");
        return formatter.get().format(date);
    }
    
    
    /**
     * 以pattern格式把dateStr解析成时间
     * 
     * @param dateStr
     * @param pattern
     * @return
     */
    public static Date getNeedTime(String dateStr, String pattern) {
        if (Tf8StringUtils.isEmpty(dateStr) || Tf8StringUtils.isEmpty(pattern)) {
            return null;
        }
        formatter.get().applyPattern(pattern);
        Date needDate = null;
        try {
            needDate = formatter.get().parse(dateStr);
        } catch (Exception e) {
            log.error("getNeedTime error", e);
        }
        return needDate;
    }

    /**
     * 把yyyy-MM-dd HH:mm:ss格式的字符串转换成日期对象
     */
    public static Date parseForSecond(String dateStr) throws ParseException {
        formatter.get().applyPattern(Tf8DateUtils.FORMAT_FOR_SECOND);
        return formatter.get().parse(dateStr);
    }

    /**
     * 把yyyy-MM-dd HH:mm格式的日期字符串转换成日期对象
     */
    public static Date parseForMinute(String dateStr) throws ParseException {
        formatter.get().applyPattern(Tf8DateUtils.FORMAT_FOR_MINUTE);
        return formatter.get().parse(dateStr);
    }

    /**
     * 把字符串转换成yyyy-MM-dd格式成日期对象
     */
    public static Date parseForDay(String dateStr) throws ParseException {
        formatter.get().applyPattern(FORMAT_FOR_DAY);
        return formatter.get().parse(dateStr);
    }

    /**
     * 
     * 判断给定的时间是否是今天
     * 
     * @see #isSameDay(Date, Date)
     * @param day
     * @return
     */
    public static boolean isToday(Date date) {
        if (date == null) {
            return false;
        }
        return isSameDay(new Date(), date);
    }

    /**
     * 判断给定的dateStr时间是否是今天
     * 
     * @param day
     * @return
     */
    public static boolean isToday(String dateStr) {
        if (org.apache.commons.lang.StringUtils.isBlank(dateStr)) {
            return false;
        }
        Date compareDate = Tf8DateUtils.mutiPatternParse(dateStr);
        if (compareDate == null) {
            return false;
        }
        return isSameDay(new Date(), compareDate);
    }

    /**
     * 判断传入的两个日期 是否属于同一天
     * 
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDay(Date date, Date compareDate) {
        return org.apache.commons.lang.time.DateUtils.isSameDay(date, compareDate);
    }




    /**
     * 判断传入的时间date是否在当前时间 前后minutes分钟之内
     * 
     * @param date
     * @param minutes
     * @return 如果在minutes分钟之内 则返回true 否则返回false
     */
    public static boolean duringAssignTime(Date date, int minutes) {
        long dateMillis = date.getTime();
        long currentTimeMillis = System.currentTimeMillis();
        long start = currentTimeMillis - minutes * 60 * 1000L;
        long end = currentTimeMillis + minutes * 60 * 1000L;
        return dateMillis >= start && dateMillis <= end;
    }


    /**
     * 获取当前日期指定天数之前或之后的日期, 时分秒都设置为0 TODO 方法名并没有体现把时分秒设置为0  parseForSecond使用错误
     * 
     * @see #getAfterOrBeforeDay
     */
    @Deprecated
    public static final Date getAfterOrBeforeDayDate(int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, amount);
        try {
            return parseForSecond(getFormatForDay(calendar.getTime()) + " 00:00:00");
        } catch (ParseException e) {
            throw new RuntimeException();
        }
    }

    /**
     * 获取当前日期指定天数之前或之后的日期, 时分秒都设置为0 TODO 方法名并没有体现把时分秒设置为0
     */
    public static final Date getAfterOrBeforeDay(int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, amount);
        try {
            return parseForDay(getFormatForDay(calendar.getTime()) + " 00:00:00");
        } catch (ParseException e) {
            throw new RuntimeException();
        }
    }

    /**
     * 如果date在now之后 会有问题 替换为beforeCurrentDateMoreThanOneWeek方法 当前时间是不是超过了date所表示的时间7天了
     * 
     * @see #beforeCurrentDateMoreThanOneWeek(Date)
     * @param date
     * @return
     */
    @Deprecated
    public static boolean moreThanOneWeek(Date date) {
        Calendar now = Calendar.getInstance();
        Calendar lastUpdateTime = Calendar.getInstance();
        lastUpdateTime.setTime(date);
        lastUpdateTime.add(Calendar.WEEK_OF_MONTH, 1);
        return now.after(lastUpdateTime);
    }

    /**
     * 当前时间是不是超过了date所表示的时间7天了
     * 
     * @param date
     * @return
     */
    public static boolean beforeCurrentDateMoreThanOneWeek(Date compareDate) {
        long currentTimeMillis = System.currentTimeMillis();
        long compareTimeMillis = compareDate.getTime();
        return (currentTimeMillis > compareTimeMillis)
                && ((currentTimeMillis - compareTimeMillis) > 7 * ONE_DAY_TIME_MILLIS);
    }


    /**
     * 判断传入的时间毫秒数是否超过了当前几分钟
     * 该方法没有需要考虑传入的timeStamp跟现在时间的前后关系 TODO
     * @param timeStamp
     * @param minutes
     * @return
     */
    public static boolean moreThanMinutes(Object timeStamp, int minutes) {
        return (System.currentTimeMillis() - (Long) timeStamp) / 1000 / 60 > minutes;
    }


    /**
     * 获取当前时间的十点钟  如：yyyy-MM-dd 00:00:00:000
     * @return
     */
    public static final Date getTenOclockTime() {
        Calendar cal = Calendar.getInstance();

        Date fullDate = new Date();
        cal.setTime(fullDate);
        cal.set(Calendar.HOUR_OF_DAY, 10);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    
    /**
     * 返回compareDate距今天的天数  可能返回负值
     * @param dtime
     * @return
     */
    public static float getDaysFromNow(Date compareDate){
        return (float) (System.currentTimeMillis()-compareDate.getTime()) / (1000*60*60*24); //一天1000*60*60*24
    }
    

    
    /**
     * 当前日期的0点
     * 
     * @param date
     * @return
     */
    public static Date getDateFirstSecond(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        return calendar.getTime();
    }


    /**
     * 把日期后的时间归0 变成(yyyy-MM-dd 00:00:00:000)
     * 
     * @param date
     * @return Date
     */
    public static final Date zerolizedTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 当前日期最后一秒
     * 
     * @param date
     * @return
     */
    public static Date getDateLastSecond(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        return calendar.getTime();
    }
    
    /**
     * 获取某个日期 某点钟的时间
     * @param date
     * @param hour
     * @return
     */
    public static Date getDateHour(Date date,int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), hour, 0, 0);
        return calendar.getTime();
    }
    
    /**
     * 获取年份
     * 
     * @param date
     * @return
     */
    public static final int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取年份
     * 
     * @param millis
     * @return
     */
    public static final int getYear(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取月份
     * 
     * @param date
     * @return
     */
    public static final int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }


    /**
     * 获取月份
     * 
     * @param millis
     * @return
     */
    public static final int getMonth(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取日期
     * 
     * @param date
     * @return
     */
    public static final int getDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DATE);
    }

    /**
     * 获取日期
     * 
     * @param millis
     * @return
     */
    public static final int getDate(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.get(Calendar.DATE);
    }

    /**
     * 获取小时
     * 
     * @param date
     * @return
     */
    public static final int getHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取小时
     * 
     * @param millis
     * @return
     */
    public static final int getHour(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }


    /**
     * 获取分钟
     * 
     * @param date
     * @return
     */
    public static final int getMinute(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }


    /**
     * 获取当前季度的开始时间或结束时间，左右开区间（2016-01-01 00:00:00至2016-04-01 00:00:00）
     * 
     * @param quartStart
     * @return
     */
    public static Date getCurrentQuarterSection(boolean quarterStart) {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        if (month >= Calendar.JANUARY && month <= Calendar.MARCH) {
            month = Calendar.JANUARY;
        } else if (month >= Calendar.APRIL && month <= Calendar.JUNE) {
            month = Calendar.APRIL;
        } else if (month >= Calendar.JULY && month <= Calendar.SEPTEMBER) {
            month = Calendar.JULY;
        } else {
            month = Calendar.OCTOBER;
        }
        calendar.set(year, month, 1, 0, 0, 0);
        if (!quarterStart) {
            calendar.add(Calendar.MONTH, 3);
        }
        return calendar.getTime();
    }

    /**
     * 获取date所在季度的开始时间或结束时间，左右开区间（2016-01-01 00:00:00至2016-04-01 00:00:00）
     * 
     * @param quartStart
     * @return
     */
    public static Date getQuarterSectionByDate(boolean quarterStart, Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        if (month >= Calendar.JANUARY && month <= Calendar.MARCH) {
            month = Calendar.JANUARY;
        } else if (month >= Calendar.APRIL && month <= Calendar.JUNE) {
            month = Calendar.APRIL;
        } else if (month >= Calendar.JULY && month <= Calendar.SEPTEMBER) {
            month = Calendar.JULY;
        } else {
            month = Calendar.OCTOBER;
        }
        calendar.set(year, month, 1, 0, 0, 0);
        if (!quarterStart) {
            calendar.add(Calendar.MONTH, 3);
        }
        return calendar.getTime();
    }

    /**
     * date加减amount天数的日期
     * 
     * @param date
     * @param days
     * @return
     */
    public static final Date getTimeAfterDays(Date date, int amount) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR, amount);
        return cal.getTime();
    }


    /**
     * 根据seconds大小，时间单位 从小到大求整数商
     * 
     * @param seconds
     * @return
     */
    public static String getTimeDescBySeconds(Date date) {
        if (date == null) {
            return null;
        }
        long seconds = (new Date().getTime() - date.getTime())/1000;
        if (seconds < 60L) {
            return seconds + "秒";
        } else if (60L <= seconds && seconds < 3600L) {
            return seconds / 60L + "分钟";
        } else if (3600L <= seconds && seconds < 43200L) {
            return seconds / 3600L + "小时";
        } else {
            return seconds / 43200L + "天";
        }
    }
    
    
    /**
     * 从现在时间往前或往后num天的凌晨 
     * 
     * @param num
     * @return
     */
    public static Date getDayStartTimeWithDayCalcuAmount(int amount) {
        return Tf8DateUtils
                .zerolizedTime(Tf8DateUtils.dateCalcu(new Date(), amount, Calendar.DAY_OF_MONTH));
    }

    /**
     * 得到今天日期，格式yyyy-MM-dd。
     * 
     * @return String 格式化的日期字符串
     */
    public static String getToday() {
        formatter.get().applyPattern(FORMAT_FOR_DAY);
        return formatter.get().format(new Date());
    }
    
    /**
     * 得到今天开始时间
     */
    public static String getTodayStart() {
        return getToday() + " 00:00:00";
    }
    
    /**
     * 得到今天结束时间
     */
    public static String getTodayEnd() {
        return getToday() + " 23:59:59";
    }
    
    /**
     * 返回本月份区间 如2016-11-01 00:00:00 2016-12-01 00:00:00
     * 
     * @return
     */
    public static DateSection getCurrentMonthSection() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);

        c.set(Calendar.DAY_OF_MONTH, 1);
        Date begin = c.getTime();
        c.add(Calendar.MONTH, 1);
        Date end = c.getTime();
        DateSection section = new DateSection(begin, end);

        return section;
    }

    /**
     * 判断两个时间区间是否是包含关系，inner的时间区间必须在outer的时间区间之内或者相等
     * outer.getBegin()<=inner.getBegin()<inner.getStart()<=outer.getBegin()
     * 
     * @param outer 外部时间区间
     * @param inner 内部时间区间
     * @return
     */
    public static boolean isInclude(DateSection outer, DateSection inner) {
        if (outer.getBegin().after(inner.getBegin())) {
            return false;
        }
        if (outer.getEnd().before(inner.getEnd())) {
            return false;
        }

        return true;
    }

    /**
     * 返回当天时间区间 如2016-11-19 00:00:00 2016-11-20 00:00:00
     * 
     * @param day
     * @return
     */
    public static DateSection getDaySection(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        Date begin = c.getTime();
        c.add(Calendar.DAY_OF_YEAR, 1);
        Date end = c.getTime();
        DateSection section = new DateSection(begin, end);
        return section;
    }
    
    private static GenericConversionService conversionService = ConversionServiceFactory
            .createDefaultConversionService();
    private static final Converter<Date, String> DATE_TO_STRING_CONVERTER =
            new Converter<Date, String>() {
                public String convert(Date source) {
                    if (source == null) {
                        return null;
                    }
                    return Tf8DateUtils.getFormatForSecond(source);
                }

            };

    private static final Converter<String, Date> STRING_TO_DATE_CONVERTER =
            new Converter<String, Date>() {
                public Date convert(String source) {
                    if (source == null) {
                        return null;
                    }
                    try {
                        return Tf8DateUtils.parseForSecond(source);
                    } catch (ParseException ex) {
                        throw new ConversionFailedException(TypeDescriptor.valueOf(String.class),
                                TypeDescriptor.valueOf(Date.class), source, ex);
                    }
                }
            };

    static {
        conversionService.addConverter(DATE_TO_STRING_CONVERTER);
        conversionService.addConverter(STRING_TO_DATE_CONVERTER);
    }

    
    public static <T> T convert(Object value, Class<T> targetType) {
        if (value == null) {
            return null;
        }
        return conversionService.convert(value, targetType);
    }
}
