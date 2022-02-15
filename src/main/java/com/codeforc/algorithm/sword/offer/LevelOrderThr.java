package com.codeforc.algorithm.sword.offer;

import com.codeforc.algorithm.datastruct.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.sql.Array;
import java.util.*;

//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
//第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
public class LevelOrderThr {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode curNode = queue.poll();
                list.add(curNode.val);
                if(curNode.left != null) queue.add(curNode.left);
                if(curNode.right != null) queue.add(curNode.right);
            }
            res.add(list);
        }

        for(int i = 0; i < res.size(); i++) {
            if(i % 2 == 0) continue;
            Collections.reverse(res.get(i));
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left=  new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        levelOrder(root);
    }
}