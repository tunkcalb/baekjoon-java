import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		HashSet<Integer> A = new HashSet<>();
		HashSet<Integer> B = new HashSet<>();
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < a; i ++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < b; i ++) {
			B.add(Integer.parseInt(st.nextToken()));
		}
		
		for(Object num : A.toArray()) {
			if(B.contains(num)) {
				B.remove(num);
				A.remove(num);
			}
		}
		System.out.println(A.size() + B.size());
	}
}
