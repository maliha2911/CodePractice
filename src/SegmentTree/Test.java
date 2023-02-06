package SegmentTree;

public class Test {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9};
        int n = arr.length;
        int height = (int)( Math.log(n)/Math.log(2) )+ 1;
        int tree_nodes = (int) Math.pow(2, height+1);
        TreeBuild treeBuild=new TreeBuild(tree_nodes);
        treeBuild.build(arr,0, 0, arr.length-1);
        for(int i=0;i<tree_nodes;i++){
            System.out.println(treeBuild.tree[i]);
        }
        System.out.println("Sum : "+ treeBuild.sumInARange( arr, 0,0, arr.length-1,2,3 ));
        treeBuild.update(arr, 0,0, arr.length-1,2, 10 );


    }
}
