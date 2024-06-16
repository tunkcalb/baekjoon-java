import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = 8;
		
		int[] nums = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		boolean flag = true;
		for(int i = 1; i <= N; i++) {
			if(nums[i] != i) {
				flag = false;
			}
		}
		
		if(flag) System.out.println("ascending"); 
		else {
			flag = true;
			for(int i = 1; i <= N; i++) {
				if(nums[i] != N + 1 - i) {
					flag = false;
				}
			}
			if(flag) System.out.println("descending");
			else System.out.println("mixed");
		}
	}
}
