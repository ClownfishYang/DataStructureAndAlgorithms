package io.clownfishyang.leetcode;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * <br>
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9
 * 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * @author ClownfishYang<br>
 * created on 2020/8/11 10:53<br>
 */
public class RomanNumber {

    public int toInt(String s) {
        int val = 0;
        int length = s.length() - 1;
        while(length >= 0) {
            char c = s.charAt(length--);
            int diff = 0;
            if (c == 'V' || c == 'X') {
                val += c == 'V' ? 5 : 10;
                while (length >= 0 && s.charAt(length) == 'I') {
                    diff++;
                    length--;
                }
            } else if (c == 'L' || c == 'C') {
                val += c == 'L' ? 50 : 100;
                while (length >= 0 && s.charAt(length) == 'X') {
                    diff += 10;
                    length--;
                }
            } else if (c == 'D' || c == 'M') {
                val += c == 'D' ? 500 : 1000;
                while (length >= 0 && s.charAt(length) == 'C') {
                    diff += 100;
                    length--;
                }
            } else {
                val ++;
            }
            val -= diff;
        }
        return val;
    }


}
