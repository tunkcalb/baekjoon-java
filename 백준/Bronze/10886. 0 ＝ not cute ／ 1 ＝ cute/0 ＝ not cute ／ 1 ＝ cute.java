import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[] cute = new int[2];
		
		for(int i = 0; i < N; i++) {
			int index = Integer.parseInt(in.readLine());
			cute[index]++;
		}
		
		if(cute[0] > cute[1]) {
			System.out.println("Junhee is not cute!");
		}
		else {
			System.out.println("Junhee is cute!");
		}
	}
}
