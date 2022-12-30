
////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static class Score implements Comparable<Score>{
		int paper;
		int interview;
		Score(int paper, int interview){
			this.paper = paper;
			this.interview=interview;
		}

		@Override
		public int compareTo(Score o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.interview,o.interview);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=0; t<T;t++) {
			int N = Integer.parseInt(br.readLine());
//			int N = 100000;
			int res = N;
			Score[] list = new Score[N];
			for(int i=0; i<N;i++) {
				st = new StringTokenizer(br.readLine());
				list[i] = new Score(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
                                                                                     
//			for(int i=0; i<N;i++) {
//				list[i] = new Score(i+1,N-i);
//			}
			Arrays.sort(list);
			int min = list[0].paper;
			for(int i=1;i<N;i++) {
				if(min>list[i].paper) {
					min = list[i].paper;
				}
				else {
					res--;
				}
			}
			System.out.println(res);
		}
	}
}