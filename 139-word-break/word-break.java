class Solution { 
    
    private int[] dp;

    private boolean solve(String s, Set<String> wordSet, int idx) {
        if (dp[idx] != -1)
            return dp[idx] == 1;

        if (idx >= s.length()) {
            dp[idx] = 1;
            return true;
        }

        for (int i = 1; i <= s.length() - idx; i++) {
            String subS = s.substring(idx, idx + i);
            if (wordSet.contains(subS) && solve(s, wordSet, idx + i)) {
                dp[idx] = 1;
                return true;
            }
        }

        dp[idx] = 0;
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return solve(s, wordSet, 0);
    }
}