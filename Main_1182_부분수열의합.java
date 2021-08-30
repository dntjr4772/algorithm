import java.io.*;
import java.util.*;

public class Main_1182_부분수열의합 {
	static int N,S,cnt;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		S=Integer.parseInt(st.nextToken());
		arr=new int[N];
		st=new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) 
			arr[i]=Integer.parseInt(st.nextToken());
		sel(0,0);
		if(S==0) cnt--;
		System.out.println(cnt);
		
	}
	private static void sel(int k,int sum) {
		if(k==N) {
			if(sum==S)
				cnt++;
			return;
		}
		sel(k+1,sum+arr[k]);
		sel(k+1,sum);
	}

}
