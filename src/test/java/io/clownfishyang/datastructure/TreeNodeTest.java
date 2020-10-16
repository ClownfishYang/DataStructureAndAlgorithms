package io.clownfishyang.datastructure;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import static org.junit.Assert.*;

/**
 * Copyright (C), 2015-2020, 深圳市环球易购电子商务有限公司<br>
 * $END$<br>
 *
 * @author ClownfishYang<br>
 * created on 2020/8/21 11:35<br>
 */
public class TreeNodeTest {

    @Test
    public void buildTest() {
        Integer[] nums = {3,9,20,null,null,15,7};
        TreeNode build = TreeNode.build(nums);
        System.out.println(build);

    }
}