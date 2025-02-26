import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			PriorityQueue<String> pq = new PriorityQueue<>();
			String[][] words = new String[n][2];
			for(int i = 0; i < n; i++) {
				words[i][0] = br.readLine();
				words[i][1] = words[i][0].toLowerCase();
			}
			Arrays.sort(words, (o1, o2) -> o1[1].compareTo(o2[1]));
			sb.append(words[0][0]).append("\n");
		}
		
		System.out.println(sb);
	}
}
