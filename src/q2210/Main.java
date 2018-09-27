package q2210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int[][] map = new int[5][5];
	static StringBuffer s = new StringBuffer();
	static HashSet<String> N = new HashSet<>();

	public static void DFS(int i, int j, int cnt) {
		int k, l, ax, ay;
		s.append(map[i][j]);
		if (cnt == 6) {
			N.add(s.toString());
			return;
		}

		for (k = 0; k < 4; k++) {
			ax = i + dx[k];
			ay = j + dy[k];

			if (ax < 0 || ax >= 5 || ay < 0 || ay >= 5)
				continue;
			cnt++;
			DFS(ax, ay, cnt);
			s = s.deleteCharAt(cnt - 1);
			cnt--;
		}
	}

	public static void main(String[] args) throws IOException {
		int i, j;

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (i = 0; i < 5; i++) {
			st = new StringTokenizer(in.readLine());
			for (j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (i = 0; i < 5; i++) {
			for (j = 0; j < 5; j++) {
				s = new StringBuffer();
				DFS(i, j, 1);
			}
		}

		System.out.println(N.size());
		in.close();
	}
}
