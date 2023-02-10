import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Item{
	char [] num;
	String command;
	public Item(char[] num, String command) {
		super();
		this.num = num;
		this.command = command;
	}
	@Override
	public String toString() {
		return "Item [num=" + Arrays.toString(num) + ", command=" + command + "]";
	}
	
	
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		outer: for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			//char [] start = intToCharArr(startInt);
			boolean check []  = new boolean[10000];
			int goal = Integer.parseInt(st.nextToken());
			Queue<Item> queue = new LinkedList<Item>();
			if(start!=0) {
				insertQueue(start,queue,check,goal,"","");
			}
			else insertQueue(9999,queue,check,goal,"S","");
			while(!queue.isEmpty()) {
					Item cur = queue.poll();
					if(insertQueue(commandD(cur.num),queue,check,goal,"D",cur.command)
						|| insertQueue(commandS(cur.num),queue,check,goal,"S",cur.command)
						|| insertQueue(commandL(cur.num),queue,check,goal,"L",cur.command)
						|| insertQueue(commandR(cur.num),queue,check,goal,"R",cur.command)	
						) continue outer; 
					
			}
			
		}
		
		
	}
	
	public static char[] intToCharArr(int num) {
		char [] res = new char[4];
		int div = 1000;
		for(int i=0;i<4;i++) {
			res[i] = (char) ((num/div)+'0');
			num%=div;
			div/=10;
			
		}
		return res;
	}
	
	public static boolean insertQueue(int num, Queue<Item> queue, boolean[]check, int goal, String command, String beforeCommand) {
		if(num==goal) {
			System.out.println(beforeCommand+command);
			return true;
		}
		if(check[num]) return false;
		check[num] = true;
		queue.offer(new Item(intToCharArr(num),beforeCommand+command));
		return false;
	}
	
	public static int charArrToInt(char[] cur) {
		int res=0;
		for(int i=0;i<4;i++) {
			res=(res*10)+(int)(cur[i]-'0');
		}
		return res;
	}
	
	public static int commandD(char[] numChar) {
		int num = charArrToInt(numChar);
		return (2*num)%10000;
	}
	public static int commandS(char[] numChar) {
		int num = charArrToInt(numChar);
		if(num==0) {
			return 9999;
		}
		return num-1;
	}
	public static int commandL(char[] numChar) {
		char [] num = new char[4];
		for(int i=0; i<4;i++) {
			num[i] = numChar[i];
		}
		
		char temp = num[0];
		for(int i=0; i<3;i++) {
			num[i] = num[i+1];
		}
		num[3] = temp;
		return charArrToInt(num);
	}
	public static int commandR(char[] numChar) {
		char [] num = new char[4];
		for(int i=0; i<4;i++) {
			num[i] = numChar[i];
		}
		char temp = num[3];
		for(int i=3;i>0;i--) {
			num[i] = num[i-1];
		}
		num[0] = temp;
		return charArrToInt(num);
	}
	
}
