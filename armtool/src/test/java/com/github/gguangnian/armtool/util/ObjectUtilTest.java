package com.github.gguangnian.armtool.util;

import org.junit.Assert;
import org.junit.Test;

public class ObjectUtilTest {

    @Test
    public void isNull() {
        Assert.assertTrue(ObjectUtil.isNull(null));
        Assert.assertFalse(ObjectUtil.isNull(new Object()));
    }

    @Test
    public void isNotNull() {
        Assert.assertTrue(ObjectUtil.isNotNull(new Object()));
        Assert.assertFalse(ObjectUtil.isNotNull(null));
    }
}