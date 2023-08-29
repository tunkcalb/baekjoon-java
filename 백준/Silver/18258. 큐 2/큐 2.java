import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		Queue<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		int num = 0;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			String command = st.nextToken();
			
			if(command.equals("push")) {
				int last = Integer.parseInt(st.nextToken());
				q.offer(last);
				num = last;
			}
			else if(command.equals("pop")) {
				if(q.isEmpty())sb.append(-1).append("\n");
				else sb.append(q.poll()).append("\n");
			}
			else if(command.equals("size")) {
				sb.append(q.size()).append("\n");
			}
			else if(command.equals("empty")) {
				if(q.isEmpty()) sb.append(1);
				else sb.append(0);
				sb.append("\n");
			}
			else if(command.equals("front")) {
				if(q.isEmpty()) sb.append(-1);
				else sb.append(q.peek());
				sb.append("\n");
			}
			else if(command.endsWith("back")) {
				if(q.isEmpty()) sb.append(-1);
				else sb.append(num);
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
