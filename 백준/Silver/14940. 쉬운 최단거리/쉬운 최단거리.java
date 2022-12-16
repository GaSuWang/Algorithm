import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int [][] map = new int[N][M];
		int [][] check = new int[N][M];
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		
		Queue<int[]> queue = new LinkedList<int[]>();
		
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				check[i][j] = 10000000;
				if(map[i][j]==2) {
					queue.offer(new int[] {i,j});
					check[i][j] = 0;
				}
			}
		}
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for(int i=0; i<4;i++) {
				int nextX = cur[1] + dx[i];
				int nextY = cur[0] + dy[i];
				if(nextX<0||nextX>=M||nextY<0||nextY>=N) continue;
				if(map[nextY][nextX]==0) continue;
				if(check[nextY][nextX]<=check[cur[0]][cur[1]]+1) continue;
				queue.offer(new int[] {nextY,nextX});
				check[nextY][nextX] = check[cur[0]][cur[1]]+1;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N;i++) {
			for(int j=0;j<M;j++) {
				if(check[i][j]== 10000000) {
					check[i][j] = map[i][j] *-1;
				}
				sb.append(check[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}