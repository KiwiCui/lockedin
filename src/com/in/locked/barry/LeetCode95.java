package com.in.locked.barry;

import java.util.*;
import com.in.locked.barry.TreeNode;

public class LeetCode95 {
    public static List<TreeNode> generateTrees(int n){
        return genTrees(1, n);
    }

    public static List<TreeNode> genTrees(int start, int end){
        List<TreeNode> result = new ArrayList<>();
        if(start > end){
            result.add(null);
            return result;
        }
        if(start == end){
            result.add(new TreeNode(start));
            return result;
        }
        List<TreeNode> left, right;
        for (int i = start; i <= end; i++){
            left = genTrees(start, i - 1);
            right = genTrees(i + 1, end);
            for (TreeNode leftNode: left
                 ) {
                for (TreeNode rightNode : right){
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    result.add(root);
                }
            }
        }
        return result;
    }


    public static void printTreeNodeAsArray(TreeNode treeNode) {

        List<TreeNode> originalNodeList = new ArrayList<>();
        originalNodeList.add(treeNode);
        System.out.print( "[");
        printTreeNode(originalNodeList);
        System.out.print("]");
    }

    public static void printTreeNode(List<TreeNode> nodes){
        List<TreeNode> nodeList = new ArrayList<>();
        for(TreeNode treeNode : nodes){
            System.out.print(treeNode.val + ",");
            if (treeNode.left != null){
                nodeList.add(treeNode.left);
            }else if(treeNode.right!=null){
                System.out.print("null,");
            }
            if (treeNode.right != null){
                nodeList.add(treeNode.right);
            }
        }
        if (!nodeList.isEmpty()){
            printTreeNode(nodeList);
        }
    }

    public static void main(String[] args){

        for (TreeNode nodes : generateTrees(2)){
            printTreeNodeAsArray(nodes);
            System.out.println(",");
        }

    }
}
