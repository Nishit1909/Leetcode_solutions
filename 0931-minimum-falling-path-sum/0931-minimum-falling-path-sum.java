class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;
        int dp[][]=new int[n][n];
        int ans = Integer.MAX_VALUE;
        for(int[] row:dp) Arrays.fill(row,Integer.MIN_VALUE);
        for (int c = 0; c < n; c++) {
            ans = Math.min(ans, fun(n - 1, c, matrix,dp));
        }
return ans;
    }
    public int fun(int i,int j,int[][] matrix,int[][] dp){
        if(j<0 || j>=matrix.length ) return (int)1e9;
        if(i==0) return matrix[0][j];
        if(dp[i][j]!=Integer.MIN_VALUE) return dp[i][j];
        int up=fun(i-1,j,matrix,dp);
        int upleft=fun(i-1,j-1,matrix,dp);
        int upright=fun(i-1,j+1,matrix,dp);
        dp[i][j]= matrix[i][j]+Math.min(up,Math.min(upleft,upright));
        return dp[i][j];
    }
}