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
		int [][] map = new int[N][M];
		//입력
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//빙산 덩어리 체크
		int flag = 1;
		//시간
		int count = 1;
		//반복
		while(true) {
			//빙산 녹이기
			map = melting(N,M,map);
			//빙산 덩어리 확인
			flag = check(N,M,map);
//			for(int i =0;i<N;i++) {
//				System.out.println(Arrays.toString(map[i]));
//				
//			}
//			System.out.println("------------");
			//만약 남아있는 빙산이 없으면
			if(flag ==0) {
				//0출력
				System.out.println(0);
				return;
			}
			//빙산이 2덩어리 이상 되면
			else if(flag==2) {
				//시간 출력
				System.out.println(count);
				return;
			}
			//1년 추가
			count++;
		}
	}
	public static int check(int N, int M, int[][] map) {
		//빙산 덩어리 반환, 없음, 1덩어리, 2덩어리 이상
		int res = 0;
		int [] dx = {1,0,-1,0};
		int [] dy = {0,1,0,-1};
		Queue<int []> queue = new LinkedList<>();
		boolean check[][] = new boolean[N][M];
		for(int i=0; i<N;i++) {
			for(int j=0; j<M;j++) {
				//빙산이 아니면 건너뜀
				if(map[i][j]==0) continue;
				//이미 체크한 빙산 건너뜀
				if(check[i][j]) continue;
				//몇번째 덩어리 빙산인지 체크하기 위함
				res++;
				//빙산이 한덩어리라면 res=1
				// res = 2라면 빙산이 2덩어리 이상 된다는 뜻 2반환 후 함수 종료
				if(res==2) {
					return res;
				}
				//시작 위치 큐에 넣기
				queue.offer(new int[] {i,j});
				//방문처리
				check[i][j] = true;
				//큐가 비어있는 동안
				while(!queue.isEmpty()) {
					int [] cur = queue.poll();
					//이웃한 빙산 추가하기
					for(int k=0; k<4;k++) {
						int nextX = cur[1] + dx[k];
						int nextY = cur[0] + dy[k];
						//범위 넘어서면 건너뜀
						if(nextX<0||nextX>=M||nextY<0||nextY>=N) continue;
						//빙산이 아니면 건너뜀
						if(map[nextY][nextX]==0) continue;
						//이미 방문 했으면 건너뜀
						if(check[nextY][nextX]) continue;
						queue.offer(new int[] {nextY,nextX});
						check[nextY][nextX] = true;
					}
				}
			}
		}
		return res;
	}
	
	public static int [][] melting(int N, int M, int[][] map) {
		int [] dx = {1,0,-1,0};
		int [] dy = {0,1,0,-1};
		//반환할 배열
		int [][] resMap = new int[N][M];
		//주변 0 갯수
		int count;
		for(int i=0; i<N;i++) {
			for(int j=0; j<M;j++) {
				if(map[i][j]==0) continue;
				count = 0;
				//4방 탐색 후 0 수 체크
				for(int k=0; k<4;k++) {
					int nextX = j + dx[k];
					int nextY = i + dy[k];
					if(nextX<0||nextX>=M||nextY<0||nextY>=N) continue;
					if(map[nextY][nextX]==0) count++;
				}
				//반환할 배열에 현재 빙산높이 - 주변 0갯수 저장
				//단, 빙산높이 - 0갯수가 0보다 작아지면 0, 아니면 빙산높이 - 0갯수
				resMap[i][j] = map[i][j] - count <0?0:map[i][j] - count;
			}
		}
		//갱신된 배열 반환
		return resMap;
	}
}
