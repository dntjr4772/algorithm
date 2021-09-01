import java.io.*;
import java.util.StringTokenizer;

public class Main_1806_ºÎºÐÇÕ {
	static final int INF=987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int S=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int[] arr=new int[N];
		for (int i = 0; i < N; i++) 
			arr[i]=Integer.parseInt(st.nextToken());
		int right=0,sum=arr[0],result=INF;
		for (int left = 0; left < N; left++) {
			while(sum<S &&right<N) {
				right++;
				if(right!=N)
					sum+=arr[right];
			}
			if(right==N) break;
			result=Integer.min(result, right-left+1);
			sum-=arr[left];
		}
		
		if(result==INF)
			System.out.println(0);
		else
			System.out.println(result);
	}
}
