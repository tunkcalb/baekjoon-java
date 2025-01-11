import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		int value = n;
		
		HashSet<Integer> a = new HashSet<>();
		HashSet<Integer> b = new HashSet<>();
		
		while(true) {
			value = (value * n) % p;
			
			if(!a.add(value)) {
				if(!b.add(value)) break;
			}
		}
		
		System.out.println(b.size());
	}
}
