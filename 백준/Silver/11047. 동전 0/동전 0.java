import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K;
	static int[] coin;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		coin = new int[N];
		
		for(int i = 1; i <= N; i++) {
			coin[N - i] = Integer.parseInt(in.readLine());
		}
		
		
		int idx = 0;
		int money = K;
		int cnt = 0;
		while (money != 0) {
			if(coin[idx] <= money) {
				cnt += money / coin[idx];
				money %= coin[idx];
			}
			idx++;
		}
		
		System.out.println(cnt);
	}
}