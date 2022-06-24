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

    @Test
    public void defaultIfNull() {
        Assert.assertNotNull(ObjectUtil.defaultIfNull(null, new Object()));
        Assert.assertNotNull(ObjectUtil.defaultIfNull(new Object(), null));
        Assert.assertNull(ObjectUtil.defaultIfNull(null, null));
    }
}