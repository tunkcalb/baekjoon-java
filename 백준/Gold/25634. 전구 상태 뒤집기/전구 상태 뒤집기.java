import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int ON = 1;
		int OFF = 0;
		int INF = 987654321;
		
		int[] nums = new int[N];
		int[] onOff = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int min = INF;
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			min = Math.min(min, nums[i]);
		}
		
		st = new StringTokenizer(br.readLine());
		int ans = 0;
		for(int i = 0; i < N; i++) {
			onOff[i] = Integer.parseInt(st.nextToken());
			
			if(onOff[i] == ON) ans += nums[i];
		}
		
		int sum = 0;
		int max = 0;
		for(int i = 0; i < N; i++) {
			if(onOff[i] == OFF) sum += nums[i];
			else sum -= nums[i];
			
			if(sum < 0) sum = 0;
			
			max = Math.max(max, sum);
		}
		
		if(max == 0) {
			ans -= min;
		}
		else ans += max;
		
		System.out.println(ans);
	}
}
