package io.clownfishyang.leetcode;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * <br>
 *
 * @author ClownfishYang<br>
 * created on 2020/9/7 16:39<br>
 */
public class NumberCompute {

    /**
     *
     * 功能描述:
     *
     * 统计所有小于非负整数 n 的质数的数量。
     *
     * 示例:
     * 输入: 10
     * 输出: 4
     * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-07 17:01:20
     */
    public int countPrimes(int n) {
        // 标记
        boolean[] notPrimes = new boolean[n];

        // 已知一个素数i,则i 的整数倍值都不可能是素数。
        // 因子的对称性，只需遍历[2,sqrt(n)] 次
        int sqrtN = (int)Math.sqrt(n);
        for (int i = 2; i <= sqrtN; i++) {
            if (notPrimes[i] == false) {
                // j = 2 * i，但 [2 * j, i * i) 已经被计算过了，直接跳过
                for (int j = i * i; j < n; j += i) {
                    notPrimes[j] = true;
                }
            }
        }
        // 统计素数数量
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrimes[i] == false) count++;
        }
        return count++;
    }


    /**
     *
     * 功能描述:
     *
     * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
     *
     * 示例 1:
     * 输入: 27
     * 输出: true
     *
     * 示例 2:
     * 输入: 0
     * 输出: false
     *
     * 示例 3:
     * 输入: 9
     * 输出: true
     *
     * 示例 4:
     * 输入: 45
     * 输出: false
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-07 17:17:00
     */
    public boolean isPowerOfThree(int n) {
        // 循环
        /*if (n < 1) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;*/
        // 进制转换
        // 对于10 进制数来说，10 的n 次幂表示为10,100,1000,
        // 2 的n 次幂表示为10,100,1000, 3 同理
//        return Integer.toString(n, 3).matches("^10*$.");
        // 运算法
        // n = 3 ^ i * i = log3(n) * i = logb(n) / logb(3)
//        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
        // 整数限制
        // 3 ^ [log3*(Integer.MAX_VALUE)] = 3 ^ [19.56] = 3 ^ 19 = 1162261467
        return n > 0 && 1162261467 % n == 0;
    }


    /**
     * 功能描述:
     * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
     *
     * 示例 1：
     * 输入：00000000000000000000000000001011
     * 输出：3
     * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
     *
     * 示例 2：
     * 输入：00000000000000000000000010000000
     * 输出：1
     * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
     *
     * 示例 3：
     * 输入：11111111111111111111111111111101
     * 输出：31
     * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
     *  
     *
     * 提示：
     * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
     * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-07 17:52:01
     */
    public int hammingWeight(int n) {
        // bitCount
//        return Integer.bitCount(xor);
        // 位移动
        /*int bits = 0, mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0)
                bits++;
            mask <<= 1;
        }
        return bits;*/

        // 位计算(布莱恩 克尼根算法)
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n-1);
        }
        return sum;
    }

    /**
     * 功能描述:
     *
     * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
     * 给出两个整数 x 和 y，计算它们之间的汉明距离。
     *
     * 注意：
     * 0 ≤ x, y < 231.
     *
     * 示例:
     * 输入: x = 1, y = 4
     *
     * 输出: 2
     * 解释:
     * 1   (0 0 0 1)
     * 4   (0 1 0 0)
     *        ↑   ↑
     * 上面的箭头指出了对应二进制位不同的位置。
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-08 09:54:24
     */
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        return hammingWeight(xor);
    }


    public int reverseBits(int n) {
        // 位移动
        /*int ret = 0, power = 31, mask = 1;
        while (n != 0) {
            ret += ((n & mask) << power);
            n >>= mask;
            power --;
        }
        return ret;*/

        // 并行法，5 * lg(N)
        /*
        // swap odd and even bits
        n = ((n >>> 1) & 0x55555555) | ((n & 0x55555555) << 1);
        // swap consecutine pairs
        n = ((n >>> 2) & 0x33333333) | ((n & 0x33333333) << 2);
        // swap nibbles ...
        n = ((n >>> 4) & 0x0F0F0F0F) | ((n & 0x0F0F0F0F) << 4);
        // swap bytes
        n = ((n >>> 8) & 0x00FF00FF) | ((n & 0x00FF00FF) << 8);
        // swap 2-byte long pairs
        n = ( n >>> 16             ) | ( n               << 16);*/

        // 变体, 使用即时常量减少内存
        int s = 32;
        int mask = ~0;
        while ((s >>= 1) > 0) {
            mask ^= (mask << s);
            n = ((n >> s) & mask) | ((n << s) & ~mask);
        }
        return n;

    }

}
