class Solution {
    public int subtractProductAndSum(int n) {
        int sum=0;
        int prod=1;
        int x=n;
        int r=0;
        while(x>0){
            r=x%10;
            x=x/10;
            sum+=r;
            prod*=r;
        }
        return (prod-sum);
    }
}