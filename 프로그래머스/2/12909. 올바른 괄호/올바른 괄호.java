import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if(now == '(') {
                stack.push(now);
            }
            else {
                if(!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }else {
                    stack.push(now);
                }
            }
        }
        if(stack.isEmpty()) answer = true;
        return answer;
    }
}