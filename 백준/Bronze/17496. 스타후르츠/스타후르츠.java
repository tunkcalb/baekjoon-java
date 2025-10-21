import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		int day = 1;
		int sum = 0;
		
		while(true) {
			day += t;
			if(day > n) break;
			sum += c * p;
		}
		
		System.out.println(sum);
	}
}
