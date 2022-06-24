package com.github.gguangnian.armtool.tree;

import com.github.gguangnian.armtool.tree.parser.NodeParser;

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
     * @param <T>            转换的实体 为数据源里的对象类型
     * @param <E>            ID类型
     * @param list           源数据集合
     * @param rootId         最顶层父id值 一般为 0 之类
     * @param treeNodeConfig 配置
     * @param nodeParser     转换器
     * @return List
     */
    public static <T, E> List<Tree<E>> build(List<T> list, E rootId, TreeNodeConfig treeNodeConfig, NodeParser<T, E> nodeParser) {
        return null;
    }
}
