
////
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		char[][] map = new char[H][W];
		int dx[] = {0,1,0,-1};
		int dy[] = {1,0,-1,0};
		for(int i=0; i<H;i++) {
			char[]temp = br.readLine().toCharArray();
			for(int j=0; j<W;j++) {
				map[i][j] = temp[j];
			}
		}
		Queue<int[]> queue = new LinkedList<int[]>();
		for(int i=0; i<W;i++) {
			if(map[0][i]=='1') continue;
			queue.offer(new int[] {0,i});
			map[0][i] = '1';
			while(!queue.isEmpty()) {
				int cur[] = queue.poll();
				if(cur[0]==H-1) {
					System.out.println("YES");
					return;
				}
				for(int j=0; j<4;j++) {
					int nextX  = cur[1]+dx[j];
					int nextY = cur[0] +dy[j];
					if(nextX<0||nextX>=W||nextY<0||nextY>=H) continue;
					if(map[nextY][nextX]!='0') continue;
					map[nextY][nextX] = '1';
					queue.offer(new int [] {nextY,nextX});
				}
			}
		}
		System.out.println("NO");
	}
	
}

