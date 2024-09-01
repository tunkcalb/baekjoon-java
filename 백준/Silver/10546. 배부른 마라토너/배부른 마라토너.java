import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		HashSet<String> set = new HashSet<>();
		for(int i = 0; i < N * 2 - 1; i ++) {
			String name = in.readLine();
			if(set.contains(name)) {
				set.remove(name);
			}
			else set.add(name);
		}
		
		for(String name : set) {
			System.out.println(name);
		}
	}
}
