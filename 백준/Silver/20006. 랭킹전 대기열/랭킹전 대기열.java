import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Player[] players = new Player[p];

		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(in.readLine());

			int lev = Integer.parseInt(st.nextToken());
			String name = st.nextToken();

			players[i] = new Player(lev, name);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < p; i++) {
			PriorityQueue<Player> pq = new PriorityQueue<>();

			if (!players[i].check) {
				int lev = players[i].lev;
				for (int j = i; j < p; j++) {

					if (pq.size() == m)
						break;

					int nowLev = players[j].lev;
					String name = players[j].name;
					if (players[j].check)
						continue;
					if (nowLev < lev - 10 || nowLev > lev + 10)
						continue;
					players[j].check = true;
					pq.offer(new Player(nowLev, name));
				}
				if (pq.size() == m) {
					sb.append("Started!").append("\n");
				} else
					sb.append("Waiting!").append("\n");
				
				int size = pq.size();
				for (int j = 0; j < size; j++) {
					Player player = pq.poll();
					sb.append(player.lev).append(" ").append(player.name).append("\n");
				}
			}
		}
		System.out.println(sb);
	}

	static class Player implements Comparable<Player> {
		int lev;
		String name;
		boolean check;

		Player(int lev, String name) {
			this.lev = lev;
			this.name = name;
			this.check = false;
		}

		@Override
		public int compareTo(Player o) {
			return name.compareTo(o.name);
		}

	}
}
