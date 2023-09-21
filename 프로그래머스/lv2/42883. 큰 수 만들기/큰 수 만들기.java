import java.util.*;

class Solution {
    public String solution(String number, int k) {
        int length = number.length();

        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        stack.push(number.charAt(0) - '0');
        for(int i = 1; i < length; i++){
            int num = number.charAt(i) - '0';
            if(stack.peek() < num && cnt < k) {
                while(!stack.isEmpty() && stack.peek() < num && cnt < k){
                    stack.pop();
                    cnt++;
                }
            }
            stack.push(num);
        }
        
        int size = stack.size();
        String[] ans = new String[size]; 
        for(int i = 0; i < size; i++){
            ans[size - 1 - i] = stack.pop().toString();
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < length - k; i++){
            sb.append(ans[i]);
        }
        return sb.toString();
    }
}