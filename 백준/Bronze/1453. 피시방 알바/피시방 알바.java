import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		StringTokenizer st = new StringTokenizer(in.readLine());
		
		HashSet<Integer> set = new HashSet<>();
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(set.contains(num)) sum++;
			else set.add(num);
		}
		System.out.println(sum);
	}
}