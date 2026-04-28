import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int bR = Integer.parseInt(st.nextToken());
		int bC = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int dR = Integer.parseInt(st.nextToken());
		int dC = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int jR = Integer.parseInt(st.nextToken());
		int jC = Integer.parseInt(st.nextToken());
		
		int bessie = Math.max(Math.abs(jR - bR), Math.abs(jC - bC));
		int daisy = Math.abs(jR - dR) + Math.abs(jC - dC);
		
		if(bessie == daisy) {
			System.out.println("tie");
		}
		else if(bessie < daisy) {
			System.out.println("bessie");
		}
		else {
			System.out.println("daisy");
		}
	}
}
