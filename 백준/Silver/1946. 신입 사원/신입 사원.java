import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(in.readLine());
			
			ArrayList<Grade> list = new ArrayList<>();
			
			for(int i = 0; i < N; i ++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				list.add(new Grade(a, b));
			}
			
			Collections.sort(list, (o1, o2) -> o1.a - o2.a);
			
			int ans = 1;
			int min = list.get(0).b;
			for(int i = 1; i < N; i++) {
				if(list.get(i).b < min) {
					ans++;
					min = list.get(i).b;
				}
			}
			System.out.println(ans);
		}
		
	}
	
	static class Grade {
		int a;
		int b;
		
		Grade(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
}
