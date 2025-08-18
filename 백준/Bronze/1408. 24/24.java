import java.io.*;
import java.util.*;
import java.time.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), ":");
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		int now = (h * 3600) + (m * 60) + s;
		
		st = new StringTokenizer(br.readLine(), ":");
		
		h = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		int start = (h * 3600) + (m * 60) + s;
		
		int time = 0;
		
		if(start > now) {
			time = start - now;
		} else {
			time = (24 * 3600) - (now - start);
		}

        int hour = time / 3600;
        int minute = (time % 3600) / 60;
        int second = time % 60;

        System.out.printf("%02d:%02d:%02d\n", hour, minute, second);
	}
}
