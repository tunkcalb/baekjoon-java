import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int D = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		int time = 0;
		if(A < 0) {
			time += C * (-A);
			time += D;
			time += E * B;
		}
		else {
			time += (B - A) * E;
		}
		
		System.out.println(time);
	}
}
