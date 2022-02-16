package com.codeforc.algorithm.sword.offer;

import com.codeforc.algorithm.datastruct.TreeNode;
import sun.reflect.generics.tree.Tree;

//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
//
public class TreeIsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        return (root == null) || (req(root.left, root.right));
    }

    public boolean req(TreeNode leftNode, TreeNode rightNode) {
        if(leftNode != null && rightNode != null) {
            return (leftNode.val == rightNode.val) && req(leftNode.left, rightNode.right) && req(leftNode.right, rightNode.left);
        }
        return leftNode == null && rightNode == null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);

        TreeIsSymmetric treeIsSymmetric = new TreeIsSymmetric();
        boolean symmetric = treeIsSymmetric.isSymmetric(root);
        System.out.printf("" + symmetric);

    }


}
