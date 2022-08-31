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
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		char[][] map = new char[H][W];
		int dx []= {1,0,-1,0};
		int dy[] = {0,1,0,-1};
		int w = 0;
		int b = 0;
		for(int i=0; i<H;i++) {
			char[]temp = br.readLine().toCharArray();
			for(int j=0;j<W;j++) {
				map[i][j] = temp[j];
			}
		}
		Queue<int []> queue = new LinkedList<int[]>();
		for(int i=0; i<H;i++) {
			for(int j=0; j<W;j++) {
				if(map[i][j]=='X') continue;
				boolean isWhite = map[i][j]=='W'?true:false;
				int count = 0;
				char curChar = map[i][j];
				map[i][j] = 'X';
				queue.offer(new int[] {i,j});
				while(!queue.isEmpty()) {
					count++;
					int[] cur = queue.poll();
					for(int k=0; k<4;k++) {
						int nextX =cur[1] +dx[k];
						int nextY = cur[0] +dy[k];
						if(nextX<0||nextX>=W||nextY<0||nextY>=H) continue;
						if(map[nextY][nextX]!=curChar) continue;
						map[nextY][nextX] = 'X';
						queue.offer(new int[] {nextY,nextX});
					}
				}
				if(isWhite) {
					w += (count*count);
				}
				else {
					b += (count*count);
				}
			}
		}
		System.out.println(w+" "+b);
	}
	
}

