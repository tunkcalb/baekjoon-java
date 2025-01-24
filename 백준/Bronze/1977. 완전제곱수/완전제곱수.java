import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int bot = (int) Math.sqrt((double) M);
		int top = (int) Math.sqrt((double) N);
		
		int sum = -1;
		int min = Integer.MAX_VALUE;
		
		for(int i = bot; i <= top; i++) {
			int now = i * i;
			if(now >= M && now <= N) {
				sum += now;
				min = Math.min(min, now);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		if(sum != -1) {
			sum++;
			sb.append(sum).append("\n").append(min);
		}
		else sb.append(sum);
		System.out.println(sb);
	}
}
