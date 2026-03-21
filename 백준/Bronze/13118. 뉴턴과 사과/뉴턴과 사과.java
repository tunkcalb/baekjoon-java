import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = 4;
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 1; i <= N; i++) {
			map.put(Integer.parseInt(st.nextToken()), i);
		}
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		
		System.out.println(map.getOrDefault(x, 0));
	}
}
