class Solution {
    public List<List<String>> partition(String s) {
        int n=s.length();
        List<String> temp=new ArrayList<>();
        List<List<String>> res=new ArrayList<>();
        return fun(s,n,0,temp,res);
    }
    public List<List<String>> fun(String s,int n,int idx,List<String> temp,List<List<String>> res){
        if(idx==n){
            res.add(new ArrayList<>(temp));
            return res;
        } 
            for(int i=idx;i<n;i++){
                if(reverse(s.substring(idx,i+1))){
                    temp.add(s.substring(idx,i+1));
                    fun(s,n,i+1,temp,res);
                    temp.remove(temp.size()-1);
                }
            }
            return res;
    }
    public boolean reverse(String s){
        char[] arr=s.toCharArray();
        int l=0,r=arr.length-1;
        while(l<r){
            if(arr[l]!=arr[r]){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}