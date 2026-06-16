class Solution {
    int n, m;
    Boolean[][] memo;

    public boolean dfs(String s1, String s2, String s3, int i, int j) {
        int k = i + j;

        if(k == s3.length()) return memo[i][j] = true;

        if(memo[i][j] != null) return memo[i][j];

        if(i == n) {
            if(j < m && s2.charAt(j) == s3.charAt(k)) {
                return memo[i][j] = dfs(s1, s2, s3, i, j + 1);
            } 

            return memo[i][j] = false;
        }

        if(j == m) {
            if(i < n && s1.charAt(i) == s3.charAt(k)) {
                return memo[i][j] = dfs(s1, s2, s3, i + 1, j);
            } 

            return memo[i][j] = false;
        }

        if(s1.charAt(i) == s2.charAt(j) && s1.charAt(i) == s3.charAt(k)) {
            return memo[i][j] = dfs(s1, s2, s3, i + 1, j) || dfs(s1, s2, s3, i, j + 1);
        } else if(s1.charAt(i) == s3.charAt(k)) {
            return memo[i][j] = dfs(s1, s2, s3, i + 1, j);
        } else if(s2.charAt(j) == s3.charAt(k))  {
            return memo[i][j] = dfs(s1, s2, s3, i, j + 1);
        }

        return memo[i][j] = false;

    }

    public boolean isInterleave(String s1, String s2, String s3) {
        n = s1.length();
        m = s2.length();

        memo = new Boolean[n + 1][m + 1];

        if(n + m != s3.length()) return false;

        return dfs(s1, s2, s3, 0, 0);

    }
}