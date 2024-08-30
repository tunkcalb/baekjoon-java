import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];

        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(in.readLine());
        }

        Arrays.sort(nums);

        int left = nums[0];
        int right = nums[N - 1] + K;

        int ans = left;
        while(left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;
            for(int num : nums) {
                if(num < mid) {
                    sum += (mid - num);
                }
                else break;
            }
            if(sum <= K) {
                ans = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
