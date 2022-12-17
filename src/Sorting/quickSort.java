package Sorting;

import java.util.Arrays;

public class quickSort {
    public static void main(String[] args) {
        int[] arr={4, 7, 8, 2, 9, 1, 3, 5, 6};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int low, int high) {
        // pivot is fixed to mid(optional)
        // one pointer is fixed to left, another to right, left one will check if a value is less than pivot and
        //right pointer will check if a value is grater than the pivot
        //if it finds so, it will be exchanged and pivot will be taken to its position
        // then recursion will be executed for both its left and right parts
        if(low>=high)
            return;
        int i=low;
        int j=high;
        int mid=i+(j-i)/2;
        int pivot=arr[mid];
        while(i<=j){
            while(arr[i]<pivot)
                i++;
            while(arr[j]>pivot)
                j--;
            if(i<=j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }
        }
        sort(arr, low, j);
        sort(arr,i, high);
    }
}
