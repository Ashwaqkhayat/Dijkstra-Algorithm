/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirFreightApp;

import GraphFramework.Vertex;

public class Location extends Vertex{
    
    private String city;
    
    public Location (String label){
        super(label);
        this.label = label; 
    }
    
    public void SetLabel(){
         
    }
    
    @Override
    public void displayInfo(){
        
        System.out.println("loc. " + label);
        
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
}
