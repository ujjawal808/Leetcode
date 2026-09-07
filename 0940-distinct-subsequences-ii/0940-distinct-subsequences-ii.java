class Solution {
    public int distinctSubseqII(String s) {

        int MOD = 1000000007;

        // dp[i] = number of distinct subsequences
        // ending with character ('a' + i)
        long[] dp = new long[26];

        // Total distinct non-empty subsequences
        long total = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            int idx = ch - 'a';

            // Store old value before replacing it
            long old = dp[idx];

            // All existing subsequences + current character alone
            long newEnding = (total + 1) % MOD;

            // Replace old subsequences ending with this character
            dp[idx] = newEnding;

            // Update total
            total = (total - old + newEnding) % MOD;

            // Avoid negative value
            if (total < 0) {
                total += MOD;
            }
        }

        return (int) total;
    }
}