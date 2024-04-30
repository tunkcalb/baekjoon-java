import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static char[] king;
	static char[] rock;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		king = st.nextToken().toCharArray();
		rock = st.nextToken().toCharArray();
		N = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N; i++) {
			String command = in.readLine();
			char[] nextKing = move(command, king);
			if(isRange(nextKing)) {
				if(nextKing[0] == rock[0] && nextKing[1] == rock[1]) {
					char[] nextRock = move(command, rock);
					if(isRange(nextRock) && (nextKing[0] != nextRock[0] || nextKing[1] != nextRock[1])) {
						king = nextKing;
						rock = nextRock;
					}
				}
				else king = nextKing;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(king[0]).append(king[1]).append("\n");
		sb.append(rock[0]).append(rock[1]);
		System.out.println(sb);
	}

	private static char[] move(String command, char[] now) {
		char[] next = now.clone();
		switch(command) {
		case "R":
			next[0]++;
			break;
		case "L":
			next[0]--;
			break;
		case "T":
			next[1]++;
			break;
		case "B":
			next[1]--;
			break;
		case "RT":
			next[0]++;
			next[1]++;
			break;
		case "LT":
			next[0]--;
			next[1]++;
			break;
		case "RB":
			next[0]++;
			next[1]--;
			break;
		case "LB":
			next[0]--;
			next[1]--;
		}
		return next;
	}

	private static boolean isRange(char[] next) {
		if(next[0] < 'A' || next[0] > 'H' || next[1] < '1' || next[1] > '8') return false;
		return true;
	}
}
