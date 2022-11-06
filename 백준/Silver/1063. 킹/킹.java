import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String kingXY = st.nextToken();
        String stoneXY = st.nextToken();
        char kingX = kingXY.charAt(0);
        char kingY = kingXY.charAt(1);
        char stoneX = stoneXY.charAt(0);
        char stoneY = stoneXY.charAt(1);
        int T = Integer.parseInt(st.nextToken());
        for(int t=0; t<T; t++) {
        	String command = br.readLine();
        	int moveX = 0;
        	int moveY = 0;
        	for(int i=0; i<command.length();i++) {
        		if('R'==command.charAt(i)) {
            		moveX = 1;
            	}
        		else if('L'==command.charAt(i)) {
            		moveX = -1;
            	}
        		else if('B'==command.charAt(i)) {
            		moveY = -1;
            	}
        		else if('T'==command.charAt(i)) {
            		moveY = 1;
            	}
        	}
        	char nextX = (char) (kingX + moveX);
        	char nextY = (char) (kingY + moveY);
        	if(nextX<'A'||nextX>'H'||nextY<'1'||nextY>'8') continue;
        	char nextStoneX = stoneX;
        	char nextStoneY = stoneY;
        	if(nextX == stoneX && nextY==stoneY) {
        		nextStoneX = (char) (stoneX + moveX);
        		nextStoneY = (char) (stoneY + moveY);
        		if(nextStoneX<'A'||nextStoneX>'H'||nextStoneY<'1'||nextStoneY>'8') continue;
        	}
        	
        	kingX = nextX;
        	kingY = nextY;
        	stoneX = nextStoneX;
    		stoneY = nextStoneY;	
        }
        StringBuilder sb = new StringBuilder();
        sb.append(kingX);
        sb.append(kingY);
        System.out.println(sb.toString());
        sb = new StringBuilder();
        sb.append(stoneX);
        sb.append(stoneY);
        System.out.println(sb.toString());
    }
   
}