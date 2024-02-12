import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int[] num = new int[n];
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int x = Integer.parseInt(in.readLine());
		
		int start = 0;
		int end = n - 1;
		int cnt = 0;
		
		Arrays.sort(num);
		
		while(start < end) {
			if(num[start] + num[end] == x) {
				cnt++;
				start++;
				end--;
			}
			if(num[start] + num[end] < x) {
				start++;
			}
			if(num[start] + num[end] > x) {
				end--;
			}
		}
		System.out.println(cnt);
		
	}
}
