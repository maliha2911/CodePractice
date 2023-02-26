package BinaryTree;

public class BSTbuild {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }
    public static Node insert(Node root, int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
       if(val< root.data) root.left= insert(root.left, val);
       else root.right= insert(root.right, val);
       return root;
    }
    public static boolean search(Node root, int key){
        if(root==null){
            return false;
        }
        if(key< root.data){
            return search(root.left, key);
        }
        else if(key== root.data){
            return true;
        }
        else{
            return search(root.right, key);
        }
    }
    public static void inOrder(Node root){
        if(root==null) return;
        inOrder(root.left);
        System.out.print(root.data+ " ");
        inOrder(root.right);
    }
    public static Node delete(Node root,int val ){
        if(val<root.data){
            root.left=delete(root.left, val);
        }
        else if(val> root.data){
            root.right= delete(root.right, val);
        }
        else{
            if(root.left==null && root.right==null){
                return null;
            }
            if(root.left==null) return root.right;
            else if (root.right==null) return root.left;
            else{
                Node IS= inOrderSuccessor(root.right);
                root.data= IS.data;
                root.right= delete(root.right,val);
            }
        }
        return root;
    }

    private static Node inOrderSuccessor(Node root) {
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    public static void printInARange(Node root, int low, int high){
        if(root==null) return;
        if(root.data>= low && root.data<=high){
            printInARange(root.left, low, high);
            System.out.print(root.data+ " ");
            printInARange(root.right, low, high);
        }
        else if(high< root.data){
            printInARange(root.left, low, high);
        }
        else {
            printInARange(root.right, low, high);
        }
    }


    public static void main(String[] args) {
        int[] values={5,1,3,4,2,7};
        Node root=null;
        for(int i=0; i<values.length; i++){
            root=insert(root, values[i]);
        }
        //System.out.println(search(root, 22));
        inOrder(root);
        Node ans= delete(root, 3);
        inOrder(root);
    }
}
