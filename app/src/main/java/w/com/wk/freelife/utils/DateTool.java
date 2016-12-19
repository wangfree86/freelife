package w.com.wk.freelife.utils;

import android.content.Context;
import android.text.TextUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

import w.com.wk.freelife.R;

/**
 * 时间工具
 */
public class DateTool {
    //一分钟
    public static final long ONE_MINUTE_MILLIONS = 60;
    //一小时
    public static final long ONE_HOUR_MILLIONS = 60 * ONE_MINUTE_MILLIONS;
    //一天
    public static final long ONE_DAY_MILLIONS = 24 * ONE_HOUR_MILLIONS;
    //一yue
    public static final long ONE_MONTH_MILLIONS = 30 * ONE_DAY_MILLIONS;
    //半年
    public static final long HALF_YEAR_MILLIONS = 6 * ONE_MONTH_MILLIONS;


    public static int getMemoryTime(Context context, String createTimeStr) {

        long beyondTime;
        long createTime = 0;
        int beyongTimeStr = 0;
        try {
            if (!TextUtils.isEmpty(createTimeStr)) {
                createTime = Long.parseLong(createTimeStr);
            }
            beyondTime = System.currentTimeMillis() / 1000 - createTime;
//            beyondTime = beyondTime * 3600;
            long t= (beyondTime / ONE_DAY_MILLIONS);
            if (t>= 15 ) {
                beyongTimeStr = 5;
            } else if (t>= 7 ) {
                beyongTimeStr = 4;
            } else if (t  >= 4) {
                beyongTimeStr = 3;
            } else if (t >= 2) {
                beyongTimeStr = 2;
            } else if (t >= 1) {
                beyongTimeStr = 1;
            } else {
                beyongTimeStr = -1;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return beyongTimeStr;

    }

    public static String getShortTime(Context context, String createTimeStr) {

        long beyondTime;
        long createTime = 0;
        String beyongTimeStr = "";
        try {
            if (!TextUtils.isEmpty(createTimeStr)) {
                createTime = Long.parseLong(createTimeStr);
            }
            if (createTime <= 0) {
                return context.getString(R.string.str_just);
            }
            beyondTime = System.currentTimeMillis() / 1000 - createTime;
//            beyondTime = beyondTime * 3600;
            if (beyondTime / ONE_MONTH_MILLIONS > 0) {
                beyongTimeStr = context.getString(R.string.str_above_month, beyondTime / ONE_MONTH_MILLIONS);
            } else if (beyondTime / ONE_DAY_MILLIONS > 0) {
                beyongTimeStr = context.getString(R.string.str_above_day, beyondTime / ONE_DAY_MILLIONS);
            } else if (beyondTime / ONE_HOUR_MILLIONS > 0) {
                beyongTimeStr = context.getString(R.string.str_above_hour, beyondTime / ONE_HOUR_MILLIONS);
            } else if (beyondTime / ONE_MINUTE_MILLIONS > 0) {
                beyongTimeStr = context.getString(R.string.str_above_minutes, beyondTime / ONE_MINUTE_MILLIONS);
            } else if (beyondTime < ONE_MINUTE_MILLIONS) {
                beyongTimeStr = context.getString(R.string.str_just);
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                beyongTimeStr = sdf.format(new Date(createTime * 1000));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return beyongTimeStr;

    }


    public static String getShortTime(Context context, long createTime) {

        long beyondTime;
        String beyongTimeStr = "";

        if (createTime <= 0) {
            return context.getString(R.string.str_just);
        }
        beyondTime = System.currentTimeMillis() / 1000 - createTime;
        if (beyondTime / ONE_MONTH_MILLIONS > 0) {
            beyongTimeStr = context.getString(R.string.str_above_month, beyondTime / ONE_MONTH_MILLIONS);
        } else if (beyondTime / ONE_DAY_MILLIONS > 0) {
            beyongTimeStr = context.getString(R.string.str_above_day, beyondTime / ONE_DAY_MILLIONS);
        } else if (beyondTime / ONE_HOUR_MILLIONS > 0) {
            beyongTimeStr = context.getString(R.string.str_above_hour, beyondTime / ONE_HOUR_MILLIONS);
        } else if (beyondTime / ONE_MINUTE_MILLIONS > 0) {
            beyongTimeStr = context.getString(R.string.str_above_minutes, beyondTime / ONE_MINUTE_MILLIONS);
        } else if (beyondTime < ONE_MINUTE_MILLIONS) {
            beyongTimeStr = context.getString(R.string.str_just);
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            beyongTimeStr = sdf.format(new Date(createTime * 1000));
        }
        return beyongTimeStr;

    }

    /**
     * 获取月日
     *
     * @return
     */
    public static String getMonth(Context context, String time) {
        DateFormat df3 = new SimpleDateFormat(context.getString(R.string.str_month_day_format));
        long r_date = Long.parseLong(time) * 1000;
        return df3.format(r_date);

    }


    /**
     * 获取还有多少天
     *
     * @return
     */
    public static String getTime(String time) {
        long r_date = Long.parseLong(time) * 1000;
        Long newTime = System.currentTimeMillis();
        Long curTime = r_date - newTime;
        long n = curTime / (1000 * 60 * 60 * 24);
        return n + "";

    }

    /**
     * 获取小时分钟
     *
     * @return
     */
    public static String getHour(String time) {
        int time1 = Integer.parseInt(time);
        String sh = (time1 / 60) + "";
        String sm = (time1 % 60) + "";
        sh = (sh.length() < 2) ? "0" + sh : sh;
        sm = (sm.length() < 2) ? "0" + sm : sm;

        return sh + ":" + sm;

    }

    /**
     * @param time 单位:秒
     * @return 活动剩余时间
     */
    public static String getActivityTime(Context context, String time) {
        String lastTime = null;
        try {
            lastTime = "";
            long r_date = Long.parseLong(time) * 1000;
            long lastTimeL = r_date - System.currentTimeMillis();
            long day = lastTimeL / (1000 * 60 * 60 * 24);
            if (day > 0) {
                lastTime = context.getString(R.string.str_day, day);
            } else {
                long hour = lastTimeL / 60 / 60 / 1000;
                if (hour > 0) {
                    lastTime = context.getString(R.string.str_hour, hour);
                } else {
                    long min = lastTimeL / 60 / 1000;
                    if (min > 0) {
                        lastTime = context.getString(R.string.str_minute, min);
                    } else {
                        lastTime = context.getString(R.string.str_minute, 1);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lastTime;

    }


    /**
     * @param time 单位:秒
     * @return 活动剩余时间
     */
    public static String getActivityTime(Context context, long time) {
        String lastTime = null;
        try {
            lastTime = "";
            long r_date = time * 1000;
            long lastTimeL = r_date - System.currentTimeMillis();
            long day = lastTimeL / (1000 * 60 * 60 * 24);
            if (day > 0) {
                lastTime = context.getString(R.string.str_day, day);
            } else {
                long hour = lastTimeL / 60 / 60 / 1000;
                if (hour > 0) {
                    lastTime = context.getString(R.string.str_hour, hour);
                } else {
                    long min = lastTimeL / 60 / 1000;
                    if (min > 0) {
                        lastTime = context.getString(R.string.str_minute, min);
                    } else {
                        lastTime = context.getString(R.string.str_minute, 1);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lastTime;

    }


    /**
     * 获取时间字符串的毫秒 yyyy-MM-dd HH:mm:ss
     */
    public static long getTimeInMillis(String time) {
        Calendar c = Calendar.getInstance();

        try {
            c.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time));
            return c.getTimeInMillis();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;
    }


    /**
     * 格式化时间字符串 00:00:00
     */
    public static String stringForTime(long timeMs) {
        StringBuilder formatBuilder = new StringBuilder();
        Formatter formatter = new Formatter(formatBuilder, Locale.getDefault());
        try {
            int totalSeconds = (int) (timeMs / 1000);

            int seconds = totalSeconds % 60;
            int minutes = (totalSeconds / 60) % 60;
            int hours = totalSeconds / 3600;

            formatBuilder.setLength(0);

            return formatter.format("%02d:%02d:%02d", hours, minutes, seconds).toString();
        } finally {
            formatter.close();
        }
    }

    /**
     * 格式化时间字符串 00:00:00
     */
    public static String stringForFollowingTime(long timeMs) {
        StringBuilder formatBuilder = new StringBuilder();
        Formatter formatter = new Formatter(formatBuilder, Locale.getDefault());
        try {
            int totalSeconds = (int) (timeMs / 1000);

            int seconds = totalSeconds % 60;
            int minutes = (totalSeconds / 60) % 60;
            int hours = totalSeconds / 3600;

            formatBuilder.setLength(0);

            return formatter.format("%d:%02d:%02d", hours, minutes, seconds).toString();
        } finally {
            formatter.close();
        }
    }

    /**
     * 获取现在日期 yyyy-MM-dd HH:mm:ss
     */
    public static String getDateString() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 获取现在日期 yyyy-MM-dd
     */
    public static String getShortDateString() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 获取现在时间 HH:mm:ss
     */
    public static String getTimeString() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date currentTime = new Date();
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 获取现在时间 HH:mm:ss
     */
    public static Long getTime() {
        Long lastTimeL = System.currentTimeMillis() / 1000;
        return lastTimeL;
    }
}
