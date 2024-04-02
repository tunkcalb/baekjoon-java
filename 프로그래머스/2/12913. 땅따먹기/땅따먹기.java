class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int length = land.length;
        int[][] dp = new int[length + 1][4];
        
        for(int i = 1; i <= length; i++) {
            for(int j = 0; j < 4; j++) {
                for(int k = 0; k < 4; k++) {
                    if(j == k) continue;
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + land[i - 1][j]);
                }
            }
        }
        
        for(int i = 0; i < 4; i++) {
            answer = Math.max(answer, dp[length][i]);
        }
        return answer;
    }
}