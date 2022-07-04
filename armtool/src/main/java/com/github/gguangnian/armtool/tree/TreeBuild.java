package com.github.gguangnian.armtool.tree;

import com.github.gguangnian.armtool.tree.strategy.RecursiveStrategy;
import com.github.gguangnian.armtool.tree.strategy.TreeBuildStrategy;

import java.util.List;

/**
 * 树构建器
 *
 * @param <T> ID类型
 * @author gcz
 * @Date 2022/6/24
 */
class TreeBuild<T> {

    private final T rootId;

    private final TreeNodeConfig treeNodeConfig;


    TreeBuild(T rootId, TreeNodeConfig treeNodeConfig) {
        this.rootId = rootId;
        this.treeNodeConfig = treeNodeConfig;
    }

    /**
     * 根据递归构建策略构建 树
     *
     * @param treeList
     * @param rootId
     * @param strategy
     * @return
     */
    List<Tree<T>> recursiveBuilder(List<Tree<T>> treeList, T rootId, TreeBuildStrategy strategy) {
        return this.buildByStrategy(treeList, rootId, new RecursiveStrategy(treeNodeConfig));
    }

    /**
     * 根据构建策略构建 树
     *
     * @param treeList
     * @param rootId
     * @param strategy
     * @return
     */
    List<Tree<T>> buildByStrategy(List<Tree<T>> treeList, T rootId, TreeBuildStrategy strategy) {
        return strategy.build(treeList, rootId);
    }
}
