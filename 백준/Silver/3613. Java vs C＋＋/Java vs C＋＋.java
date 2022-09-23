import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 2022.09.23
 * Java vs C++
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        
        boolean java = false;
        boolean c = false;
        for(int i = 0, size = str.length(); i < size; i++) {
        	//ch 현재 문자
            char ch = str.charAt(i);
            //현재 문자 -'a'
            int num = ch - 'a';
            
            //소문자면 그냥 붙임
            if(num >= 0) sb.append(ch);
            //소문자가 아니면
            else {
            	//언더바면
                if(num == -2) {
                	//자바로 변환
                    java = true;
                    //언더바가 마지막이거나 처음이거나 다음이 언더바이거나 이미 c로 변환된거거나 에러출력
                    if(i+1 >= size || i == 0 || str.charAt(i+1) -'a' < 0 || c) {
                        System.out.println("Error!");
                        return;
                    }
                    //그렇지 않으면 다음거 대문자 변환해서 붙임
                    sb.append((char)(str.charAt(i+1) - 32));
                    i++;
                    
                //언더버가 아니고 대문자면
                }else if(num >= -32 && num <= -7) {
                	//c로변환
                    c = true;
                    //대문자가 처음으로 오거나 이미 자바변환이면 에러
                    if(i == 0 || java) {
                        System.out.println("Error!");
                        return;
                    }
                    //언더a바 붙임
                    sb.append("_").append((char)(ch + 32));
                }
//                else {
//                    System.out.println("Error!");
//                    return;
//                }
            }
            
        }
        
        //if(!java && !c) System.out.println("Error!");
         System.out.println(sb.toString());
        
    }
}