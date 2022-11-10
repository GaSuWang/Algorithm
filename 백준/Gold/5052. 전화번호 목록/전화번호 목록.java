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
		int T = Integer.parseInt(br.readLine());
		test: for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			char arr[][] = new char[N][];
			for(int i=0; i<N;i++) {
				arr[i] = br.readLine().toCharArray();
			}
			Arrays.sort(arr, new Comparator<char[]>() {
				@Override
				public int compare(char[] o1, char[] o2) {
					return Integer.compare(o1.length, o2.length);
				}
			});
			for(int i=0; i<N;i++) {
				outer: for(int j=i+1; j<N;j++) {
					if(arr[i].length==arr[j].length) continue;
					for(int k=0;k<arr[i].length;k++) {
						if(arr[i][k]!=arr[j][k]) continue outer;
					}
					System.out.println("NO");
					continue test;
				}
			}
			System.out.println("YES");
		}
		
	}
	
}
