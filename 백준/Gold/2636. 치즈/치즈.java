import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][M];
		//시간, 남은 치즈 칸
		int t;
		int cheese = 0;
		//입력 받기, 처음 치즈 칸 세기
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) cheese++;
			}
		}
		//1시간 지난 뒤 치즈 칸
		int temp=0;
		//치즈가 없어질 때까지 반복
		for(t=1;;t++) {
			//bfs 
			map = bfs(map,N,M);
			//치즈 칸 세기
			temp = check(map,N,M);
			//이번에 모두 없어졌다면 반복 중지
			if(temp==0) {
				break;
			}
			//남은 치즈 칸 수를 현재로 갱신
			cheese = temp;
			
		}
		
		System.out.println(t);
		System.out.println(cheese);
	}
	
	//치즈 칸 세기
	public static int check(int [][] map, int N, int M) {
		int res =0;
		for(int i=0; i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==1) res++;
			}
		}
		return res;
	}
	//map 복사
	public static int [][] copy(int [][]map,int N, int M){
		int[][] resMap = new int[N][M];
		for(int i=0; i<N;i++) {
			for(int j=0;j<M;j++) {
				//값이 2이면 이번에 사라진 치즈 칸, 0으로 만들어주기
				if(map[i][j]==2||map[i][j]==-1) resMap[i][j] = 0;
				
				else resMap[i][j] = map[i][j];
			}
		}
		return resMap;
	}
	
	public static int[][] bfs(int [][]map, int N, int M){
		int [] dx= {1,0,-1,0};
		int [] dy= {0,1,0,-1};
		
		
		Queue<int[]> queue = new LinkedList<int[]>();
		//bfs시작점 찾기

		queue.offer(new int[] {0,0});
		map[0][0] = -1;
					
		//bfs
		while(!queue.isEmpty()) {
			int [] cur = queue.poll();
			//4방탐색
			for(int i=0; i<4;i++) {
				int nextX = cur[1] + dx[i];
				int nextY = cur[0] + dy[i];
				//범위 나가면 건너뜀
				if(nextX<0||nextX>=M||nextY<0||nextY>=N) continue;
				//이미 체크했으면 건너뜀
				if(map[nextY][nextX]==-1) continue;
				//이번에 만난 치즈칸은 없어지는 칸, 2로 갱신
				else if(map[nextY][nextX]==1) map[nextY][nextX] = 2;
				//빈칸이면 큐에 넣기
				else if(map[nextY][nextX]==0) {
					queue.offer(new int[] {nextY,nextX});
					map[nextY][nextX] = -1;
				}
			}
			
		}
		//갱신된 배열 반환
		int[][] newMap = copy(map,N,M);
		return newMap;
	}
}