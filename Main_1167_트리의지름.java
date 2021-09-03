import java.io.*;
import java.util.*;

public class Main_1167_트리의지름 {
	static int V,max,maxVertex;
	static List<Node> tree[];
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		tree=new ArrayList[V+1];
		visit=new boolean[V+1];
		for (int i = 1; i <= V; i++) 
			tree[i]=new ArrayList<>();
		int a,b,len;
		for (int i = 1; i <= V; i++) {
			st=new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken());
			while(true) {
				b=Integer.parseInt(st.nextToken());
				if(b==-1)
					break;
				len=Integer.parseInt(st.nextToken());
				tree[a].add(new Node(b,len));
			}
		}
		visit[1]=true;
		dfs(1,0);
		Arrays.fill(visit, false);
		max=0;
		dfs(maxVertex,0);
		System.out.println(max);
	}
	
	private static void dfs(int cur,int distance) {
		if(max<distance) {
			max=distance;
			maxVertex=cur;
		}
		visit[cur]=true;
		for(Node next : tree[cur]) {
			if(visit[next.vertex]) continue;
			dfs(next.vertex,distance+next.len);
		}
		
	}

	static class Node{
		int vertex,len;
		Node(int vertex,int len){
			this.vertex=vertex;
			this.len=len;
		}
	}
}
