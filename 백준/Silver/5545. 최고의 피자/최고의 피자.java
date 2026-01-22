import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int price = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int cal = Integer.parseInt(br.readLine());
		
		Integer[] cals = new Integer[N];
		for(int i = 0; i < N; i++) {
			cals[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(cals, Collections.reverseOrder());
		
		int max = cal / price;
		
		for(int i = 0; i < N; i++) {
			price += t;
			cal += cals[i];
			int tmp = cal / price;
			
			max = Math.max(max, tmp);
		}
		
		System.out.println(max);
	}
}
