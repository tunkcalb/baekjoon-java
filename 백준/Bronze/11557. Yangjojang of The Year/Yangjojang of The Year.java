import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(in.readLine());
			int max = 0;
			String name = "";
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				String school = st.nextToken();
				int consume = Integer.parseInt(st.nextToken());
				
				if(consume > max) {
					max = consume;
					name = school; 
				}
			}
			System.out.println(name);
		}
	}
}
