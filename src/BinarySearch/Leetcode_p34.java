package BinarySearch;

public class Leetcode_p34 {

    public static void main(String[] args) {
        int[] nums={2,3,7,7,7,7,8,9};
        int target=7;
        int[] ans=searchRange(nums, target);
        System.out.println(ans);

    }
    public static int[] searchRange(int[] nums, int target) {
        int [] ans={-1, -1};
        int start=search(nums, target, true);
        int end=search(nums, target, false);

        ans[0]=start;
        ans[1]=end;
        return ans;
    }
    public static int search(int[] nums, int target, Boolean isFirst){
        int ans=-1;
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
                if(isFirst) end=mid-1;
                else start=mid+1;
            }

        }
        return ans;
    }

}
