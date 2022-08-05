import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int truck[] = new int[n];
		Queue<int[]> bridge = new LinkedList<int[]>();
		int totalWeight = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n;i++) {
			truck[i] = Integer.parseInt(st.nextToken());
		}
		totalWeight = truck[0];
		int count=1;
		int lastEnter = 0;
		bridge.offer(new int[] {truck[0],1});
		while(!bridge.isEmpty()) {
			count++;
			int size = bridge.size();
			for(int i=0; i<size;i++) {
				int [] cur = bridge.poll();
				cur[1]+=1;
				if(cur[1]>w) {
					totalWeight-=cur[0];
				}
				else {
					bridge.offer(cur);
				}
			}
			if(lastEnter+1<n&&totalWeight+truck[lastEnter+1]<=L) {
				lastEnter+=1;
				bridge.offer(new int[] {truck[lastEnter],1});
				totalWeight+=truck[lastEnter];
			}
		}
		System.out.println(count);
	}
	
	

}