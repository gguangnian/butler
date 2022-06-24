package com.github.gguangnian.armtool.util;

import java.util.Map;

/**
 * Map相关工具类
 *
 * @author gcz
 * @Date 2022/6/24
 */
public class MapUtil {
    /**
     * Map是否为空
     *
     * @param map 集合
     * @return 是否为空
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    /**
     * Map是否为非空
     *
     * @param map 集合
     * @return 是否为非空
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return isEmpty(map) == false;
    }
}
