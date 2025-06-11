import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++){
            char[] paper = br.readLine().toCharArray();
            if (canFold(paper)){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    public static boolean canFold (char[] paper) {
        if (paper.length == 1){
            return true;
        } else {
            int middle = paper.length/2;
            for (int j = 0; j < paper.length / 2; j++){

                //배열의 가운데를 기준으로 좌측과 우측의 합이 1이 되어야 함. 좌측과 우측이 서로 같다면 접을 수 없음
                if (paper[j] == paper[paper.length - j - 1]){
                    return false;
                }
            }
            //좌측 배열
            char[] left = Arrays.copyOfRange(paper, 0, middle);

            //우측 배열
            char[] right = Arrays.copyOfRange(paper, middle + 1, paper.length);
            
            return canFold(left) && canFold(right);
        }
    }
}