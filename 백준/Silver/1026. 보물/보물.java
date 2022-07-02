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
	static int A[];
	static int B[];
	static int res;
	public static void main(String[] args) throws IOException {
		// 행에 있는 열의 개수와 스위치 끄고 킬수 있는 횟수 %2 값이 같아야 해당 행이 켜질 수 있다.
		// 위의 조건을 일치하는 행이 나오면 해당 행과 같은 모양인 행도 다 켜지게 된다.
		// 따라서 행에 있는 열의 개수와 스위치 끄고 킬수 있는 횟수 %2 값이 같아지는 행과 같은 모양의 행의 수를 세 가장 큰 값을 출력하면
		// 된다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		B = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int j = 0; j < N; j++) {
			A[j] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int j = 0; j < N; j++) {
			B[j] = Integer.parseInt(st.nextToken());
		}
		res = 0;
		Arrays.sort(A);
		Arrays.sort(B);
		for(int i=0; i<N;i++) {
			res = res+A[i]*B[N-i-1];
		}
		System.out.println(res);

	}
		
		
	

}
