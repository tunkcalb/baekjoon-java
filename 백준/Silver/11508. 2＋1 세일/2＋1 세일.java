import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		Integer[] goods = new Integer[N];
		
		for(int i = 0; i < N; i++) {
			goods[i] = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(goods, Comparator.reverseOrder());
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			if (i % 3 == 2) continue;
			sum += goods[i];
		}
		System.out.println(sum);
	}
}
