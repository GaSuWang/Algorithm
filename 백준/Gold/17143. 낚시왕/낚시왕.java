
////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Shark{
		int x;
		int y;
		int speed;
		int dir;
		int size;
		boolean isDie;
		Shark(int y,int x, int s, int d, int z){
			this.x = x;
			this.y = y;
			this.speed = s;
			this.dir = d;
			this.size = z;
			this.isDie = false;
		}
		@Override
		public String toString() {
			return "Shark [x=" + x + ", y=" + y + ", speed=" + speed + ", dir=" + dir + ", size=" + size + ", isDie="
					+ isDie + "]";
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int dx [] = {0,1,0,-1};
		int dy [] = {-1,0,1,0};
		List<Shark> list = new ArrayList<Shark>();
		int [][] map = new int[R][C];
		int	[][] newMap;
		for(int i=0; i<R;i++) {
			Arrays.fill(map[i],-1);
		}
		for(int i=0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken())-1;
			if(d==1) d=2;
			else if(d==2) d=1;
			int z = Integer.parseInt(st.nextToken());
			list.add(new Shark(y,x,s,d,z));
			map[y][x] = i;
		}
		int res=0;
		for(int i=0;i<C;i++) {
//			System.out.println("--------------");
//			for(int j=0; j<R;j++) {
//				
//				System.out.println(Arrays.toString(map[j]));
//			}
			//낚시꾼 낚시
			//현재 C기준으로 R확인
			for(int j=0;j<R;j++) {
				if(map[j][i]!=-1) {
					//map에서 -1이 아닌 다른 수 찾으면 그 숫자 상어 잡음
					Shark target = list.get(map[j][i]);
					//격자판에서 상어 사라짐
					map[j][i] = -1;
					res+=target.size;
					//상어 죽음처리
					target.isDie=true;
					//낚시꾼 턴 끝
					break;
				}
			}
			//상어 움직임
			newMap = new int[R][C];
			for(int j=0;j<R;j++) {
				Arrays.fill(newMap[j],-1);
			}
			for(int j=0;j<M;j++) {
				Shark cur = list.get(j);
				//살아있는 상어만 움직임
				if(cur.isDie) continue;
				//상어 시작 위치 -1로 바꿈
				map[cur.y][cur.x] = -1;
				int nextX = cur.x;
				int nextY = cur.y;
				for(int k=0;k<cur.speed;k++) {
					nextX = nextX + dx[cur.dir];
					nextY = nextY + dy[cur.dir];
					if(nextX<0||nextY<0||nextX>=C||nextY>=R) {
						//방향 반대로
						nextX = nextX - dx[cur.dir];
						nextY = nextY - dy[cur.dir];
						cur.dir=(cur.dir+2)%4;
						k--;
						continue;
					}
				}
				//도착한 위치에 다른 상어가 있다면
				if(newMap[nextY][nextX]!=-1) {
					Shark other = list.get(newMap[nextY][nextX]);
					//위치에 있던 상어랑 비교
					//작은쪽 죽이기
					if(other.size>cur.size) {
						//방금 움직인 상어가 죽은거면 이후 처리안하고 건너뜀
						cur.isDie = true;
						continue;
					}
					else {
						//다른상어가 죽으면
						other.isDie = true;
					}
					
				}
				//위치 갱신
				newMap[nextY][nextX] = j;
				cur.x = nextX;
				cur.y = nextY;
			}
			map = newMap;
		}
		System.out.println(res);
	}
}