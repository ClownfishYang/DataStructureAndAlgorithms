package io.clownfishyang.leetcode;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * <br>
 * <p>
 * 计数二进制子串
 * <p>
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 * 重复出现的子串要计算它们出现的次数。
 * <p>
 * 示例 1 :
 * <p>
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 * <p>
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 * <p>
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 * <p>
 * 示例 2 :
 * <p>
 * 输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 *
 * @author ClownfishYang<br>
 * created on 2020/8/10 15:15<br>
 */
public class CountBinarySubstrings {

    /**
     *
     * 功能描述:
     *
     * 由于不会出现混合的情况，只需要对当前字符串（curr）与前一个字符串进行（pre）比较，即curr 每次增加 && 小于 pre，则计数加一。
     * <p>
     * 例如，<br>
     * "000111" 先遍历 0 的数量为 curr = 3, 当到 1 时, pre = curr 赋值为 3, 然后 curr = 1 表示现在 1 的个数；<br>
     * 接下来只要 curr <= pre,<br>
     * 那么当 curr = 1 时， 可以组成 01，则计数加一;<br>
     * 当curr = 2, 可以组成 0011，则计数加一,<br>
     * 当curr = 3, 可以组成 000111，则计数加一,<br>
     * 遍历完字符串。
     * </p>
     * @param s
     * @return 二进制子串数量
     * @auther ClownfishYang
     * created on 2020-08-10 15:59:36
     */
    public int linearCount(String s) {
        int i = 1, n = 0, pre = 0, curr = 1, len = s.length();
        char c = s.charAt(0);
        while (i < len) {
            char c1 = s.charAt(i);
            if (c == c1) {
                curr ++ ;
            } else {
                pre = curr;
                curr = 1;
                c = c1;
            }
            if (pre >= curr) {
                n++;
            }
            i ++;
        }
        /*
        int n = 0, pre = 0, curr = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                curr++;
            } else {
                pre = curr;
                curr = 1;
            }
            if (pre >= curr) {
                n++;
            }
        }
        */
        return n;
    }

    /**
     *
     * 功能描述:
     *
     * 由于不会出现混合的情况，只需要考虑子串前后之间的组合数量即可，前后子串计数去min 之和就是总计数。
     * <p>
     * 例如，<br>
     * "00111011" 可以得到counts 数组：counts={2,3,1,2}<br>
     * counts 数组中两个相邻数表示u 个0 和v 个1 或者u 个1 和v 个0，则它们之间能组成子串的数目为min(u,v)。
     * 将counts 数组间的计数求和就是总的计数。
     * </p>
     * @param s
     * @return 二进制子串数量
     * @auther ClownfishYang
     * created on 2020-08-10 15:59:36
     */
    public int groupCount(String s) {
        int ptr = 0, n = s.length(), last = 0, ans = 0;
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr < n && s.charAt(ptr) == c) {
                ptr++;
                count ++;
            }
            ans += Math.min(last, count);
            last = count;
        }
        return ans;
    }



}
