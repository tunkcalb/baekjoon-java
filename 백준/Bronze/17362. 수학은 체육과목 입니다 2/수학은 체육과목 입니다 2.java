import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int idx = 1;
		int gap = 1;
		N %= 8;
		if(N == 0) idx = 2;
		for(int i = 1; i < N; i++) {
			idx += gap;
			
			if(idx <= 1 || idx >= 5) gap *= -1;
		}
		
		System.out.println(idx);
	}
}
