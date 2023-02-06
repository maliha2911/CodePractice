package SegmentTree;

import com.sun.source.tree.Tree;

public class TreeBuild {
    int[] tree;
    TreeBuild(int n){
        tree=new int[n];
    }
    void build(int[] arr, int node, int start, int end){
        if(start == end){
            tree[node] = arr[start];
        }
        else{
            int left=2*node+1;
            int right=2*node+2;
            int mid = (start + end)/2;
            build(arr, left, start, mid);
            build(arr, right, mid+1, end);
            tree[node] = tree[left] + tree[right];
        }
    }
    int sumInARange(int[] arr, int node, int start, int end, int leftrange, int rightrange){
        if(rightrange<start || leftrange>end){
            return 0;
        }
        if(start>=leftrange && end<=rightrange){
            return tree[node];
        }
        int left=2*node+1;
        int right=2*node+2;
        int mid=(start+end)/2;
        int p1= sumInARange(arr, left, start, mid, leftrange, rightrange);
        int p2= sumInARange(arr, right, mid+1, end, leftrange, rightrange );
        return p1+p2;
    }
    void update(int[] arr, int node, int start, int end, int index, int value){
        if(index>end || index<start){
            return;
        }
        if(index<=start && index>=end){
            tree[node]=value;
            return;
        }
        int left=2*node+1;
        int right=2*node+2;
        int mid=(start+end)/2;
        update(arr, left, start, mid, index, value);
        update(arr, right, mid+1, end, index, value);
        tree[node]=tree[left]+tree[right];

    }

}
