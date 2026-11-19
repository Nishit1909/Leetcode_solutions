class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int bothsmall=nums[n-1]-nums[2];
        int bothlarg=nums[n-3]-nums[0];
        int bothend=nums[n-2]-nums[1];
        return Math.min(bothsmall,Math.min(bothlarg,bothend));
    }
}