import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		int max = 1000001;
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int[] nums = new int[N];
		boolean[] card = new boolean[max];
		int[] score = new int[max];
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			card[nums[i]] = true;
		}
		
		for(int num : nums) {
			for(int i = num * 2; i < max; i += num) {
				if(card[i]) {
					score[num]++;
					score[i]--;
				}
			}
		}
		
		for(int num : nums) {
			sb.append(score[num]).append(" ");
		}
		System.out.println(sb);
	}
}
