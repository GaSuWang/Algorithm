import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] lionIndex = new int[N];
		st= new StringTokenizer(br.readLine());
		int index = 0;
		for(int i=0;i<N;i++) {
			if(Integer.parseInt(st.nextToken())==1) {
				lionIndex[index] = i;
				index++;
			}
		}
		int res = 2*N;
		for(int i=0; i<index-(K-1);i++) {
			res = Math.min(res,lionIndex[i+(K-1)]-lionIndex[i]+1);
		}
		System.out.println(res==2*N?-1:res);
	}
}