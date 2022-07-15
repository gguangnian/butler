package com.github.gguangnian.armtool.binarytree;

import java.util.*;

/**
 * @author gcz
 * @Date 2022/3/25
 */
public class LinkedTree<E extends Comparable<E>> extends AbstractCollection<E> {

    private transient int size;

    private transient Node<E> root;

    @Override
    public boolean add(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        if (root == null) {
            root = new Node<>(e, null);
        } else {
            int comp;
            Node<E> tem;
            Node<E> parent = root;
            do {
                tem = parent;
                comp = parent.item.compareTo(e);
                if (comp > 0) {
                    parent = tem.left;
                } else if (comp < 0) {
                    parent = tem.right;
                } else {
                    tem.item = e;
                    return false;
                }
            } while (parent != null);
            Node<E> newNode = new Node<>(e, tem);
            if (comp > 0) {
                tem.left = newNode;
            } else {
                tem.right = newNode;
            }
            fixAfterInsertion(newNode);
        }
        size++;
        return true;
    }


    @Override
    public boolean remove(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (root == null) {
            return false;
        } else {
            int comp;
            Node<E> tem;
            Node<E> parent = root;
            do {
                tem = parent;
                comp = parent.item.compareTo((E) o);
                if (comp > 0) {
                    parent = tem.left;
                } else if (comp < 0) {
                    parent = tem.right;
                } else {
                    parent = null;
                }
            } while (parent != null);
            if (comp == 0) {
                fixAfterDeletion(tem);
                size--;
                return true;
            }
            return false;
        }
    }

    /**
     * 插入后修复
     *
     * @param e
     */
    private void fixAfterInsertion(Node<E> e) {
        Node<E> p = parentOf(e);
        Node<E> tem = e;
        if (leftOf(p) == tem && rightOf(p) != null) {
            p.balance++;
        } else if (rightOf(p) == tem && leftOf(p) != null) {
            p.balance--;
        } else {
            while (p != null) {
                if (leftOf(p) == tem) {
                    p.balance++;
                } else if (rightOf(p) == tem) {
                    p.balance--;
                }

                if (p.balance > 1) {
                    if (tem.balance < 0) {
                        this.rotateLeft(tem);
                    }
                    this.rotateRight(p);
                    break;
                } else if (p.balance < -1) {
                    if (tem.balance > 0) {
                        this.rotateRight(tem);
                    }
                    this.rotateLeft(p);
                    break;
                } else {
                    tem = p;
                    p = parentOf(p);
                }
            }
        }
    }

    /**
     * 删除后修改
     * <table>
     *     <tr>
     *         <th>p</th>
     *         <th>l </th>
     *     </tr>
     * </table>
     *
     * @param e
     */
    private void fixAfterDeletion(Node<E> e) {

    }

    /**
     * 左旋
     * <p>
     * 设 x,y为正整数 p.balance 为 ptem 且 ptem < 0 , r.balance 为 rtem</br>
     * p 的左高度为 x + ptem , 右高度为 x;</br>
     * r 的左高度为 y + rtem , 右高度为 y;</br>
     * </p>
     * -------------------------------------------------------------
     * <p>
     * 左旋转 r 的左树枝成为 p 的右树枝，p 成为 r 的左树枝</br>
     * p 的左高度为 x + ptem , 右高度为 y + rtem;</br>
     * r 的右高度为 y , 左高度为
     *     <ol>
     *         <li>如果 (x + ptem)>(y + rtem) 高度为 x + ptem +1</li>
     *         <li>如果 (x + ptem)<(y + rtem) 高度为 y + rtem +1</li>
     *         <li>如果 (x + ptem)==(y + rtem) 高度为 x + ptem +1 或 y + rtem +1</li>
     *     </ol>
     *     </br>
     * </p>
     * ---------------------------------------------------------------
     * <p>
     *     重新计算平衡因子</br>
     *     <ol>
     *         <li>如果 rtem >0 则 x - (y + rtem) = 1; p的平衡因子为 (x + ptem) - (y + rtem) = (ptem + 1)。如果 p 的平衡因子<0 则 l的平衡因子 为 (y + rtem +1) - y = (rtem + 1)</li>
     *         <li>如果 rtem >0 则 x - (y + rtem) = 1; p的平衡因子为 (x + ptem) - (y + rtem) = (ptem + 1)。如果 p 的平衡因子>0 则 l的平衡因子 为 (x + ptem +1) - y = (ptem + rtem + 2)</li>
     *         <li>如果 rtem <0 则 x - y = 1; p的平衡因子为 (x + ptem) - (y + rtem) = (ptem -rtem + 1)。如果 p 的平衡因子<0 则 l的平衡因子 为 (y + rtem +1) - y = (rtem + 1)</li>
     *         <li>如果 rtem <0 则 x - y = 1; p的平衡因子为 (x + ptem) - (y + rtem) = (ptem -rtem + 1)。如果 p 的平衡因子>0 则 l的平衡因子 为 (x + ptem +1) - y = (ptem + 2)</li>
     *     </ol>
     * </p>
     *
     * @param p
     */
    private void rotateLeft(Node<E> p) {
        Node<E> r = rightOf(p);

        int balanceOfP = p.balance;
        int balanceOfR = r.balance;

        p.right = r.left;
        r.left = p;

        r.parent = p.parent;
        p.parent = r;

        if (r.parent != null && r.parent.left == p) {
            r.parent.left = r;
        } else if (r.parent != null && r.parent.right == p) {
            r.parent.right = r;
        } else {
            this.root = r;
        }

        if (balanceOfR >= 0) {
            p.balance = balanceOfP + 1;
            if (p.balance <= 0) {
                r.balance = balanceOfR + 1;
            } else {
                r.balance = balanceOfP + balanceOfR + 2;
            }
        } else {
            p.balance = balanceOfP - balanceOfR + 1;
            if (p.balance <= 0) {
                r.balance = balanceOfR + 1;
            } else {
                r.balance = balanceOfP + 2;
            }
        }
    }

    /**
     * 右旋
     * <p>
     * 设 x,y为正整数 p.balance 为 ptem 且 ptem >0 , l.balance 为 ltem</br>
     * p 的左高度为 x + ptem , 右高度为 x;</br>
     * l 的左高度为 y + ltem , 右高度为 y;</br>
     * </p>
     * -------------------------------------------------------------
     * <p>
     * 右旋转 l 的右树枝成为 p 的左树枝，p 成为 l 的右树枝</br>
     * p 的左高度为 y , 右高度为 x;</br>
     * l 的左高度为 y + ltem , 右高度为
     *     <ol>
     *         <li>如果 x>y 高度为 x+1</li>
     *         <li>如果 x<y 高度为 y+1</li>
     *         <li>如果 x==y 高度为 x+1 或 y+1</li>
     *     </ol>
     *     </br>
     * </p>
     * ---------------------------------------------------------------
     * <p>
     *     重新计算平衡因子</br>
     *     <ol>
     *         <li>如果 ltem >0 则 (x + ptem) - (y + ltem) = 1; p的平衡因子为 (y-x) = (ptem - ltem -1)。如果 p 的平衡因子<0 则 l的平衡因子 为 (y + ltem) - (x+1) = (ptem - 2)</li>
     *         <li>如果 ltem >0 则 (x + ptem) - (y + ltem) = 1; p的平衡因子为 (y-x) = (ptem - ltem -1)。如果 p 的平衡因子>0 则 l的平衡因子 为 (y + ltem) - (y+1) = (ltem - 1)</li>
     *         <li>如果 ltem <0 则 (x + ptem) - y = 1; p的平衡因子为 (y-x) = (ptem-1)。如果 p 的平衡因子<0 则 l的平衡因子 为 (y + ltem) - (x+1) = (ptem + ltem -2)</li>
     *         <li>如果 ltem <0 则 (x + ptem) - y = 1; p的平衡因子为 (y-x) = (ptem-1)。如果 p 的平衡因子>0 则 l的平衡因子 为 (y + ltem) - (y+1) = (ltem - 1)</li>
     *     </ol>
     * </p>
     *
     * @param p
     */
    private void rotateRight(Node<E> p) {
        Node<E> l = p.left;
        int balanceOfP = p.balance;
        int balanceOfL = l.balance;

        p.left = l.right;
        l.right = p;

        l.parent = p.parent;
        p.parent = l;

        if (l.parent != null && l.parent.left == p) {
            l.parent.left = l;
        } else if (l.parent != null && l.parent.right == p) {
            l.parent.right = l;
        } else {
            this.root = l;
        }

        if (balanceOfL >= 0) {
            p.balance = balanceOfP - balanceOfL - 1;
            if (p.balance <= 0) {
                l.balance = balanceOfP - 2;
            } else {
                l.balance = balanceOfL - 1;
            }
        } else {
            p.balance = balanceOfP - 1;
            if (p.balance <= 0) {
                l.balance = balanceOfP + balanceOfL - 2;
            } else {
                l.balance = balanceOfL - 1;
            }
        }
    }

    private static <E> Node<E> parentOf(Node<E> p) {
        return (p == null) ? null : p.parent;
    }

    private static <E> Node<E> leftOf(Node<E> p) {
        return (p == null) ? null : p.left;
    }

    private static <E> Node<E> rightOf(Node<E> p) {
        return (p == null) ? null : p.right;
    }

    @Override
    public Iterator iterator() {
        return new Itr();
    }

    @Override
    public int size() {
        return size;
    }

    /*------------------------内部类-------------------------*/

    private static class Node<E> {
        E item;
        int balance;
        Node parent;
        Node left;
        Node right;

        Node(E item, Node parent) {
            this.item = item;
            this.parent = parent;
        }
    }

    private class Itr implements Iterator<E> {

        private LinkedList<Node<E>> stack = new LinkedList();

        private HashSet<Node<E>> navigationPath = new HashSet<>();

        private Node<E> point;

        @Override
        public boolean hasNext() {
            if (isEmpty()) {
                return false;
            }
            return point != null;
        }

        @Override
        public E next() {
            if (point == null) {
                throw new NoSuchElementException();
            } else {
                Node<E> result = point;
                this.navigation();
                return result.item;
            }
        }

        public Itr() {
            stack.add(root);
            point = root;
        }

        /**
         * 指针下移
         */
        private void navigation() {
            navigationPath.add(point);
            boolean stop = false;
            do {
                Node<E> e = stack.peekLast();
                if (stop = Objects.nonNull(leftOf(e)) && !navigationPath.contains(leftOf(e))) {
                    stack.offerLast(leftOf(e));
                    point = leftOf(e);
                } else if (stop = Objects.nonNull(rightOf(e)) && !navigationPath.contains(rightOf(e))) {
                    stack.offerLast(rightOf(e));
                    point = rightOf(e);
                } else {
                    stack.pollLast();
                }
            } while (!stop && stack.size() != 0);
            if (stack.size() == 0) {
                point = null;
            }
        }
    }

}
