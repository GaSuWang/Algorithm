
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;



public class Main {
	 
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pos = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> neg = new PriorityQueue<>();
		int zero = 0;
		int one = 0;
		for(int i=0; i<N;i++) {
			int cur = Integer.parseInt(br.readLine());
			if(cur==0) {
				zero++;
			}else if(cur==1) {
				one++;
			}else if(cur<0) {
				neg.offer(cur);
			}else {
				pos.offer(cur);
			}
		}
		int sum = one;
		while(pos.size()>1) {
			int num1 = pos.poll();
			int num2 = pos.poll();
			sum+= num1*num2;
		}
		while(!pos.isEmpty()) {
			sum+= pos.poll();
		}
		while(neg.size()>1) {
			int num1 = neg.poll();
			int num2 = neg.poll();
			sum+= num1*num2;
		}
		while(zero>0&&!neg.isEmpty()) {
			neg.poll();
			zero--;
		}
		while(!neg.isEmpty()) {
			sum+=neg.poll();
		}
		System.out.println(sum);
	}
} 