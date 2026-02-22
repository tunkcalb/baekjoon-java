import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		StringBuilder a = new StringBuilder();
		StringBuilder b = new StringBuilder();
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			
			for(int j = 0; j < M; j++) {
				char now = line.charAt(j);
				a.append(now);
				a.append(now);
			}
			a.append("\n");
		}
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M * 2; j++) {
				char now = line.charAt(j);
				b.append(now);
			}
			b.append("\n");
		}
		
		if(a.toString().equals(b.toString())) {
			System.out.println("Eyfa");
		}
		else {
			System.out.println("Not Eyfa");
		}
	}
}
