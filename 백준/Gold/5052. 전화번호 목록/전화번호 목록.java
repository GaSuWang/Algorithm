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
		//테스트케이스 반복
		int T = Integer.parseInt(br.readLine());
		test: for(int t=0;t<T;t++) {
			//전화번호 수
			int N = Integer.parseInt(br.readLine());
			//전화번호 저장배열
			char arr[][] = new char[N][];
			//전화번호 받기
			for(int i=0; i<N;i++) {
				arr[i] = br.readLine().toCharArray();
			}
			//전화번호 정렬하는데 전화번호 길이로 정렬함
			//짧은 전화번호를 기준으로 긴 전화번호들과 비교해야 확인가능하기 때문
			Arrays.sort(arr, new Comparator<char[]>() {
				@Override
				public int compare(char[] o1, char[] o2) {
					return Integer.compare(o1.length, o2.length);
				}
			});
			//전화번호 반복
			for(int i=0; i<N;i++) {
				//이후 자기보다 뒤에 있는 전화번호들 확인 -> 길이순으로 정렬했기 때문에 뒤에는 무조건 길이가 같거나 더 김
				outer: for(int j=i+1; j<N;j++) {
					//길이가 같으면 비교하지 않음 -> 문제에서 같은 전화번호는 없다고 했기 때문
					if(arr[i].length==arr[j].length) continue;
					//짧은 전화번호 길이만큼 앞에서 비교 -> "접두어"를 기준으로 하기 때문에 앞에서부터 비교하면 됨
					for(int k=0;k<arr[i].length;k++) {
						//다른 숫자 나오면 다음 번호 체크
						if(arr[i][k]!=arr[j][k]) continue outer;
					}
					//위 continue 안걸리면 짧은 전화번호로 시작되는 긴 번호가 있다는 뜻 NO출력하고 다음 테케로 넘어감
					System.out.println("NO");
					continue test;
				}
			}
			//위 반복을 무사히 끝내면 일관성 있는 목록 YES출력
			System.out.println("YES");
		}
		
	}
	
}
