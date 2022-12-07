package BinarySearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ternarySearch {
    public static void main(String[] args) throws IOException{
//        int arr[]={3,4,5,6,7,8,9,10,11,12,13};
//        int length= arr.length;
        BufferedReader bf=new BufferedReader(new FileReader("src/demo.txt"));
        String str=bf.readLine();
        int target=Integer.parseInt(bf.readLine());
        String [] splitarray= str.split(" ");
        int [] arr=new int[splitarray.length];
        for(int i=0; i<splitarray.length;i++){
            arr[i]=Integer.parseInt(splitarray[i]);
        }

        int ans= ternarySearch(arr, 0, arr.length-1, target);
        System.out.println(ans);
    }
    public static int ternarySearch(int[] arr, int l, int r, int target){
        if(r>=l){
            int mid1= l+(r-l)/3;
            int mid2= r-(r-l)/3;
            if(arr[mid1]== target) return mid1;
            if(arr[mid2]== target) return mid2;
            if(target<arr[mid1]) return ternarySearch(arr, l, mid1-1, target);
            if(target>arr[mid2]) return ternarySearch(arr, mid2+1, r, target);
            else return ternarySearch(arr, mid1+1, mid2-1, target);
        }

        return -1;
    }
}
