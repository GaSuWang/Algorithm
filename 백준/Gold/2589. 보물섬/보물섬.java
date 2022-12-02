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
		char [][] map = new char[N][M];
		int [][] distance = new int [N][M];
		int dx [] = {1,0,-1,0};
		int dy [] = {0,1,0,-1};
		Queue <int[]> queue = new LinkedList<int[]>();
		for(int i=0; i<N;i++) {
			map[i] = br.readLine().toCharArray();
		}
		int res = 0;
		for(int i=0; i<N;i++) {
			for(int j=0; j<M;j++) {
				if(map[i][j]=='W') continue;
				for(int k=0;k<N;k++) {
					Arrays.fill(distance[k],3000);
				}
				
				queue.offer(new int[] {i,j});
				distance[i][j] = 0;
				while(!queue.isEmpty()) {
					int [] cur = queue.poll();
					
					for(int k=0;k<4;k++) {
						int nextX = cur[1] + dx[k];
						int nextY = cur[0] +dy[k];
						if(nextX<0||nextX>=M||nextY<0||nextY>=N) continue;
						if(map[nextY][nextX]=='W') continue;
						if(distance[nextY][nextX]!=3000) continue;
						queue.offer(new int[] {nextY,nextX});
						distance[nextY][nextX] = distance[cur[0]][cur[1]] +1;
						res = Math.max(res,distance[nextY][nextX]);
					}	
				}
			}
		}
		System.out.println(res);
		
	}
}
