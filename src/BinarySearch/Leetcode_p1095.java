package BinarySearch;

public class Leetcode_p1095 {
    public static void main(String[] args) {
        int [] arr={1,2,3,2,1};
        int ans=findInMountainArray(10, arr);
        System.out.println(ans);

    }
    public static int findInMountainArray(int target, int[] arr) {
        int peak=peakIndexInMountainArray(arr);
        int firstTry=orderAgnosticBS(arr,target,0, peak, true);
        if(firstTry!=-1) return firstTry;
        else return orderAgnosticBS(arr, target, peak+1, arr.length-1, false);

    }
    public static int peakIndexInMountainArray(int[] arr) {
        int start= 0;
        int end=arr.length-1;
        while(start<end){
            int mid= start+(end-start)/2;
            if(arr[mid]<arr[mid+1]){
                start=mid+1;
            }
            else{
                end=mid;
            }

        }
        return start;

    }
    public static int orderAgnosticBS(int[] arr, int target, int start, int end, Boolean isAscending){
        while(start<=end){
            int mid= start+(end-start)/2;
            if(target==arr[mid]) return mid;
            if(isAscending){
                if(target<arr[mid]){
                    end=mid-1;
                }
                else {
                    start=mid+1;
                }
            }
            else{
                if(target>arr[mid]){
                    end=mid-1;
                }
                else {
                    start=mid+1;
                }
            }
        }
        return -1;
    }
}
