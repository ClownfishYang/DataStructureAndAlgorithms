package io.clownfishyang.leetcode;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * <br>
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * <p>
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * @author ClownfishYang<br>
 * created on 2020/8/11 9:18<br>
 */
public class IntReverse {


    /**
     *
     * 功能描述:
     *
     * 使用字符串线性遍历反转，判断首位(0)是否为符号位(-)，以此往首位(idx)插入，最后进行溢出判断。
     *
     * @param x
     * @return 反转数值
     * @auther ClownfishYang
     * created on 2020-08-11 09:58:39
     */
    public int linearString(int x) {
        String s = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0);
        int idx = 0;
        if (c == '-') {
            sb.append(c);
            idx = 1;
        }
        for (int i = idx; i < s.length(); i++) {
            sb.insert(idx, s.charAt(i));
        }
        Long val = Long.valueOf(sb.toString());
        return val > Integer.MAX_VALUE || val < Integer.MIN_VALUE
                ? 0 : val.intValue();
    }

    /**
     *
     * 功能描述:
     *
     * 通过循环对10 进行取余得到(pop)个数位，整除得到(x) 剩余值，反转值(ans) 等于上一个ans * 10 + pop。
     * 每次进行ans 计算前进行溢出判断，则(ans < maxInt / 10 && pop < 7) && (ans > minInt / 10 && pop > -8)。
     *
     * @param x
     * @return 反转数值
     * @auther ClownfishYang
     * created on 2020-08-11 10:00:39
     */
    public int numberConversion(int x) {
        int ans = 0;
        int maxValue = Integer.MAX_VALUE / 10;
        int minValue = Integer.MIN_VALUE / 10;
        while (x != 0) {
            int pop = x % 10;
            if (ans > maxValue || (ans == maxValue && pop > 7)) {
                return 0;
            }
            if (ans < minValue || (ans == minValue && pop < -8)) {
                return 0;
            }
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }

    /**
     *
     * 功能描述:
     *
     * 通过循环对10 进行取余得到(pop)个数位，整除得到(x) 剩余值，反转值(ans) 等于上一个ans * 10 + pop。
     * 使用long 保存ans 值，最后进行溢出判断。
     *
     * @param x
     * @return 反转数值
     * @auther ClownfishYang
     * created on 2020-08-11 10:00:39
     */
    public int longConversion(int x) {
        long ans = 0;
        while (x != 0) {
            int pop = x % 10;
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE
                ? 0 : (int) ans;
    }

}
