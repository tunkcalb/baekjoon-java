import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 7;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(in.readLine());
			if(num % 2 == 1) {
				sum += num;
				min = Math.min(min, num);
			}
		}
		if(sum == 0) {
			System.out.println(-1);
		}
		else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
}
