package com.github.gguangnian.armtool.tree.strategy;

import com.github.gguangnian.armtool.tree.Tree;

import java.util.List;

/**
 * 组装树的策略模式
 *
 * @author gcz
 * @Date 2022/6/24
 */
public interface TreeStrategy {

    <T> List<Tree<T>> build(List<Tree<T>> treeList, T rootId, int maxDeep);
}
