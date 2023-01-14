# [Gold I] 구슬 탈출 2 - 13460 

[문제 링크](https://www.acmicpc.net/problem/13460) 

### 성능 요약

메모리: 11744 KB, 시간: 76 ms

### 분류

너비 우선 탐색(bfs), 그래프 이론(graphs), 그래프 탐색(graph_traversal), 구현(implementation), 시뮬레이션(simulation)

### 문제 설명

<p>스타트링크에서 판매하는 어린이용 장난감 중에서 가장 인기가 많은 제품은 구슬 탈출이다. 구슬 탈출은 직사각형 보드에 빨간 구슬과 파란 구슬을 하나씩 넣은 다음, 빨간 구슬을 구멍을 통해 빼내는 게임이다.</p>

<p>보드의 세로 크기는 N, 가로 크기는 M이고, 편의상 1×1크기의 칸으로 나누어져 있다. 가장 바깥 행과 열은 모두 막혀져 있고, 보드에는 구멍이 하나 있다. 빨간 구슬과 파란 구슬의 크기는 보드에서 1×1크기의 칸을 가득 채우는 사이즈이고, 각각 하나씩 들어가 있다. 게임의 목표는 빨간 구슬을 구멍을 통해서 빼내는 것이다. 이때, 파란 구슬이 구멍에 들어가면 안 된다.</p>

<p>이때, 구슬을 손으로 건드릴 수는 없고, 중력을 이용해서 이리 저리 굴려야 한다. 왼쪽으로 기울이기, 오른쪽으로 기울이기, 위쪽으로 기울이기, 아래쪽으로 기울이기와 같은 네 가지 동작이 가능하다.</p>

<p>각각의 동작에서 공은 동시에 움직인다. 빨간 구슬이 구멍에 빠지면 성공이지만, 파란 구슬이 구멍에 빠지면 실패이다. 빨간 구슬과 파란 구슬이 동시에 구멍에 빠져도 실패이다. 빨간 구슬과 파란 구슬은 동시에 같은 칸에 있을 수 없다. 또, 빨간 구슬과 파란 구슬의 크기는 한 칸을 모두 차지한다. 기울이는 동작을 그만하는 것은 더 이상 구슬이 움직이지 않을 때 까지이다.</p>

<p>보드의 상태가 주어졌을 때, 최소 몇 번 만에 빨간 구슬을 구멍을 통해 빼낼 수 있는지 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫 번째 줄에는 보드의 세로, 가로 크기를 의미하는 두 정수 N, M (3 ≤ N, M ≤ 10)이 주어진다. 다음 N개의 줄에 보드의 모양을 나타내는 길이 M의 문자열이 주어진다. 이 문자열은 '<code>.</code>', '<code>#</code>', '<code>O</code>', '<code>R</code>', '<code>B</code>' 로 이루어져 있다. '<code>.</code>'은 빈 칸을 의미하고, '<code>#</code>'은 공이 이동할 수 없는 장애물 또는 벽을 의미하며, '<code>O</code>'는 구멍의 위치를 의미한다. '<code>R</code>'은 빨간 구슬의 위치, '<code>B</code>'는 파란 구슬의 위치이다.</p>

<p>입력되는 모든 보드의 가장자리에는 모두 '<code>#</code>'이 있다. 구멍의 개수는 한 개 이며, 빨간 구슬과 파란 구슬은 항상 1개가 주어진다.</p>

### 출력 

 <p>최소 몇 번 만에 빨간 구슬을 구멍을 통해 빼낼 수 있는지 출력한다. 만약, 10번 이하로 움직여서 빨간 구슬을 구멍을 통해 빼낼 수 없으면 -1을 출력한다.</p>

```Java
////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Pos {
		int[] red;
		int[] blue;
		int dir;

		Pos(int[] red, int[] blue, int dir) {
			this.red = red;
			this.blue = blue;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Pos [red=" + Arrays.toString(red) + ", blue=" + Arrays.toString(blue) + ", dir=" + dir + "]";
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] target = new int[2];
		char[][] map = new char[N][M];
		//위치 체크 배열 [빨강y][빨강x][파랑y][파랑x]
		boolean check[][][][] = new boolean[N][M][N][M];
		//시작위치,처음에는 방향을 저장해서 이전에 왔던 방향으로 다시 돌아가지 않게 하려 했으나 방문배열 만들어서 안씀
		Pos start = new Pos(new int[2], new int[2], -3);
		//입력받기
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp[j];
				//구멍위치
				if (map[i][j] == 'O') {
					target[0] = i;
					target[1] = j;
				}
				//구슬 위치, 처음위치 저장하고 빈칸으로 바꿈
				else if (map[i][j] == 'R') {
					start.red[0] = i;
					start.red[1] = j;
					map[i][j] = '.';
				} else if (map[i][j] == 'B') {
					start.blue[0] = i;
					start.blue[1] = j;
					map[i][j] = '.';
				}
			}
		}

		Queue<Pos> queue = new LinkedList<Pos>();
		//시작위치 큐에 넣고 방문처리
		queue.offer(start);
		check[start.red[0]][start.red[1]][start.blue[0]][start.blue[1]] = true;
		//움직인 횟수
		int iter = 0;
		//현재 움직임 단계에서 큐 사이즈
		int size;
		//큐가 빌때까지 혹은 10번 넘을때까지
		while (!queue.isEmpty() && iter < 10) {
			iter++;
			size = queue.size();
			//현재 움직임 횟수에서 반복
			while (--size >=0) {
				//현재 구슬 위치
				Pos cur = queue.poll();
				//4방향으로 움직임
				for (int i = 0; i < 4; i++) {
					//구슬을 움직이는 moving 메소드
					Pos next = moving(cur, i, map);
					//구멍에 빠지면 x,y위치 0,0으로 바꿈
					//빨강,파랑 동시에 구멍에 빠질 수 있기 때문에 파랑먼저 검사
					//파랑 구슬이 구멍에 빠지면 이번건 실패이기 때문에 건너뜀
					if (next.blue[0] == 0 && next.blue[1] == 0)
						continue;
					//빨강 구슬이 구멍에 빠지면 성공했기 때문에 반복회수 출력 후 끝
					if (next.red[0] == 0 && next.red[1] == 0) {
						System.out.println(iter);
						return;
					}
					//만약 방문했으면 건너뜀
					if (check[next.red[0]][next.red[1]][next.blue[0]][next.blue[1]])
						continue;
					//큐에 넣고 방문처리
					queue.offer(next);
					check[next.red[0]][next.red[1]][next.blue[0]][next.blue[1]] = true;
					
				}
			}
		}
		System.out.println(-1);

	}

	public static Pos moving(Pos cur, int dir, char[][] map) {
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		//다음 구슬 위치 초기화
		Pos next = new Pos(new int[] { -1, -1 }, new int[] { -1, -1 }, dir);
		//flag 구슬이 움직인 경로에 다른 구슬이 있는지 판별, 있다면 구슬 위치 조정해야함
		boolean flagR = false;
		boolean flagB = false;
		//빨강 먼저 움직임
		//현재좌표 저장
		int curX = cur.red[1];
		int curY = cur.red[0];
		while (true) {
			//좌표 다음으로 옮김
			int nextX = curX + dx[dir];
			int nextY = curY + dy[dir];
			//옮긴 좌표 벽인지 확인, 벽이면 반복 멈춤
			if (map[nextY][nextX] == '#')
				break;
			//옮긴 좌표 구멍이면 좌표 0,0으로 초기화,
			//구멍에 빠졌기때문에 위치조정 불필요 flag false처리
			if (map[nextY][nextX] == 'O') {
				curX = 0;
				curY = 0;
				flagR = false;
				break;
			}
			//만약 움직이다가 다른 구슬을 만나면 flag true
			if(nextY==cur.blue[0]&&nextX==cur.blue[1]) {
				flagR = true;
			}
			//현재위치를 옮긴 위치로 갱신
			curX = nextX;
			curY = nextY;
		}
		//만약 옮기다가 다른 구슬이 있었으면 한칸 이전으로 움직임
		//구슬은 1칸에 하나만 있을 수 있음
		//구슬을 움직일 때 다른 구슬은 고려하지 않고 옮겼기 때문에 여기서 다른 구슬영향 반영
		if (flagR) {
			curX = curX - dx[dir];
			curY = curY - dy[dir];
		}
		//파랑구슬 빨강구슬과 동일한 로직
		next.red[0] = curY;
		next.red[1] = curX;
		curX = cur.blue[1];
		curY = cur.blue[0];
		while (true) {
			int nextX = curX + dx[dir];
			int nextY = curY + dy[dir];
			if (map[nextY][nextX] == '#')
				break;
			if (map[nextY][nextX] == 'O') {
				curX = 0;
				curY = 0;
				flagB = false;
				break;
			}
			if(nextY==cur.red[0]&&nextX==cur.red[1]) {
				flagB = true;
			}
			curX = nextX;
			curY = nextY;
		}
		
		if (flagB) {
			curX = curX - dx[dir];
			curY = curY - dy[dir];
		}
		next.blue[0] = curY;
		next.blue[1] = curX;
		return next;
	}
}
```
