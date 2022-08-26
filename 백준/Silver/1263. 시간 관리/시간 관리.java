
////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static class Task implements Comparable<Task>{
		int deadline;
		int time;
		public Task(int deadline, int time) {
			super();
			this.deadline = deadline;
			this.time = time;
		}
		@Override
		public int compareTo(Task o) {
			// TODO Auto-generated method stub
			return o.deadline - this.deadline;
		}
		@Override
		public String toString() {
			return "Task [deadline=" + deadline + ", time=" + time + "]";
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Task[] taskArr = new Task[N];
		for(int i=0; i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int deadline = Integer.parseInt(st.nextToken());
			taskArr[i] = new Task(deadline,time);
		}
		Arrays.sort(taskArr);
		int startTime = taskArr[0].deadline;
		for(int i=0;i<N;i++) {
			startTime = startTime>taskArr[i].deadline?taskArr[i].deadline:startTime;
			startTime = startTime-taskArr[i].time;
			if(startTime <0) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(startTime);
	}
}
