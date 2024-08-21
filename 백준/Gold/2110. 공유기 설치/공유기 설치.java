import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }

        Arrays.sort(arr);

        int low = 1;
        int high = arr[N - 1];
        int ans = 0;
        while(low <= high) {
            int mid = (low + high) / 2;
            int prev = arr[0];
            int cnt = 1;

            for(int i = 1; i < N; i++) {
                if(arr[i] - prev >= mid) {
                    prev = arr[i];
                    cnt++;
                }
            }

            if(cnt < C) high = mid - 1;
            else {
                low = mid + 1;
                ans = mid;
            }
        }
        System.out.println(ans);
    }
}
