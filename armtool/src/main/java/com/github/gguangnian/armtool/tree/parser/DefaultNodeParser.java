package com.github.gguangnian.armtool.tree.parser;

import com.github.gguangnian.armtool.tree.Tree;
import com.github.gguangnian.armtool.tree.TreeNode;
import com.github.gguangnian.armtool.util.MapUtil;

import java.util.Map;

/**
 * 默认的简单转换器
 *
 * @author gcz
 * @Date 2022/6/23
 */
public class DefaultNodeParser<T> implements NodeParser<TreeNode<T>, T> {

    @Override
    public void parse(TreeNode<T> persistent, Tree<T> tree) {
        tree.setId(persistent.getId());
        tree.setParentId(persistent.getParentId());
        tree.setWeight(persistent.getWeight());
        tree.setName(persistent.getName());

        //扩展字段
        final Map<String, Object> extra = persistent.getExtra();
        if (MapUtil.isNotEmpty(extra)) {
            extra.forEach(tree::putExtra);
        }
    }
}
