import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), "/");
		
		int K = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		
		String ans = "gosu";
		
		if(K + A < D || D == 0) ans = "hasu";
		
		System.out.println(ans);
	}
}
