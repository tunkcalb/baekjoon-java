import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int cnt = N;
		int idx = 1;
		int time = 1;
		while(true) {
			if(cnt < idx) {
				idx = 1;
				continue;
			}
			cnt -= idx;
			if(cnt == 0) break;
			idx++;
			time++;
		}
		System.out.println(time);
	}
}
