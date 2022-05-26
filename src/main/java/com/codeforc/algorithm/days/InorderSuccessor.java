package com.codeforc.algorithm.days;

import com.codeforc.algorithm.datastruct.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 * example:
 * 输入: root = [2,1,3], p = 1
 *   2
 *  / \
 * 1   3
 * 输出: 2
 *
 * example:
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 *
 *       5
 *      / \
 *     3   6
 *    / \
 *   2   4
 *  /
 * 1
 *
 * 输出: null
 */
public class InorderSuccessor {

    /**
     * root
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null, curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (prev == p) {
                return curr;
            }
            prev = curr;
            curr = curr.right;
        }
        return null;
    }

    public static void main(String[] args) {
        InorderSuccessor inorderSuccessor = new InorderSuccessor();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        inorderSuccessor.inorderSuccessor(root, root.left);
    }
}
