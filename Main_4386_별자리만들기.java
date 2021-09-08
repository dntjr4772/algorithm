import java.io.*;
import java.util.*;

public class Main_4386_별자리만들기 {
	static int n;
	static double result;
	static Star[] stars;
	static Double[][] distance;
	static PriorityQueue<Edge> PQ;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		stars=new Star[n];
		distance=new Double[n][n];
		visit=new boolean[n];
		Double x,y;
		PQ=new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			st=new StringTokenizer(br.readLine());
			x=Double.parseDouble(st.nextToken());
			y=Double.parseDouble(st.nextToken());
			stars[i]=new Star(x,y);
		}
		//별들끼리 거리구하기
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				distance[i][j]=distance[j][i]=Math.sqrt((stars[i].x-stars[j].x)*(stars[i].x-stars[j].x)+(stars[i].y-stars[j].y)*(stars[i].y-stars[j].y));
				
			}
		}
		//prim
		PQ.add(new Edge(0,0));
		while(!PQ.isEmpty()) {
			Edge cur=PQ.poll();
			if(visit[cur.node]) continue;
			visit[cur.node]=true;
			result+=cur.dis;
			for (int next = 0; next < n; next++) {
				if(visit[next]) continue;
				PQ.add(new Edge(next,distance[cur.node][next]));
			}
		}
		System.out.println(Math.round(result*100)/100.0);
	}

	static class Star{
		double x,y;
		Star(double x, double y){
			this.x=x;
			this.y=y;
		}
	}
	static class Edge implements Comparable<Edge>{
		int node;
		double dis;
		Edge(int node,double dis){
			this.node=node;
			this.dis=dis;
		}
		public int compareTo(Edge o) {
			return (int)(this.dis-o.dis);
		}
	}
}
