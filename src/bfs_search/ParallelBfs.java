/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfs_search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author Omar
 */
public class ParallelBfs {

    private Node n;
    private LinkedList<Node> Q;
    private ConcurrentLinkedQueue<LinkedList<Node>> QueueOfLevels;
    private int level;
    private char Value;
    private LinkedList<Node> Temp;
    private ThreadPoolExecutor executor;
    private int numThreads;
    private int StartFrom;
    private int EndAt;
    private int numofnodes;
    private int LastThreadNode;

    public ParallelBfs() {//constructor
        Q = new LinkedList<Node>();
        QueueOfLevels = new ConcurrentLinkedQueue<LinkedList<Node>>();
        n = new Node();
        level = 0;
    }

    public synchronized int ParallelBreadthFirstSearch(Node StartNode, char Value) { //main Function
        this.Value = Value;
        this.Q.add(StartNode);
        this.QueueOfLevels.add(Q);
        while (!QueueOfLevels.isEmpty()) //loop on levels
        {
            //pop level queue and paralel seach all
            this.Q=QueueOfLevels.poll();
            if (this.Q.isEmpty()) {
                break;
            }
            Node m=ParallelSearchAllNodes(this.Q);
            if(m!=null)
            {
                return m.getName();
                
            }
         
            //make new level of adjacencies 
            MakeNewLevel(this.Q);
            

        }

        return -1;
    }

    public synchronized Node ParallelSearchAllNodes(LinkedList<Node> C) {//here we get a full level 3
        Node result=null;
        //calculate num of threads
        this.numThreads = Runtime.getRuntime().availableProcessors();//4
        // create list of threads 
        Thread[] threads;
        if (C.size() < this.numThreads) {
            threads = new Thread[C.size()];//3
            this.numThreads =C.size();
        } else {
            threads = new Thread[numThreads];
        }

        this.numofnodes = C.size() / this.numThreads;//1 
        this.StartFrom = 0;
        this.LastThreadNode = C.size() % this.numThreads;//0
        this.EndAt = this.numofnodes;//1
        for (int i = 0; i < this.numThreads; i++) {//0
            try {
                ParallelBfsTask B = new ParallelBfsTask(C, this.Value, this.StartFrom, this.EndAt);
                threads[i] = new Thread(B);
                threads[i].start();
                threads[i].join();
                if (B.Found) {
                    result=B.getN();
                    break;
                }
                if (i == this.numThreads - 1) {/////////////////
                    this.StartFrom = this.EndAt;
                    this.EndAt = this.StartFrom + this.LastThreadNode;
                } else {
                    this.StartFrom = this.EndAt;//1
                    this.EndAt = i == this.numThreads - 2 ? C.size() : this.EndAt + this.numofnodes;//2
                }

                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(result!=null){
        return result;
        }
     return null;
    }

    /* public void AddNodeAdjtoqueue(Node N) {//threads for each adjacent to add it into Temp;
        //adj1 sent to Setvisited and seach 
        //adj1 sent to Setvisited and seach 
        //adj1 sent to Setvisited and seach 
        //adj1 sent to Setvisited and seach 

    }*/
 /*
    public void SetVisitedAndSearch(Node N) {  //here threads check for value and if found its interupt if not it 
        
            N.setVisited(true);
            
            if (N.CheckValue(this.Value)) {
                
            }

        

    }
     */
    public synchronized void MakeNewLevel(LinkedList<Node> m) {
        this.Temp = new LinkedList<Node>();
        for (Node n : m) {
            if (n.getAdjacencies() != null) {
                for (Node s : n.getAdjacencies()) {
                    if (!s.isVisited() && !Temp.contains(s)) {
                        //s.setVisited(true);
                        this.Temp.add(s);
                    }
                }
            }

        }

        this.QueueOfLevels.add(this.Temp);

    }

}
