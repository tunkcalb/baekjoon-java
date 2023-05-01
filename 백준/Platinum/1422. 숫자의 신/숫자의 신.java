import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	static int K, N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		String[] line = new String[N];
		Integer[] temp = new Integer[K];
		for(int i = 0; i < K; i++) {
			line[i] = in.readLine();
			temp[i] = Integer.parseInt(line[i]);
		}
		
		String answer = "";
		if( K < N) {
			Arrays.sort(temp, Collections.reverseOrder());
			for(int i = K; i < N; i++) {
				line[i] = temp[0] + "";
			}
		}
		
		Arrays.sort(line, new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
		});
		
		
		for(int i = 0; i < N; i++) {
			answer += line[i];
		}
		
		if(answer.charAt(0) == '0') System.out.println(0);
		else System.out.println(answer);
	}
}
