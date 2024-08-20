import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int score = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		
		int ans = 1;
		int last = 0;
		for(int i = 0; i < N; i++) {
			if(i == 0) st = new StringTokenizer(in.readLine());
			int num = Integer.parseInt(st.nextToken());
			if(num > score) ans++;
			if(ans > P) ans = -1;
			if(i == N - 1) last = num;
		}
		
		if(P <= N && last >= score) ans = -1;
		System.out.println(ans);
	}
}
