package BinarySearch;

public class Leetcode_p35 {
    public static void main(String[] args) {
        int[] nums={5,6,9,20,30,40,56,67};
        int ans=searchInsert(nums, 10);
        System.out.println(ans);
    }
    public static int searchInsert(int[] nums, int target) {
        int start= 0;
        int end=nums.length-1;

        while(start<=end){
            int mid= start+(end-start)/2;
            if(target<nums[mid]){
                end=mid-1;
            }
            else if(target>nums[mid]){
                start=mid+1;
            }
            else{
                return mid;
            }

        }
        return start;
    }
}
