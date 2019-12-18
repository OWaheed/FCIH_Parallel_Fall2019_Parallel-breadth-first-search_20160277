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
public class ParallelBfsTask implements  Runnable{
    Node N;
    LinkedList<Node> Nodes;
    char Value;
    int Startfrom,EndAt;
    boolean Found;

    public Node getN() {
        return N;
    }

    public boolean isFound() {
        return Found;
    }
    public ParallelBfsTask(LinkedList<Node> Nodes ,char Value,int Startfrom,int EndAt) {
        this.Nodes=Nodes;
        this.Value=Value;
        this.Startfrom=Startfrom;
        this.EndAt=EndAt;
        this.Found=false;
                
    }

    @Override
    public void run() {
        for (int i =Startfrom; i < EndAt; i++) {
            this.Nodes.get(i).setVisited(true);
            if (this.Nodes.get(i).CheckValue(Value)) {
                this.Found=true;
                this.N=this.Nodes.get(i);
//                System.out.println(this.N.getName());
                return;
            }
            
            
        }
        
    }
    
    
    
}
