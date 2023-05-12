import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int [][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int res = 0;
		outer: for(int i=0; i<N;i++) {
			int len = 1;
			for(int j=0; j<N-1;j++) {
				//높이 같을때
				if(map[i][j]==map[i][j+1]) len++;
				//높이가 낮아질때
				else if(map[i][j]==map[i][j+1]+1) {
					//L만큼 갈 수 있는지 확인
					//L만큼 갈 수 있을 때 -> j위치 옮기기, len길이 초기화
					//L만큼 못가면? -> 경사로 설치 불가능
					//L만큼 못가는 경우 -> 남은 칸의 길이가 L보다 짧은경우, L만큼 가기전 높이가 변하는 경우
					for(int k=j+1;k<j+L;k++) {
						if(k+1==N) continue outer;
						if(map[i][k]!=map[i][k+1]) continue outer;
					}
					j=j+L-1;
					len=0;
				}
				//높이 높을때
				else if(map[i][j]==map[i][j+1]-1) {
					if(len<L) continue outer;
					len =1;
				}
				else continue outer;
			}
			res++;
		}
		outer: for(int j=0; j<N;j++) {
			int len = 1;
			for(int i=0; i<N-1;i++) {
				//높이 같을때
				if(map[i][j]==map[i+1][j]) len++;
				//높이가 낮아질때
				else if(map[i][j]==map[i+1][j]+1) {
					//L만큼 갈 수 있는지 확인
					//L만큼 갈 수 있을 때 -> j위치 옮기기, len길이 초기화
					//L만큼 못가면? -> 경사로 설치 불가능
					//L만큼 못가는 경우 -> 남은 칸의 길이가 L보다 짧은경우, L만큼 가기전 높이가 변하는 경우
					for(int k=i+1;k<i+L;k++) {
						if(k+1==N) continue outer;
						if(map[k][j]!=map[k+1][j]) continue outer;
					}
					i=i+L-1;
					len=0;
				}
				//높이 높을때
				else if(map[i][j]==map[i+1][j]-1) {
					if(len<L) continue outer;
					len =1;
				}
				else continue outer;
			}
			res++;
		}
		System.out.println(res);
	}
	
}
