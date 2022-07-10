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
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int [][] map = new int[N+1][M];
		int dx[] = {1,0,-1,0};
		int dy[] = {0,1,0,-1};
		float avg = 0;
		for(int i=1; i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				avg +=map[i][j];
			}
		}
		
		avg = avg/(M*N);
		Queue<int[]> queue =new LinkedList<>(); 
		for(int t=0; t<T;t++) {
			st = new StringTokenizer(br.readLine());
			int X= Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			for(int i=X,num=1; i<N+1;i=X*(++num)) { // 돌릴 원판
				for(int j=0;j<(D==0?1:M-1)*K;j++) { // 회전시키기
					int temp = map[i][M-1];
					for(int k=M-1; k>0;k--) {
						map[i][k] = map[i][k-1];
					}
					map[i][0] = temp;
				}
			}
			boolean flag = false;
			for(int i=1; i<N+1;i++) {
				for(int j=0; j<M;j++) {
					if(map[i][j]==0)continue;
					queue.offer(new int[] {j,i,map[i][j]});
					while(!queue.isEmpty()){
						int [] cur = queue.poll();
						for(int k=0;k<4;k++) {
							int nextX = cur[0] + dx[k];
							int nextY = cur[1] + dy[k];
							if(nextY<1||nextY>N) continue;
							if(nextX<0) nextX = M-1;
							else if(nextX>=M) nextX = 0;
							if(map[nextY][nextX]!=cur[2]) continue;
							queue.offer(new int[] {nextX,nextY,map[nextY][nextX]});
							flag = true;
							map[nextY][nextX] = 0;
						}
					}
				}
			}
			if(!flag) {
				for(int i=1;i<N+1;i++) {
					for(int j=0; j<M;j++) {
						if(map[i][j]==0) continue;
						if(map[i][j]>avg) map[i][j]--;
						else if(map[i][j]<avg) map[i][j]++;
					}
				}			
			}
			avg = 0;
			int count = 0;
			for(int i=1;i<N+1;i++) {
				for(int j=0; j<M;j++) {
					if(map[i][j]==0) continue;
					avg += map[i][j];
					count++;
				}
			}
			avg/=count;

		}
		int res = 0;
		for(int i =1;i<N+1;i++) {
			for(int j=0;j<M;j++) {
				res += map[i][j];
			}
		}
		System.out.println(res);
	}
}



