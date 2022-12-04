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
		Queue<int []> queue = null;
		int dx[] = {1,0,-1,0};
		int dy[] = {0,1,0,-1};
		StringTokenizer st = null;
		for(int t=1;;t++) {
			int N = Integer.parseInt(br.readLine());
			if(N==0) break;
			int map[][] = new int[N][N];
			int cost[][] = new int[N][N];
			for(int i=0; i<N;i++) {
				st = new StringTokenizer(br.readLine());
				Arrays.fill(cost[i], 400000);
				for(int j=0; j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			queue = new LinkedList<>();
			queue.offer(new int [] {0,0,map[0][0]});
			cost[0][0] = map[0][0];
			while(!queue.isEmpty()) {
				int [] cur = queue.poll();
				if(cur[0]==N-1&&cur[1]==N-1) continue;
				for(int i=0;i<4;i++) {
					int nextX = cur[1] + dx[i];
					int nextY = cur[0] + dy[i];
					if(nextX<0||nextX>=N||nextY<0||nextY>=N) continue;
					if(cost[nextY][nextX]<=cur[2]+map[nextY][nextX]) continue;
					queue.offer(new int [] {nextY,nextX,cur[2]+map[nextY][nextX]});
					cost[nextY][nextX] = cur[2] + map[nextY][nextX];
				}
 			}
			System.out.printf("Problem %d: %d\n",t,cost[N-1][N-1]);
		}
	}
}
