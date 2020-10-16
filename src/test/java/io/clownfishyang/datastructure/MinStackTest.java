package io.clownfishyang.datastructure;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * $END$<br>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/24 16:38<br>
 */
public class MinStackTest {


    @Test
    public void getMinTest() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        Assert.assertEquals(minStack.getMin(), -2);
        Assert.assertEquals(minStack.top(), -1);
        minStack.pop();
        Assert.assertEquals(minStack.getMin(), -2);
    }
}