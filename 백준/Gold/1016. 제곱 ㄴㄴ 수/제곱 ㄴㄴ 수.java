import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		long min = Long.parseLong(st.nextToken());
		
		long max = Long.parseLong(st.nextToken());
		
		int size = (int) (max - min + 1);
		int sqrt = ((int) Math.sqrt(max));
		
		boolean[] check = new boolean[size];
		long[] num = new long[size];
		
		for (long i = 2; i <= sqrt; i++) {
			long square = i * i;
			long start = min / square;
			
			if(min % square != 0) start += 1;
			for(long j = start; j * square <= max; j++) {
				check[(int) (j * square - min)] = true;
			}
		}
		
		int count = 0;
		for(int i = 0; i < size; i++) {
			if(!check[i]) count++;
		}
		System.out.println(count);
	}
}
