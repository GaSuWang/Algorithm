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
		int [] bottleMax = new int[3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		bottleMax[0] = Integer.parseInt(st.nextToken());
		bottleMax[1] = Integer.parseInt(st.nextToken());
		bottleMax[2] = Integer.parseInt(st.nextToken());
		boolean check[][][] = new boolean[bottleMax[0]+1][bottleMax[1]+1][bottleMax[2]+1];
		List<Integer> res = new ArrayList<>();
		Queue<int []> queue = new LinkedList<int[]>();
		queue.offer(new int[] {0,0,bottleMax[2]});
		check[0][0][bottleMax[2]] = true;
		int [] insert;
		int[] cur;
		while(!queue.isEmpty()) {
			 cur = queue.poll();
			if(cur[0]==0&&!res.contains(cur[2])) {
				res.add(cur[2]);
			}
			for(int i=0;i<3;i++) {
				if(cur[i]==0) continue;
				for(int j=0;j<3;j++) {
					if(i==j) continue;
					if(cur[j]==bottleMax[j]) continue;
					insert = Arrays.copyOf(cur,3);
					if(cur[j]+cur[i]>bottleMax[j]) {
						insert[j] = bottleMax[j];
						insert[i] = cur[i] - ( bottleMax[j]-cur[j]); 
					}
					else {
						insert[j] = cur[j]+cur[i];
						insert[i] = 0;
					}
					if(check[insert[0]][insert[1]][insert[2]]) continue;
					queue.offer(insert);
					check[insert[0]][insert[1]][insert[2]] = true;
				}
			}
		}
		Collections.sort(res);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<res.size();i++) {
			sb.append(res.get(i)+" ");
		}
		System.out.println(sb.toString());		
	}

}