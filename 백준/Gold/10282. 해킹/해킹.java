import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		ArrayList<int[]>[] list = null;
		StringTokenizer st= null;
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken())-1;
			list = new ArrayList[N];
			int start,end,cost;
			for(int i=0;i<d;i++) {
				st = new StringTokenizer(br.readLine());
				start = Integer.parseInt(st.nextToken())-1;
				end = Integer.parseInt(st.nextToken())-1;
				cost = Integer.parseInt(st.nextToken());
				if(list[end]==null) {
					list[end] = new ArrayList<int[]>();
				}
				list[end].add(new int[] {start,cost});
			}
			int [] res = fun(N,c,list);
			System.out.println(res[0]+" "+res[1]);
			
		}
		
		
	}
	public static int [] fun(int N, int c, ArrayList<int[]> [] list) {
		int [] res = new int[2];
		int[] cost = new int[N];
		int[] check = new int[N];
		
		Arrays.fill(cost,Integer.MAX_VALUE);
		cost[c] = 0;
		PriorityQueue<int []> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1]-o2[1];
			}
		});
		queue.offer(new int[] {c,0});
		while(!queue.isEmpty()) {
			int [] cur = queue.poll();
			if(list[cur[0]]==null) continue;
			if(cost[cur[0]]<cur[1]) continue;
			for(int i=0; i< list[cur[0]].size();i++) {
				int [] next = list[cur[0]].get(i);
				if(cost[next[0]]>cur[1]+next[1]) {
					cost[next[0]] = cur[1]+next[1];
					queue.offer(new int[] {next[0],cost[next[0]]});
				}
			}
		}
		for(int i=0;i<N;i++) {
			if(cost[i]==Integer.MAX_VALUE) continue;
			res[0]++;
			res[1]=Math.max(res[1],cost[i]);
		}
		
		return res;
	}
	
	
}