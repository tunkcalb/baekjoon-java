import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 20;
		int cnt = N;
		double totalSum = 0;
        double scoreSum = 0;
		HashMap<String, Double> map = new HashMap<>();
		map.put("A+", 4.5);
		map.put("A0", 4.0);
		map.put("B+", 3.5);
		map.put("B0", 3.0);
		map.put("C+", 2.5);
		map.put("C0", 2.0);
		map.put("D+", 1.5);
		map.put("D0", 1.0);
		map.put("F", 0.0);
		map.put("P", 0.0);

		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			
			double score = Double.parseDouble(st.nextToken());
			String grade = st.nextToken();
			
			if(grade.equals("P")) {
				cnt--;
				continue;
			}
			scoreSum += score;
			totalSum += score * map.get(grade);
		}
		
		totalSum /= scoreSum;
		System.out.println(totalSum);
	}
}
