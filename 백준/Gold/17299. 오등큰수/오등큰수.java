import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int M = 1000001;
        int[] nums = new int[N];
        int[] cnt = new int[M];
        int[] ans = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            nums[i] = num;
            cnt[nums[i]]++;
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < N; i++) {
            while(!stack.isEmpty() && cnt[nums[stack.peek()]] < cnt[nums[i]]) {
                ans[stack.pop()] = nums[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(ans[i]).append(" ");
        }

        System.out.println(sb);
    }
}
