import java.util.ArrayList;

/*Author : Teman Beck
*CMSC 350 Project 4
*Date : October 10th, 2021
*This class extends the Graph class. 
*This class checks to see if a node has connected edges, if it does it is added to the adjacencyList
*/

public class DirectedGraph extends Graph<Vertex> {
    
    public void addEdge(String sourceEdge, String destinationEdge) {

        ArrayList<Vertex> edgeList = adjacencyList.get(getVertex(sourceEdge));          //check to see if node has connected edges

        if (edgeList == null) {                                                         //if no edge, create new ArrayList to store edges
            edgeList = new ArrayList<>();                                               //if no edge, create new ArrayList to store edges
        }
        edgeList.add(getVertex(destinationEdge));                                       //adds destination edge to list
        adjacencyList.put(getVertex(sourceEdge), edgeList);                             //updates adjacency list
    }

    public Vertex getVertex(String sourceEdge) {
        if (!vertices.containsKey(sourceEdge)) {
            vertices.put(sourceEdge, new Vertex(sourceEdge));                           //assigns the sourceEdge to a new Vertex
        }

        return vertices.get(sourceEdge);                                                //returns the corresponding vertex of the node
    }
}