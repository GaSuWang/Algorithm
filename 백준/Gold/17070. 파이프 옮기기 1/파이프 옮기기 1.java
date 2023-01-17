
////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int map[][] = new int[N][N];
		StringTokenizer st;
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if(map[N-1][N-1]==1) {
			System.out.println(0);
			return;
		}
		Queue<int[]> queue = new LinkedList<>();
		int countMap[][] = new int[N+1][N+1];
		queue.offer(new int[] {0,1,0});//y,x,놓인형태(0=가로 1=세로 2=대각선)
		countMap[0][1] = 1;
		while(!queue.isEmpty()) {
			int [] cur = queue.poll();
			//가로일때
			int nextX=cur[1];
			int nextY=cur[0];
			if(nextX>=N||nextY>=N) continue;
			if(cur[2]==0) {
				//오른쪽으로 밀때
				nextX++;
				if(nextX>=N) continue;
				if(map[nextY][nextX]==1) continue;
				queue.offer(new int[] {nextY,nextX,0});
				countMap[nextY][nextX]++;
				//대각선으로
				nextY++;
				if(nextY>=N) continue;
				if(map[nextY][nextX]==1||map[nextY][cur[1]]==1) continue;
				queue.offer(new int[] {nextY,nextX,2});
				countMap[nextY][nextX] ++;
			}
			//세로일때
			else if(cur[2]==1) {
				//아래로 밀때
				nextY++;
				if(nextY>=N) continue;
				if(map[nextY][nextX]==1) continue;
				queue.offer(new int[] {nextY,nextX,1});
				countMap[nextY][nextX]++;
				//대각선으로
				nextX++;
				if(nextX>=N) continue;
				if(map[nextY][nextX]==1||map[cur[0]][nextX]==1) continue;
				queue.offer(new int[] {nextY,nextX,2});
				countMap[nextY][nextX]++;
			}
			//대각선일때
			else {
				//오른쪽
				nextX++;
				if(nextX<N && map[nextY][nextX]!=1) {
					queue.offer(new int[] {nextY,nextX,0});
					countMap[nextY][nextX] ++;
				}
				nextX--;
				//아래
				nextY++;
				if(nextY>=N) continue;
				if(map[nextY][nextX]==1) continue;
				queue.offer(new int[] {nextY,nextX,1});
				countMap[nextY][nextX] ++;
				
				//대각선으로
				nextX++;
				if(nextX>=N) continue;
				if(map[nextY][nextX]==1||map[cur[0]][nextX]==1) continue;
				queue.offer(new int[] {nextY,nextX,2});
				countMap[nextY][nextX] ++;
			}
		}
		System.out.println(countMap[N-1][N-1]);
	}
}