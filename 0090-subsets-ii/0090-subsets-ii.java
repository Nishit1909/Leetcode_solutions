class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> temp=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        return fun(nums,nums.length,0,temp,res);
    }
    public List<List<Integer>> fun(int []nums,int n,int idx,List<Integer> temp,List<List<Integer>> res ){
        if(idx==n){
            res.add(new ArrayList<>(temp));
            return res;
        }
        temp.add(nums[idx]);
        fun(nums,n,idx+1,temp,res);
        temp.remove(temp.size()-1);
        
        while(idx+1<n && nums[idx+1]==nums[idx]) idx++;
        fun(nums,n,idx+1,temp,res);
        return res;
    }
}