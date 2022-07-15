package com.github.gguangnian.armtool.binarytree;

/**
 * 二叉树
 *
 * @param <T> 元素
 * @author gcz
 * @Date 2022/7/15
 */
public interface BinaryTree<T extends Comparable<T>> {

    /**
     * 节点梳理
     *
     * @return
     */
    int size();

    /**
     * 是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 是否包含指定元素
     *
     * @param o
     * @return
     */
    boolean contains(T o);

    /**
     * 添加元素
     *
     * @param e
     * @return
     */
    boolean add(T e);

    /**
     * 移除元素
     *
     * @param o
     * @return
     */
    boolean remove(T o);

    /**
     * 清空数
     */
    void clear();

    /**
     * 重写equals方法
     *
     * @param o
     * @return
     */
    @Override
    boolean equals(Object o);

    /**
     * 重写hashcode方法
     *
     * @return
     */
    @Override
    int hashCode();
}
