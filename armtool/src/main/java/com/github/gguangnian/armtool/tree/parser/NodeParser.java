package com.github.gguangnian.armtool.tree.parser;

import com.github.gguangnian.armtool.tree.Tree;

/**
 * 树节点解析器,将{@link com.github.gguangnian.armtool.tree.TreeNode}或实体转换为Tree 可以参考{@link DefaultNodeParser}
 *
 * @param <T> 转换的实体 为数据源里的对象类型
 * @param <E> ID类型
 * @author gcz
 * @Date 2022/6/23
 */
public interface NodeParser<T, E> {

    /**
     * 源数据实体 转换为Tree
     *
     * @param persistent 源数据实体
     * @param treeNode   树节点实体
     */
    void parse(T persistent, Tree<E> treeNode);
}
