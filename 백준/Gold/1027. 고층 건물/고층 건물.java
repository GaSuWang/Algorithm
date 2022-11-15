import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2022.11.15
 * 고층 건물
 */
public class Main {
    public static void main(String[] args) throws IOException {
//    	double a = 1.0 * 3 / 10;
//    	double b =;
    	
//    	System.out.println(a);
//    	System.out.println(b);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] buildings = new int[n]; // 빌딩의 높이
        for(int i = 0; i < n; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }
        
        int result = 0; // 결과
        for(int i = 0; i < n; i++) { // 빌딩 A
            int cnt = 0; 
            for(int j = 0; j < n; j++) { // 빌딩 B
                if(i == j) continue;
                int start = Math.min(i, j);
                int end = Math.max(i, j);
                double lean = (double)(buildings[end]-buildings[start])/(end-start); // 빌딩 A, B의 기울기
                boolean flag = true;
                //double height = buildings[start];
                for(int k = start+1; k < end; k++) { // A, B의 기울기로 선분을 그었을 때 그안에 있는 빌딩들이 더 작아야함
                    //height += lean;
                    if(buildings[start]+(lean*(k-start)) <= buildings[k]) {
                        flag = false;
                        break; 
                    }
                }
                
                if(flag) cnt++;
            }
            
//            System.out.println(cnt);
            result = Math.max(result, cnt); // 최고 값 갱신
        }
        
        System.out.println(result);
        
    }
}                                        