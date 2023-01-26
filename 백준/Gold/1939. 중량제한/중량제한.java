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
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<int []> [] map = new ArrayList[N];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			if(map[a]==null) {
				map[a] = new ArrayList<>();
			}
			if(map[b]==null) {
				map[b]= new ArrayList<>();
			}
			map[a].add(new int[] {b,cost});
			map[b].add(new int[] {a,cost});
		}
		int [] nodeCost = new int[N];
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken())-1;
		int end = Integer.parseInt(st.nextToken())-1;
		int left = 1;
		int right = 1000000000;
		int mid = left+right/2;
		while(left<=right) {
			if(check(map,start,end,mid,N)) {
				left = mid+1;
			}
			else {
				right = mid-1;
				
			}
			mid = (left+right)/2;
		}
		System.out.println(mid);
		
		
	}
	public static boolean check(List<int[]>[]map,int start, int end, int weight, int N) {
		boolean visited[] = new boolean[N];
		Queue<int []> queue = new LinkedList<int[]>();
		queue.offer(new int[] {start,1000000001});
		visited[start] = true;
		while(!queue.isEmpty()) {
			int [] cur = queue.poll();
			if(map[cur[0]]==null) continue;
			for(int i=0; i<map[cur[0]].size();i++) {
				int next = map[cur[0]].get(i)[0];
				int nextCost = map[cur[0]].get(i)[1];
				if(nextCost<weight) continue;
				if(visited[next]) continue;
				if(next==end) {
					return true;
				}
				queue.offer(new int[] {next,nextCost});
				visited[next] = true;
			}
		}
		return false;
	}
}
