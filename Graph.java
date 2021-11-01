import java.util.*;

/*Author : Teman Beck
*CMSC 350 Project 4
*Date : October 10th, 2021
*This class defines the Graph class.
*This class creates a few different Hashmaps. One hashmap corresponds to the vertices, the other to the adjacencylist
*This class also creates a Hashset to keep track of visited nodes.
*/

public class Graph<VertexNode> {
    public VertexNode startingNode = null;                                      //Sets starting node of the graph to null

    Map<String, VertexNode> vertices = new HashMap<>();                         //Creates a Hashmap of vertices


    Map<VertexNode, ArrayList<VertexNode>> adjacencyList = new HashMap<>();     //creates a Hashmap of adjacencyList to store the vertices

    Set<VertexNode> visited = new HashSet<>();                                  //Utilize set utility for tracking as no duplicates can be allowed

    ParenthesizedList hierarchy = new ParenthesizedList();                      //creates the visual representation of Tree
    Hierarchy parenthesizedList = new Hierarchy();                              //creates the visual representation of Tree

    boolean completeRotation;                                                   //tracks if a completeRotation happens


    Set<VertexNode> found = new HashSet<>();

    public void depthFirstSearch() {
        completeRotation = false;                                               //sets initial boolean to false
        dfs(startingNode);                                                      //initialies depthFirstSearch from first data node
    }

    private void dfs(VertexNode node) {
        if (found.contains(node)) {                                             //checks to see if this node has been visited
            completeRotation = true;                                            //sets to true if visited

            hierarchy.fullRotation();                                                      
            parenthesizedList.fullRotation();
            return;
        }

        hierarchy.processVertex((Vertex) node);
        parenthesizedList.processVertex((Vertex) node);

        hierarchy.descendVertex((Vertex) node);
        parenthesizedList.descendVertex((Vertex) node);

        found.add(node);                                                            //adds node to found
        visited.add(node);                                                          //adds node to visited


        ArrayList<VertexNode> list = adjacencyList.get(node);                       //discover child nodes
        if (list != null) {
            for (VertexNode u : list)
            dfs(u);
        }

        hierarchy.ascendVertex((Vertex) node);
        parenthesizedList.ascendVertex((Vertex) node);
  
        found.remove(node);
    }

    public void displayUnreachableClasses(){
        for (Map.Entry<VertexNode, ArrayList<VertexNode>> entry : adjacencyList.entrySet()) {
            if(entry.getValue().size()>0){                                                  //check for unvisited nodes
                if(!visited.contains(entry.getKey())){                                      //checks node to ensure it hasnt been visited
                    System.out.println(entry.getKey() + " is unreachable");                 //prints to screen the node/ nodes that are unreachable
                    visited.add(entry.getKey());
                }

                for (VertexNode vertex : entry.getValue()){
                    if(!visited.contains(vertex)){                                          //checks all remaining nodes to ensure it hasnt been visited
                        System.out.println(vertex + " is unreachable");                     //prints to screen the node/ nodes that are unreachable
                        visited.add(vertex);
                    }   
                }
            }
        }
    }
}