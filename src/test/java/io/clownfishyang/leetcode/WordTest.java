package io.clownfishyang.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * $END$<br>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/12 18:34<br>
 */
public class WordTest {

    @Test
    public void lengthOfLastWordTest() {
        Word word = new Word();
        Assert.assertEquals(word.lengthOfLastWord("Hello World"), 5);
        Assert.assertEquals(word.lengthOfLastWord("Hello World  "), 5);
        Assert.assertEquals(word.lengthOfLastWord("World  "), 5);
        Assert.assertEquals(word.lengthOfLastWord(" World  "), 5);
    }
}