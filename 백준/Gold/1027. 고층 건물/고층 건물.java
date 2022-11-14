
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		//빌딩 높이
		int building[] = new int[N];
		//각 빌딩에서 보이는 빌딩 수
		int count[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N;i++) {
			building[i] = Integer.parseInt(st.nextToken());
		}
		//i 1증가당 높이 증가량
		double num;
		//빌딩하나씩 선택
		for(int i=0;i<N;i++) {
			//선택된 빌딩 오른쪽에 위치한 빌딩들 확인
			//왼쪽 빌딩들은 이미 왼쪽에 있는 빌딩을 선택했을때 확인함
			outer: for(int j=i+1;j<N;j++) {
				//증가율 = (빌딩j높이 - 빌딩i높이)/(j-i)
				num =(double)(building[j]-building[i])/(j-i);
				//빌딩 i와 빌딩 j 사이에 있는 빌딩들 확인
				for(int k=i+1;k<j;k++) {
					//빌딩k의 높이가 빌딩 i,j를 이은 선분에 닿으면 빌딩 i,j는 서로 보이지 않음
					if(building[i]+(num*(k-i))<=building[k]) continue outer;
				}
				//빌딩i가 보는 빌딩수 +1
				count[i]++;
				//빌딩j가 보는 빌딩수 +1
				count[j]++;
			}
		}
		int res = 0;
		for(int i=0; i<N;i++) {
			res = Math.max(res,count[i]);
		}
		System.out.println(res);
	}
}
