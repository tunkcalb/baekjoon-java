import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	static int N;
	static ArrayList<Long> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		list = new ArrayList<>();
		
		if(N <= 10) System.out.println(N);
		else if(N > 1022) System.out.println(-1);
		else {
			for(int i = 0; i < 10; i++) {
				func(i, 1);
			}
			Collections.sort(list);
			System.out.println(list.get(N));
		}
	}

	private static void func(long num, int idx) {
		if(idx > 10) return;
		
		list.add(num);
		for(int i = 0; i < num % 10; i++) {
			func((num * 10) + i, idx + 1);
		}
		
	}
}
