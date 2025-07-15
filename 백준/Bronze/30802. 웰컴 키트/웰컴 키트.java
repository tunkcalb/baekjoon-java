import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  
		  int N = Integer.parseInt(br.readLine());
		  StringTokenizer st = new StringTokenizer(br.readLine());		  
		  
		  int[] arr = new int[6];
		  for(int i = 0; i < 6; i++) {
			  arr[i] = Integer.parseInt(st.nextToken());
		  }
		  
		  st = new StringTokenizer(br.readLine());
		  int T = Integer.parseInt(st.nextToken());
		  int P = Integer.parseInt(st.nextToken());
		  
		  int cnt = 0;
		  for(int i = 0; i < 6; i++) {
			  cnt += arr[i] / T;
			  cnt = arr[i] % T > 0 ? cnt + 1 : cnt;
		  }
		  StringBuilder sb = new StringBuilder();
		  sb.append(cnt).append("\n");
		  sb.append(N / P).append(" ").append(N % P);
		  
		  System.out.println(sb);
	}
}
