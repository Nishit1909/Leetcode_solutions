class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        boolean[] used=new boolean[n];
        List<Integer> temp=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        return fun(nums,used,n,0,temp,res);
    }   
    public List<List<Integer>> fun(int[] nums,boolean[] used,int n,int idx,List<Integer> temp,List<List<Integer>> res){
        if(temp.size()==n){
            res.add(new ArrayList<>(temp));
            return res;
        }
        for(int i=0;i<n;i++){
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            else{
                used[i]=true;
                temp.add(nums[i]);
                fun(nums,used,n,i+1,temp,res);
                temp.remove(temp.size()-1);
                used[i]=false;
            }
            
        }
        return res;
    }
}