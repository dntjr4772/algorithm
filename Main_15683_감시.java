import java.io.*;
import java.util.*;

public class Main_15683_감시 {
	static int N,M,cameraNum,result=999;
	static char[][] map,mapCopy;
	static List<int[]> cameras;
	static int[] dy= {0,1,0,-1};	//오아왼위
	static int[] dx= {1,0,-1,0};
	static int[] cameraDir;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new char[N][M];
		mapCopy=new char[N][M];
		cameras=new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]=st.nextToken().charAt(0);
				mapCopy[i][j]=map[i][j];
				if(map[i][j]!='0'&&map[i][j]!='6')
					cameras.add(new int[] {i,j});
			}
		}
		cameraNum=cameras.size();
		cameraDir=new int[cameraNum];
		cases(0);
		System.out.println(result);
	}
	
	//cctv의 방향 설정
	private static void cases(int depth) {
		if(depth==cameraNum) {
			go();
			return;
		}
		for (int i = 0; i < 4; i++) {
			cameraDir[depth]=i;
			cases(depth+1);
		}
	}
	private static void go() {
		for (int i = 0; i < cameraNum; i++) {
			int[] loc=cameras.get(i);
			char camera=map[loc[0]][loc[1]];
			if(camera=='1') {
				shoot(loc[0],loc[1],cameraDir[i]);
			}else if(camera=='2') {
				shoot(loc[0],loc[1],cameraDir[i]);
				shoot(loc[0],loc[1],cameraDir[i]+2);
			}else if(camera=='3') {
				shoot(loc[0],loc[1],cameraDir[i]);
				shoot(loc[0],loc[1],cameraDir[i]+1);
			}else if(camera=='4') {
				shoot(loc[0],loc[1],cameraDir[i]);
				shoot(loc[0],loc[1],cameraDir[i]+1);
				shoot(loc[0],loc[1],cameraDir[i]+2);
			}else if(camera=='5') {
				shoot(loc[0],loc[1],cameraDir[i]);
				shoot(loc[0],loc[1],cameraDir[i]+1);
				shoot(loc[0],loc[1],cameraDir[i]+2);
				shoot(loc[0],loc[1],cameraDir[i]+3);
			}
		}
		counting();
	}
	
	//위치와 방향을 인자로 받아 cctv 가동해서 보이는곳은 '7'로 채우기
	private static void shoot(int y,int x,int dir) {
		dir%=4;
		while(true) {
			y+=dy[dir];
			x+=dx[dir];
			if(y<0 || y>=N || x<0 || x>=M || map[y][x]=='6') break;
			if(map[y][x]!='0') continue;
			map[y][x]='7';
		}
	}
	private static void counting() {
		int cnt=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]=='0') cnt++;
			}
		}
		result=Integer.min(result, cnt);
		//map 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j]=mapCopy[i][j];
			}
		}
	}
	
}
