import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int sum = 0;
		
		int[] time = new int[100];
		
		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			for(int j = start - 1; j < end - 1; j++) {
				time[j]++;
			}
		}
		
		for(int cnt : time) {
			if(cnt == 1) {
				sum += cnt * a;
			} else if (cnt == 2) {
				sum += cnt * b;
			} else {
				sum += cnt * c;
			}
		}
		
		System.out.println(sum);
	}
}
