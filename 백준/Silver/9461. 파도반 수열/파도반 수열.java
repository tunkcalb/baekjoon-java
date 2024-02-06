import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static long[] pado;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		pado = new long[101];
		pado[1] = 1;
		pado[2] = 1;
		pado[3] = 1;
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(in.readLine());
			System.out.println(getPado(N));
		}
	}

	private static long getPado(int n) {
		
		if(pado[n] == 0 && n != 0) {
			pado[n] = getPado(n - 2) + getPado(n - 3);
		}
		
		return pado[n];
	}
}
