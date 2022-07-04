import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int dx[] = {0,1,1,1,0,-1,-1,-1};
		int dy[] = {-1,-1,0,1,1,1,0,-1};
		int map[][][][] = new int [N][N][2][5]; 
		//0 = m 질량, 1 = s 속력, 2 = d 방향, 3 = (0 = 짝수만, 1=홀수만, 2 = 홀수짝수섞임),4=파이어볼 갯수
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			map[r][c][0][0] = Integer.parseInt(st.nextToken());
			map[r][c][0][1] = Integer.parseInt(st.nextToken());
			map[r][c][0][2] = Integer.parseInt(st.nextToken());
			map[r][c][0][4] = 1;
		}
		
		for(int k=0;k<K;k++) {
			//파이어볼 이동
			for(int i=0; i<N;i++) {
				for(int j=0; j<N;j++) {
					if(map[i][j][0][0]==0) continue;
					if(map[i][j][0][4]==1) { //1개짜리
			
						int nextX = j + (dx[map[i][j][0][2]]==0?0:map[i][j][0][1]*dx[map[i][j][0][2]]);
						int nextY = i + (dy[map[i][j][0][2]]==0?0:map[i][j][0][1]*dy[map[i][j][0][2]]);
						if(nextX<0) nextX = N- (Math.abs(nextX)%N);
						if(nextX>N-1) nextX = nextX%N;
						if(nextY<0) nextY = N- (Math.abs(nextY)%N);
						if(nextY>N-1) nextY =nextY%N;
						
						if(map[nextY][nextX][1][4]==0) {
							map[nextY][nextX][1][3] = map[i][j][0][2] % 2;
						}
						else {
							if(map[nextY][nextX][1][3]!=map[i][j][0][2]%2) map[nextY][nextX][1][3] = 2;
						}
						
						
						map[nextY][nextX][1][0] += map[i][j][0][0]; //질량 합치기
						map[nextY][nextX][1][1] += map[i][j][0][1]; //속도 합치기
						map[nextY][nextX][1][2] = map[i][j][0][2]; //방향 유지, 여러개는 4등분되니까 생각x					
						map[nextY][nextX][1][4]++;	
						for(int l=0;l<5;l++) {
							map[i][j][0][l] = 0;
						}
					}
					else {//여러개 합쳐진부분
						map[i][j][0][0] = map[i][j][0][0] / 5;
						map[i][j][0][1] = map[i][j][0][1] / map[i][j][0][4];
						if(map[i][j][0][0] == 0) { //질량 0이면 소멸
							for(int l=0;l<5;l++) {
								map[i][j][0][l] = 0;
							}
							continue;
						}
						for(int l = map[i][j][0][3]==2?1:0; l<8; l+=2) {
							int nextX = j + (dx[l]==0?0:map[i][j][0][1]*dx[l]);
							int nextY = i + (dy[l]==0?0:map[i][j][0][1]*dy[l]);
							if(nextX<0) nextX = N- (Math.abs(nextX)%N);
							if(nextX>N-1) nextX = nextX%N;
							if(nextY<0) nextY = N- (Math.abs(nextY)%N);
							if(nextY>N-1) nextY =nextY%N;
							
							if(map[nextY][nextX][1][4]==0) {
								map[nextY][nextX][1][3] = l % 2;
							}
							else {
								if(map[nextY][nextX][1][3]!=l%2) map[nextY][nextX][1][3] = 2;
							}
							map[nextY][nextX][1][0] += map[i][j][0][0]; //질량 합치기
							map[nextY][nextX][1][1] += map[i][j][0][1]; //속도 합치기
							map[nextY][nextX][1][2] = l;				
							map[nextY][nextX][1][4]++;
						}
						for(int l=0;l<5;l++) {
							map[i][j][0][l] = 0;
						}
					}				
				}
			}
			for(int i=0; i<N;i++) {
				for(int j=0; j<N;j++) {
					for(int l=0;l<5;l++) {
						map[i][j][0][l] = map[i][j][1][l];
						map[i][j][1][l] = 0;
					}					
				}
			}
		}
		int res = 0;
		for(int i=0; i<N;i++) {
			for(int j=0; j<N;j++) {
				res += (map[i][j][0][4]==1?map[i][j][0][0]:(map[i][j][0][0]/5)*4);
			}
		}
		System.out.println(res);

	}
		
		
	

}
