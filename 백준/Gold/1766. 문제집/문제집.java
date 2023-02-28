

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;


class Item implements Comparable<Item>{
	int num;
	int [] beforeP;
	Stack<Integer> afterP;
	
	public Item(int num, int [] beforeP) {
		super();
		this.num = num;
		this.beforeP = beforeP;
		this.afterP = new Stack<>();
		
		
	}
	
	@Override
	public int compareTo(Item o) {
		if(this.beforeP[this.num]==o.beforeP[o.num]) {
			if(this.beforeP[this.num]==0) {
				return Integer.compare(this.num,o.num);	
			}
			else return Integer.compare(this.num, o.num);
		}
		
		return Integer.compare(this.beforeP[this.num], o.beforeP[o.num]);
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		PriorityQueue<Item> pq = new PriorityQueue<Item>();
		int [] beforeP = new int [N];
		Item [] itemList = new Item[N];
		for(int i=0;i<N;i++) {
			itemList[i] = new Item(i,beforeP);
		}
		
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int before = Integer.parseInt(st.nextToken())-1;
			int after = Integer.parseInt(st.nextToken())-1;
			itemList[before].afterP.push(after);
			beforeP[after]++;
		}
		for(int i=0;i<N;i++) {
			pq.offer(itemList[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!pq.isEmpty()) {
			Item cur = pq.poll();
			sb.append(cur.num+1).append(' ');
			while(!cur.afterP.isEmpty()) {
				int afterNum = cur.afterP.pop();
				beforeP[afterNum]--;
				pq.remove(itemList[afterNum]);
				pq.offer(itemList[afterNum]);
			}
			
		}
		System.out.println(sb.toString());
		
	}
}


