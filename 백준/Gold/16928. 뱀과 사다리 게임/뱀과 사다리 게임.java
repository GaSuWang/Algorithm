import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] ladder = new int[N][2];
		int[][] snake = new int[M][2];
		boolean[] check = new boolean[101];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			ladder[i][0] = Integer.parseInt(st.nextToken());
			ladder[i][1] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			snake[i][0] = Integer.parseInt(st.nextToken());
			snake[i][1] = Integer.parseInt(st.nextToken());
		}
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { 1, 0 });
		check[1] = true;
		while (!queue.isEmpty()) {
			int cur[] = queue.poll();
			if (cur[0] == 100) {
				System.out.println(cur[1]);
				return;
			}
			outer: for (int i = 1; i < 7; i++) {
				int next = cur[0] + i;
				if (next > 100)
					continue;
				if (check[next])
					continue;
				for (int j = 0; j < N; j++) {
					if (ladder[j][0] == cur[0] + i) {
						next = ladder[j][1];
						queue.offer(new int[] { next, cur[1] + 1 });
						continue outer;
					}
				}
				for (int j = 0; j < M; j++) {
					if (snake[j][0] == cur[0] + i) {
						next = snake[j][1];
						queue.offer(new int[] { next, cur[1] + 1 });
						continue outer;
					}

				}

				queue.offer(new int[] { next, cur[1] + 1 });
				check[next] = true;
			}
		}

	}
}