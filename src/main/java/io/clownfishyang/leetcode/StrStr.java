package io.clownfishyang.leetcode;

import io.clownfishyang.datastructure.KMP;

import java.util.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * <br>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/11 18:25<br>
 */
public class StrStr {

    /**
     *
     * 功能描述:
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *
     * 示例:
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-11 15:02:50
     */
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return Collections.EMPTY_LIST;
        // 字母列表
        String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> letterList = new ArrayList<>(digits.length());
        for (int i = 0; i < digits.length(); i++)
            // 0 1 没有字母
            letterList.add(letters[digits.charAt(i) - '0' - 2]);
        List<String> res = new LinkedList<>();
        // 组合
        combination(res, letterList, 0, new StringBuilder());
        return res;
    }

    private void combination(List<String> res, List<String> letterList, int idx, StringBuilder sb) {
        // idx = 列表size
        if (idx == letterList.size()) {
            res.add(sb.toString());
        } else {
            // idx - 字母
            String s = letterList.get(idx);
            // 遍历字母
            for (int i = 0; i < s.length(); i++) {
                // 每次对第i 位进行组合
                sb.append(s.charAt(i));
                combination(res, letterList, idx + 1, sb);
                sb.deleteCharAt(idx);
            }
        }
    }

    /**
     * 功能描述:
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * 示例 2:
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     *
     * 示例 3:
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-09 14:11:23
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] charBit = new int[256];
        int startIdx = 0, maxLen = 0, curLen = 0;
        for (int i = 0; i < s.length();i++) {
            int idx = s.charAt(i);
            int c = charBit[idx];
            if (c == 0) {
                curLen ++;
            } else {
                if (curLen > maxLen)
                    maxLen = curLen;
                startIdx = Math.max(c - 1, startIdx);
                curLen = i - startIdx;

            }
            charBit[idx] = i + 1;
        }
        return curLen > maxLen ? curLen : maxLen;
        // 哈希
        /*Map<Character, Integer> map = new HashMap<>();
        int startIdx = 0, maxLen = 0, curLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char o = s.charAt(i);
            Integer idx = map.get(o);
            if (idx == null) {
                curLen ++;
            } else {
                if (curLen > maxLen)
                    maxLen = curLen;
                startIdx = Math.max(idx, startIdx);
                curLen = i - startIdx;
            }
            map.put(o, i);
        }
        return curLen > maxLen ? curLen : maxLen;*/
    }

    /**
     * 功能描述:
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     *
     * 示例:
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     *
     * 说明：
     * 所有输入均为小写字母。
     * 不考虑答案输出的顺序。
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-09 10:47:21
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Long, List<String>> map = new HashMap<>();
        for (String str : strs) {
            long key = 1;
            for (int i = 0; i < str.length(); i++) {
                key *= (str.charAt(i) - 97);
            }
            List<String> strList = map.get(key);
            if (strList == null) {
                strList = new LinkedList<>();
                map.put(key, strList);
            }
            strList.add(str);
        }
        return new ArrayList<>(map.values());
    }

    public String charCountStr(int[] charCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] > 0)
                sb.append('#').append(i).append('|').append(charCount[i]);
        }
        return sb.toString();
    }

    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<String>(n);
        for (int i = 1; i <= n; i++) {
            // 1、匹配
            // 2、字符串拼接
            // 3、hash 映射
            boolean threeFlag = i % 3 == 0;
            boolean fiveFlag = i % 5 == 0;
            if (threeFlag && fiveFlag) {
                res.add("FizzBuzz");
            } else if (threeFlag) {
                res.add("Fizz");
            } else if (fiveFlag) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }


    /**
     *
     * 功能描述:
     *
     * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
     *
     * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
     * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
     * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
     * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
     * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
     *
     * 提示：
     * 本题中的空白字符只包括空格字符 ' ' 。
     * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
     *
     * 示例 1:
     * 输入: "42"
     * 输出: 42
     *
     * 示例 2:
     * 输入: "   -42"
     * 输出: -42
     * 解释: 第一个非空白字符为 '-', 它是一个负号。
     *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
     *
     * 示例 3:
     * 输入: "4193 with words"
     * 输出: 4193
     * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
     *
     * 示例 4:
     * 输入: "words and 987"
     * 输出: 0
     * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     *      因此无法执行有效的转换。
     *
     * 示例 5:
     * 输入: "-91283472332"
     * 输出: -2147483648
     * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     *      因此返回 INT_MIN (−231) 。
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-03 16:36:36
     */
    public int atoi(String str) {
        if (str == null || str.length() == 0) return 0;
        int start = 0;
        int ans = 0;
        int maxVal = Integer.MAX_VALUE / 10;
        int minVal = Integer.MIN_VALUE / 10;
        int sign = 1;
        while (start < str.length() && str.charAt(start) == ' ') {
            start ++;
        }
        if (start < str.length() && (str.charAt(start) == '-' || str.charAt(start) == '+')) {
            if (str.charAt(start) == '-')
                sign = -1;
            start++;
        }
        while (start < str.length()) {
            int pop = str.charAt(start++) - 48;
            if (pop < 0 || pop > 9) return ans;
            if (ans > maxVal || (ans == maxVal && pop > 7)) {
                return Integer.MAX_VALUE;
            }
            if (ans < minVal || (ans == minVal && pop > 8)) {
                return Integer.MIN_VALUE;
            }
            ans = ans * 10 + sign * pop;
        }
        return ans;
    }

    /**
     * 功能描述:
     * <p>
     * 将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
     * <p>
     * 示例 1：
     * 输入：["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     * <p>
     * 示例 2：
     * 输入：["H","a","n","n","a","h"]
     * 输出：["h","a","n","n","a","H"]
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-02 15:44:04
     */
    public void reverseString(char[] s) {
        reverseString(s, 0, s.length - 1);
    }

    public void reverseString(char[] s, int l, int r) {
        while (l < r) {
            s[l] ^= s[r];
            s[r] ^= s[l];
            s[l++] ^= s[r--];
            /*char temp = s[l];
            s[l++] = s[r];
            s[r--] = temp;*/
        }
    }

    /**
     * 功能描述:
     * <p>
     * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
     * <p>
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     *  
     * 示例:
     * 输入: s = "abcdefg", k = 2
     * 输出: "bacdfeg"
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-02 16:38:51
     */
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int start = 0; start < chars.length; start += 2 * k) {
            int l = start, r = Math.min(start + k - 1, chars.length - 1);
            while (l < r) {
                chars[l] ^= chars[r];
                chars[r] ^= chars[l];
                chars[l++] ^= chars[r--];
            }
        }
        return new String(chars);
    }

    /**
     * 功能描述:
     * <p>
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     * 示例：
     * s = "leetcode"
     * 返回 0
     * s = "loveleetcode"
     * 返回 2
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-02 17:02:56
     */
    public int firstUniqChar(String s) {
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }

    /**
     * 功能描述:
     * <p>
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * <p>
     * 示例 1:
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * <p>
     * 示例 2:
     * 输入: s = "rat", t = "car"
     * 输出: false
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-09-02 17:18:49
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
            chars[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0)
                return false;
        }
        return true;
    }


    public boolean repeatedSubstringPattern(String s) {
        return false;
    }

    /**
     * 功能描述:
     * <p>
     * repeatedSubstringPatternByMatch 的KMP 实现
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-26 11:11:13
     */
    public boolean repeatedSubstringPatternByKMP(String s) {
        String query = s + s;
        int n = query.length();
        int m = s.length();
        int[] fail = new int[m];
        Arrays.fill(fail, -1);
        for (int i = 1; i < m; i++) {
            int j = fail[i - 1];
            while (j != -1 && s.charAt(j + 1) != s.charAt(i)) {
                j = fail[j];
            }
            if (s.charAt(j + 1) == s.charAt(i))
                fail[i] = j + 1;
        }

        int match = -1;
        for (int i = 1; i < n - 1; i++) {
            while (match != -1 && s.charAt(match + 1) != query.charAt(i)) {
                match = fail[match];
            }
            if (s.charAt(match + 1) == query.charAt(i)) {
                match++;
                if (match == m - 1)
                    return true;
            }
        }

        return false;
    }

    /**
     * 功能描述:
     * <p>
     * repeatedSubstringPatternByMatch 说明，多次"移位和换行" 字符串，并使其与原始字符串匹配。
     * 例：abcabc
     * 移位一次：cabab
     * 移位两次：bcaba
     * 移位三次：abcab
     * 则说明n' 等于3，移位3次 与原始字符串匹配，即存在重复子串。
     * <p>
     * 基于改思想，可以创建一个新的字符串str = (s+s)，这就包含了所有移位的可能性。
     * 例：abcabc -> abcabcabcabc 包含了bca、cab、abc；
     * 就像一个滑动窗口，所以可以直接去除首尾元素，判断自否包含自身。
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-25 18:07:42
     */
    public boolean repeatedSubstringPatternBySearch(String s) {
        return (s + s).indexOf(s, 1) != s.length();

    }

    /**
     * 功能描述:
     * <p>
     * 如果一个长度为 n 的字符串 s 可以由它的一个长度为 n' 的子串 s' 重复多次构成，那么
     * n 一定是n' 的倍数；
     * s' 一定是s 的前缀及后缀；
     * 对于任意i ∈ [n',n)，有s[i] = s[i-n'] 成立。
     * 也就是说，s 中长度为n' 的前缀s'，并且在之后每个位置上的字符s[i] = s[i-n'] 相同。
     *
     * @param
     * @return
     * @auther ClownfishYang
     * created on 2020-08-25 18:01:31
     */
    public boolean repeatedSubstringPatternByMatch(String s) {
        int n = s.length();
        for (int i = 1; i <= n / 2; i++) {
            // n 一定是n' 的倍数
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; j++) {
                    // s[i] = s[i - n']
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match)
                    return true;
            }
        }
        return false;
    }


    /**
     * 功能描述:
     * <p>
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     * <p>
     * 示例 1:
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * <p>
     * 示例 2:
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     * <p>
     * 先获取needle 字符串的首(s)尾(e)字符，线性遍历haystack 字符串，索引(i)与首字符(s) 比较，
     * 若相等，则在索引(i) + needle 字符串的长度(len) 与尾字符(e)比较，若也相等，比较中间字符。
     *
     * @param haystack 字符串
     * @param needle   查询字符串
     * @return 首次出现位置
     * @auther ClownfishYang
     * created on 2020-08-11 18:30:56
     */
    public int headTailContains(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        char s = needle.charAt(0);
        int len = needle.length() - 1;
        char e = needle.charAt(len);
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == s) {
                if (i + len >= haystack.length()) {
                    return -1;
                }
                if (haystack.charAt(i + len) == e) {
                    boolean flag = true;
                    for (int j = 1; j < len; j++) {
                        if (haystack.charAt(i + j) != needle.charAt(j)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag)
                        return i;
                }
            }
        }
        return -1;
    }

    /**
     * 功能描述:
     * <p>
     * headTailContains 的另一种解法，不使用尾字符判断，直接根据needle 字符串长度线性遍历判断。
     *
     * @param haystack 字符串
     * @param needle   查询字符串
     * @return 首次出现位置
     * @auther ClownfishYang
     * created on 2020-08-12 09:47:37
     */
    public int linearContains(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        int pn = 0, L = needle.length(), n = haystack.length();
        int len = n - L + 1;
        char c = needle.charAt(0);
        while (pn < len) {
            // first idx
            while (pn < len && haystack.charAt(pn) != c) pn++;

            int currLen = 0, idx = 0;
            while (idx < L && pn < n && haystack.charAt(pn) == needle.charAt(idx)) {
                pn++;
                idx++;
                currLen++;
            }

            if (currLen == L) return pn - currLen;
            pn = pn - currLen + 1;
        }
        return -1;
    }


    /**
     * 功能描述:
     * <p>
     * rabin karp 算法查询字符串，生成窗口内子串的hash，然后跟needle 的hash 比较。
     * 需要在常数时间内生成子串的hash，就需要使用滚动hash。
     * <p>
     * 即abcd 整数数组形式就是 [0, 1, 2, 3]，当窗口从 abcd 滑动到 bcde 时，
     * 整数形式数组从 [0, 1, 2, 3] 变成了 [1, 2, 3, 4]，数组最左边的 0 被移除，同时最右边新添了 4，
     * 滑动后数组的哈希值可以根据滑动前数组的哈希值来计算。
     *
     * @param haystack 字符串
     * @param needle   查询字符串
     * @return 首次出现位置
     * @auther ClownfishYang
     * created on 2020-08-12 13:44:22
     */
    public int rabinKarpContains(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        if (L > n) return -1;

        // base value for the rolling hash function
        int a = 26;
        // modulus value for the rolling hash function to avoid overflow
        long modulus = (long) Math.pow(2, 31);

        // compute the hash of strings haystack[:L], needle[:L]
        long h = 0, ref_h = 0;
        for (int i = 0; i < L; i++) {
            h = (h * a + hash(haystack.charAt(i))) % modulus;
            ref_h = (ref_h * a + hash(needle.charAt(i))) % modulus;
        }
        if (h == ref_h) return 0;

        // const value to be used often : a**L % modulus
        long aL = 1;
        for (int i = 1; i <= L; i++) aL = (aL * a) % modulus;

        for (int start = 1; start < n - L + 1; start++) {
            h = (h * a - hash(haystack.charAt(start - 1)) * aL
                    + hash(haystack.charAt(start + L - 1))) % modulus;
            if (h == ref_h) return start;
        }
        return -1;
    }


    public int hash(char c) {
        return c - 'a';
    }


    /**
     * 功能描述:
     * <p>
     * 使用KMP 算法进行字符串搜索
     *
     * @param haystack 字符串
     * @param needle   查询字符串
     * @return 首次出现位置
     * @auther ClownfishYang
     * created on 2020-08-12 15:12:47
     */
    public int kmpContains(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }

        KMP kmp = new KMP(needle);
        return kmp.search(haystack);
    }

    /**
     * 功能描述:
     * <p>
     * 使用sunday 算法进行字符串搜索
     *
     * @param haystack 字符串
     * @param needle   查询字符串
     * @return 首次出现位置
     * @auther ClownfishYang
     * created on 2020-08-12 18:27:51
     */
    public int sundayContains(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int L = needle.length(), n = haystack.length();
        // 移动位数
        int[] move = new int[256];
        for (int i = 0; i < 256; i++) {
            move[i] = L + 1;
        }
        for (int i = 0; i < L; i++) {
            move[needle.charAt(i)] = L - i;
        }
        int s = 0;
        while (s <= n - L) {
            int j = 0;
            while (j < L && haystack.charAt(s + j) == needle.charAt(j)) {
                j++;
            }
            if (j == L) return s;
            // 越界
            if (s + L >= n) break;
            // 移动
            s += move[haystack.charAt(s + L)];
        }
        return -1;
    }

}
