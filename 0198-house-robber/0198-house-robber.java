class Solution {
    int dp[];
    public int rob(int[] nums) {
        int n=nums.length;
        dp=new int[n];
        Arrays.fill(dp,-1);
        return help(nums,0,n);

    }
    public int help(int []nums,int idx,int n){
        if(idx>=n){
            return 0;
        }
        if(dp[idx]!=-1) return dp[idx];
        int pick=nums[idx]+help(nums,idx+2,n);
        int nonpick=help(nums,idx+1,n);
        dp[idx]= Math.max(pick,nonpick);
        return dp[idx];
    }   
}