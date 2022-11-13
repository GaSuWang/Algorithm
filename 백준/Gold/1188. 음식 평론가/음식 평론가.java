import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int dp [][] = new int[N+1][M+1];
		int restPiece;
		int restPeople;
		int cutCount;
		for(int i=1;i<=M;i++) {
			dp[1][i] = i-1;
		}
		for(int t = 2; t <=N;t++) {
			for(int u =1; u<=M;u++ ) {
				int s = t;
				int m = u;
				//나눠줘야 할 소시지가 사람 보다 많거나 같을때
				if(s>=m) {
					//같으면 칼질 할 필요 없음
					if(s%m==0) {
						dp[t][u] = 0;
						continue;
					}
					//소시지가 더 많으면 1개씩 나눠주고 남은거 칼질해서 주면 됨
					else {
						dp[t][u] = dp[s%m][m];
						continue;
					}
				}
				//나눠줘야 할 소시지가 사람보다 적을 때
				//한 사람당 소시지수/사람수 크기만큼 나눠주면 됨
				//s = 분자, m = 분모
//				for(int i=s; i>=1;i--) {
//					//칼질 최소화를 위해 m,s 약분
//					if(m%i==0&&s%i==0) {
//						m = m/i;
//						s = s/i;
//					}
//				}
				restPiece = 0;
				restPeople=0;
				cutCount=0;
				//소시지 당 칼질 횟수 구하기
				for(int i=1;;i++) {
					//소시지 전체 크기를 m이라고 생각
					//m을 s크기로 자름
					if(i*s>=m) {
						//소시지 하나당 자른 횟수
						cutCount = i-1;
						//소시지가 딱 떨어지게 잘리지 않으면
						if(i*s>m) {
							restPeople = u-t*cutCount;
							restPiece = t;
						}
						dp[t][u] = cutCount * t + dp[restPiece][restPeople];
						break;
					}
				}
			}
		}
		System.out.println(dp[N][M]);
	}
	
}
