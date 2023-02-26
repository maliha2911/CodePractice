package BinaryTree;

import com.sun.source.tree.BinaryTree;
import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;


public class TreeBuild {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static class BinaryTree {
        static int idx = -1;

        public Node build(int[] arr) {
            idx++;
            if (arr[idx] == -1) return null;
            Node node = new Node(arr[idx]);
            node.left = build(arr);
            node.right = build(arr);
            return node;
        }
    }
        public static void preorder(Node root){
            if(root==null) return;
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
        public static void inorder(Node root){
            if(root== null) return;
            inorder(root.left);
            System.out.print(root.data+ " ");
            inorder(root.right);
        }
        public static void postorder(Node root){
            if(root== null) return;
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+ " ");
        }
        public static void levelorder(Node root) {
            if (root == null) return;
            Queue<Node> q = new LinkedList<Node>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }
        public static int countOfNodes(Node root){
             if(root== null) return 0;
             int leftcount= countOfNodes(root.left);
             int rightcount=countOfNodes(root.right);

             return leftcount+rightcount+1;

        }
    public int calculateSum(Node root){
        if(root== null) return 0;
        int leftsum= calculateSum(root.left);
        int rightsum= calculateSum(root.right);

        return leftsum+ rightsum+ root.data;
    }
    public int maxDepth(Node root) {
        if(root==null) return 0;
        else{
            int leftDepth=maxDepth(root.left);
            int rightDepth=maxDepth(root.right);
            if(leftDepth>rightDepth) return leftDepth+1;
            else return rightDepth+1;
        }

    }
    static class TreeInfo{
        int height;
        int diameter;
        TreeInfo(int height, int diameter){
            this.height=height;
            this.diameter=diameter;
        }

    }
    public static TreeInfo diameterCalc(Node root){
        if(root== null){
            return new TreeInfo(0,0);
        }
        TreeInfo left= diameterCalc(root.left);
        TreeInfo right=diameterCalc(root.right);

        int maxHeight= Math.max(left.height, right.height) +1 ;

        int diam1= left.diameter;
        int diam2= right.diameter;
        int diam3= left.height + right.height + 1;

        int maxDiametre= Math.max(diam1, Math.max(diam2, diam3));
        TreeInfo treeInfo= new TreeInfo(maxHeight,maxDiametre);
        return  treeInfo;
    }

    public static void main(String[] args) {
        int[] arr={1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree=new BinaryTree();
        Node root=tree.build(arr);
//        System.out.println(root.data);
//        levelorder(root);
        System.out.println(diameterCalc(root).diameter);
    }
}
