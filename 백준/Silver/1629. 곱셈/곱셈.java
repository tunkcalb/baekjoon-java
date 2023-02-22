import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	private static long C;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
				
		System.out.println(cal(A, B));
	}
		
	private static long cal(long A, long B) {
		if(B == 1) return A % C;
		
		long temp = cal(A, B / 2);
		
		if(B % 2 == 1) {	
			return(temp * temp % C) * A % C;
		}
		
		return (temp * temp) % C;
	}	
}