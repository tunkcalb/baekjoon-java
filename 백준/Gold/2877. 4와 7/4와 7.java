import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(in.readLine());
		
		K++;
		StringBuilder sb = new StringBuilder();
		
		int num = 0;
		
		while(K != 0) {
			num = K % 2;
			sb.append(num);
			K /= 2;
		}
		
		StringBuilder ans = new StringBuilder();
		for(int i = sb.toString().length() - 2; i >= 0; i--) {
			if(sb.charAt(i) == '0') ans.append(4);
			else ans.append(7);
		}
		System.out.println(ans);
	}
}
