import java.io.*;
import java.util.*;
public class Main_2667_단지번호붙이기 {

	static int N,result,cnt;
	static boolean[][] map,visit;
	static List<Integer> houseCnt;
	static int[] dy= {1,0,-1,0};
	static int[] dx= {0,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		map=new boolean[N][N];
		visit=new boolean[N][N];
		houseCnt=new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			String input=st.nextToken();
			for (int j = 0; j < N; j++) {
				if(input.charAt(j)=='1')
					map[i][j]=true;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]&&!visit[i][j]) {
					cnt=1;
					result++;
					dfs(i,j);
					houseCnt.add(cnt);
				}
			}
		}
		Collections.sort(houseCnt);
		StringBuilder sb=new StringBuilder();
		sb.append(result).append("\n");
		for (int i = 0; i < result; i++) 
			sb.append(houseCnt.get(i)).append("\n");
		System.out.println(sb);
	}
	private static void dfs(int y, int x) {
		visit[y][x]=true;
		for (int k = 0; k < 4; k++) {
			int ny=y+dy[k];
			int nx=x+dx[k];
			if(ny<0 || nx<0 || ny>=N || nx>=N) continue;
			if(!map[ny][nx] || visit[ny][nx]) continue;
			cnt++;
			dfs(ny,nx);
		}
		
	}
}
