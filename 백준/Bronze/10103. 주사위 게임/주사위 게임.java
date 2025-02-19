import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 100;
		int n = Integer.parseInt(br.readLine());
		
		int A = N;
		int B = N;
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a < b) {
				A -= b;
			}
			else if(a > b){
				B -= a;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(A).append("\n");
		sb.append(B);
		System.out.println(sb);
	}
}
