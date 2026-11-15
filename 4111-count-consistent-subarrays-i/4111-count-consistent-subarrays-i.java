class Solution {
    public int countConsistent(int[] nums) {
        int c=0;
        
        for(int i=0;i<nums.length;i++){
            int min=nums[i];
            int ans=nums[i];
            for(int j=i;j<nums.length;j++){
                min=Math.min(nums[j],min);
                ans=ans&nums[j];
                if(min==ans){
                    c++;
                }
            }
        }
        return c;
    }
}