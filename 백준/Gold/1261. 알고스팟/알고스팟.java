import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


	static class Point implements Comparable<Point>{
		int x;
		int y;
		int cost;
		public Point(int x, int y, int cost) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.cost-o.cost;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int res = 0;
		int dx []= {0,0,-1,1};
		int dy []= {-1,1,0,0};
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int [][] map = new int[H][W];
		int [][] costMap = new int[H][W];
		boolean [][] check = new boolean[H][W];
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		for(int i=0;i<H;i++) {
			char temp[] = br.readLine().toCharArray();
			for(int j=0;j<W;j++) {
				map[i][j] = temp[j] - '0';
				costMap[i][j] = 100*100+1;
			}
		}
		pq.offer(new Point(0,0,0));
		costMap[0][0] = 0;
		check[0][0] = true;
		while(!pq.isEmpty()) {
			Point cur = pq.poll();
			if(cur.x==W-1&&cur.y==H-1) {
				res = cur.cost;
				break;
			}
			for(int i=0;i<4;i++) {
				int nextX = cur.x+dx[i];
				int nextY = cur.y+dy[i];
				if(nextX<0||nextX>=W||nextY<0||nextY>=H) continue;
				if(check[nextY][nextX]) continue;
				if(costMap[nextY][nextX]>costMap[cur.y][cur.x]+map[nextY][nextX]) {
					costMap[nextY][nextX] = cur.cost+map[nextY][nextX];
					pq.offer(new Point(nextX,nextY,costMap[nextY][nextX]));
					check[nextY][nextX]  =true;
				}
			}
		}
		System.out.println(res);
	}
}
