import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char [][] map = new char[N][M];
		for(int i=0; i<N;i++) {
			map[i] = br.readLine().toCharArray();
		}
		int [] dx = {1,0,-1,0};
		int [] dy = {0,1,0,-1};
		int nextX;
		int nextY;
		int index;
		Queue<int[]> queue = new LinkedList<>();
		boolean check[][] = new boolean[N][M];
		for(int i=0; i<N;i++) {
			for(int j=0;j<M;j++) {
				if(check[i][j]) continue;
				check[i][j] = true;
				queue.offer(new int[] {i,j,0});
				while(!queue.isEmpty()) {
					int [] cur = queue.poll();
					//System.out.println(Arrays.toString(cur));
					for(int k = 0; k<2;k++) {
						index = (cur[2]+k)%4;
						nextX = cur[1] + dx[index];
						nextY = cur[0] + dy[index];
						if(nextX<0||nextX>=M||nextY<0||nextY>=N) continue;
						if(map[nextY][nextX]!=map[cur[0]][cur[1]]) continue;
						if(check[nextY][nextX]) {
							System.out.println("Yes");
							return;
						}
						queue.offer(new int[] {nextY,nextX,index});
						check[nextY][nextX] = true;
					}
				}
			}
		}
		System.out.println("No");
	}

}