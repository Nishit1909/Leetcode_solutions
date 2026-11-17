    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int i=obstacleGrid.length;
            int j=obstacleGrid[0].length;
            int[][] dp=new int[i][j];
            for(int[] row:dp) Arrays.fill(row,-1);
            return fun(i-1,j-1,obstacleGrid,dp);
        }
        public int fun(int i,int j,int[][] obstacleGrid,int[][] dp){
            if(i<0 || j<0 ) return 0;
            if(obstacleGrid[i][j]==1) return 0;
            if(i==0 && j==0){
                return 1;
            }
            if(dp[i][j]!=-1) return dp[i][j];
            dp[i][j]=fun(i-1,j,obstacleGrid,dp)+fun(i,j-1,obstacleGrid,dp);
            return dp[i][j];
        }
    }