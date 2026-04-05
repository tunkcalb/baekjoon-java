import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String jinho = br.readLine();
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			
			if(jinho.equals(line)) cnt++;
		}
		
		System.out.println(cnt);
	}
}
