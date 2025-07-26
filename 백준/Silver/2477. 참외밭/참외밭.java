import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = 6;
		List<Integer> point = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			point.add(Integer.parseInt(st.nextToken()));
		}
		
		point.add(point.get(0));
		
		int sum = 0;
		int area = 0;
		for(int i = 0; i < M; i++) {
			int tmp = point.get(i) * point.get(i + 1);
			area = Math.max(area, tmp);
			sum += tmp;
		}
		
		System.out.println(N * (sum - 2 * area));
	}
}
