import java.io.*;
import java.util.*;

public class Main_4195_ģ����Ʈ��ũ {
	static HashMap<String,Integer> map;	//key :��� �̸�, value : parent �ε���
	static int[] parent,cnt;	//cnt : parent�� �Ȱ��� �ε������鼭 ó������ 1�� �ʱ�ȭ
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int T=Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			map=new HashMap<>();
			st=new StringTokenizer(br.readLine());
			int F=Integer.parseInt(st.nextToken());
			parent=new int[2*F];
			cnt=new int[2*F];
			Arrays.fill(cnt, 1);
			int idx=0;
			for (int f = 0; f < F; f++) {
				st=new StringTokenizer(br.readLine());
				String a=st.nextToken();
				String b=st.nextToken();
				if(!map.containsKey(a)) {
					map.put(a, idx);	
					parent[idx]=idx++;	//ó���� �ڱ� �ڽ��� �θ�
				}
				if(!map.containsKey(b)) {
					map.put(b, idx);	
					parent[idx]=idx++;	
				}
				System.out.println(union(map.get(a),map.get(b)));
			}	//end of f
		}	// end of tc
	}
	private static int union(int a, int b) {
		a=find(a);
		b=find(b);
		if(a!=b) {
			parent[b]=a;
			cnt[a]+=cnt[b];
		}
		return cnt[a];
	}
	private static int find(int x) {
		if(parent[x]==x)
			return x;
		return parent[x]=find(parent[x]);
	}
	
}
