package com.github.gguangnian.armtool.tree;

import com.github.gguangnian.armtool.test.Assert;
import com.github.gguangnian.armtool.tree.parser.DefaultNodeParser;
import com.github.gguangnian.armtool.tree.parser.NodeParser;
import com.github.gguangnian.armtool.util.CollUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 树工具类
 *
 * @author gcz
 * @Date 2022/6/24
 */
public class TreeUtil {
    /**
     * 树构建
     *
     * @param <E>    ID类型
     * @param list   源数据集合
     * @param rootId 最顶层父id值 一般为 0 之类
     * @return List
     */
    public static <E> List<Tree<E>> build(List<TreeNode<E>> list, E rootId) {
        return build(list, rootId, TreeNodeConfig.DEFAULT_CONFIG);
    }

    /**
     * 树构建
     *
     * @param <E>            ID类型
     * @param list           源数据集合
     * @param rootId         最顶层父id值 一般为 0 之类
     * @param treeNodeConfig 配置
     * @return List
     */
    public static <E> List<Tree<E>> build(List<TreeNode<E>> list, E rootId, TreeNodeConfig treeNodeConfig) {
        return build(list, rootId, treeNodeConfig, new DefaultNodeParser<E>());
    }

    /**
     * 树构建
     *
     * @param <T>            转换的实体 为数据源里的对象类型
     * @param <E>            ID类型
     * @param list           源数据集合
     * @param rootId         最顶层父id值 一般为 0 之类
     * @param treeNodeConfig 配置
     * @param nodeParser     转换器
     * @return List
     */
    public static <T, E> List<Tree<E>> build(List<T> list, E rootId, TreeNodeConfig treeNodeConfig, NodeParser<T, E> nodeParser) {
        if (CollUtil.isEmpty(list)) {
            return new ArrayList<Tree<E>>(0);
        }
        Assert.isNotNull(rootId);
        Assert.isNotNull(nodeParser);

        List<Tree<E>> treeList = new ArrayList<>(list.size());
        for (T obj : list
        ) {
            Tree<E> tree = new Tree<>(treeNodeConfig);
            nodeParser.parse(obj, tree);
            treeList.add(tree);
        }
        return new TreeBuild<E>(rootId, treeNodeConfig).recursiveBuilder(treeList);
    }
}
