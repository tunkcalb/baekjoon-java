import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		TreeSet<Integer> set = new TreeSet<>();
		st = new StringTokenizer(in.readLine());
		
		for(int i = 0; i < a; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(in.readLine());
		
		for(int i = 0; i < b; i++) {
			set.remove(Integer.parseInt(st.nextToken()));
		}
		
		if(set.size() == 0) {
			System.out.println(0);
			return;
		}
		
		System.out.println(set.size());
		
		for(int num : set) {
			System.out.print(num + " ");
		}
	}
}
