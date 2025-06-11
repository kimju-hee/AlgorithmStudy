package zaryogujo;
import java.util.*;

public class New {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T= sc.nextInt(); //테스트 케이스 수
		
		for(int i=0; i<T; i++){
			int n=sc.nextInt();
			int count=1; // 무조건 1명 뽑음
			int interview[]=new int[n+1];
			
			for(int j=0; j<n; j++) {
				int d_rank=sc.nextInt(); // 서류
				int i_rank=sc.nextInt(); // 면접
				interview[d_rank]=i_rank;
			}
			
			int top=interview[1];
			
			for(int j=2; j<=n; j++) {
				if(interview[j]<top) {
					top=interview[j];
					count++;
				}
			}
			System.out.println(count);
			
		}
		sc.close();

	}

}
