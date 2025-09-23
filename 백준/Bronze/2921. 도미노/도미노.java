import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int sum = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j <= i; j++) {
				sum += i + j;
			}
		}
		
		System.out.println(sum);
	}
}
