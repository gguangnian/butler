package com.github.gguangnian.armtool.tree;

import com.github.gguangnian.armtool.util.HashUtil;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/**
 * 实体数据的标准结构，但不是必须的。 每个属性都可以在{@link TreeNodeConfig}中被重命名<br>
 * 在你的项目里它可以是部门实体、地区实体等任意类树节点实体
 * 类树节点实体: 包含key，父Key.不限于这些属性的可以构造成一颗树的实体对象
 *
 * @param <T> ID类型
 * @author gcz
 * @Date 2022/6/23
 */
public class TreeNode<T> implements Serializable {

    /**
     * ID
     */
    private T id;

    /**
     * 父节点ID
     */
    private T parentId;

    /**
     * 名称
     */
    private CharSequence name;

    /**
     * 顺序 越小优先级越高 默认0
     */
    private Comparable<?> weight = 0;

    /**
     * 扩展字段
     */
    private Map<String, Object> extra;

    /**
     * 空构造
     */
    public TreeNode() {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TreeNode) {
            return Objects.equals(id, ((TreeNode) obj).getId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public T getId() {
        return id;
    }

    public TreeNode<T> setId(T id) {
        this.id = id;
        return this;
    }

    public T getParentId() {
        return parentId;
    }

    public TreeNode<T> setParentId(T parentId) {
        this.parentId = parentId;
        return this;
    }

    public CharSequence getName() {
        return name;
    }

    public TreeNode<T> setName(CharSequence name) {
        this.name = name;
        return this;
    }

    public Comparable<?> getWeight() {
        return weight;
    }

    public TreeNode<T> setWeight(Comparable<?> weight) {
        this.weight = weight;
        return this;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public TreeNode<T> setExtra(Map<String, Object> extra) {
        this.extra = extra;
        return this;
    }
}
