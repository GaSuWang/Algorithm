////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] inputMap = new int[N][N];
		int[][] countMap = new int[N][N];
		int res = N*N+1;
		int dx[] = {1,0,-1,0};
		int dy[] = {0,1,0,-1};
		Queue<int[]> queue = new LinkedList<int[]>();
		for(int i=0;i<N;i++) {
			char[] line = br.readLine().toCharArray();
			for(int j=0; j<N;j++) {
				inputMap[i][j] = line[j]-'0';
				countMap[i][j] = N*N+1;
			}
		}
		countMap[0][0] = 0;
		queue.offer(new int[] {0,0,0});
		while(!queue.isEmpty()) {
			int [] cur = queue.poll();
			if(cur[0]==N-1&&cur[1]==N-1) {
				res = Math.min(cur[2],res);
			}
			
			for(int i=0; i<4;i++) {
				int nextX = cur[0] + dx[i];
				int nextY = cur[1] + dy[i];
				if(nextX<0||nextX>=N||nextY<0||nextY>=N) continue;
				if(countMap[nextY][nextX]<=cur[2]) continue;
				int count = inputMap[nextY][nextX]==1?cur[2]:cur[2]+1;
				countMap[nextY][nextX] = count;
				queue.offer(new int[] {nextX,nextY,count});
			}
		}
		System.out.println(res);
		
	}
	
}
