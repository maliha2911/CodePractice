package HashMap;

import java.util.ArrayList;
import java.util.LinkedList;

public class CustomHashMap {
    static class HashMap<K, V>{
        private class Node{
            K key;
            V value;
            public Node(K key, V value){
                this.key=key;
                this.value=value;
            }
        }
        private int n;
        private int N;
        private LinkedList<Node> buckets[];
        public HashMap(){
            this.N=4;
            this.buckets=new LinkedList[4];
            for(int i=0;i<4;i++){
                this.buckets[i]=new LinkedList<>();
            }
        }
        private int hashFunction(K key){
            int bi=key.hashCode();
            return Math.abs(bi) %N;
        }
        private int searchInLL(K key,int bi){
            LinkedList<Node> ll= buckets[bi];
            for(int i=0; i<ll.size(); i++){
                if(ll.get(i).key==key){
                    return i;
                }
            }
        return -1;
        }
        private void rehash(){
            LinkedList<Node> oldBucket[] = buckets;
            buckets= new LinkedList[N*2];
            for(int i=0;i<N*2;i++){
                buckets[i] = new LinkedList<>();
            }
            for(int i=0;i<N*2;i++){
                LinkedList<Node> ll= buckets[i];
                for( int j=0; j<ll.size(); j++){
                    Node node=ll.get(j);
                    put(node.key, node.value);
                }
            }
        }
        public void put(K key, V value){
            int bi= hashFunction(key); //bucket index from hash function
            int di=searchInLL(key, bi); //index in the linked list
            if(di==-1){ //key doesnt exist
                buckets[bi].add(new Node(key, value));
                n++;
            }
            else{
                Node node=buckets[bi].get(di);
                node.value=value;
            }
            double lambda=(double) n/N;
            if(lambda>2.0)
                rehash();
        }
        public V get(K key){
            int bi= hashFunction(key);
            int di=searchInLL(key, bi);
            if(di==-1){
                return null;
            }
            else{
                Node node=buckets[bi].get(di);
                return node.value;
            }
        }
        public boolean containsKey(K key){
            int bi= hashFunction(key);
            int di=searchInLL(key, bi);
            if(di==-1){
                return false;
            }
            else{
                return true;
            }

        }
        public V remove(K key){
            int bi= hashFunction(key);
            int di=searchInLL(key, bi);
            if(di==-1){
               return null;
            }
            else{
                Node node=buckets[bi].remove(di);
                return node.value;
            }

        }
        public int size(){
            return n;
        }
        public boolean isEmpty(){
            return n==0;
        }
        public ArrayList<K> keySet(){
            ArrayList<K> keys= new ArrayList<>();
            for(int i=0;i<buckets.length;i++){
                LinkedList<Node> ll= buckets[i];
                for( int j=0; j<ll.size(); j++){
                    Node node=ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;

        }

    }

    public static void main(String[] args) {
        HashMap<String, Integer> hashMap=new HashMap<>();
        hashMap.put("India", 120);;
        hashMap.put("BD", 50);
        hashMap.put("Srilanka", 10);
    }
}
