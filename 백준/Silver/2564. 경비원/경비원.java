import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		int max =  (width + height) * 2;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] locations = new int[N + 1];
		
		for(int i = 0; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int way = Integer.parseInt(st.nextToken());
			locations[i] = Integer.parseInt(st.nextToken());
			
			switch(way) {
			case 2:
				locations[i] = width * 2 + height - locations[i];
				break;
			case 3:
				locations[i] = max - locations[i];
				break;
			case 4:
				locations[i] += width;
				break;
			}
		}
		
		int sum = 0;
		
		for(int i = 0; i < N; i++) {
			int len = Math.abs(locations[N] - locations[i]);
			sum += Math.min(len, max - len);
		}
		System.out.println(sum);
		
	}
}
