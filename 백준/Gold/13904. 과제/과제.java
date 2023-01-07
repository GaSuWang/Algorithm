
////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


/**
 * @author kws04
 *
 */
class Homework implements Comparable<Homework>{
	int deadline;
	int score;
	
	Homework(int deadline, int score){
		this.deadline = deadline;
		this.score = score;
	}

	@Override
	public int compareTo(Homework o) {
		// TODO Auto-generated method stub
		//마감일 내림차순
		//해당 마감일 되면 pq에 넣기
		//pq 팝
		//반복 한 번 할때마다 일자 하나씩 빼기
		if(this.score==o.score) {
			return Integer.compare(o.deadline, this.deadline);
		}
		
		return Integer.compare(o.score, this.score);
	}

	@Override
	public String toString() {
		return "Homework [deadline=" + deadline + ", score=" + score + "]";
	}
	
	
}



public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Homework [] arr = new Homework[N];
		StringTokenizer st = null;
		int maxday = 0;
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int deadline = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			maxday = Math.max(deadline, maxday);
			arr[i] = new Homework(deadline,score);
		}
		Arrays.sort(arr,new Comparator<Homework>() {

			@Override
			public int compare(Homework o1, Homework o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o2.deadline, o1.deadline);
			}
			
		});
		int index = 0;
		int res = 0;
		PriorityQueue<Homework> pq = new PriorityQueue<Homework>();
		for(int i=maxday;i>0;i--) {
			for(int j=index; j<N;j++) {
				if(arr[j].deadline<i) {
					break;
				}
				pq.offer(arr[j]);
				index++;
			}
			if(!pq.isEmpty()) {
				res+=pq.poll().score;
			}
			
		}
		System.out.println(res);
		
	}

}