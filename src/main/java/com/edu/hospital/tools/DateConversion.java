package com.edu.hospital.tools;

import java.util.Calendar;
import java.util.Date;

public class DateConversion {

    /**
     * 定义排班规则枚举
     */
    public enum ScheduleRule {
        MON_WED_FRI_AM(1, "一三五上午"),   // 周一、周三、周五上午
        MON_WED_FRI_PM(2, "一三五下午"),   // 周一、周三、周五下午
        TUE_THU_SAT_AM(3, "二四六上午"),   // 周二、周四、周六上午
        TUE_THU_SAT_PM(4, "二四六下午"),   // 周二、周四、周六下午
        SUN_AM(5, "周日上午"),            // 周日上午
        SUN_PM(6, "周日下午");            // 周日下午

        private final int number;
        private final String description;

        ScheduleRule(int number, String description) {
            this.number = number;
            this.description = description;
        }

        public int getNumber() {
            return number;
        }

        public String getDescription() {
            return description;
        }
    }


    /**
     * 将日期转换为排班序号
     *
     * @param date 日期
     * @return 排班序号(1-6)，无效日期返回0
     */
    public static int convertDateToScheduleNumber(Date date) {
        if (date == null) {
            return 0; // 无效日期返回0
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        // 转换为常规的周一1到周日7的表示方式
        int day = dayOfWeek == 1 ? 7 : dayOfWeek - 1;

        // 获取小时数，判断上午或下午
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        switch (day) {
            case 1: // 周一
            case 3: // 周三
            case 5: // 周五
                return hour < 12 ? ScheduleRule.MON_WED_FRI_AM.getNumber()
                        : ScheduleRule.MON_WED_FRI_PM.getNumber();
            case 2: // 周二
            case 4: // 周四
            case 6: // 周六
                return hour < 12 ? ScheduleRule.TUE_THU_SAT_AM.getNumber()
                        : ScheduleRule.TUE_THU_SAT_PM.getNumber();
            case 7: // 周日
                return hour < 12 ? ScheduleRule.SUN_AM.getNumber()
                        : ScheduleRule.SUN_PM.getNumber();
            default:
                return 0; // 无效日期返回0
        }
    }


    /**
     * 将中文时间字符串（如 "周一上午"）转换为排班序号
     *
     * @param chineseTime 中文时间字符串
     * @return 排班序号(1-6)，无效输入返回0
     */
    public static int convertChineseToScheduleNumber(String chineseTime) {
        if (chineseTime == null || chineseTime.isEmpty()) {
            return 0; // 无效输入返回0
        }

        switch (chineseTime) {
            case "周一上午":
            case "周三上午":
            case "周五上午":
                return 1; // 一三五上午
            case "周一下午":
            case "周三下午":
            case "周五下午":
                return 2; // 一三五下午
            case "周二上午":
            case "周四上午":
            case "周六上午":
                return 3; // 二四六上午
            case "周二下午":
            case "周四下午":
            case "周六下午":
                return 4; // 二四六下午
            case "周日上午":
                return 5; // 周日上午
            case "周日下午":
                return 6; // 周日下午
            default:
                return 0; // 无效输入返回0
        }
    }

}
