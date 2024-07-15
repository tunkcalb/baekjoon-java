import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			int N = Integer.parseInt(in.readLine());
			if(N == -1) break;
			
			ArrayList<Integer> list = new ArrayList<>();
			
			int sum = 0;
			
			for(int i = 1; i < N; i++) {
				if(N % i == 0) {
					list.add(i);
					sum += i;
				}
			}
			sb.append(N);
			if(N == sum) {
				sb.append(" = ");
				for(int i = 0; i < list.size() - 1; i++) {
					sb.append(list.get(i) + " + ");
				}
				sb.append(list.get(list.size() - 1));
			}else {
				sb.append(" is NOT perfect.");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
