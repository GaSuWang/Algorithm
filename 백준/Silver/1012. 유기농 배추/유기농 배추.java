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

public class Main {
	static int M;
	static int N;
	static int K;
	static int map [][];
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		// 노래 사이 5초 시간, D초에 한번 1초만
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			for(int i=0; i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			int res = 0;
			for(int i=0; i<N;i++) {
				for(int j=0; j<M;j++) {
					if(map[i][j]==0) continue;
					dfs(j,i);
					res++;
				}
			}
			System.out.println(res);
		}
	}

	private static void dfs(int x, int y) {
		map[y][x] = 0;
		for(int i=0;i<4;i++) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];
			if(nextX<0||nextX>=M||nextY<0||nextY>=N) continue;
			if(map[nextY][nextX]==0) continue;
			dfs(nextX,nextY);
		}
		return;
	}
}
