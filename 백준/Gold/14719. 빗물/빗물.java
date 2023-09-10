import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		int[] height = new int[w];
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < w; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		
		for(int i = 1; i < w - 1; i++) {
			int left = 0;
			int right = 0;
			
			for(int j = 0; j < i; j++) {
				left = Math.max(height[j], left);
			}
			
			for(int j = i + 1; j < w; j++) {
				right = Math.max(height[j], right);
			}
			
			if(height[i] < left && height[i] < right) result += Math.min(left, right) - height[i];
		}
		System.out.println(result);
		
	}
}
