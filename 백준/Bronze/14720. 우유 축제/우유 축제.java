import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = 3;
		
		int cnt = 0;
		int milk = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(num == milk) {
				cnt++;
				milk++;
				
				if(milk == M) milk = 0;
			}
		}
		
		System.out.println(cnt);	
	}
}
