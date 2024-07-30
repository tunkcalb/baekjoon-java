import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		max = -Integer.MAX_VALUE;
		
		N = Integer.parseInt(in.readLine());
		
		List<Integer> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		gather(list, 0);
		System.out.println(max);
		
	}

	private static void gather(List<Integer> list, int sum) {
		
		if(list.size() == 2) {
			max = Math.max(max, sum);
			return;
		}
		for(int i = 1; i < list.size() - 1; i++) {
			int tmp = list.get(i);
			int value = list.get(i - 1) * list.get(i + 1);
			list.remove(i);
			gather(list, sum + value);
			list.add(i, tmp);
		}
		
	}
}
