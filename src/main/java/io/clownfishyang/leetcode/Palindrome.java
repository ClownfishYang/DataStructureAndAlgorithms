package io.clownfishyang.leetcode;

import io.clownfishyang.datastructure.ListNode;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * <br>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的。
 * <p>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/11 9:58<br>
 */
public class Palindrome {

    public boolean is(ListNode head) {
        if (head == null) return true;
//        找到前半部分链表的尾节点。
//        反转后半部分链表。
        // Find the end of first half and reverse second half.
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);
//        判断是否为回文。
        boolean flag = true;
        ListNode l1 = head, l2 = secondHalfStart;
        while (l2 != null) {
            if (l1.val != l2.val) {
                flag = false;
                break;
            } else {
                l1 = l1.next;
                l2 = l2.next;
            }
        }
//        恢复链表。
        firstHalfEnd.next = reverseList(secondHalfStart);
//        返回结果。
        return flag;
    }


    private ListNode reverseList(ListNode head) {
        ListNode cur = null, per = head;
        while (per != null) {
            ListNode next = per.next;
            per.next = cur;
            cur = per;
            per = next;
        }
        return cur;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    /**
     * 功能描述:
     * 判断一个整数是否是回文数。
     * <p>
     * 示例 1:
     * 输入: 121
     * 输出: true
     * <p>
     * 示例 2:
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * <p>
     * 示例 3:
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     * <p>
     * 进阶: 你能不将整数转为字符串来解决这个问题吗？
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-11 10:14:35
     */
    public boolean is(int x) {
        return halfNumberCheck(x);
    }


    /**
     * 功能描述:
     * 先计算出数值x 的位数(div)，然后x / div 得到首位(left)，x % 10 得到尾位(right)，
     * 判断left == right，然后x % div / 10 得到去除首尾的中间值，对中间值重复校验。
     *
     * @param x
     * @return 是否是回文
     * @auther ClownfishYang
     * created on 2020-08-11 10:27:15
     */
    public boolean headTailCheck(int x) {
        //边界判断
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        // x 的位数
        int div = 1;
        while (x / div >= 10) div *= 10;
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

    /**
     * 功能描述:
     * <p>
     * 计算出后半段数字(reverseNumber)进行反转，reverseNumber == x 前半段 || reverseNumber / 10 == x 前半段，因为x 可能为奇位数。
     * 半段数字的确定可以通过依次对x 与10 进行整除，当x <= reverseNumber 时，
     * 前后半段数值已经临界，数值位数相等或因为x 为奇位数 reverseNumber 多了一位。
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-11 10:31:36
     */
    public boolean halfNumberCheck(int x) {
        if (x == 0) return true;
        if (x < 0 || x % 10 == 0) return false;
        int reverseNumber = 0;
        while (x > reverseNumber) {
            reverseNumber = reverseNumber * 10 + x % 10;
            x /= 10;
        }
        return x == reverseNumber || x == reverseNumber / 10;
    }


    /**
     *
     * 功能描述:
     *
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     *
     * 示例 1:
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     *
     * 示例 2:
     * 输入: "race a car"
     * 输出: false
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-24 15:09:57
     */
    public boolean is(String s) {
        return headTailCheck(s);
    }

    /**
     *
     * 功能描述:
     *
     * 双指针，头尾偏移校验
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-24 15:10:13
     */
    public boolean headTailCheck(String s) {
        if (s == null || s.length() == 0) return true;
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < end && !Character.isLetterOrDigit(s.charAt(start)))
                start++;
            while (start < end && !Character.isLetterOrDigit((s.charAt(end))))
                end--;
            if (start < end) {
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end)))
                    return false;
                start++;
                end--;
            }
        }
        return true;
    }

    /**
     *
     * 功能描述:
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     *
     * 示例 1：
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     *
     * 示例 2：
     * 输入: "cbbd"
     * 输出: "bb"
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-09 15:49:29
     */
    public String longestPalindrome(String s) {
        // 中心扩散法
        int len = s.length();
        if (len < 2) return s;
        int start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            // 回文串长度可能是奇数或偶数
            int len_odd = expandCenter(s, i, i);
            int len_even = expandCenter(s, i, i + 1);
            int curLen = Math.max(len_odd, len_even);
            if (curLen > end - start) {
                start = i - (curLen - 1) >> 1;
                end = i + (curLen >> 1);
            }
        }
        return s.substring(start, end + 1);

        // 动态规划
        /*int len = s.length();
        if (len < 2) return s;

        int maxLen = 1, begin = 0;
        // 状态初始化
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        // 按列设置状态
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                // s[i] == s[j] -> s(i,j) is true
                if (s.charAt(i) == s.charAt(j)) {
                    // 只剩下一个字符
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        // 状态转移
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // s[i,j] is true && curLen > maxLen
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);*/
        /*int maxLen = 0, beginIdx = 0, endIdx = Math.min(s.length(),1);
        for (int i = 1; i < s.length(); i++) {
            int low = 0, high = i;
            while (low < high) {
                while (low < high && s.charAt(low) != s.charAt(high)) low ++;
                int l = low, r = high;
                boolean flag = true;
                while (l < r) {
                    if (s.charAt(l) != s.charAt(r)) {
                        flag = false;
                        break;
                    }
                    l ++;
                    r --;
                }
                if (flag) {
                    int curLen = Math.max(high - low, 0);
                    if (curLen > maxLen) {
                        beginIdx = low;
                        endIdx = high + 1;
                        maxLen = curLen;
                    }
                }
                low ++;
            }
        }
        return s.substring(beginIdx, endIdx);*/
    }

    private int expandCenter(String s, int low, int high) {
        while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
            low --;
            high++;
        }
        // high - low + 1 - 2 -> high - low - 1 去除边间
        return high - low - 1;
    }

}
