import java.io.*;

public class Main {
	
	static int N;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String num = in.readLine();
		N = Integer.parseInt(num);
		max = 0;
		
		dfs(0);
		System.out.println(max);
	}

	private static void dfs(int num) {
		if(num > N) return;
		
		max = Math.max(max, num);
		
		dfs(num * 10 + 7);
		dfs(num * 10 + 4);		
		
	}
}
