import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int[] num = new int[N];
		int[] sorted = new int[N];
		
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			sorted[i] = num[i];
		}
		
		Arrays.sort(sorted);
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int number = 0;
		for(int i = 0; i < N; i++) {
			if(!map.containsKey(sorted[i])) {
				map.put(sorted[i], number++);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			sb.append(map.get(num[i])).append(" ");
		}
		
		System.out.println(sb);
	}
}
