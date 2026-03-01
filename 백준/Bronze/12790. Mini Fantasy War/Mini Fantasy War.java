import java.io.*;
import java.util.*;
	
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] point = new int[8];
			
			for(int j = 0; j < 8; j++) {
				point[j] = Integer.parseInt(st.nextToken());
			}
			
			for(int j = 0; j < 4; j++) {
				point[j] += point[j + 4];
			}

			point[0] = (point[0] < 1) ? 1 : point[0];
			point[1] = (point[1] < 1) ? 1 : point[1];
			point[2] = (point[2] < 0) ? 0 : point[2];
			
			int ans = point[0] + (point[1]*5) + (point[2]*2) + (point[3]*2);
			sb.append(ans).append("\n");
		}
		
		System.out.println(sb);
	}
}
