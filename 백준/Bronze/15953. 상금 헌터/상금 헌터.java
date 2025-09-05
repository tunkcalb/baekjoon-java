import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int first  = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			if(first == 0) sum += 0;
			else if(first == 1) {
				sum += 5000000;
			} else if (first <= 3) {
				sum += 3000000;
			} else if (first <= 6) {
				sum += 2000000;
			} else if (first <= 10) {
				sum += 500000;
			} else if (first <= 15) {
				sum += 300000;
			} else if (first <= 21) {
				sum += 100000;
			}
			
			if(second == 0) sum += 0;
			else if(second == 1) {
				sum += 5120000;
			} else if (second <= 3) {
				sum += 2560000;
			} else if (second <= 7) {
				sum += 1280000;
			} else if (second <= 15) {
				sum += 640000;
			} else if (second <= 31) {
				sum += 320000;
			}
			
			System.out.println(sum);
		}
		
		
	}
}
