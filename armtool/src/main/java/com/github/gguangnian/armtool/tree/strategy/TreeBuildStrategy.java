package com.github.gguangnian.armtool.tree.strategy;

import com.github.gguangnian.armtool.tree.Tree;

import java.util.List;

/**
 * 组装树的策略模式
 *
 * @param <T> ID类型
 * @author gcz
 * @Date 2022/6/24
 */
public interface TreeBuildStrategy<T> {

    /**
     * 将 {@link Tree} 集合 组装成 树形结构
     *
     * @param treeList 节点集合
     * @param rootId   父节点
     * @param <T>      id
     * @return 树形结构
     */
    <T> List<Tree<T>> build(List<Tree<T>> treeList, T rootId);
}
