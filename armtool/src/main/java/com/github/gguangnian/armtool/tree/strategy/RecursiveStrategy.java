package com.github.gguangnian.armtool.tree.strategy;

import com.github.gguangnian.armtool.tree.Tree;
import com.github.gguangnian.armtool.tree.TreeNodeConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * 利用递归组装树结构
 *
 * @param <T> ID类型
 * @author gcz
 * @Date 2022/6/24
 */
public class RecursiveStrategy<T> implements TreeBuildStrategy<T> {

    private final TreeNodeConfig config;

    public RecursiveStrategy(TreeNodeConfig config) {
        this.config = config;
    }

    @Override
    public <T> List<Tree<T>> build(List<Tree<T>> trees, T rootId) {
        List<Tree<T>> parentTree = new ArrayList();
        for (Tree<T> tree : trees
        ) {
            if (tree.getId().equals(rootId)) {
                parentTree.add(tree);
                this.innerBuild(trees, tree);
            }
        }
        return parentTree;
    }

    private <T> void innerBuild(List<Tree<T>> trees, Tree<T> parentTree) {
        for (Tree<T> tree : trees
        ) {
            if (parentTree.getId().equals(tree.getId())) {
                tree.setParent(parentTree);
                parentTree.addChildren(tree);
                this.innerBuild(trees, tree);
            }
        }
    }
}
