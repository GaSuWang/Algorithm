

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int map [][] = new int[N][N];
		res = 0;
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<4;i++) {
			fun(0,N,move(map,i,N));
		}
		System.out.println(res);
	}
	
	static void fun(int num, int N, int[][] map) {
		if(num==4) {
			
//			for(int i=0; i<N;i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println("--------------------------------");
			res = Math.max(res,find(map,N));
			return;
		}
		for(int i=0; i<4;i++) {
			fun(num+1, N, move(map,i,N));
		}
	}
	
	static int find(int [][] map, int N) {
		int max = 0;
		for(int i=0; i<N;i++) {
			for(int j=0; j<N;j++) {
				max = Math.max(map[i][j], max);
			}
		}
		return max;
	}
	
	static int [][] move(int [][] map,int dir, int N){
		int [][] res = copyMap(map);
		if(dir==0) {
			for(int i=0; i<N-1;i++) {
				for(int j=0; j<N;j++) {
					if(res[i][j]==0) {
						for(int k=i+1; k<N;k++) {
							if(res[k][j]!=0) {
								res[i][j] = res[k][j];
								res[k][j] = 0;
								break;
							}
						}
					}
					for(int k=i+1;k<N;k++) {
						if(res[k][j]!=0) {
							if(res[k][j]==res[i][j]) {
								res[i][j] = res[i][j]*2;
								res[k][j] = 0;
							}
							break;
						}
					}
				}
			}
		}
		else if(dir==1) {
			for(int i=N-1; i>=0;i--) {
				for(int j=N-1; j>=0;j--) {
					if(res[i][j]==0) {
						for(int k=i-1; k>=0;k--) {
							if(res[k][j]!=0) {
								res[i][j] = res[k][j];
								res[k][j] = 0;
								break;
							}
						}
					}
					for(int k=i-1;k>=0;k--) {
						if(res[k][j]!=0) {
							if(res[k][j]==res[i][j]) {
								res[i][j] = res[i][j]*2;
								res[k][j] = 0;
							}
							break;
						}
					}
				}
			}
		}
		else if(dir==2) {
			for(int j=0; j<N-1;j++) {
				for(int i=0; i<N;i++) {
					if(res[i][j]==0) {
						for(int k=j+1; k<N;k++) {
							if(res[i][k]!=0) {
								res[i][j] = res[i][k];
								res[i][k] = 0;
								break;
							}
						}
					}
					for(int k=j+1;k<N;k++) {
						if(res[i][k]!=0) {
							if(res[i][k]==res[i][j]) {
								res[i][j] = res[i][j]*2;
								res[i][k] = 0;
							}
							break;
						}
					}
				}
			}	
		}
		else if(dir==3) {
			for(int j=N-1; j>0;j--) {
				for(int i=N-1; i>=0;i--) {
					if(res[i][j]==0) {
						for(int k=j-1; k>=0;k--) {
							if(res[i][k]!=0) {
								res[i][j] = res[i][k];
								res[i][k] = 0;
								break;
							}
						}
					}
					for(int k=j-1;k>=0;k--) {
						if(res[i][k]!=0) {
							if(res[i][k]==res[i][j]) {
								res[i][j] = res[i][j]*2;
								res[i][k] = 0;
							}
							break;
						}
					}
				}
			}	
		}
		return res;
	}
	
	static int [][] copyMap(int [][] map){
		int [][] res = new int[map.length][map.length];
		for(int i=0; i<map.length;i++) {
			for(int j=0; j<map.length;j++) {
				res[i][j] = map[i][j];
			}
		}
		return res;
	}
	
}