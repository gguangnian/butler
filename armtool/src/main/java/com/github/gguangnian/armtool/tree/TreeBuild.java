package com.github.gguangnian.armtool.tree;

import com.github.gguangnian.armtool.test.Assert;
import com.github.gguangnian.armtool.tree.strategy.RecursiveStrategy;
import com.github.gguangnian.armtool.tree.strategy.TreeStrategy;
import com.github.gguangnian.armtool.util.ObjectUtil;

import java.util.ArrayList;
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

    private static final List<TreeStrategy> defaultStrategy;

    static {
        defaultStrategy = new ArrayList<>(1);
        defaultStrategy.add(new RecursiveStrategy());
    }

    TreeBuild(T rootId, TreeNodeConfig treeNodeConfig) {
        Assert.isNotNull(rootId);
        this.rootId = rootId;
        this.treeNodeConfig = ObjectUtil.defaultIfNull(treeNodeConfig, TreeNodeConfig.DEFAULT_CONFIG);
    }
}
