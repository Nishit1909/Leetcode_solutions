class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int in=increase(nums);
        int de=decrease(nums);
        return Math.max(in,de);
    }
    public int increase(int []nums){
            int l=0;
            int ans=1;
            for(int r=1;r<nums.length;r++){
                if(nums[r-1]>=nums[r]) l=r;
                ans=Math.max(ans,r-l+1);
            }   
            return ans;
    }
    public int decrease(int []nums){
        int l=0;
        int ans=1;
        for(int r=1;r<nums.length;r++){
            if(nums[r-1]<=nums[r]) l=r;
            ans=Math.max(ans,r-l+1);
        }
        return ans;
    }
}