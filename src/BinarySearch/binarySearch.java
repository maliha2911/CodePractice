package BinarySearch;

public class binarySearch {

    public static void main(String[] args) {
        int [] arr={-10,-2,2,3,5,6,8,9,10,12,30,40};
        int ans=bSearch(arr, 10);
        System.out.println(ans);
    }
    public static int bSearch(int[] arr, int target){
        int start= 0;
        int end=arr.length-1;

        while(start<=end){
            int mid= start+(end-start)/2;
            if(target<arr[mid]){
                end=mid-1;
            }
            else if(target>arr[mid]){
                start=mid+1;
            }
            else{
                return mid;
            }

        }
        return -1;

    }
    public static int orderAgnosticBS(int[] arr, int target, Boolean isAscending){
        int start= 0;
        int end=arr.length-1;

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
