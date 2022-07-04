package com.codeforc.algorithm.days;

import com.codeforc.algorithm.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 */
public class LargestValues {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> maxs = new ArrayList<>();
        dfs(maxs, root, 0);
        return maxs;
    }
    public void dfs(List<Integer> res, TreeNode root, int curHeight) {
        if (curHeight == res.size()) {
            res.add(root.val);
        } else {
            res.set(curHeight, Math.max(res.get(curHeight), root.val));
        }
        if (root.left != null) {
            dfs(res, root.left, curHeight + 1);
        }
        if (root.right != null) {
            dfs(res, root.right, curHeight + 1);
        }
    }


    public static void main(String[] args) {

    }
}
