import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*Author : Teman Beck
*CMSC 350 Project 4
*Date : October 10th, 2021
*This class contains our main run method.
*This class creates a JFileChooser to allow selection of file from default directory
*/

public class Main {

    static DirectedGraph directedGraph = new DirectedGraph();                       //creates instance of DirectedGraph


    public void readGraph() {                                                       //method for reading selected graph

        JFileChooser fileChooser = new JFileChooser();                              //initializes filechooser to allow selection of file from default directory
        int response = fileChooser.showOpenDialog(null);                            //assigns int value of selected option

        if (response == JFileChooser.APPROVE_OPTION) {
            try {

                Scanner input = new Scanner(fileChooser.getSelectedFile());         //assigns selected file to input

                while (input.hasNextLine()) {                                       //check to see if input has nextline
                    String edgeString = input.nextLine();                           
                    String[] edge = edgeString.split(" ");                          //splits edges by space delimiter

                    if (directedGraph.startingNode == null){                        //check for starting node
                        directedGraph.startingNode = directedGraph.getVertex(edge[0]);  //sets first edge
                    }

                    for (int i = 1; i < edge.length; i++) {
                        directedGraph.addEdge(edge[0], edge[i]);                    //adds additional edges to directedGraph

                    }

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        new Main().readGraph();                                             //initializes Main class and calls readGraph()

        directedGraph.depthFirstSearch();                                   //calls depthFirstSearch() method on the directedGraph object

        System.out.println(directedGraph.parenthesizedList.toString());     //Display Parenthesized List

        System.out.println(directedGraph.hierarchy.toString());             //Display Hierarchy

        directedGraph.displayUnreachableClasses();                          //displays the unreachable nodes after search is done
    }
}