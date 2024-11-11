import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        
        int[] nums = new int[n];
    	StringTokenizer st = new StringTokenizer(in.readLine());
    	
        for(int i = 0; i < n; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(in.readLine());
        
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        long ans = 0;

        ans += n;

        for (int i = 0; i < n; i++) {
            nums[i] -= b;
            if (nums[i] <= 0) continue;
            ans += nums[i] / c;
            if (nums[i] % c != 0) {
            	ans++;
            }
        }
        System.out.println(ans);
	}
}
