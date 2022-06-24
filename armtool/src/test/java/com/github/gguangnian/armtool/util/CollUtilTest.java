package com.github.gguangnian.armtool.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class CollUtilTest {

    @Test
    public void isEmpty() {
        Assert.assertTrue(CollUtil.isEmpty(null));
        Assert.assertTrue(CollUtil.isEmpty(new ArrayList<>(0)));
    }

    @Test
    public void isNotEmpty() {
        ArrayList<Object> objects = new ArrayList<>(0);
        objects.add(new Object());
        Assert.assertTrue(CollUtil.isNotEmpty(objects));
        Assert.assertFalse(CollUtil.isNotEmpty(null));
        Assert.assertFalse(CollUtil.isNotEmpty(new ArrayList<>(0)));
    }
}