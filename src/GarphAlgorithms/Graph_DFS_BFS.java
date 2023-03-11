package GarphAlgorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Graph_DFS_BFS {
    static LinkedList<Integer> adj[];
    public Graph_DFS_BFS(int v){
        adj=new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList<Integer>();
        }
    }
    public static void addEdge(int source, int destination){
        adj[source].add(destination);
        adj[destination].add(source);
    }
    public void bfs(int source){
        boolean[] isVisited=new boolean[adj.length];
//        int[] parentNodes=new int[adj.length];
        Queue<Integer> q=new LinkedList<>();
        q.add(source);
        isVisited[source]=true;
//        parentNodes[source]=-1;
        while(!q.isEmpty()){
            int val=q.poll();
            System.out.println(val);
            for(int i: adj[val]){
                if(isVisited[i]==false) {
                    isVisited[i] = true;
                    q.add(i);
//                    parentNodes[i] = val;
                }
            }
        }

    }
//    public static void dfs(int source){
//        boolean[] isVisited=new boolean[adj.length];
//        int[] parentNodes=new int[adj.length];
//        Stack<Integer> s=new Stack<>();
//        s.add(source);
//        isVisited[source]=true;
//        parentNodes[source]=-1;
//        while(!s.isEmpty()){
//            int val=s.pop();
//            System.out.println(val);
//            for(int i: adj[val]){
//                if(isVisited[i]==false) {
//                    isVisited[i] = true;
//                    s.add(i);
//                    parentNodes[i] = val;
//                }
//            }
//        }
//
//    }
    public static void dfsUtil(int v, boolean[] isVisited){
        isVisited[v]= true;
        System.out.println(v);
        for(int i=0; i<adj[v].size(); i++){
            int val= adj[v].get(i);
            if(isVisited[val]!=true){
                dfsUtil(val, isVisited);

            }
        }
    }
    public static void dfs(int source){
        boolean isVisited[]= new boolean[adj.length];
        dfsUtil(source, isVisited);

    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter no of vertices");
        int vertex=scanner.nextInt();
        System.out.println("enter no of edges");
        int edge=scanner.nextInt();

        Graph_DFS_BFS graph=new Graph_DFS_BFS(vertex);
        System.out.println("enter edges");
        for(int i=0;i<edge;i++){
            int source= scanner.nextInt();
            int destination=scanner.nextInt();
            addEdge(source,destination);
        }
        System.out.println("enter source");


        int source=scanner.nextInt();
        graph.dfs(source);
        graph.bfs(source);


    }
}
