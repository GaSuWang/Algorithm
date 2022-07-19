
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int [][] green = new int[6][4];
		int [][] blue = new int[4][6];
		int score=0;
		for(int n=0; n<N;n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken()); // 1 = xy 2 (x.y / x,y+1) 3(x,y / x+1,y)
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int i=0; i<6;i++) {
				if(t == 1) {
					if(blue[y][i]!=0) {
						blue[y][i-1] = 1;
						break;
					}
					if(i==5) {
						blue[y][i] = 1;
					}
					
				}
				else if(t==2) {
					if(blue[y][i]!=0||blue[y+1][i]!=0) {
						blue[y][i-1] = 2;
						blue[y+1][i-1] = 2;
						break;
					}
					if(i==5) {
						blue[y][i] = 2;
						blue[y+1][i] = 2;
					}
					
				}
				else {
					if(blue[y][i]!=0) {
						blue[y][i-1] = 3;
						blue[y][i-2] = 3;
						break;
					}
					if(i==5) {
						blue[y][i] = 3;
						blue[y][i-1] = 3;
					}
				}
				
			}
			
			for(int i=0;i<6;i++) {
				if(t==1) {
					if(green[i][x]!=0) {
						green[i-1][x] = 1;
						break;
					}
					if(i==5) {
						green[i][x] = 1;
					}
				}else if(t==2) {
					if(green[i][x]!=0) {
						green[i-1][x] = 2;
						green[i-2][x] = 2;
						break;
					}
					if(i==5) {
						green[i][x] = 2;
						green[i-1][x] = 2;
					}
				}else {
					if(green[i][x]!=0||green[i][x+1]!=0) {
						green[i-1][x] = 3;
						green[i-1][x+1] = 3;
						break;
					}
					if(i==5) {
						green[i][x] = 3;
						green[i][x+1] = 3;
					}
				}
			}
			//점수 획득 확인
			outer: for(int i=5; i>1;i--) {
				for(int j=0;j<4;j++) {
					if(blue[j][i]==0) continue outer;
				}
				score++;
				for(int j=0; j<4;j++) {
					blue[j][i] = 0;
				}
			}
			for(int i=0;i<4;i++) {
				for(int j=4;j>=0;j--) {
					if(blue[i][j]==1||blue[i][j]==3) {
						for(int k=j;k<6;k++) {
							if(blue[i][k]!=0) {
								blue[i][k-1] = blue[i][j];
								blue[i][j] = 0;
							}
							if(k==5) {
								blue[i][k] = blue[i][j];
								blue[i][j] = 0;
							}
						}
					}
					else if(blue[i][j]==2&&i!=3) {
						for(int k=j;k<6;k++) {
							if(blue[i][k]!=0||blue[i+1][k]!=0) {
								blue[i][k-1] = blue[i][j];
								blue[i+1][k-1] = blue[i+1][j];
							}
							if(i==5) {
								blue[i][k] = blue[i][j];
								blue[i+1][k] = blue[i+1][j];
							}
						}
					}
				}
			}
			
			
			outer: for(int i=5; i>1;i--) {
				for(int j=0;j<4;j++) {
					if(green[i][j]==0) continue outer;
				}
				score++;
				for(int j=0;j<4;j++) {
					green[i][j] = 0;
				}
			}

			//내려주기 blue
			//중간에서 지워졌을때도 제대로 처리하기
			
			//연한부분 체크 후 내려주기
			int num=0;
			outer: for(int i=0;i<2;i++) {
				for(int j=0;j<4;j++) {
					if(blue[j][i]!=0) {
						num++;
						continue outer;
					}
				}
			}
			if(num!=0) {
				for(int i=5; i>=2;i--) {
					for(int j=0; j<4;j++) {
						blue[j][i] = blue[j][i-num];
					}
				}
			}
			num =0;
			outer: for(int i=0;i<2;i++) {
				for(int j=0;j<4;j++) {
					if(green[i][j]!=0) {
						num++;
						continue outer;
					}
				}
			}
			if(num!=0) {
				for(int i=5; i>=2;i--) {
					for(int j=0; j<4;j++) {
						green[i][j] = green[i-num][j];
					}
				}
			}
			for(int i=0; i<2;i++) {
				for(int j=0;j<4;j++) {
					blue[j][i] = 0;
					green[i][j] = 0;
				}
			}
			for(int i=0;i<4;i++) {
				System.out.println(Arrays.toString(blue[i]));
			}
			System.out.println("");
			for(int i=0;i<6;i++) {
				System.out.println(Arrays.toString(green[i]));
			}
			System.out.println("--------");
			
		}
		System.out.println(score);
		int count =0;
		for(int i=0;i<6;i++) {
			for(int j=0;j<4;j++) {
				if(green[i][j]!=0) count++;
				if(blue[j][i]!=0) count++;
			}
		}
		System.out.println(count);
		
	}
}



