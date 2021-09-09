import java.io.*;
import java.util.*;
public class Main_7576_≈‰∏∂≈‰ {

	static int N,M,cnt=-1;
	static int[][] map;
	static Queue<int[]> Q;
	static int[] dy= {1,0,-1,0};
	static int[] dx= {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		Q=new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1)
					Q.add(new int[] {i,j});
			}
		}
		while(!Q.isEmpty()) {
			int size=Q.size();
			cnt++;
			for (int i = 0; i < size; i++) {
				int[] cur=Q.poll();
				int y=cur[0];
				int x=cur[1];
				for (int k = 0; k < 4; k++) {
					int ny=y+dy[k];
					int nx=x+dx[k];
					if(ny<0 || ny>=N ||nx<0 || nx>=M) continue;
					if(map[ny][nx]!=0) continue;
					Q.add(new int[] {ny,nx});
					map[ny][nx]=1;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(cnt);

	}	//end of main

}
