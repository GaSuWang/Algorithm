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
static int N;
static int M;
static int lamp[][];
static int K;
static int res;
	public static void main(String[] args) throws IOException {
		// 행에 있는 열의 개수와 스위치 끄고 킬수 있는 횟수 %2 값이 같아야 해당 행이 켜질 수 있다.
		// 위의 조건을 일치하는 행이 나오면 해당 행과 같은 모양인 행도 다 켜지게 된다.
		// 따라서  행에 있는 열의 개수와 스위치 끄고 킬수 있는 횟수 %2 값이 같아지는 행과 같은 모양의 행의 수를 세 가장 큰 값을 출력하면 된다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lamp = new int[N][M];
		res = 0;
		for(int i=0; i<N;i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j=0; j<M;j++) {
				lamp[i][j]  = temp[j] - '0';
			}
		}
		K = Integer.parseInt(br.readLine());
		
		boolean checkN[] = new boolean[N]; // 행체크
		for(int i=0; i<N;i++) {
			checkN[i] = true; // 현재행 방문처리
			int check[] = new int[M]; //열 모양 체크용
			int count = 0; // 행에 있는 0의 개수
			for(int j=0;j<M;j++) {
				if(lamp[i][j]==0) count++; // 0갯수 증가
				if(lamp[i][j]==1) check[j] = lamp[i][j]; //
			}
			if(count>K) continue;
			if(count%2!=K%2) continue; //행 0 개수, K %2가 다르면 건너뜀
			int temp = 1;//현재 모양 행 갯수
			outer: for(int j=0;j<N;j++ ) {
				if(checkN[j]) continue; //이전에 체크한 행이면 다른모양이란뜻 건너뜀
				for(int k=0; k<M;k++) { 
					if(lamp[j][k]!=check[k]) continue outer; //다른 모양이면 해당 행 건너뜀
				}
				temp++; //여기까지 오면 같은모양 행이라는뜻
			}
			res = Math.max(res,temp); //res와 temp중 큰 값 선택
		}
		
		System.out.println(res);
	}


}
