package io.clownfishyang.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * $END$<br>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/11 18:30<br>
 */
public class StrStrTest {

    @Test
    public void headTailContainsTest() {
        StrStr strStr = new StrStr();
        Assert.assertEquals(strStr.headTailContains("hello", "he"), 0);
        Assert.assertEquals(strStr.headTailContains("hello", "ll"), 2);
        Assert.assertEquals(strStr.headTailContains("hello", "h"), 0);
        Assert.assertEquals(strStr.headTailContains("hello", "o"), 4);
        Assert.assertEquals(strStr.headTailContains("hello", "lo"), 3);
        Assert.assertEquals(strStr.headTailContains("aaaaa", "bba"), -1);
        Assert.assertEquals(strStr.headTailContains("aaaaa", ""), 0);
        Assert.assertEquals(strStr.headTailContains("mississippi", "a"), -1);
        Assert.assertEquals(strStr.headTailContains("mississippi", "issip"), 4);
    }

    @Test
    public void containsTest() {
        StrStr strStr = new StrStr();
        Assert.assertEquals(strStr.linearContains("hello", "he"), 0);
        Assert.assertEquals(strStr.linearContains("hello", "ll"), 2);
        Assert.assertEquals(strStr.linearContains("hello", "lo"), 3);
        Assert.assertEquals(strStr.linearContains("aaaaa", "bba"), -1);
        Assert.assertEquals(strStr.linearContains("aaaaa", ""), 0);
        Assert.assertEquals(strStr.linearContains("mississippi", "a"), -1);
        Assert.assertEquals(strStr.linearContains("mississippi", "issip"), 4);
    }

    @Test
    public void rabinKarpContainsTest() {
        StrStr strStr = new StrStr();
        Assert.assertEquals(strStr.rabinKarpContains("hello", "he"), 0);
        Assert.assertEquals(strStr.rabinKarpContains("hello", "ll"), 2);
        Assert.assertEquals(strStr.rabinKarpContains("hello", "lo"), 3);
        Assert.assertEquals(strStr.rabinKarpContains("aaaaa", "bba"), -1);
        Assert.assertEquals(strStr.rabinKarpContains("aaaaa", ""), 0);
        Assert.assertEquals(strStr.rabinKarpContains("mississippi", "a"), -1);
        Assert.assertEquals(strStr.rabinKarpContains("mississippi", "issip"), 4);
    }

    @Test
    public void kmpContainsTest() {
        StrStr strStr = new StrStr();
        Assert.assertEquals(strStr.kmpContains("cabaababac", "aab"), -1);
        Assert.assertEquals(strStr.kmpContains("aaacaaab", "aaab"), 4);
        Assert.assertEquals(strStr.kmpContains("aaaaaaab", "aaab"), 4);
        Assert.assertEquals(strStr.kmpContains("hello", "he"), 0);
        Assert.assertEquals(strStr.kmpContains("hello", "ll"), 2);
        Assert.assertEquals(strStr.kmpContains("hello", "lo"), 3);
        Assert.assertEquals(strStr.kmpContains("aaaaa", "bba"), -1);
        Assert.assertEquals(strStr.kmpContains("aaaaa", ""), 0);
        Assert.assertEquals(strStr.kmpContains("mississippi", "a"), -1);
        Assert.assertEquals(strStr.kmpContains("mississippi", "issip"), 4);
    }

    @Test
    public void sundayContainsTest() {
        StrStr strStr = new StrStr();
        Assert.assertEquals(strStr.sundayContains("cabaababac", "aab"), 3);
        Assert.assertEquals(strStr.sundayContains("aaacaaab", "aaab"), 4);
        Assert.assertEquals(strStr.sundayContains("aaaaaaab", "aaab"), 4);
        Assert.assertEquals(strStr.sundayContains("hello", "he"), 0);
        Assert.assertEquals(strStr.sundayContains("hello", "ll"), 2);
        Assert.assertEquals(strStr.sundayContains("hello", "lo"), 3);
        Assert.assertEquals(strStr.sundayContains("aaaaa", "bba"), -1);
        Assert.assertEquals(strStr.sundayContains("aaaaa", ""), 0);
        Assert.assertEquals(strStr.sundayContains("mississippi", "a"), -1);
        Assert.assertEquals(strStr.sundayContains("mississippi", "issip"), 4);
    }

    @Test
    public void repeatedSubstringPatternTest() {

        String s = "ababa";
        System.out.println((s + s).indexOf(s, 1) != s.length());

//        StrStr strStr = new StrStr();
//        System.out.println(strStr.repeatedSubstringPattern("ababab"));
//        System.out.println(strStr.repeatedSubstringPattern("abababc"));
//        System.out.println(strStr.repeatedSubstringPattern("abababb"));
//        System.out.println(strStr.repeatedSubstringPattern("abababab"));
//        System.out.println(strStr.repeatedSubstringPattern("babababa"));
//        System.out.println(strStr.repeatedSubstringPattern("babababab"));
    }

    @Test
    public void repeatedSubstringPatternByKMPTest() {
        StrStr strStr = new StrStr();
        strStr.repeatedSubstringPatternByKMP("abcabc");
    }

    @Test
    public void reverseStringTest() {
        StrStr strStr = new StrStr();

        String str = "hello";
        char[] s = str.toCharArray();
        strStr.reverseString(s);
        Assert.assertEquals(new String(s), "olleh");
    }

    @Test
    public void reverseStrTest() {
        StrStr strStr = new StrStr();

        String str = "abcdefg";
        Assert.assertEquals(strStr.reverseStr(str, 2), "bacdfeg");
    }

    @Test
    public void firstUniqCharTest() {
        StrStr strStr = new StrStr();
        int idx = strStr.firstUniqChar("leetcode");
        Assert.assertEquals(idx, 0);
        idx = strStr.firstUniqChar("loveleetcode");
        Assert.assertEquals(idx, 2);
    }

    @Test
    public void isAnagramTest() {
        StrStr strStr = new StrStr();
        Assert.assertTrue(strStr.isAnagram("anagram", "nagaram"));
        Assert.assertFalse(strStr.isAnagram("rat", "car"));
        Assert.assertFalse(strStr.isAnagram("b", "ab"));
    }

    @Test
    public void atoiTest() {
        StrStr strStr = new StrStr();
//        Assert.assertEquals(strStr.atoi( ""), 0);
//        Assert.assertEquals(strStr.atoi( " "), 0);
//        Assert.assertEquals(strStr.atoi( "42"), 42);
//        Assert.assertEquals(strStr.atoi( "+42"), 42);
//        Assert.assertEquals(strStr.atoi("a afds 42 sadfsa f"), 0);
//        Assert.assertEquals(strStr.atoi("  -42 "), -42);
//        Assert.assertEquals(strStr.atoi("  -4 2 "), -4);
//        Assert.assertEquals(strStr.atoi("4193 with words"), 4193);
        Assert.assertEquals(strStr.atoi("-91283472332"), -2147483648);
    }

    @Test
    public void groupAnagramsTest() {
        StrStr strStr = new StrStr();
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat","aabbcc","abcabc","abc","aabbc"};
        List<List<String>> lists = strStr.groupAnagrams(strs);
        System.out.println(lists);
    }

    @Test
    public void lengthOfLongestSubstringTest() {
        StrStr strStr = new StrStr();
        System.out.println(strStr.lengthOfLongestSubstring(""));
        System.out.println(strStr.lengthOfLongestSubstring(" "));
        System.out.println(strStr.lengthOfLongestSubstring("aab"));
        System.out.println(strStr.lengthOfLongestSubstring("dvdf"));
        System.out.println(strStr.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(strStr.lengthOfLongestSubstring("bbbbb"));
        System.out.println(strStr.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    public void letterCombinationsTest() {
        StrStr strStr = new StrStr();
        List<String> res = strStr.letterCombinations("23");
        System.out.println(res);
    }
}