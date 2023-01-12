
////
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
		int dx[] = {1,0,-1,0};
		int dy[] = {0,1,0,-1};
		char[][] map = new char[N][M];
		int [][] dis = new int[N][M];
		Queue<int []> queue = new LinkedList<int[]>();
		for(int i=0; i<N;i++) {
			Arrays.fill(dis[i], N*M+1);
			String temp = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = temp.charAt(j);
				if(map[i][j]=='S') {
					queue.offer(new int[] {i,j});
					dis[i][j] = 0;
				}
			}
		}
		while(!queue.isEmpty()) {
			//물채우기
			map = fillWater(map,N,M);
			int size = queue.size();
			while(--size>=0) {
				int cur[] = queue.poll();
				for(int i=0;i<4;i++) {
					int nextX = cur[1] + dx[i];
					int nextY = cur[0] + dy[i];
					if(nextX<0||nextX>=M||nextY<0||nextY>=N) continue;
					if(map[nextY][nextX]=='D') {
						System.out.println(dis[cur[0]][cur[1]]+1);
						return;
					}
					if(map[nextY][nextX]!='.') continue;
					if(dis[nextY][nextX]<=dis[cur[0]][cur[1]]+1) continue;
					dis[nextY][nextX] = dis[cur[0]][cur[1]]+1;
					queue.offer(new int[] {nextY,nextX});
					
				}
			}
		}
		System.out.println("KAKTUS");
	}
	public static char[][] fillWater(char[][]map,int N,int M) {
		int dx[] = {1,0,-1,0};
		int dy[] = {0,1,0,-1};
		char [][] returnMap = new char[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				returnMap[i][j] = map[i][j];
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]!='*') continue;
				for(int k=0;k<4;k++) {
					int nextX = j+dx[k];
					int nextY = i+dy[k];
					if(nextX<0||nextY<0||nextX>=M||nextY>=N) continue;
					if(map[nextY][nextX]!='.') continue;
					returnMap[nextY][nextX] = '*';
				}
			}
		}
		return returnMap;
	}
}