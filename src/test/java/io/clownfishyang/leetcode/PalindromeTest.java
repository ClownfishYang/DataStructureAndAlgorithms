package io.clownfishyang.leetcode;

import io.clownfishyang.datastructure.ListNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * $END$<br>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/11 10:24<br>
 */
public class PalindromeTest {

    @Test
    public void headTailCheckTest() {
        Palindrome palindrome = new Palindrome();
        Assert.assertTrue(palindrome.headTailCheck(0));
        Assert.assertTrue(palindrome.headTailCheck(1021201));
    }

    @Test
    public void halfNumberCheckTest() {
        Palindrome palindrome = new Palindrome();
        Assert.assertTrue(palindrome.halfNumberCheck(0));
        Assert.assertTrue(palindrome.halfNumberCheck(1021201));
    }

    @Test
    public void headTailCheckStrTest() {
        Palindrome palindrome = new Palindrome();
        Assert.assertTrue(palindrome.headTailCheck(""));
        Assert.assertTrue(palindrome.headTailCheck("A man, a plan, a canal: Panama"));
        Assert.assertFalse(palindrome.headTailCheck("race a car"));
    }

    @Test
    public void isListNodeTest() {
        Palindrome palindrome = new Palindrome();
//        System.out.println(palindrome.is(ListNode.build(1, 2, 2, 1)));
//        System.out.println(palindrome.is(ListNode.build(1, 2, 2)));
        System.out.println(palindrome.is(ListNode.build(1, 2)));
    }

    @Test
    public void longestPalindromeTest() {
        Palindrome palindrome = new Palindrome();
        String str;
//        Assert.assertEquals(palindrome.longestPalindrome(""), "");
//        Assert.assertEquals(palindrome.longestPalindrome("a"), "a");
//        Assert.assertEquals(palindrome.longestPalindrome("ac"), "c");
        Assert.assertEquals(palindrome.longestPalindrome("abcda"), "a");
        Assert.assertEquals(palindrome.longestPalindrome("babad"), "bab");
        Assert.assertEquals(palindrome.longestPalindrome("cbbd"), "bb");
        Assert.assertEquals(palindrome.longestPalindrome("aaaaaaaaa"), "aaaaaaaaa");
        Assert.assertEquals(palindrome.longestPalindrome("aaaabbaaaa"), "aaaabbaaaa");
        Assert.assertEquals(palindrome.longestPalindrome("baaaabaaaad"), "aaaabaaaa");
    }
}