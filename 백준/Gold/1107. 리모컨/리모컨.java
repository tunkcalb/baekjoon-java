import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int M = Integer.parseInt(br.readLine());
		
		Set<Integer> set = new HashSet<>();
		
		StringTokenizer st;
		if(M != 0) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				set.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		int min = Math.abs(100 - N);
		
		control: for(int i = 0; i < 999999; i++) {
			String line = String.valueOf(i);
			for(int j = 0; j < line.length(); j++) {
				if(set.contains(line.charAt(j) - '0')) continue control;
			}
			min = Math.min(min, line.length() + Math.abs(i - N));
		}
		
		System.out.println(min);
	}
}
