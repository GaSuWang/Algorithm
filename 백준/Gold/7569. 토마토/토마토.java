import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int map[][][] = new int[h][n][m];
		int countT = 0;
		int countW = 0;
		int dx[] = {1,0,-1,0,0,0};
		int dy[] = {0,1,0,-1,0,0};
		int dh[] = {0,0,0,0,1,-1};
		for(int i=0; i<h;i++) {
			for(int j=0; j< n;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<m;k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if(map[i][j][k]==1) countT++;
					else if(map[i][j][k]==-1) countW++;
				}
			}
		}
		if(countT+countW==m*n*h) {
			System.out.println(0);
			return;
		}
		Queue<int[]> queue = new LinkedList<int[]>();
		for(int i=0; i<h;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0; k<m;k++) {
					if(map[i][j][k]==1) {
						queue.offer(new int [] {k,j,i,0});//0 x 1 y 2 z 3 day
					}
				}
			}
		}
		int day =0;
		while(!queue.isEmpty()) {
			int [] cur = queue.poll();
			day = Math.max(day,cur[3]);
			for(int i =0; i<6; i++) {
				int nextX = cur[0]+dx[i];
				int nextY = cur[1]+dy[i];
				int nextH = cur[2]+dh[i];
				if(nextX<0||nextX>=m||nextY<0||nextY>=n||nextH<0||nextH>=h) continue;
				if(map[nextH][nextY][nextX]==-1||map[nextH][nextY][nextX]==1) continue;
				queue.offer(new int [] {nextX,nextY,nextH,cur[3]+1});
				map[nextH][nextY][nextX] =1;
			}
		}
		for(int i=0;i<h;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<m;k++) {
					if(map[i][j][k]==0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		System.out.println(day);
	}	

}

