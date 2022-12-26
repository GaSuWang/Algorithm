////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static class Item implements Comparable<Item>{
		Long num;
		
		Item(long num){
			this.num = num;
		}
		
		@Override
		public int compareTo(Item o) {
			if(Math.abs(this.num)==Math.abs(o.num)) {
				return Long.compare(this.num,o.num);
			}
			return Long.compare(Math.abs(this.num), Math.abs(o.num));
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Item> pq = new PriorityQueue<Item>();
		for(int i=0; i<N; i++) {
			long input = Long.parseLong(br.readLine());
			Item cur = new Item(input);
			
			if(cur.num==0L) {
				if(pq.size()==0) {
					System.out.println(0);
				}
				else {
					System.out.println(pq.poll().num);
				}
			}
			else {
				pq.offer(cur);
			}
		}
	}
}