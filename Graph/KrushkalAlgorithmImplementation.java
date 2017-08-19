package Graph;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 *In the name of Allah the Most Merciful.
 * Author
 * Md. Toufiqul Islam
 * Dept. Of CSE
 * Ahsanullah University Of Science And Technology
 */

public class KrushkalAlgorithmImplementation {

	static class Edge implements Comparable<Edge> {
		int u;
		int v;
		int w;

		public Edge(int u, int v, int w) {

			this.u = u;
			this.v = v;
			this.w = w;

		}

		@Override
		public int compareTo(Edge arg0) {

			return this.w - arg0.w;
		}

	}

	int id[];
	static List<Edge> ans = new ArrayList<>();

	public KrushkalAlgorithmImplementation(int a) {

		id = new int[a];
		for (int i = 0; i < a; i++) {
			id[i] = i;
		}
	}

	public int find(int n) {
		while (n != id[n]) {
			n = id[n];
		}
		return n;
	}

	void Union(int i, int j) {
		id[i] = j;
	}

	public void MST(List<Edge> edge) {

		for (int i = 0; i < edge.size(); i++) {

			int uu = find(edge.get(i).u);
			int vv = find(edge.get(i).v);

			if (uu != vv) {

				Union(uu, vv);

				ans.add(edge.get(i));

			}

		}

	}

	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		List<Edge> edge = new ArrayList();
		List<Integer> weights = new ArrayList();

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			int c = sc.nextInt();

			Edge ob = new Edge(a, b, c);
			edge.add(ob);

		}

		KrushkalAlgorithmImplementation K = new KrushkalAlgorithmImplementation(n);

		Collections.sort(edge);

		K.MST(edge);

		int totalWeight = 0;
	System.out.println("THE MST IS ");

		for (int i = 0; i < ans.size(); i++) {
		System.out.println(ans.get(i).u + " " + ans.get(i).v + " " + ans.get(i).w);
			totalWeight += ans.get(i).w;
		}

	System.out.println("Total Weight " + totalWeight);
		//System.out.println(totalWeight*2);
	}
}
