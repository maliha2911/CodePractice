package Sorting;

public class Sorting {
    public static void main(String[] args) {
        int[] arr={4, 7, 8, 2, 9, 1, 3, 5, 6};
        int[] sortedArray= insertionSort(arr);
        printArray(sortedArray);
    }
    public static void printArray(int[] arr){
        for(int i=0; i< arr.length; i++){
            System.out.print(arr[i]+"  ");
        }
    }
    //bubble sort-compare element with the next element and swap with it if it is smaller than the next element
    public static int[] bubbleSort(int[] arr){
        for(int i=0; i< arr.length; i++){
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }
    //selection sort-find the minimum element and place sequentially from the beginning
    public static int[] selectionSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int smallest=i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[smallest]>arr[j]){
                    smallest=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[smallest];
            arr[smallest]=temp;
        }
        return arr;
    }
    //insertion sort-from index 1, divided into two parts sorted and unsorted.
    // each element selected from unsorted part will be compared to the sorted part and to find with
    // which index its smaller to, and be placed at that position
    public  static int[] insertionSort(int[] arr){
        for(int i=1;i<arr.length; i++){
            int current=arr[i];
            int j=i-1;
            while(j>=0 && current<arr[j]){
                arr[j+1]=arr[j];
                j--;
            }

            arr[j+1]=current;
        }
        return arr;
    }
}
