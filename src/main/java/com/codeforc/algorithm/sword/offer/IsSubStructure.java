package com.codeforc.algorithm.sword.offer;

import com.codeforc.algorithm.datastruct.TreeNode;

//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
//B是A的子结构， 即 A中有出现和B相同的结构和节点值。
public class IsSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (eq(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    private boolean eq(TreeNode a, TreeNode b) {
        if(b == null) return true;
        if(a == null || a.val != b.val) return false;
        return eq(a.left, b.left) && eq(a.right, b.right);
    }
}
