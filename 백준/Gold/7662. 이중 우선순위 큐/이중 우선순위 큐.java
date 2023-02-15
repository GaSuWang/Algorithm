
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node{
	int val;
	Node left;
	Node right;
	
	Node(int val){
		this.val = val;
		this.left = null;
		this.right = null;
	}
	
	@Override
	public String toString() {
		return "[ val = "+val+" ]";
	}
}


public class Main {
	 
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=0; t<T;t++) {
		
			int N = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> min = new PriorityQueue<>();
			Map<Integer,Integer> map = new HashMap<>();
			for(int i=0; i<N;i++) {
				st = new StringTokenizer(br.readLine());
				String command = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				if("I".equals(command)) {
					max.offer(num);
					min.offer(num);
					map.put(num, map.getOrDefault(num, 0)+1);
				}
				else {
					if(map.isEmpty()) continue;
					if(num==1) remove(max,map);
					else remove(min,map);
				}
			}
			if(map.isEmpty()) {
				System.out.println("EMPTY");
				continue;
			}
			int resMax = remove(max,map);
			int resMin = map.isEmpty()?resMax:remove(min,map);
			System.out.println(resMax+" "+resMin);
		}
	}
	
	public static int remove(PriorityQueue<Integer> queue, Map<Integer,Integer> map) {
		int cur = 0;
		while(true) {
			cur = queue.poll();
			
			int res = map.getOrDefault(cur, 0);
			if(res == 0 ) continue;
			else if(res ==1) {
				map.remove(cur);
				break;
			}
			else{
				map.put(cur,res-1);
				break;
			}
		}
		return cur;
	}


} 