

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Node implements Comparable<Node>{
	int index;
	int val;
	
	Node(int index, int val){
		this.index =index;
		this.val = val;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.val,o.val);
	}
		
}


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		Deque<Node> dq = new LinkedList<Node>();
		PriorityQueue<Node> pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N;i++) {
			int val = Integer.parseInt(st.nextToken());
//			dq.add(new Node(i,val));
//			int min = Integer.MAX_VALUE;
//			if(dq.size()>L) dq.pollFirst();
//			for(int j=0; j<dq.size();j++) {
//				min = Math.min(dq.getFirst().val,min);
//				dq.offer(dq.pollFirst());
//			}
			//int val = i;
			pq.offer(new Node(i,val));
			while(pq.peek().index<i-L+1) {
				pq.poll();
			}
//			sb.append(min).append(' ');
			sb.append(pq.peek().val).append(' ');
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	
}