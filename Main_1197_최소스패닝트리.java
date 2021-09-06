import java.io.*;
import java.util.*;

public class Main_1197_최소스패닝트리 {
	static int V,E,A,B,C,cnt;
	static long result;
	static List<Edge> list[];
	static PriorityQueue<Edge> pq;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		list=new ArrayList[V+1];
		visit=new boolean[V+1];
		pq= new PriorityQueue<>();
		for (int i = 1; i <= V; i++) {
			list[i]=new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st=new StringTokenizer(br.readLine());
			A=Integer.parseInt(st.nextToken());
			B=Integer.parseInt(st.nextToken());
			C=Integer.parseInt(st.nextToken());
			list[A].add(new Edge(B, C));
			list[B].add(new Edge(A, C));
		}
		pq.add(new Edge(1,0));
		while(!pq.isEmpty()) {
			Edge cur=pq.poll();
			if(visit[cur.node]) continue;
			visit[cur.node]=true;
			result+=cur.dis;
			if(++cnt==V) break;
			for(Edge next : list[cur.node]) {
				if(visit[next.node]) continue;
				pq.add(next);
			}
		}
		System.out.println(result);
	}
	
	
	static class Edge implements Comparable<Edge>{
		int node,dis;
		Edge(int node,int dis){
			this.node=node;
			this.dis=dis;
		}
		public int compareTo(Edge o) {
			return this.dis-o.dis;
		}
	}
}
