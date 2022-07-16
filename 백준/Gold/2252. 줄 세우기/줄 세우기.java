import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>out [] = new ArrayList[N];
		int [] in = new int[N];
		for(int i=0; i<N;i++) {
			out[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken())-1;
			int num2 = Integer.parseInt(st.nextToken())-1;
			in[num2] ++;
			out[num1].add(num2);
		}
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0; i<N;i++) {
			if(in[i]==0) {
				queue.offer(i);
				sb.append(i+1);
				sb.append(" ");
			}
		}
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(int i=0; i<out[cur].size();i++) {
				int next = out[cur].get(i);
				in[next]--;
				if(in[next]==0) {
					queue.offer(next);
					sb.append(next+1);
					sb.append(" ");
				}
			}
		}
		System.out.println(sb);
	}
}



