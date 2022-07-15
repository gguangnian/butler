package com.github.gguangnian.armtool.util;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.TypeVariable;

/**
 * @author gcz
 * @Date 2022/6/22
 */
public class ReflectUtil {

    /**
     * 设置方法为可访问（私有方法可以被外部调用）
     *
     * @param <T>              AccessibleObject的子类，比如Class、Method、Field等
     * @param accessibleObject 可设置访问权限的对象，比如Class、Method、Field等
     * @return 被设置可访问的对象
     */
    public static <T extends AccessibleObject> T setAccessible(T accessibleObject) {
        if (accessibleObject != null && accessibleObject.isAccessible() == false) {
            accessibleObject.setAccessible(true);
        }
        return accessibleObject;
    }
}
