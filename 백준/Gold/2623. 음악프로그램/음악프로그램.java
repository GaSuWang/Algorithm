

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;




public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer> [] list = new ArrayList[N];
		int [] degree = new int[N];
		int [] input;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			input = new int[cnt];
			for(int j=0; j<cnt;j++) {
				input[j] = Integer.parseInt(st.nextToken())-1;
			}
			for(int j=0; j<cnt-1;j++) {
				if(list[input[j]]==null) list[input[j]] = new ArrayList<>();
				list[input[j]].add(input[j+1]);
				degree[input[j+1]]++;
			}
		}
		boolean flag = true;
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		while(true) {
			inputQueue(queue,degree);
			if(queue.isEmpty()) break;
			while(!queue.isEmpty()) {
				int cur = queue.poll();
				sb.append(cur+1).append('\n');
				if(list[cur]==null) continue;
				for(int i=0; i<list[cur].size();i++) {
					int next = list[cur].get(i);
					degree[next]--;
				}
			}
		}
		if(check(degree)) {
			System.out.println(sb.toString());
			return;
		}
		System.out.println(0);
	}
	
	public static boolean check(int [] degree) {
		for(int i=0; i<degree.length;i++) {
			if(degree[i]!=10000) return false;
		}
		return true;
	}
	
	public static void inputQueue(Queue<Integer> queue, int [] degree) {
		for(int i=0; i<degree.length;i++) {
			if(degree[i]==0) {
				queue.offer(i);
				degree[i] = 10000;
			}
		}
	}
}


