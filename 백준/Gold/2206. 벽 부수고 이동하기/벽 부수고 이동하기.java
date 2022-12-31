
////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		for(int i=0; i<N;i++) {
			map[i] = br.readLine().toCharArray();
		}
		boolean check[][][] = new boolean[N][M][2];
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {0,0,1,1});//y,x,벽뚫기
		int[] dx= {1,0,-1,0};
		int[] dy= {0,1,0,-1};
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			if(cur[0]==N-1&&cur[1]==M-1) {
				System.out.println(cur[3]);
				return;
			}
			for(int i=0; i<4;i++) {
				int nextY = cur[0] +dy[i];
				int nextX = cur[1] + dx[i];
				if(nextY<0||nextY>=N||nextX<0||nextX>=M) continue;
				if(map[nextY][nextX]=='1') {
					if(cur[2]==1) {
						queue.add(new int [] {nextY,nextX,0,cur[3]+1});
						check[nextY][nextX][1] = true; 
					}
				}
				else {
					if(cur[2]==1&&!check[nextY][nextX][0]) {
						queue.add(new int[] {nextY,nextX,1,cur[3]+1});
						check[nextY][nextX][0] = true; 
					}
					else if(cur[2]==0&&!check[nextY][nextX][1]) {
						queue.add(new int[] {nextY,nextX,0,cur[3]+1});
						check[nextY][nextX][1] = true;
					}
				}
			}
			
		}
		System.out.println(-1);
	}

}