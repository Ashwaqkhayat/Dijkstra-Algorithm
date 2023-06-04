package GraphFramework;

public class SingleSourceSPAlg extends ShortestPathAlgorithm {

    /*declare instance variables used in the class*/
    String[] path;
    int[] distance;
    double Infinity = Double.POSITIVE_INFINITY;
    
    /*constructor*/
    public SingleSourceSPAlg(Graph g) {
        this.graph = g;
        this.graph.verticesNo = g.verticesNo;
    }
    
    /*This method computes the shortest paths using Dijkstra's 
    algorithm from a given source vertex vert.*/
    public void computeDijkstraAlg(Vertex vert) {
        
        /*initialize the path and distance arrays to have the same length
        as the number of vertices in the graph.*/
        path = new String[graph.verticesNo];
        distance = new int[graph.verticesNo];
        
        /*set all elements of the distance array to Infinity*/
        for (int i = 0; i < graph.verticesNo; i++) {
            distance[i] = (int) Infinity;
        }
        // ===========================================
        
        /*search for the index of the source vertex in the graph.
        vertices array based on its label and sets idx to that index.*/
        int idx=-1;
        for (int i = 0; i < graph.vertices.length; i++) {
            if(vert.getLabel().equalsIgnoreCase(graph.vertices[i].getLabel())){
                idx = i;
            }
            graph.vertices[i].setIsVisited(false);
        }
        // ===========================================
        
        /* set the distance of the source vertex to 0 and initialize its corresponding path.*/
        distance[idx] = 0;
        path[idx] = "loc. " + graph.vertices[idx].getLabel()+": city " + idx;

        for (int i = 0; i < graph.verticesNo-1 ; i++) {

            int v = 0;
            int minDistance = (int) Infinity;

            /* Find minimum distanced vertex that is not added to Vt yet "not visited"*/
            for (int j = 0; j < graph.vertices.length; j++) {
                if (graph.vertices[j].isVisited != true && distance[j] < minDistance) {
                    minDistance = distance[j];
                    v = j;
                }
            }

            /*Mark the min distanced vertex as Visited and add it to Vt*/
            Vertex currentVert = graph.vertices[v];
            currentVert.setIsVisited(true);
            
            /*This loop iterates through the adjacent edges of the current vertex*/
            for (int j = 0; j < currentVert.adjList.size(); j++) {
                Edge edge = currentVert.adjList.get(j);
                Vertex temp = edge.target;
                if(temp.isVisited==false && edge.weight != Infinity && edge.weight != 0){
                    
                    /* Find index of that vertex --> To know which distance[] value we need to compare with*/
                    int index = -1;
                    for (int k = 0; k < graph.vertices.length; k++) {
                        if(temp.getLabel().equalsIgnoreCase(graph.vertices[k].getLabel())){
                            index = k;
                        }
                    }
                    
                    /*compare the sum of the distance to the current vertex and the weight of 
                    the edge with the current distance of the target vertex. 
                    --> If the sum is smaller, it update the distance and path of the target vertex*/
                    if(distance[v]+edge.weight < distance[index]){
                        distance[index] = distance[v]+edge.weight;
                        path[index] = path[v] + " - loc. " + temp.getLabel()+": city " + index;
                    }
                }
            }
        }
        printResult(vert, idx);
    }
    
    /*This method prints the shortest paths and distances from the source vertex to all other vertices.*/
    public void printResult(Vertex vert, int index){
        System.out.println("The starting point location is " + graph.vertices[index].getLabel()+
                "\nThe routes from location " + graph.vertices[index].getLabel() +
                " to the rest of the locations are:");
        
        for (int i = 0; i < path.length; i++) {
            if(distance[i] !=0){
                System.out.println(path[i] + " --- route length: " + distance[i]); 
            }
        }
        System.out.println("……..\n");
    }
}
