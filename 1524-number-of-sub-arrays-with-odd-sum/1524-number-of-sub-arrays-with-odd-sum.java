class Solution {
    public int numOfSubarrays(int[] arr) {
        int n=arr.length;
        int ec=1;
        int oc=0;
        long c=0;
        int sum=0;
        for(int i=0;i<n;i++){
           sum+=arr[i];
           if(sum%2==0){
                c+=oc;
                ec++;
           }
           else{
                c+=ec;
                oc++;
           }
        }
        return (int)(c%1_000_000_007);
    }
}