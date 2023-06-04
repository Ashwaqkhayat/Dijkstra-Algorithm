/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirFreightApp;

import GraphFramework.Edge;
import GraphFramework.Graph;
import GraphFramework.Vertex;

/**
 *
 * @author ACER
 */
public class AFRouteMap extends Graph{
    
    public AFRouteMap(){
        
    }
     // to make an object of graph using AFRouteMap
    public AFRouteMap(int verticesNo, int edgeNo, boolean isDigraph) {
        super(verticesNo, edgeNo, isDigraph);
    }

    @Override
    public Vertex createVertex(String label) {
        return new Location(label);
    }

    @Override
    public Edge createEdge(Vertex v, Vertex u, int w) {
        return new Route(v,u,w);
    }
    
}
