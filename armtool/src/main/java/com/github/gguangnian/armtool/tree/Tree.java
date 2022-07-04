package com.github.gguangnian.armtool.tree;

import com.github.gguangnian.armtool.util.ObjectUtil;

import java.io.Serializable;
import java.util.*;

/**
 * 树形结构的节点实体
 * 通过转换器将你的实体转化为 Tree 节点实体 属性都存在此处,Tree可支持排序
 *
 * @param <T> ID类型
 * @author gcz
 * @Date 2022/6/23
 */
public class Tree<T> implements Map<String, Object>, Comparable<Tree<T>>, Serializable {
    private final Map<String, Object> data;

    private final TreeNodeConfig treeNodeConfig;

    /**
     * 父节点
     */
    private Tree<T> parent;

    public Tree() {
        this(null);
    }

    public Tree(TreeNodeConfig treeNodeConfig) {
        this.treeNodeConfig = ObjectUtil.defaultIfNull(treeNodeConfig, TreeNodeConfig.DEFAULT_CONFIG);
        this.data = new HashMap<>();
    }

    /**
     * 获取ID
     *
     * @return ID
     */
    public T getId() {
        return (T) data.get(treeNodeConfig.getIdKey());
    }

    /**
     * 设置ID
     *
     * @param id ID
     * @return this
     */
    public Tree<T> setId(T id) {
        data.put(treeNodeConfig.getIdKey(), id);
        return this;
    }

    /**
     * 获取父节点ID
     *
     * @return 父节点ID
     */
    public T getParentId() {
        return (T) data.get(treeNodeConfig.getParentIdKey());
    }

    /**
     * 设置父节点ID
     *
     * @param parentId 父节点ID
     * @return this
     */
    public Tree<T> setParentId(T parentId) {
        data.put(treeNodeConfig.getParentIdKey(), parentId);
        return this;
    }


    public Tree<T> getParent() {
        return parent;
    }

    public Tree<T> setParent(Tree<T> parent) {
        this.parent = parent;
        return this;
    }

    /**
     * 获取节点标签名称
     *
     * @return 节点标签名称
     */
    public CharSequence getName() {
        return (CharSequence) data.get(treeNodeConfig.getNameKey());
    }

    /**
     * 设置节点标签名称
     *
     * @param name 节点标签名称
     * @return this
     */
    public Tree<T> setName(CharSequence name) {
        data.put(treeNodeConfig.getNameKey(), name);
        return this;
    }

    /**
     * 获取权重
     *
     * @return 权重
     */
    public Comparable<?> getWeight() {
        return (Comparable<?>) data.get(treeNodeConfig.getWeightKey());
    }

    /**
     * 设置权重
     *
     * @param weight 权重
     * @return this
     */
    public Tree<T> setWeight(Comparable<?> weight) {
        data.put(treeNodeConfig.getWeightKey(), weight);
        return this;
    }

    /**
     * 获取所有子节点
     *
     * @return 所有子节点，可能为null
     */
    public List<Tree<T>> getChildren() {
        return (List<Tree<T>>) this.get(treeNodeConfig.getChildrenKey());
    }

    /**
     * 设置所有子节点
     *
     * @param children 所有子节点，会覆盖原有数据
     * @return
     */
    public Tree<T> setChildren(List<Tree<T>> children) {
        data.put(treeNodeConfig.getChildrenKey(), children);
        return this;
    }

    /**
     * 添加字节点
     *
     * @param childrenTree {@link Tree}
     * @return
     */
    public Tree<T> addChildren(Tree<T> childrenTree) {
        List<Tree<T>> children = null;
        if (ObjectUtil.isNull(this.get(treeNodeConfig.getChildrenKey()))) {
            data.put(treeNodeConfig.getChildrenKey(), new ArrayList());
        }
        this.getChildren().add(childrenTree);
        return this;
    }

    /**
     * 扩展属性
     *
     * @param key   键
     * @param value 扩展值
     */
    public void putExtra(String key, Object value) {
        data.put(key, value);
    }


    @Override
    @SuppressWarnings("rawtypes")
    public int compareTo(Tree<T> o) {
        Comparable weight = this.getWeight();
        if (ObjectUtil.isNotNull(weight)) {
            return weight.compareTo(o.getWeight());
        }
        return 0;
    }

    @Override
    @SuppressWarnings("rawtypes")
    public boolean equals(Object obj) {
        if (obj instanceof Tree) {
            return Objects.equals(this.getId(), ((Tree) obj).getId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }

    //聚合---------------------------------------------------------------------------------------------------------------

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return data.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return data.containsValue(value);
    }

    @Override
    public Object get(Object key) {
        return data.get(key);
    }

    @Override
    public Object put(String key, Object value) {
        return data.put(key, value);
    }

    @Override
    public Object remove(Object key) {
        return data.remove(key);
    }

    @Override
    public void putAll(Map<? extends String, ?> m) {
        data.putAll(m);
    }

    @Override
    public void clear() {
        data.clear();
    }

    @Override
    public Set<String> keySet() {
        return data.keySet();
    }

    @Override
    public Collection<Object> values() {
        return data.values();
    }

    @Override
    public Set<Entry<String, Object>> entrySet() {
        return data.entrySet();
    }

}
