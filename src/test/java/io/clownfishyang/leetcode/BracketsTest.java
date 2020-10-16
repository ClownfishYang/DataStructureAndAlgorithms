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
 * created on 2020/8/11 15:17<br>
 */
public class BracketsTest {

    @Test
    public void stackCheckTest() {
        Brackets brackets = new Brackets();
        Assert.assertTrue(brackets.stackCheck("()"));
        Assert.assertTrue(brackets.stackCheck("()[]{}"));
        Assert.assertFalse(brackets.stackCheck("(]"));
        Assert.assertFalse(brackets.stackCheck("([)]"));
        Assert.assertTrue(brackets.stackCheck("{[]}"));
    }

    @Test
    public void replaceCheckTest() {
        Brackets brackets = new Brackets();
        Assert.assertTrue(brackets.replaceCheck("()"));
        Assert.assertTrue(brackets.replaceCheck("()[]{}"));
        Assert.assertFalse(brackets.replaceCheck("(]"));
        Assert.assertFalse(brackets.replaceCheck("([)]"));
        Assert.assertTrue(brackets.replaceCheck("{[]}"));
    }

    @Test
    public void generateParenthesisTest() {
        Brackets brackets = new Brackets();
        List<String> res =null;
//        res = brackets.generateParenthesis(0);
//        System.out.println(res);
//        res = brackets.generateParenthesis(1);
//        System.out.println(res);
//        res = brackets.generateParenthesis(2);
//        System.out.println(res);
//        res = brackets.generateParenthesis(3);
//        System.out.println(res);
        res = brackets.generateParenthesis(4);
        System.out.println(res);
    }
}