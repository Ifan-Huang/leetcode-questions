package com.codeforc.algorithm.playground;

import java.util.Calendar;

//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。
//求所有子数组的和的最大值。要求时间复杂度为O(n)。
public class Dp1 {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    private static final String IDCARD_PAT = "([1-9][0-9]{5}(18|19|20)[0-9]{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)[0-9]{3}[0-9Xx])|([1-9][0-9]{5}[0-9]{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)[0-9]{3})";

    public static Integer of(String idcard) {
        if(idcard == null) return null;
        Integer age = null;
        boolean matches = idcard.matches(IDCARD_PAT);
        if(matches) {
            Integer selectYear = Integer.valueOf(idcard.substring(6, 10));         //出生的年份
            Integer selectMonth = Integer.valueOf(idcard.substring(10, 12));       //出生的月份
            Integer selectDay = Integer.valueOf(idcard.substring(12, 14));         //出生的日期
            Calendar cal = Calendar.getInstance();
            Integer yearMinus = cal.get(Calendar.YEAR) - selectYear;
            Integer monthMinus = cal.get(Calendar.MONTH) + 1 - selectMonth;
            Integer dayMinus = cal.get(Calendar.DATE) - selectDay;
            age = yearMinus;
            if (yearMinus < 0) {
                age = 0;
            } else if (yearMinus == 0) {
                age = 0;
            } else if (yearMinus > 0) {
                if (monthMinus == 0) {
                    if (dayMinus < 0) {
                        age = age - 1;
                    }
                } else if (monthMinus > 0) {
                    age = age + 1;
                }
            }
        }
        return age;
    }

    public static void main(String[] args) {
        Integer of = of("360124199609022138");
        System.out.println(of);
    }

}