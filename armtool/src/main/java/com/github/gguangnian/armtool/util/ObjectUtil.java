package com.github.gguangnian.armtool.util;

/**
 * 对象工具类，包括判空
 *
 * @author gcz
 * @Date 2022/6/22
 */
public class ObjectUtil {

    /**
     * 检查对象是否为null<br>
     * 判断标准为：
     *
     * <pre>
     * 1. == null
     * 2. equals(null)
     * </pre>
     *
     * @param obj 对象
     * @return 是否为null
     */
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    /**
     * 检查对象是否不为null
     *
     * @param obj 对象
     * @return 是否为null
     */
    public static boolean isNotNull(Object obj) {
        return obj != null;
    }
}
