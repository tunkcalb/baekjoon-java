import java.io.*;
import java.util.*;

public class Main {
	
	static int w, h;
	static int p, q;
	static int t;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		p = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		t = Integer.parseInt(br.readLine());
		
		p = (p + t) % (2 * w);
		q = (q + t) % (2 * h);
		
		if(p > w) p = w - (p - w);
		if(q > h) q = h - (q - h);
		
		System.out.println(p + " " + q);
	}
}
