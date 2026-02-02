import java.io.*;
import java.util.*;

public class Main {
	
	static long p;
	static long q;
	static Map<Long, Long> map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N = Long.parseLong(st.nextToken());
		p = Long.parseLong(st.nextToken());
		q = Long.parseLong(st.nextToken());
		
		map = new HashMap<>();
		System.out.println(get(N));
	}

	private static long get(long n) {
		if(n == 0) return 1;
		if(map.containsKey(n)) return map.get(n);
		
		long a = (long) Math.floor(n / p);
		long b = (long) Math.floor(n / q);
		
		map.put(n, get(a) + get(b));
		return map.get(n);
	}
}
