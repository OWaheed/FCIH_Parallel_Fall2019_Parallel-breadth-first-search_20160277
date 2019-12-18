/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfs_search;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author Omar
 */
public class Node {
    private boolean Visited;
    private int name;
    private char  value;
    private ConcurrentLinkedQueue<Node> Adjacencies=null;

    public ConcurrentLinkedQueue<Node> getAdjacencies() {
        return Adjacencies;
    }

    public Node(int name,char value) {
         this.name=name;
         this.value=value;
         this.Visited=false;
         this.Adjacencies=new ConcurrentLinkedQueue<Node>();
    }

    public int getName() {
        return name;
    }

    public boolean isVisited() {
        return Visited;
    }

    public void setVisited(boolean Visited) {
        this.Visited = Visited;
    }


    public char getValue() {
        return value;
    }

    public Node() {
    }

    public void setValue(char value) {
        this.value = value;
    }
    /**
     *function to check if the sent value equal to the node value
     *@param value  the value of the node
     */
    public boolean CheckValue(char value){
      return this.value==value;
    }
    public void AddEdgeDirected(Node Adjacent)
    {
        this.Adjacencies.add(Adjacent);

    }
    public void AddEdgeNonDirected(Node Adjacent)
    {
        this.Adjacencies.add(Adjacent);
        Adjacent.AddEdgeDirected(this);

    }
    
    }
    