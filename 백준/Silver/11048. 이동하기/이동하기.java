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
		int [][] map = new int[N][M];
		int [][] sum = new int[N][M];
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int dx[] = {1,0,1};
		int dy[] = {0,1,1};
		sum[0][0] = map[0][0];
		for(int i=0; i<N;i++) {
			for(int j=0;j<M;j++) {
				for(int k=0;k<3;k++) {
					int nextX = j+dx[k];
					int nextY = i +dy[k];
					if(nextX<0||nextX>=M||nextY<0||nextY>=N) continue;
					sum[nextY][nextX] = Math.max(sum[nextY][nextX], sum[i][j]+map[nextY][nextX]);
				}
			}
		}
		System.out.println(sum[N-1][M-1]);
	}
}
