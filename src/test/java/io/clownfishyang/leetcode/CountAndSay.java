package io.clownfishyang.leetcode;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * <br>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 * 整数序列中的每一项将表示为一个字符串。
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “一个 1 ”，记作 11
 * 描述前一项，这个数是 11 即 “两个 1 ” ，记作 21
 * 描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 1211
 * 描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 111221
 *
 * @author ClownfishYang<br>
 * created on 2020/8/12 16:56<br>
 */
public class CountAndSay {

    /**
     *
     * 功能描述:
     *
     * 示例 1:
     * 输入: 1
     * 输出: "1"
     * 解释：这是一个基本样例。
     *
     * 示例 2:
     * 输入: 4
     * 输出: "1211"
     * 解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；类似 "1" 可以读作 "11"。所以答案是 "12" 和 "11"
     * 组合在一起，也就是 "1211"。
     *
     * 利用递归对上级结果遍历计数。
     *
     * @param n
     * @return 散列表示
     * @auther ClownfishYang
     * created on 2020-08-12 17:04:44
     */
    public String say(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuilder sb = new StringBuilder("1");
        StringBuilder temp = new StringBuilder();
        int r = 1;
        while (r < n) {
            int count = 1;
            for (int i = 0; i < sb.length(); i++) {
                if (i + 1 < sb.length() && sb.charAt(i) == sb.charAt(i + 1))
                    count++;
                else {
                    temp.append(count).append(sb.charAt(i));
                    count = 1;
                }
            }
            sb.delete(0, sb.length());
            sb.append(temp);
            temp.delete(0, temp.length());
            r++;
        }
        return sb.toString();
        /*if (n == 1) {
            return "1";
        }
        StringBuilder sb = new StringBuilder();
        String pre = say(--n);
        int count = 1;
        for (int i = 0; i < pre.length(); i++) {
            if (i + 1 < pre.length() && pre.charAt(i) == pre.charAt(i+1)) {
                count++;
            } else {
                sb.append(count).append(pre.charAt(i));
                count = 1;
            }
        }
        return sb.toString();*/
    }

}
