import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        int[] nums = new int[n];

        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(in.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        int idx = 1;

        StringBuilder sb = new StringBuilder();
        for(int num : nums) {
            while(num >= idx) {
                sb.append("+").append("\n");
                stack.push(idx++);
            }
            if(!stack.isEmpty() && stack.peek() == num) {
                stack.pop();
                sb.append("-").append("\n");
            }
            else {
                sb = new StringBuilder("NO");
                break;
            }
        }
        System.out.println(sb);
    }
}
