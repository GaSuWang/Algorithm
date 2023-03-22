

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Building {
	int indegree;
	int buildTime;
	List<Integer> nextBuilding;
	public Building(int indegree, int buildTime) {
		this.indegree =indegree;
		this.buildTime = buildTime;
		nextBuilding = new ArrayList<>();
	}
}

public class Main {
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] indegree = new int[N];
		int [] totalbuildTime = new int[N];
		int [] buildTime = new int[N];
		List<Integer> [] nextBuild = new ArrayList[N];
		Queue<Integer> queue = new LinkedList<Integer>();
		StringTokenizer st;
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int curTime = Integer.parseInt(st.nextToken());
			int before;
			int curIndegree = 0;
			while((before = Integer.parseInt(st.nextToken())) !=-1) {
				before--;
				curIndegree++;
				if(nextBuild[before]==null) {
					nextBuild[before] = new ArrayList<>();
				}
				nextBuild[before].add(i);
			}
			indegree[i] = curIndegree;
			buildTime[i] = curTime;
			totalbuildTime[i] = curTime;
			if(curIndegree==0) {
				queue.offer(i);
			}
		}
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				int index = queue.poll();
				if(nextBuild[index]==null) continue;
				for(Integer next : nextBuild[index]) {
					indegree[next]--;
					totalbuildTime[next] = Math.max(totalbuildTime[next],totalbuildTime[index]+buildTime[next]);
					if(indegree[next]==0) {
						queue.offer(next);
					
					}
				}
			}
		}
		for(int i=0; i<N;i++) {
			System.out.println(totalbuildTime[i]);
		}
		
	}
}


