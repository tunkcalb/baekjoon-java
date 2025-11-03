import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sum = Integer.parseInt(st.nextToken());
		int dif = Integer.parseInt(st.nextToken());
		
		if(sum < dif || (sum - dif) % 2 != 0){
			System.out.println(-1);
			return;
		}
		int B = (sum - dif) / 2;
		int A = sum - B;
		
		StringBuilder sb = new StringBuilder();
		if((A + B) == sum && (A - B) == dif) {
			sb.append(A).append(" ").append(B);			
		}
		else sb.append(-1);
		System.out.println(sb);
	}
}
