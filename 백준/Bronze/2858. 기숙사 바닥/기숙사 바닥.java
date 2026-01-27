import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int sum = r + b;
		
		StringBuilder sb = new StringBuilder();
		
		for(int l = 1; l < sum; l++) {
			if(b % l == 0) {
				int w = b / l;
				if(l * 2 + w * 2 + 4 == r) {
					sb.append(w + 2).append(" ").append(l + 2);
					break;
				}
			}
		}
		System.out.println(sb);
	}
}
