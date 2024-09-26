import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int[] distance = new int[N - 1];
        int[] cost = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i = 0; i < N - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(in.readLine());

        for(int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        int min = cost[0];
        for(int i = 0; i < N - 1; i++) {
            min = Math.min(min, cost[i]);

            ans += min * distance[i];
        }
        System.out.println(ans);
    }
}
