package GraphFramework;

public class DBAllSourceSPAlg extends ShortestPathAlgorithm {

    /*constructor*/
    public DBAllSourceSPAlg(Graph g) {
        this.graph = g;
    }

    /*This method computes all-pairs shortest paths using Dijkstra's algorithm.*/
    public void computeDijkstraBasedSPAlg() {
        
        /*creating an instance of SingleSourceSPAlg called dijkstra, passing the 
        current graph to it as a parameter.*/
        SingleSourceSPAlg dijkstra = new SingleSourceSPAlg(this.graph); 
        
        /* iterates through all the vertices in the graph and calls 
        computeDijkstraAlg() method of dijkstra for each vertex.*/
        for (int i = 0; i < graph.verticesNo; i++) {
            dijkstra.computeDijkstraAlg(graph.vertices[i]);
        }
    }

}
