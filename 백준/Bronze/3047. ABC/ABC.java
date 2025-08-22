import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = 3;
		int[] nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		map.put('A', nums[0]);
		map.put('B', nums[1]);
		map.put('C', nums[2]);
		
		String line = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			char key = line.charAt(i);
			sb.append(map.get(key)).append(" ");
		}
		
		System.out.println(sb);
	}
}
