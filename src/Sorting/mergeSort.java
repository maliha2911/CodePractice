package Sorting;

import java.util.Arrays;

public class mergeSort {
    public static void main(String[] args) {
        int[] arr={4, 7, 8, 2, 9, 1, 3, 5, 6};
        sort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));

    }
    public static void sort(int[] arr, int start, int end){
        if(end-start==1){
            return;
        }
        int mid= (start+end)/2;
        sort(arr, start, mid);
        sort(arr, mid, end);
        merge(arr, start, end, mid);
    }
    public static void merge(int[] arr, int start,int end, int mid){
        int[] mix=new int[end-start];
        int i=start;
        int j=mid;
        int k=0;
        while(i<mid && j<end){
            if(arr[i]<arr[j]){
                mix[k]=arr[i];
                i++;
            }
            else{
                mix[k]=arr[j];
                j++;
            }
            k++;
        }
        while(i<mid){
            mix[k]=arr[i];
            i++;
            k++;
        }
        while(j<end){
            mix[k]=arr[j];
            j++;
            k++;
        }
        for(int l=0;l<mix.length;l++){
            arr[start+l]=mix[l];
        }
    }
}
