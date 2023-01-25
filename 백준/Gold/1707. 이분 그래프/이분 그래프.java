
////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		List<Integer> [] map;
		outer: for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			map = new ArrayList[N];
			int nodes[] = new int[N];
			Arrays.fill(nodes,-1);
			for(int i=0; i<M;i++) {
				st = new StringTokenizer(br.readLine());				
				int a = Integer.parseInt(st.nextToken())-1; 
				int b = Integer.parseInt(st.nextToken())-1; 
				if(map[a]==null) {
					map[a] = new ArrayList<>();
				}
				if(map[b]==null) {
					map[b] = new ArrayList<>();
				}
				map[a].add(b);
				map[b].add(a);
			}
			Queue<Integer> queue = new LinkedList<>();
			for(int i=0;i<N;i++) {
				if(nodes[i]!=-1) continue;
				nodes[i] = 0;
				if(map[i]==null) continue;
				queue.offer(i);
				while(!queue.isEmpty()) {
					int cur = queue.poll();
					for(int j=0;j<map[cur].size();j++) {
						int next = map[cur].get(j);
						if(nodes[next]==-1) {
							nodes[next] = (nodes[cur]+1)%2;
							queue.offer(next);
						}
						else if(nodes[next]==nodes[cur]) {
							System.out.println("NO");
							continue outer;
						}
						
					}
				}
				
			}
			System.out.println("YES");
			
		}
		
		
	}
	
}