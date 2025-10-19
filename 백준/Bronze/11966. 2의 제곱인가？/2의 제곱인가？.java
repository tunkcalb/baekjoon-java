import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int ans = 0;
		
		for(int i = 0; i < 31; i++) {
			if(Math.pow(2, i) == N) {
				ans = 1;
				break;
			}
		}
		
		System.out.println(ans);
	}
}
