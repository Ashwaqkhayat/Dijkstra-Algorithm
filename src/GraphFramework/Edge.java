
package GraphFramework;

public class Edge {
    // attributes
    public int weight; //weight is an integer value, that holds the weight assigned to the edge connecting the source and target vertices.
    //source vertex, destination vertex and parent vertex; all of the type Vertex.
    public Vertex source;
    public Vertex target;
    public Vertex parent;

    // constructor with parameters 
    public Edge(int weight, Vertex source, Vertex target) {
        
        this.weight = weight;
        this.source = source;
        this.target = target;
    }
    
    // constructor without parameters 
    public Edge() {
        
        source = new Vertex();
        target = new Vertex();
        parent = new Vertex();
    }
    
    // displayInfo method will display the information of the class attribute 'weight'
    public void displayInfo(){
        System.out.print(weight);
    }
    
}
