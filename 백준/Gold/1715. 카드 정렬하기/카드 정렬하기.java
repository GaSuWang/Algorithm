import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<N;i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		int res = 0;
		if(N==1) {
			System.out.println(0);
			return;
		}
		
		
		while(pq.size()!=1) {
			int sum = pq.poll()+pq.poll();
			pq.offer(sum);
			res+=sum;
		}
		
		System.out.println(res);
	}
}



