import java.util.*;

public class Kruskal {

    public static WGraph kruskal(WGraph g) {

        ArrayList<Edge> edgesList = g.listOfEdgesSorted();          //get list of edges
        DisjointSets setCopy = new DisjointSets(g.getNbNodes());    //get disjoint sets

        WGraph mst = new WGraph();

        for (int i = 0; i < edgesList.size(); i++) {
            if (IsSafe(setCopy, edgesList.get(i))) {
                setCopy.union(edgesList.get(i).nodes[0], edgesList.get(i).nodes[1]);
                mst.addEdge(edgesList.get(i));
            }
        }
        return mst;
    }

    public static Boolean IsSafe(DisjointSets p, Edge e) {

        if (p.find(e.nodes[0]) != p.find(e.nodes[1])) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        String file = args[0];
        WGraph g = new WGraph(file);
        WGraph t = kruskal(g);
        System.out.println(t);

    }
}
