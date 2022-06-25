import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Monkey {
	int x;
	int y;
	int K;
	int count;

	public Monkey(int x, int y, int k, int count) {
		super();
		this.x = x;
		this.y = y;
		K = k;
		this.count = count;
	}

}

public class Main {

	public static void main(String[] args) throws IOException {
		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][M];
		boolean check[][][] = new boolean[N][M][K+1];
		int res = 40000;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		Queue<Monkey> queue = new LinkedList<>();
		check[0][0][K] = true;
		queue.offer(new Monkey(0, 0, K, 0));
		while (!queue.isEmpty()) {
			Monkey cur = queue.poll();
			if (cur.count > res)
				continue;
			if (cur.x == M - 1 && cur.y == N - 1) {
				res = Math.min(res, cur.count);
				continue;
			}
			for (int i = 0; i < 4; i++) {
				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];
				if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N)
					continue;
				if (map[nextY][nextX] == 1)
					continue;
				if (check[nextY][nextX][cur.K]) continue;
				check[nextY][nextX][cur.K] = true;
				queue.offer(new Monkey(nextX, nextY, cur.K, cur.count + 1));
			}
			if (cur.K > 0) {
				for (int i = 0; i < 4; i++) {
					int key = 1;
					for (int j = 0; j < 2; j++) {
						int nextX = cur.x + (dx[i] == 0 ? key : dx[i] * 2);
						int nextY = cur.y + (dy[i] == 0 ? key : dy[i] * 2);
						key *= -1;
						if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N)
							continue;
						if (map[nextY][nextX] == 1)
							continue;
						if (check[nextY][nextX][cur.K-1]) continue;
						check[nextY][nextX][cur.K-1] = true;
						queue.offer(new Monkey(nextX, nextY, cur.K - 1, cur.count + 1));
					}
				}

			}

		}
		System.out.println(res == 40000 ? -1 : res);
	}
}
