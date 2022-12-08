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
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		//시험관
		int [][] map = new int[N][N];
		//바이러스 별 위치 저장용
		List<int[]>[]virus = new ArrayList[K+1];
		int dx[] = {1,0,-1,0};
		int dy[] = {0,1,0,-1};
		//입력받기
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==0) continue;
				if(virus[map[i][j]]==null) {
					virus[map[i][j]] = new ArrayList<int[]>();
				}
				//바이러스 위치 저장
				virus[map[i][j]].add(new int[] {i,j});
			}
		}
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int targetY = Integer.parseInt(st.nextToken())-1;
		int targetX = Integer.parseInt(st.nextToken())-1;


		Queue<int []> queue = new LinkedList<>();
		//초기 바이러스 큐에 넣기
		for(int i=1;i<=K;i++) {
			if(virus[i]==null) continue;
			for(int j=0;j<virus[i].size();j++) {
				int [] cur = virus[i].get(j);
				queue.offer(new int[] {cur[0],cur[1],i});
			}
			
		}
		//시간만큼 반복
		for(int i=0;i<S;i++) {
			//1초 기준으로 반복하기
			int size = queue.size();
			for(int j=0; j<size;j++) {
				int [] cur = queue.poll();
				
				for(int k=0; k<4;k++) {
					int nextX = cur[1] +dx[k];
					int nextY = cur[0] +dy[k];
					if(nextX<0||nextX>=N||nextY<0||nextY>=N) continue;
					if(map[nextY][nextX]!=0) continue;
					queue.offer(new int[] {nextY,nextX,cur[2]});
					map[nextY][nextX] = cur[2];
				}
			}
		}
		System.out.println(map[targetY][targetX]);
				
	}
	
	
}