package com.github.gguangnian.armtool.binarytree;

import org.w3c.dom.Node;

/**
 * 二叉树常用方法 也是普通二叉树
 *
 * @author gcz
 * @Date 2022/7/15
 */
public abstract class AbstractBinaryTree<T extends Comparable<T>> implements BinaryTree<T> {

    private int size;

    private Node<T> root;

    public interface Node<T> {

        T getVal();
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root==null;
    }

    @Override
    public boolean contains(T o) {
        return false;
    }

    @Override
    public boolean add(T e) {
        if (e == null) {
            throw new NullPointerException();
        }
        if (isEmpty()) {
            root = new TreeNode(e, null);
        }else {
            Node<T> parent = root;
            do {
                e.compareTo(parent.getVal());
            } while (parent != null);
        }
        return false;
    }

    @Override
    public boolean remove(T o) {
        return false;
    }

    @Override
    public void clear() {
        root = null;
    }

    /**
     * 节点
     *
     * @param <T>
     */
    private static class TreeNode<T> implements Node<T> {
        T value;
        TreeNode parent;
        TreeNode left;
        TreeNode right;

        public TreeNode(T value, TreeNode parent) {
            this.value = value;
            this.parent = parent;
        }

        @Override
        public T getVal() {
            return value;
        }
    }

}
