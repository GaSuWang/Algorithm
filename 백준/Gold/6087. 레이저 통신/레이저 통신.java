import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Item{
	int x;
	int y;
	int dir;
	int cnt;
	
	Item(int y, int x,int dir,int cnt){
		this.y = y;
		this.x = x;
		this.dir = dir;
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "Item [x=" + x + ", y=" + y + ", dir=" + dir +", cnt=" + cnt + "]";
	}
	
}

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		int [][] dis = new int[N][M];
		int [] start = new int[2];
		int [] end = new int[2];
		start[0] = -1;
		for(int i=0; i<N;i++) {
			char [] temp = br.readLine().toCharArray();
			for(int j=0; j<M;j++) {
				map[i][j] = temp[j];
				if(map[i][j]=='C') {
					if(start[0]==-1) {
						start[0] = i;
						start[1] = j;
					}
					else {
						end[0] = i;
						end[1] = j;
					}
				}
			}
		}
		for(int i=0; i<N;i++) {
			Arrays.fill(dis[i], 100000);
		}
		int [] dx = {1,0,-1,0};
		int [] dy = {0,1,0,-1};
		Queue<Item> queue = new LinkedList<Item>();
		dis[start[0]][start[1]] = 0;
		queue.offer(new Item(start[0],start[1],0,0));
		Item cur = queue.poll();
		for(int i=0; i<4;i++) {
			int nextX = cur.x + dx[i];
			int nextY = cur.y + dy[i];
			if(nextX<0||nextX>=M||nextY<0||nextY>=N) continue;
			if(map[nextY][nextX]=='*') continue;
			queue.offer(new Item(nextY,nextX,i,0));
			dis[nextY][nextX] = 0;
		}
		while(!queue.isEmpty()) {
			cur = queue.poll();
			int nextMirror;
			for(int i=0; i<4;i++) {
				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];
				
				if(nextX<0||nextX>=M||nextY<0||nextY>=N) continue;
				if(map[nextY][nextX]=='*') continue;
				if(cur.dir!=i) {
					  nextMirror = cur.cnt+1;
				}
				else nextMirror = cur.cnt;
				if(dis[nextY][nextX]<nextMirror) continue;
				queue.offer(new Item(nextY,nextX,i,nextMirror));
				dis[nextY][nextX] = nextMirror;
			}
			
		}
		System.out.println(dis[end[0]][end[1]]);
		
	}

}