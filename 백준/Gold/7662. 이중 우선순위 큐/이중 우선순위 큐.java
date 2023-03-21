import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	static int T;
	static int k;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(in.readLine());
		
		for(int t = 0; t < T; t++) {
			k = Integer.parseInt(in.readLine());
			Map<Integer, Integer> map = new HashMap<>();
			PriorityQueue<Integer> minq = new PriorityQueue<>();
			PriorityQueue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());

			
			for(int i = 0; i < k; i++) {
				
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				char process = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());
				
				if(process == 'I') {
					map.put(num, map.getOrDefault(num, 0) + 1);
					minq.offer(num);
					maxq.offer(num);
				}else if (process == 'D') {
					if(map.size() == 0) continue;
					if(num == -1) {
						removeMap(minq,map);
						
					}else if(num == 1) {
						removeMap(maxq,map);
					}
					
				}
				
			}
			if(map.size() == 0) {
				sb.append("EMPTY").append("\n");
			}else {
				int n = removeMap(maxq, map);
				sb.append(n).append(" ");
				sb.append(map.size() > 0 ? removeMap(minq, map) : n).append("\n");
			}
			
		}
		
		System.out.println(sb);
	}

	private static int removeMap(PriorityQueue<Integer> que, Map<Integer, Integer> map) {
		int num;
		while(true) {
			num = que.poll();
			int count = map.getOrDefault(num, 0);
			
			if(count == 0) continue;
			if(count == 1) map.remove(num);
			else map.put(num,  count - 1);
			break;
		}
		return num;
	}
}