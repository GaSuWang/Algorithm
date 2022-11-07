import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int L,R,C;
		int [] start;
		int [] exit;
		char [][][]map;
		int [][][] check;
		int dx[] = {1,0,-1,0,0,0};
		int dy[] = {0,1,0,-1,0,0};
		int dz[] = {0,0,0,0,1,-1};
		//#막힌칸, .비어있는칸, S시작, E출구
		while(true) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if(L==0&&R==0&&C==0) break;
			start  = new int[3];
			exit = new int[3];
			map = new char[L][R][C];
			check = new int [L][R][C];
			for(int i=0;i<L;i++) {
				for(int j=0; j<R;j++) {
					Arrays.fill(check[i][j], 1000000);
					String temp = br.readLine();
					map[i][j] = temp.toCharArray();
					if(temp.indexOf('S')!=-1) {
						start[0] = i;
						start[1] = j;
						start[2] = temp.indexOf('S');
					}
					if(temp.indexOf('E')!=-1) {
						exit[0] = i;
						exit[1] = j;
						exit[2] = temp.indexOf('E');
					}
				}
				br.readLine();
			}
			check[start[0]][start[1]][start[2]] = 0;
			Queue<int[]> queue = new LinkedList<int[]>();
			queue.offer(new int[] {start[0],start[1],start[2],0});
			while(!queue.isEmpty()) {
				int [] cur = queue.poll();
				if(cur[0]==exit[0]&&cur[1]==exit[1]&&cur[2]==exit[2]) {
					continue;
				}
				for(int i=0; i<6;i++) {
					int nextX = cur[2] +dx[i];
					int nextY = cur[1] +dy[i];
					int nextZ = cur[0] +dz[i];
					if(nextX<0||nextX>=C||nextY<0||nextY>=R||nextZ<0||nextZ>=L) continue;
					if(check[nextZ][nextY][nextX] <= cur[3]+1) continue;
					if(map[nextZ][nextY][nextX]=='#') continue;
					check[nextZ][nextY][nextX] = cur[3]+1;
					queue.offer(new int[] {nextZ,nextY,nextX,cur[3]+1});
				}
			}
			System.out.println(check[exit[0]][exit[1]][exit[2]]==1000000?"Trapped!":"Escaped in "+ check[exit[0]][exit[1]][exit[2]]+" minute(s).");
		}
		
	}
}
