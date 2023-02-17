import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	private static int N;

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num <= L) {
				L++;
			}else {
				list.add(num);
			}
		}
		Collections.sort(list);
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) <= L) {
				L++;
			}else {
				break;
			}
		}
		sb.append(L);
	
		System.out.println(sb);
	}
	
}
