import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int arr[] = new int[N];
			int countEdge[] = new int[N];
			int time[] = new int[N];
			ArrayList<Integer>[] out = new ArrayList[N];
			for(int i=0; i<N;i++) {
				out[i] = new ArrayList<Integer>();
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=0; i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int cur = Integer.parseInt(st.nextToken())-1;
				int next = Integer.parseInt(st.nextToken())-1;
				out[cur].add(next);
				countEdge[next]++;
			}
			int target = Integer.parseInt(br.readLine())-1;
			Queue<Integer> queue = new LinkedList<Integer>();
			for(int i=0; i<N;i++) {
				if(countEdge[i]==0) {
					queue.offer(i);
					time[i] = arr[i];
				}
			}
			while(!queue.isEmpty()) {
				int cur = queue.poll();
				if(cur==target) break;
				for(int i=0;i<out[cur].size();i++) {
					int next = out[cur].get(i);
					time[next] = Math.max(time[next],time[cur]+arr[next]);
					countEdge[next]--;
					if(countEdge[next]==0)	queue.offer(next);
				}
			}			
			System.out.println(time[target]);
			
		}
		
	}
}



