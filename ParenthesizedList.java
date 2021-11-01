import java.util.LinkedList;
import java.util.Queue;

/*Author : Teman Beck
*CMSC 350 Project 4
*Date : October 10th, 2021
*This class defines our ParenthesizedList class.
*This class will produce an alternate representation that will be returned as a String
*Circular dependencies will be flagged
*/

public class ParenthesizedList implements DFSActions<Vertex> {
    Queue<String> resultString = new LinkedList<>();

    @Override
    public void processVertex(Vertex vertex) {
        resultString.add(vertex.toString());
    }

    @Override
    public void descendVertex(Vertex vertex) {
        resultString.add("(");
    }

    @Override
    public void ascendVertex(Vertex vertex) {
        resultString.add(")");
    }

    @Override
    public void fullRotation() {
        resultString.add("*");
    }

    @Override
    public String toString() {                          //this toString will build our parenthesied representation of the node tree

        String answerString = "";
        answerString += "( ";
        while (resultString.size() > 0) {
            String c = resultString.peek();
            resultString.remove();

            if (c == "(") {
                if (resultString.peek() == ")") {
                    resultString.remove();
                    continue;
                } else if (resultString.peek() == "*") {
                    answerString += resultString.peek() + " ";
                    resultString.remove();
                    resultString.remove();
                    continue;
                }
            }
            answerString += c + " ";

        }   
        answerString += ")\n";

        return answerString;                                            //returns toString 
    }
}