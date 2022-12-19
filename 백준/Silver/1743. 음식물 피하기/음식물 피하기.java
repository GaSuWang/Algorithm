////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int [][] map = new int[N][M];
		int group = 1;
		for(int i=0; i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			map[y][x] = 1;
		}
		
		int res = 0;
		int temp;
		int dx[] = {0,1,0,-1};
		int dy[] = {1,0,-1,0};
		Queue<int[]> queue = new LinkedList<int[]>();
		for(int i=0; i<N;i++) {
			for(int j=0; j<M;j++) {
				if(map[i][j]==0) continue;
				temp = 1;
				queue.offer(new int[] {i,j});
				map[i][j] = 0;
				while(!queue.isEmpty()) {
					int [] cur = queue.poll();
					for(int k=0; k<4;k++) {
						int nextX = cur[1] + dx[k];
						int nextY = cur[0] + dy[k];
						if(nextX<0||nextX>=M||nextY<0||nextY>=N) continue;
						if(map[nextY][nextX]==0) continue;
						temp++;
						queue.offer(new int[] {nextY,nextX});
						map[nextY][nextX] = 0;
					}
				}
				res = Math.max(res, temp);
			}
		}
		System.out.println(res);
	} 
}