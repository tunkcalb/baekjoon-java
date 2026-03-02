import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        
        Stack<Integer> stack = new Stack<>();
        long ans = 0;
        
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            
            if (c == 's') {
                stack.push(1);
            } else if (c == 'k') {
                if (!stack.isEmpty() && stack.peek() == 1) stack.push(stack.pop() + 1);
                else stack.clear();
            } else if (c == 'e') {
                if (!stack.isEmpty() && (stack.peek() == 2 || stack.peek() == 3)) stack.push(stack.pop() + 1);
                else stack.clear();
            } else if (c == 'p') {
                if (!stack.isEmpty() && stack.peek() == 4) stack.push(stack.pop() + 1);
                else stack.clear();
            } else {
                stack.clear();
            }
            
            while (!stack.isEmpty() && stack.peek() == 5) {
                ans++;
                stack.pop();
                if (!stack.isEmpty()) {
                    stack.push(stack.pop() + 1);
                }
            }
        }
        System.out.println(ans);
    }
}
