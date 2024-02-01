import java.util.Arrays;

class Kruskals {
    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    int V, E;
    Edge edge[];

    Kruskals(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    int find(int parent[], int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    void union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    void kruskalsMST() {
        Edge result[] = new Edge[V];
        int e = 0;
        int i = 0;
        for (i = 0; i < V; ++i)
            result[i] = new Edge();

        Arrays.sort(edge);

        int parent[] = new int[V];
        Arrays.fill(parent, -1);

        i = 0;

        while (e < V - 1) {
            Edge next_edge = edge[i++];
            int x = find(parent, next_edge.src);
            int y = find(parent, next_edge.dest);

            if (x != y) {
                result[e++] = next_edge;
                union(parent, x, y);
            }
        }

        System.out.println("Edge \tWeight");
        for (i = 0; i < e; ++i)
            System.out.println(result[i].src + " - " + result[i].dest + "\t" + result[i].weight);
    }

    public static void main(String[] args) {
        int V = 5;
        int E = 7;
        Kruskals graph = new Kruskals(V, E);

        // Add edges
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 2;

        graph.edge[1].src = 0;
        graph.edge[1].dest = 3;
        graph.edge[1].weight = 6;

        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 3;

        graph.edge[3].src = 1;
        graph.edge[3].dest = 4;
        graph.edge[3].weight = 5;

        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 8;

        graph.edge[5].src = 2;
        graph.edge[5].dest = 4;
        graph.edge[5].weight = 7;

        graph.edge[6].src = 3;
        graph.edge[6].dest = 4;
        graph.edge[6].weight = 9;

        graph.kruskalsMST();
    }
}
