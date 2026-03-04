import java.io.*;
import java.util.*;

public class Main {
	
	static int S;
	static StringBuilder sb = new StringBuilder();
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = Integer.parseInt(br.readLine());
		visited = new boolean[2001][2001];
		
		bfs(new Emoticon(0, 1, 0));
		System.out.println(sb);
	}

	
	private static void bfs(Emoticon emoticon) {
		
		Queue<Emoticon> q = new LinkedList<>();
		q.add(emoticon);
		
		while(!q.isEmpty()) {
			Emoticon now = q.poll();
			int display = now.display;
			int clipboard = now.clipboard;
			int time = now.time;
			
			if(now.display == S) {
				sb.append(now.time);
				break;
			}
			
			if(!visited[display][display]) {
				visited[display][display] = true;
				q.add(new Emoticon(display, display, time + 1));
			}
			
			if(clipboard != 0 && display + clipboard <= 2000) {
				if(!visited[display + clipboard][clipboard]) {
					visited[display + clipboard][clipboard] = true;
					q.add(new Emoticon(clipboard, display + clipboard, time + 1));
				}
			}
			
			if(display > 0) {
				if(!visited[display - 1][clipboard]) {
					visited[display - 1][clipboard] = true;
					q.add(new Emoticon(clipboard, display - 1, time + 1));
				}
			}
		}
	}


	private static class Emoticon {
		int clipboard;
        int display;
        int time;

        public Emoticon(int clipboard, int display, int time) {
            this.clipboard = clipboard;
            this.display = display;
            this.time = time;
        }
    }
}
