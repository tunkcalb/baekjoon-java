import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		List<Integer> list = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(num == 0) list.add(i);
			else list.add(list.size() - num, i);
		}
		for(int num : list) {
			System.out.print(num + " ");
		}
	}
}
