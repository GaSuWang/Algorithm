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
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int y = Integer.parseInt(st.nextToken());
    	int x = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	int map[][] = new int[N][M];
    	//    2
    	// 4  1  3  6
    	//    5
    	//    6
    	
    	//주사위 펼쳤을때 세로값들
    	int [] diceV = new int[4]; //[2,1,5,6] 위에서 아래로
    	//주사위 펼쳤을때 가로값들
    	int [] diceH = new int[4];// [4,1,3,6]왼쪽에서 오른쪽으로
    	// 동,서로 움직일때는 diceH배열 돌리기, 북,남으로 움직일때는 diceV배열 돌리기
    	// diceH[1]==diceV[1], diceH[3]==diceV[3] 이기 때문에 배열 돌려준 후 값 갱신하기
    	
    	
    	//동서북남 이동
    	int dx[] = {1,-1,0,0};
    	int dy[] = {0,0,-1,1};
    	
    	for(int i=0; i<N;i++) {
    		st =new StringTokenizer(br.readLine()," ");
    		for(int j=0; j<M;j++) {
    			map[i][j] = Integer.parseInt(st.nextToken()) ;
    		}
    	}
    	int[] commands = new int[K];
    	st = new StringTokenizer(br.readLine()," ");
    	for(int i=0; i<K;i++) {
    		commands[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	for(int i=0; i<K;i++) {
    		//이동 명령대로 x,y값 변경
    		int nextX = x +dx[commands[i]-1];
    		int nextY = y +dy[commands[i]-1];
    		//범위 바깥으로 넘어가면 pass
    		if(nextX<0||nextX>=M||nextY<0||nextY>=N) continue;
    		//x,y값 갱신
    		x = nextX;
    		y= nextY;
    		//동쪽으로 움직일때
    		
    		if(commands[i]==1) {
    			//일단 0번째 값 저장
    			int temp = diceH[0];
    			//오른쪽에 있는 값들 왼쪽으로 땡겨줌
    			for(int j=0; j<3;j++) {
    				diceH[j] = diceH[j+1];
    			}
    			//3번째 값 0번째로 갱신
    			diceH[3] = temp;
    			//1번,3번 값 맞춰주기
    			diceV[1] = diceH[1];
    			diceV[3] = diceH[3];
    		}
    		else if(commands[i]==2) {
    			//서
    			int temp = diceH[3];
    			//왼쪽에 있는 값들 오른쪽으로 땡겨줌
    			for(int j=3;j>0;j--) {
    				diceH[j] = diceH[j-1];
    			}
    			diceH[0] = temp;
    			diceV[1] = diceH[1];
    			diceV[3] = diceH[3];
    		}
    		else if(commands[i]==3) {
    			//북
    			int temp = diceV[3];
    			//위에있는 값 아래로 땡김, 즉 배열상 왼쪽 값 오른쪽으로 땡김
    			for(int j=3; j>0;j--) {
    				diceV[j] = diceV[j-1];
    			}
    			diceV[0] = temp;
    			diceH[1] = diceV[1];
    			diceH[3] = diceV[3];
    		}
    		else if(commands[i]==4){
    			int temp = diceV[0];
    			//아래에있는 값 위로 땡김, 즉 배열상 오른쪽 값 왼쪽으로 땡김
    			for(int j=0; j<3;j++) {
    				diceV[j] = diceV[j+1];
    			}
    			diceV[3] = temp;
    			diceH[1] = diceV[1];
    			diceH[3] = diceV[3];
    			//남
    		}
    		if(map[y][x]==0) {
    			//주사위 바닥이 칸에 복사
    			map[y][x] = diceH[1];
    			
    		}
    		else {
    			//칸이 바닥으로 복사 칸은 0
    			//바닥은 diceH[1], diceV[1] 이므로 같이 변경해줌
    			diceH[1] = map[y][x];
    			diceV[1] = map[y][x];
    			map[y][x] = 0;
    		}
    		//주사위 윗면 출력
    		System.out.println(diceH[3]);	
    	}  
    }   
}