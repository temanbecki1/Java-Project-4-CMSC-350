import java.util.LinkedList;
import java.util.Queue;

/*Author : Teman Beck
*CMSC 350 Project 4
*Date : October 10th, 2021
*This class defines our Hierarchy class.
*This class will produce a hierarchical representation of the class dependencies
*Circular dependencies will be flagged
*/

public class Hierarchy implements DFSActions<Vertex> {

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
    public String toString() {
        String answerString = "";
        int size = 0;

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

            if(c=="(")
                size++;
            else if(c==")")
                --size;

            if(c=="(" || c==")")
                continue;

            if(c!="*")
                answerString += "\n";

            for (int i = 0; i < size; i++) {
                answerString += "\t";
            }


            answerString += c + " " ;

        }
        answerString += "\n";

        return answerString;

    }
}