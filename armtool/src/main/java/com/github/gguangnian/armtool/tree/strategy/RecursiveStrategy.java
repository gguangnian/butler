package com.github.gguangnian.armtool.tree.strategy;

import com.github.gguangnian.armtool.tree.Tree;
import com.github.gguangnian.armtool.util.ObjectUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 利用递归组装树结构
 *
 * @author gcz
 * @Date 2022/6/24
 */
public class RecursiveStrategy implements TreeStrategy {

    @Override
    public <T> List<Tree<T>> build(List<Tree<T>> treeList, T rootId, int maxDeep) {
        maxDeep = maxDeep == 0 ? Integer.MAX_VALUE : maxDeep;
        int deep = 0;
        List<Tree<T>> topNodeList = new ArrayList<>();
        for (Tree<T> node : treeList) {
            if (rootId.equals(node.getParentId())) {
                topNodeList.add(node);
                deep++;
                this.innerBuild(treeList, node, deep, maxDeep);
                deep--;
            }
        }
        //顶部列表排序
        Collections.sort(topNodeList);
        return topNodeList;
    }

    private <T> void innerBuild(List<Tree<T>> treeList, Tree<T> parentNode, int deep, int maxDeep) {
        if (deep >= maxDeep) {
            return;
        }
        for (Tree<T> node : treeList) {
            if (parentNode.getId().equals(node.getParentId())) {
                List<Tree<T>> children = parentNode.getChildren();
                if (ObjectUtil.isNull(children)) {
                    children = new ArrayList<>();
                    parentNode.setChildren(children);
                }
                node.setParent(parentNode);
                children.add(node);
                Collections.sort(children);
                deep++;
                this.innerBuild(treeList, node, deep, maxDeep);
                deep--;
            }
        }
    }
}
