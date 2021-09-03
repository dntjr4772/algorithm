import java.io.*;
import java.util.*;

public class Main_11725_트리의부모찾기 {
	static List<Integer> list[];
	static int N;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		parent=new int[N+1];
		list=new ArrayList[N+1];
		for (int i = 1; i <= N; i++) 
			list[i]=new ArrayList<>();
		int a,b;
		for (int i = 0; i < N-1; i++) {
			st=new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		dfs(1);
		parent[1]=1;
		StringBuilder sb=new StringBuilder();
		for (int i = 2; i <= N; i++) 
			sb.append(parent[i]).append("\n");
		
		System.out.println(sb);
	}
	private static void dfs(int idx) {
		for(int child : list[idx]) {
			if(parent[child]!=0) continue;
			parent[child]=idx;
			dfs(child);
		}
		
	}
}
