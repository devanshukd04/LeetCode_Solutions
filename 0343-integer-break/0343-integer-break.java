class Solution {
    int[] memo;
    
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        
        memo = new int[n + 1];
        return dp(n);
    }
    
    public int dp(int num) {
        if (num <= 3) {
            return num;
        }
        
        if (memo[num] != 0) {
            return memo[num];
        }
        
        int ans = num;
        for (int i = 2; i < num; i++) {
            ans = Math.max(ans, i * dp(num - i));
        }
        
        memo[num] = ans;
        return ans;
    }
}