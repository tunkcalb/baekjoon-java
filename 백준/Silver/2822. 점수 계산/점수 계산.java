import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = 8;
		
		int[] score = new int[N];
		int[] arr = new int[3];
		int idx = 0;
		int sum = 0;
		
		for(int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(in.readLine());
		}
		
		int[] copy = Arrays.copyOf(score, N);
		
		Arrays.sort(copy);
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < N; j++) {
				if(copy[i] == score[j]) {
					arr[i] = j;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			if(i == arr[0] || i == arr[1] || i == arr[2]) continue;
			
			sum += score[i];
		}
		
		System.out.println(sum);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			if(i == arr[0] || i == arr[1] || i == arr[2]) continue;
			sb.append(i + 1).append(" ");
		}
		System.out.println(sb);
	}
}
