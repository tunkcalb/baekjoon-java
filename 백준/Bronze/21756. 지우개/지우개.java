import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 1; i <= n; i++) {
			list.add(i);
		}
		
		while(list.size() != 1) {
			ArrayList<Integer> tmp = new ArrayList<>();
			for(int i = 1; i < list.size(); i += 2) {
				tmp.add(list.get(i));
			}
			list = tmp;
		}
		
		System.out.println(list.get(0));
	}
}
