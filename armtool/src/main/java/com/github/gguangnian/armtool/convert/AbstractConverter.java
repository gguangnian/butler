package com.github.gguangnian.armtool.convert;

/**
 * 抽象的转换类，封装了一些常用方法。
 *
 * @param <T> 目标类型
 * @author gcz
 * @Date 2022/7/15
 */
public abstract class AbstractConverter<T> implements Converter<T> {

    @Override
    public T convert(Object value, T defaultValue) throws IllegalArgumentException {
        return null;
    }

    /**
     * 内部转换器，被 {@link AbstractConverter#convert(Object, Object)} 调用，实现基本转换逻辑<br>
     * 内部转换器转换后如果转换失败可以做如下操作，处理结果都为返回默认值：
     *
     * <pre>
     * 1、返回{@code null}
     * 2、抛出一个{@link RuntimeException}异常
     * </pre>
     *
     * @param value 值
     * @return 转换后的类型
     */
    protected abstract T convertInternal(Object value);
}
