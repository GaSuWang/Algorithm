import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Data implements Comparable<Data> {
		int start,end;
		Data(int start, int end){
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Data o) {
			return this.start-o.start==0?this.end-o.end:this.start-o.start;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Data> pq = new PriorityQueue<>();
		StringTokenizer st = null;
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			pq.offer(new Data(start,end));
		}
		List<Integer> list = new ArrayList<>();
		list.add(pq.poll().end);
		outer: while(!pq.isEmpty()) {
			Data cur = pq.poll();
			for(int i=0;i<list.size();i++) {
				if(list.get(i)<=cur.start) {
					list.set(i, cur.end);
					continue outer;
				}
			}
			list.add(cur.end);
		}
		System.out.println(list.size());
		
	}
	
}
