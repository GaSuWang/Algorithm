////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static class Room implements Comparable<Room>{
		long start;
		long end;
		
		Room(long start, long end){
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Room o) {
			// TODO Auto-generated method stub
			return Long.compare(this.start,o.start);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Room> pq = new PriorityQueue<Room>();
		StringTokenizer st;
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			Long start = Long.parseLong(st.nextToken());
			Long end = Long.parseLong(st.nextToken());
			pq.offer(new Room(start,end));
		}
//		for(int i=0; i<100000;i++) {
//			Long start = 10L+i;
//			Long end = start+10L+i;
//			pq.offer(new Room(start,end));
//		}
		List<Long> list = new ArrayList<Long>();
		outer: for(int i=0; i<N;i++) {
			Room cur = pq.poll();
			for(int j=0;j<list.size();j++) {
				 Long last = list.get(j);
				if(last <=cur.start) {
					list.remove(j);
					list.add(cur.end);
					continue outer;
				}
			}
			list.add(cur.end);
		}
		System.out.println(list.size());
	}
}