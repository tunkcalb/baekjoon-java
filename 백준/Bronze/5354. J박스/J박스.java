import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			if(N == 1) {
				sb.append("#");
			}
			else {				
				for(int i = 0; i < N; i++) {
					sb.append("#");
				}
				sb.append("\n");
				
				for(int i = 0; i < N - 2; i++) {
					sb.append("#");
					for(int j = 0; j < N - 2; j++) {
						sb.append("J");
					}
					sb.append("#").append("\n");
				}
				
				for(int i = 0; i < N; i++) {
					sb.append("#");
				}
			}
			sb.append("\n\n");
		}
		
		System.out.println(sb);
	}
}
