class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int []a={1,2,3,4,5,6,7,8,9};
        List<Integer> temp=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        int sum=0;
        return fun(a,k,n,0,sum,temp,res);
    }
    public List<List<Integer>> fun(int []a,int k,int n,int idx,int sum,List<Integer> temp,List<List<Integer>> res){
        if(temp.size()==k){
            if(sum==n){
                res.add(new ArrayList<>(temp));
            }
            
            return res;
        }
        if(idx==a.length) return res;
        fun(a,k,n,idx+1,sum,temp,res);

        if(sum<=n){
            sum+=a[idx];
            temp.add(a[idx]);
            fun(a,k,n,idx+1,sum,temp,res);
            sum-=a[idx];
            temp.remove(temp.size()-1);       
        }
        return res;
    }
}