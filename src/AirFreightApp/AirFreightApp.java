package AirFreightApp;

import GraphFramework.DBAllSourceSPAlg;
import java.io.File;
import java.util.Scanner;

public class AirFreightApp {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        // Print welcoming statements
        System.out.println("Compute the all-pair-source shortest path problem using Dijkstra's algorithm" +
                "\n--> Requirement 1: Run Dijkstra's Algorithm on an input file" +
                "\n--> Requirement 2: Run Dijkstra's Algorithm on a random generated graph");
        System.out.print("\n>> Which requirement do you want to run (1|2)? ");
        int choice = sc.nextInt();
        AFRouteMap routeMap;
        
        switch(choice){
            case 1:
                System.out.println("\n--> Running Requirement 1");
                // Create a new graph.
                routeMap = new AFRouteMap();
                // Read graph information.
                File f = new File("Graph.txt");
                routeMap.readGraphFromFile(f);
                break;
            case 2:
                System.out.println("\n--> Running Requirement 2");
                System.out.print(">> Choose the number of locations & Routes: ");
                int n = sc.nextInt();
                int m=0;
                switch(n){
                    case 2000: m= 10000; break;
                    case 3000: m= 15000; break;
                    case 4000: m= 20000; break;
                    case 5000: m= 25000; break;
                    case 6000: m= 30000; break;
                }
                System.out.println(">> You're running Dijkstra on a graph of " +n+ " Vertices and " +m+ " Edges.");
                // Create a new graph of n Locations (Vertices) and m Routes (Edges)
                routeMap = new AFRouteMap(n,m,false);
                routeMap.makeGraph();
                break;
            // default is random graph of 5 verts and 10 edges
            default: routeMap = new AFRouteMap(5,10,false);
        }
        
        DBAllSourceSPAlg dijkstra = new DBAllSourceSPAlg(routeMap);
        long start = System.currentTimeMillis();
        dijkstra.computeDijkstraBasedSPAlg();
        long end = System.currentTimeMillis();
        long totalTime = end-start;
        System.out.println(">> Total running time: " + totalTime + " msec ~" + totalTime/1000.0 +" sec");
    }
    
}
