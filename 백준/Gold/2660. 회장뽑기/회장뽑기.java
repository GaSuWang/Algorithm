import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [][] map = new int[N][N];
		int a,b;
		StringTokenizer st = null;
		List<Integer> res = new ArrayList<>();
		Queue<int[]> queue = new LinkedList<>();
		while(true) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken())-1;
			b = Integer.parseInt(st.nextToken())-1;
			if(a==-2&&b==-2) break;
			map[a][b] = 1;
			map[b][a] = 1;
		}
		for(int i=0; i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[j][i]==0) continue;
				queue.offer(new int[] {j,1});
			}
			while(!queue.isEmpty()) {
				int []cur = queue.poll();
				for(int j=0;j<N;j++) {
					if(i==j) continue;
					if(map[j][cur[0]]!=1) continue;
					if(map[j][i]==0?false:map[j][i]<=cur[1]+1) continue;
					queue.offer(new int[] {j,cur[1]+1});
					map[j][i] = cur[1]+1;
				}
			}
		}
		int min = 100;
		outer: for(int i=0;i<N;i++) {
			int curScore = -1;
			for(int j=0;j<N;j++) {
				if(i==j) continue;
				if(map[j][i]==0) continue outer;
				curScore = Math.max(curScore, map[j][i]);
			}
			min = Math.min(min,curScore==-1?100:curScore);
		}
		outer: for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[j][i]>min) continue outer;
			}
			res.add(i+1);
		}
		StringBuilder sb = new StringBuilder();
		Collections.sort(res);
		sb.append(min).append(' ').append(res.size()).append('\n');
		for(int i=0; i<res.size();i++) {
			sb.append(res.get(i)).append(' ');
		}
		System.out.println(sb.toString());
	}

}