////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean check[] = new boolean[N];
		List<Integer> [] list = new ArrayList[N];
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			if(list[a]==null) {
				list[a] = new ArrayList<Integer>();
			}
			if(list[b]==null) {
				list[b] = new ArrayList<Integer>();
			}
			list[a].add(b);
			list[b].add(a);
		}
		queue.offer(0);
		check[0] = true;
		int size=0;
		int temp=0;
		int dis=0;
		int res=0;
		while(!queue.isEmpty()) {
			size = queue.size();
			temp = size;
			res = 20001;
			while(temp-->0) {
				int cur = queue.poll();
				res = Math.min(res,cur);
				for(int i=0;i<list[cur].size();i++) {
					int next = list[cur].get(i);
					if(check[next]) continue;
					check[next] = true;
					queue.offer(next);
					
				}
			}
			dis++;
		}
		StringBuilder sb= new StringBuilder();
		sb.append(res+1).append(' ').append(dis-1).append(' ').append(size);
		System.out.println(sb.toString());
	}
}