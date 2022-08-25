import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int map[][] = new int[n][m];
		int start[] = new int[2];
		int dx[]  = {1,0,-1,0};
		int dy[] = {0,1,0,-1};
		int min = 9*1000000+1;
		String resString = "NIE";
		for(int i=0; i<n;i++) {
			char[] line = br.readLine().toCharArray();
			for(int j=0;j<m;j++) {
				map[i][j] = line[j]-'0';
				if(map[i][j]==2) {
					start[0] = i;
					start[1] = j;
				}
			}
		}
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {start[0],start[1],0,2});//0 y, 1 x,2 d
		map[start[0]][start[1]] = 1;
		while(!q.isEmpty()) {
			int [] cur = q.poll();
			int curPlace = cur[3];
			if(curPlace ==3||curPlace==4||curPlace==5) {
				min = Math.min(min, cur[2]);
				resString = "TAK";
			}
			for(int i=0; i<4;i++) {
				int nextY = cur[0] + dy[i];
				int nextX = cur[1] + dx[i];
				if(nextX<0||nextX>=m||nextY<0||nextY>=n) continue;
				if(map[nextY][nextX]==1) continue;
				q.offer(new int[] {nextY,nextX,cur[2]+1,map[nextY][nextX]});
				map[nextY][nextX] = 1;
			}
		}
		System.out.println(resString);
		if(resString.equals("TAK")) {
			System.out.println(min);
		}
	}
}