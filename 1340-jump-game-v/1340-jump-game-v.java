class Solution {

    int[] dp;

    public int dfs(int i, int[] arr, int d) {
        if (dp[i] != -1)
            return dp[i];

        int n = arr.length;
        int ans = 1;

        // Check right side
        for (int j = i + 1; j <= Math.min(n - 1, i + d); j++) {
            if (arr[j] >= arr[i])
                break;

            ans = Math.max(ans, 1 + dfs(j, arr, d));
        }

        // Check left side
        for (int j = i - 1; j >= Math.max(0, i - d); j--) {
            if (arr[j] >= arr[i])
                break;

            ans = Math.max(ans, 1 + dfs(j, arr, d));
        }

        return dp[i] = ans;
    }

    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }

        int result = 1;

        for (int i = 0; i < n; i++) {
            result = Math.max(result, dfs(i, arr, d));
        }

        return result;
    }
}