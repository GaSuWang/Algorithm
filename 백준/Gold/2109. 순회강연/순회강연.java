
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Req implements Comparable<Req> {
	int pay;
	int deadline;

	Req(int pay, int deadline) {
		super();
		this.pay = pay;
		this.deadline = deadline;
	}

	@Override
	public int compareTo(Req o) {
		// TODO Auto-generated method stub

		return Integer.compare(o.pay, this.pay);

	}

}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Req> pq = new PriorityQueue<>();
		int lastDay = 0;
		StringTokenizer st;
		Req [] list = new Req[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int pay = Integer.parseInt(st.nextToken());
			int deadline = Integer.parseInt(st.nextToken());
			lastDay = Math.max(lastDay, deadline);
			list[i] = new Req(pay,deadline);
			//pq.offer(new Req(pay, deadline));
		}
		Arrays.sort(list,new Comparator<Req>(){
			@Override
			public int compare(Req o1, Req o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o2.deadline, o1.deadline);
			}
		});
		int res = 0;
		int point = 0;
		// List로 저장, 날짜별 내림차순 정렬
		// pointer하나 두고 날짜 되면 pq에 넣기
		for (int i = lastDay; i > 0; i--) {
			while(point<N&&list[point].deadline==i) {
				pq.offer(list[point]);
				point++;
			}
			if(point<N&&pq.isEmpty()) {
				i = list[point].deadline+1;
				continue;
			}
			Req cur = pq.poll();
			res += cur.pay;
			
		}
		System.out.println(res);
	}

}