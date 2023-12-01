import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int D = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		double pow = Math.pow(D, 2) / (Math.pow(H, 2) + Math.pow(W, 2));
		double sqrt = Math.sqrt(pow);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append((int) (sqrt * H)).append(" ") .append((int) (sqrt * W));
		System.out.println(sb);
	}
}
