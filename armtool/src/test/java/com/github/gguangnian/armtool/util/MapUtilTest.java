package com.github.gguangnian.armtool.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class MapUtilTest {

    @Test
    public void isEmpty() {
        Assert.assertTrue(MapUtil.isEmpty(null));
        Assert.assertTrue(MapUtil.isEmpty(new HashMap<>()));
    }

    @Test
    public void isNotEmpty() {
        Assert.assertFalse(MapUtil.isNotEmpty(null));
        HashMap<Object, Object> map = new HashMap<>();
        Assert.assertFalse(MapUtil.isNotEmpty(map));
        map.put("object", new Object());
        Assert.assertTrue(MapUtil.isNotEmpty(map));
    }
}