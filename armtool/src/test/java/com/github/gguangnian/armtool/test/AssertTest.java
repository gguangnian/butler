package com.github.gguangnian.armtool.test;

import org.junit.Test;

public class AssertTest {

    @Test
    public void isTrue() {
        Assert.isTrue(true);
    }

    @Test
    public void isFalse() {
        Assert.isFalse(false);
    }

    @Test
    public void isNull() {
        Assert.isNull(null);
    }

    @Test
    public void isNotNull() {
        Assert.isNotNull(new Object());
    }
}