
////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char [][] map = new char[N][N];
		for(int i=0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
		}
		int dx[] = {1,0,-1,0};
		int dy[] = {0,1,0,-1};
		List<Integer> arr = new ArrayList<Integer>();
		Queue<int[]> queue = new LinkedList<int[]>();
		for(int i=0; i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]=='0') continue;
				int count = 1;
				queue.offer(new int[] {i,j});
				map[i][j]='0';
				while(!queue.isEmpty()) {
					int [] cur = queue.poll();
					for(int k=0; k<4;k++) {
						int nextX = cur[1]+dx[k];
						int nextY = cur[0]+dy[k];
						if(nextX<0||nextX>=N||nextY<0||nextY>=N) continue;
						if(map[nextY][nextX]!='1') continue;
						queue.offer(new int[] {nextY,nextX});
						map[nextY][nextX] = '0';
						count++;
					}
				}
				arr.add(count);
			}
		}
		System.out.println(arr.size());
		Collections.sort(arr);
		for(int out : arr) {
			System.out.println(out);
		}
	}

}