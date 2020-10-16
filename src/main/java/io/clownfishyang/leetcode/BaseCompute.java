package io.clownfishyang.leetcode;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * <br>
 * 进制计算
 *
 * @author ClownfishYang<br>
 * created on 2020/8/13 9:53<br>
 */
public class BaseCompute {

    /**
     *
     * 功能描述:
     *
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     *
     * 示例 1:
     * 输入: 4
     * 输出: 2
     *
     * 示例 2:
     * 输入: 8
     * 输出: 2
     * 说明: 8 的平方根是 2.82842...,
     *      由于返回类型是整数，小数部分将被舍去。
     *
     * 使用[袖珍计算器算法] 一种用指数函数exp 和对数函数ln 代替平方根函数的方法。
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-13 11:10:19
     */
    public int mySqrt(int x) {
        if (x < 0) throw new IllegalArgumentException();
        if (x == 0) return 0;
        int ans = (int)Math.exp(0.5 * Math.log(x));
        return ((long)(ans + 1) << 1) <= x ? ans + 1 : ans;
    }

    /**
     * 功能描述:
     * <p>
     * 给你两个二进制字符串，返回它们的和（用二进制表示）。
     * 输入为 非空 字符串且只包含数字 1 和 0。
     * <p>
     * 示例 1:
     * 输入: a = "11", b = "1"
     * 输出: "100"
     * <p>
     * 示例 2:
     * 输入: a = "1010", b = "1011"
     * 输出: "10101"
     * <p>
     * 使用[列竖式]的方法，末尾对齐，逐位相加，逢二进一。
     * 1、取n = max{|a|, |b|}，循环n 次，从最低位开始。
     * 2、定义变量carry 表示上一位置的进位，默认为0；
     * 3、则每一个位的结果 = (carry + ai + bi) mod 2;
     * 4、进位的结果为 = (carry + ai + bi) / 2;
     * <p>
     * 使用StringBuilder insert 0 为4ms < reverse 为3ms < char 为2ms；
     *
     * @param a
     * @param b
     * @return 结果
     * @auther ClownfishYang
     * created on 2020-08-13 09:54:20
     */
    public String addBinary(String a, String b) {
        if (a == null || b == null) throw new IllegalArgumentException();
        if (a.length() == 0) return b;
        if (b.length() == 0) return a;
        int n = Math.max(a.length(), b.length()), carry = 0;
        char[] chars = new char[n + 1];
        // 48 为ascii 码的'0',用于int 和char 的转换
        for (int i = 0; i < n; i++) {
            carry += i < a.length() ? a.charAt(a.length() - i - 1) - 48 : 0;
            carry += i < b.length() ? b.charAt(b.length() - i - 1) - 48 : 0;
            chars[n - i] = (char) (carry % 2 + 48);
            carry /= 2;
        }
        if (carry != 0) chars[0] = (char) (carry + 48);
        // 首位进位则从0 开始，否则从1 开始，0 忽略
        int offset = carry == 0 ? 1 : 0;
        return new String(chars, offset, chars.length - offset);
    }

}
