class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n][];
        for(int i=0;i<n;i++){
            dp[i] = new int[i + 1];
            Arrays.fill(dp[i],Integer.MIN_VALUE);
        }

        
        return fun(0,0,triangle,dp);
    }
    public int fun(int i,int j,List<List<Integer>> triangle,int[][] dp){
        if(i==triangle.size()-1) return triangle.get(i).get(j);
        if(dp[i][j]!=Integer.MIN_VALUE) return dp[i][j];
        int down=fun(i+1,j,triangle,dp);
        int diagnol=fun(i+1,j+1,triangle,dp);
        
        dp[i][j]=triangle.get(i).get(j)+Math.min(down,diagnol);
        return dp[i][j];
    }
}