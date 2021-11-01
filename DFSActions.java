/*Author : Teman Beck
*CMSC 350 Project 4
*Date : October 10th, 2021
*This class defines an interface class methods.
*/

public interface DFSActions<V> {
    public void fullRotation();

    public void processVertex(V vertex);
    
    public void descendVertex(V vertex);
    
    public void ascendVertex(V vertex);
    
    
    }