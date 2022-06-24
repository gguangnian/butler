package com.github.gguangnian.armtool.util;

/**
 * Hash算法<br>
 *
 * @author gcz
 * @Date 2022/6/24
 */
public class HashUtil {
    /**
     * BKDR算法<br>
     * 最好的字符串hash算法<br>
     * {@link java.util.Objects#hash(Object...)}使用了同样的算法
     *
     * @param str 字符串
     * @return hash值
     */
    public static int bkdrHash(String str) {
        // 31 131 1313 13131 131313 etc..
        int seed = 131;
        int hash = 0;

        for (int i = 0; i < str.length(); i++) {
            hash = (hash * seed) + str.charAt(i);
        }

        return hash & 0x7FFFFFFF;
    }
}
