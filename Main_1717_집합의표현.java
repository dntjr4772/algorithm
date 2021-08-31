import java.io.*;
import java.util.*;

public class Main_1717_집합의표현 {
	
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n,m,k,a,b;
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		parent=new int[n+1];
		for (int i = 0; i <= n; i++) {
			parent[i]=i;
		}
		for (int i = 0; i < m; i++) {
			st=new StringTokenizer(br.readLine());
			k=Integer.parseInt(st.nextToken());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			if(k==0)
				union(a,b);
			else {
				if(find(a)==find(b))
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}
	private static int find(int num) {
		if(parent[num]==num)
			return num;
		else
			return parent[num]=find(parent[num]);
	}
	private static void union(int a, int b) {
		a=find(a);
		b=find(b);
		if(a!=b) {
			parent[b]=a;
		}
	}

}
