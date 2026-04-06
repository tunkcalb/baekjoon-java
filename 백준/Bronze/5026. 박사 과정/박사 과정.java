import java.io.*;
import java.util.*;
	
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			
			if(line.equals("P=NP")) sb.append("skipped");
			else {
				StringTokenizer st = new StringTokenizer(line , "+");

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				sb.append(a + b);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
