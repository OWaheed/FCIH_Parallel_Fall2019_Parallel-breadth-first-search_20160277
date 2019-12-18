/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfs_search;

import java.util.LinkedList;

/**
 *
 * @author Omar
 */
public class SerialBfs {
    private LinkedList<Node> Queue;
    private int currentindex;
    private Node n;

    
    public SerialBfs() {
        //Here We initialize Different  Objects
        Queue=new LinkedList<Node>();
    }
    
    
    public int SerialBreadthFirstSearch(Node StartNode,char Value)
    {        Queue.add(StartNode);
            while (!Queue.isEmpty()) 
            {
                 Node CurrentNodeInQueue = Queue.removeFirst();
                 CurrentNodeInQueue.setVisited(true);
                 //System.out.println("I am in node :"+CurrentNodeInQueue.getName());
                    if (CurrentNodeInQueue.CheckValue(Value)) {
                        return CurrentNodeInQueue.getName();
                    }
                 AddAdjacenciesNodesToQueue(CurrentNodeInQueue);
            
            }
            return -1;
    }
    public void AddAdjacenciesNodesToQueue(Node parentNode)
    {
        for (Node node : parentNode.getAdjacencies()) {
            if (!node.isVisited()&&!Queue.contains(node)) {
                Queue.add(node);
            }
        }
        
    }
    
    
    
}
