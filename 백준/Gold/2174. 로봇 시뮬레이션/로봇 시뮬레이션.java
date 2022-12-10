import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Robot{
		int x;
		int y;
		int dir;
		
		Robot(int x, int y, char dir){
			this.x=x;
			this.y=y;
			if(dir=='E') {
				this.dir=0;
			}
			else if(dir=='N') {
				this.dir=1;
			}
			else if(dir=='W') {
				this.dir=2;
			}
			else if(dir=='S') {
				this.dir=3;
			}
		}

		@Override
		public String toString() {
			return "Robot [x=" + x + ", y=" + y + ", dir=" + dir + "]";
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int [] dx = {1,0,-1,0};
		int [] dy = {0,1,0,-1};
		char map[][] = new char[B][A];
		Robot robots[] = new Robot[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			map[y][x] =  (char) ((i+1)+'0');
			robots[i] = new Robot(x, y, st.nextToken().charAt(0));
		}
		
		for(int c = 0; c<M;c++) {
			st = new StringTokenizer(br.readLine());
			int robot = Integer.parseInt(st.nextToken())-1;
			char command = st.nextToken().charAt(0);
			int num = Integer.parseInt(st.nextToken());
			Robot cur = robots[robot];
			if(command == 'L') {
				for(int i=0;i<num;i++) {
					cur.dir = (cur.dir + 1)%4;
				}
			}
			else if(command == 'R') {
				for(int i=0;i<num;i++) {
					cur.dir=cur.dir-1<0?3:cur.dir-1;
				}
			}
			else if(command == 'F') {
				//System.out.println(cur.toString());
				int curX = cur.x;
				int curY = cur.y;
				int dir = cur.dir;
				for(int i=0;i<num;i++) {
					int nextX = curX+dx[dir];
					int nextY = curY+dy[dir];
					if(nextX<0||nextX>=A||nextY<0||nextY>=B) {
						System.out.printf("Robot %d crashes into the wall",robot+1);
						return;
					}
					if(map[nextY][nextX]!=0) {
						System.out.printf("Robot %d crashes into robot %d",robot+1,map[nextY][nextX]-'0');
						return;
					}
					map[nextY][nextX] = map[curY][curX];
					map[curY][curX] = 0;
					curY = nextY;
					curX = nextX;
				}
				cur.x=curX;
				cur.y=curY;
			}
			robots[robot] = cur;
		}
//		for(int i=0; i<B;i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		System.out.println("OK");
	}
	
	
}