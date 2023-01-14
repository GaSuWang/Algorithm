
////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Pos {
		int[] red;
		int[] blue;
		int dir;

		Pos(int[] red, int[] blue, int dir) {
			this.red = red;
			this.blue = blue;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Pos [red=" + Arrays.toString(red) + ", blue=" + Arrays.toString(blue) + ", dir=" + dir + "]";
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] target = new int[2];
		char[][] map = new char[N][M];
		boolean check[][][][] = new boolean[N][M][N][M];
		
		Pos start = new Pos(new int[2], new int[2], -3);
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp[j];
				if (map[i][j] == 'O') {
					target[0] = i;
					target[1] = j;
				} else if (map[i][j] == 'R') {
					start.red[0] = i;
					start.red[1] = j;
					map[i][j] = '.';
				} else if (map[i][j] == 'B') {
					start.blue[0] = i;
					start.blue[1] = j;
					map[i][j] = '.';
				}
			}
		}
		Queue<Pos> queue = new LinkedList<Pos>();
		queue.offer(start);
		check[start.red[0]][start.red[1]][start.blue[0]][start.blue[1]] = true;
		
		int iter = 0;
		int size;
//		int dx[] = {1,0,-1,0};//오0/아1/왼2/위3
//		int dy[] = {0,1,0,-1};
		
		while (!queue.isEmpty() && iter < 10) {
			iter++;
			size = queue.size();
			while (--size >=0) {
				Pos cur = queue.poll();
				for (int i = 0; i < 4; i++) {
					Pos next = moving(cur, i, map);
					if (next.blue[0] == 0 && next.blue[1] == 0)
						continue;
					if (next.red[0] == 0 && next.red[1] == 0) {
						System.out.println(iter);
						return;
					}
					if (check[next.red[0]][next.red[1]][next.blue[0]][next.blue[1]])
						continue;
					queue.offer(next);
					check[next.red[0]][next.red[1]][next.blue[0]][next.blue[1]] = true;
					
				}
			}
		}
		System.out.println(-1);

	}

	public static Pos moving(Pos cur, int dir, char[][] map) {
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		Pos next = new Pos(new int[] { -1, -1 }, new int[] { -1, -1 }, dir);
		boolean flagR = false;
		boolean flagB = false;
		int curX = cur.red[1];
		int curY = cur.red[0];
		while (true) {
			int nextX = curX + dx[dir];
			int nextY = curY + dy[dir];
			if (map[nextY][nextX] == '#')
				break;
			if (map[nextY][nextX] == 'O') {
				curX = 0;
				curY = 0;
				flagR = false;
				break;
			}
			if(nextY==cur.blue[0]&&nextX==cur.blue[1]) {
				flagR = true;
			}
			curX = nextX;
			curY = nextY;
		}
		
		if (flagR) {
			curX = curX - dx[dir];
			curY = curY - dy[dir];
		}
		next.red[0] = curY;
		next.red[1] = curX;
		curX = cur.blue[1];
		curY = cur.blue[0];
		while (true) {
			int nextX = curX + dx[dir];
			int nextY = curY + dy[dir];
			if (map[nextY][nextX] == '#')
				break;
			if (map[nextY][nextX] == 'O') {
				curX = 0;
				curY = 0;
				flagB = false;
				break;
			}
			if(nextY==cur.red[0]&&nextX==cur.red[1]) {
				flagB = true;
			}
			curX = nextX;
			curY = nextY;
		}
		
		if (flagB) {
			curX = curX - dx[dir];
			curY = curY - dy[dir];
		}
		next.blue[0] = curY;
		next.blue[1] = curX;
		return next;
	}
}