class Solution {
    
    int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        dfs(numbers, target, 0);
        
        return answer;
    }

    public void dfs(int[] numbers, int target, int idx) {
        if(idx == numbers.length) {
            if(target == 0) answer++;
            return;
        }
        dfs(numbers, target + numbers[idx], idx + 1);
        dfs(numbers, target - numbers[idx], idx + 1);
    }
}