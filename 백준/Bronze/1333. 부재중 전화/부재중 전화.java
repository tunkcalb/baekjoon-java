import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < L; j++) {
				list.add(1);
			}
			for(int j = 0; j < 5; j++) {
				list.add(0);
			}
		}
		
		int time = 0;
		
		while(true) {
			if(time >= list.size()) {
				break;
			}
			
			if(list.get(time) == 0) break;
			else time += D;
		}
		
		System.out.println(time);
	}
}
