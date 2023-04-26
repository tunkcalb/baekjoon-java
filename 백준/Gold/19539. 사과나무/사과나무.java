import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int tmp;
		int sum = 0;
		int num = 0;
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			tmp = Integer.parseInt(st.nextToken());
			sum += tmp;
			if(tmp % 2 == 1) {
				num++;
			}
		}
		
		if(sum % 3 == 0 && num <= sum/3) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
}
