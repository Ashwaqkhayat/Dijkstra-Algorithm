/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirFreightApp;

import GraphFramework.Edge;
import GraphFramework.Vertex;

/**
 *
 * @author ACER
 */
public class Route extends Edge{
    int ILength;

    public Route(Vertex source, Vertex target, int weight) {
        super(weight, source, target);
        this.ILength = weight * 5;
    }
    
    
    @Override
    public void displayInfo(){
        System.out.println("Route Length: " + ILength);
    }
}
