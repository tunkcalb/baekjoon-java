import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		Score[] scores = new Score[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			String name = st.nextToken();
			int guk = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			
			scores[i] = new Score(name, guk, eng, math);
		}
		Arrays.sort(scores);
		
		for(int i = 0; i < N; i++) {
			System.out.println(scores[i].name);
		}
	}
	
	public static class Score implements Comparable<Score>{
		String name;
		int guk;
		int eng;
		int math;
		
		Score(String name, int guk, int eng, int math) {
			this.name = name;
			this.guk = guk;
			this.eng = eng;
			this.math = math;
		}

		@Override
		public int compareTo(Score o) {
			
			if(o.guk != this.guk) return o.guk - this.guk;
			if(o.eng != this.eng) return this.eng - o.eng;
			if(o.math != this.math)return o.math - this.math;
			return this.name.compareTo(o.name);
		}
	}
}
