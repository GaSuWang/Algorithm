import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[][] map = new String[N][N];
		StringTokenizer st;
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N;j++) {
				map[i][j] = st.nextToken();
			}
		}
		for(int i=0; i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!map[i][j].equals("X")) continue;
				map[i][j] = "O";
				if(dfs(i,j,map,N,0)) {
					System.out.println("YES");
					return;
				}
				map[i][j] = "X";
			}
		}
		System.out.println("NO");
	}
	public static boolean dfs(int y,int x, String[][]map,int N,int num) {
		
		if(num==2) {
			//System.out.println("------------");
			return check(map,N);
			
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!map[i][j].equals("X")) continue;
				map[i][j] = "O";
				if(dfs(i,j,map,N,num+1)) {
					return true;
				}
				map[i][j] = "X";
			}
		}
		return false;
	}

	
	public static boolean check(String[][]map, int N) {
		
		int [] dx= new int[] {1,0,-1,0};
		int [] dy= new int[] {0,1,0,-1};
//		for(int i=0;i<N;i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		for(int i=0; i<N;i++) {
			
			for(int j=0; j<N;j++) {
				if(!map[i][j].equals("T")) continue;
				for(int k=0;k<4;k++) {
					int nextX = j+dx[k];
					int nextY = i+dy[k];
					while(nextX>=0&&nextX<N&&nextY>=0&&nextY<N&&!map[nextY][nextX].equals("O")) {
						if(map[nextY][nextX].equals("S")) return false;
						nextX = nextX + dx[k] ;
						nextY = nextY + dy[k];
					}
				}
			}
		}
		
		return true;
	}
}