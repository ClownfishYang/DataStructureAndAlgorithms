package io.clownfishyang.leetcode;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * <br>
 *
 * 查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * @author ClownfishYang<br>
 * created on 2020/8/11 13:59<br>
 */
public class LongestCommonPrefix {

    /**
     *
     * 功能描述:
     * 横向搜索
     *
     * 示例 1:
     *
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     *
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-11 14:00:03
     */
    public String horizontalSearch(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
            pre = longestCommonPrefix(pre, strs[i]);
            if (pre.length() == 0) {
                return pre;
            }
        }
        return pre;
    }

    private String longestCommonPrefix(String s1, String s2) {
        int min = Math.min(s1.length(), s2.length());
        int idx = 0;
        while (idx < min && s1.charAt(idx) == s2.charAt(idx)) {
            idx++;
        }
        return s1.substring(0, idx);
    }

    /**
     *
     * 功能描述:
     * 纵向搜索。
     *
     * 示例 1:
     *
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     *
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-11 14:00:03
     */
    public String verticalSearch(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int min = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (min > strs[i].length())
                min = strs[i].length();
        }
        int idx = 0;
        while (idx < min) {
            char pre = strs[0].charAt(idx);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(idx) != pre) {
                    return strs[0].substring(0, idx);
                }
            }
            idx++;
        }
        return strs[0].substring(0, idx);
    }

    /**
     *
     * 功能描述:
     *
     * 二分查找的方式，确定min 为初始 high。
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-11 14:58:11
     */
    public String binarySearch(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int min = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (min > strs[i].length())
                min = strs[i].length();
        }
        int low = 0, high = min;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (isCommonPrefix(strs, low, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);
    }

    private boolean isCommonPrefix(String[] strs, int low, int high) {
        for (int i = 1; i < strs.length; i++) {
            for (int j = low; j < high; j++) {
                if (strs[0].charAt(j) != strs[i].charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

}
