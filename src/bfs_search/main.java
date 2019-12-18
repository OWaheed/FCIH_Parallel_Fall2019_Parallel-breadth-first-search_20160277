/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfs_search;

import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Omar
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Node n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13, n14, n15;
        n1 = new Node(1, 'A');
        n2 = new Node(2, 'B');
        n3 = new Node(3, 'C');
        n4 = new Node(4, 'D');
        n5 = new Node(5, 'E');
        n6 = new Node(6, 'F');
        n7 = new Node(7, 'G');
        n8 = new Node(8, 'H');
        n9 = new Node(9, 'I');
        n7 = new Node(10, 'J');
        n8 = new Node(11, 'K');
        n9 = new Node(12, 'L');
        n10 = new Node(13, 'M');
        n11 = new Node(14, 'N');
        n12 = new Node(15, 'O');
        n13 = new Node(16, 'P');
        n13 = new Node(17, 'Q');
        n13 = new Node(18, 'R');
        n13 = new Node(19, 'S');
        n14 = new Node(20, 'T');
        n15 = new Node(21, 'X');

        n1.AddEdgeDirected(n2);
        n1.AddEdgeDirected(n3);
        n2.AddEdgeDirected(n4);
        n2.AddEdgeDirected(n5);
        n3.AddEdgeDirected(n6);
        n3.AddEdgeDirected(n7);
        n4.AddEdgeDirected(n8);
        n4.AddEdgeDirected(n9);
        n5.AddEdgeDirected(n10);
        n5.AddEdgeDirected(n11);
        n6.AddEdgeDirected(n12);
        n6.AddEdgeDirected(n13);
        n7.AddEdgeDirected(n14);
        n7.AddEdgeDirected(n15);

        /* n1.AddEdgeNonDirected(n2);
         n1.AddEdgeNonDirected(n3);
         n2.AddEdgeNonDirected(n4);
         n2.AddEdgeNonDirected(n5);
         */
        long start, end, start_p, end_p;
        SerialBfs s = new SerialBfs();
        ParallelBfs p = new ParallelBfs();
        System.out.println("Serial Vesion");
        start = Calendar.getInstance().getTimeInMillis();
        int ser = s.SerialBreadthFirstSearch(n1, 'X');
        end = Calendar.getInstance().getTimeInMillis();
        switch (ser) { // the switch is to handle the three possible Situations Coming from The Bfs Function 
            case -1:
                System.out.println("Element not found ");
                break;
            default:
                System.out.println("Element found in node :" + ser);
                break;
        }
        double time_ser = end - start;
        System.out.println("Time Taken :" + (end - start) + " Mili second");

//        /////////////////////////////////////////////////////////
        System.out.println("*************************************************");
        System.out.println("Parallel Vesion");
        n1 = new Node(1, 'A');
        n2 = new Node(2, 'B');
        n3 = new Node(3, 'C');
        n4 = new Node(4, 'D');
        n5 = new Node(5, 'E');
        n6 = new Node(6, 'F');
        n7 = new Node(7, 'G');
        n8 = new Node(8, 'H');
        n9 = new Node(9, 'I');
        n7 = new Node(10, 'J');
        n8 = new Node(11, 'K');
        n9 = new Node(12, 'L');
        n10 = new Node(13, 'M');
        n11 = new Node(14, 'N');
        n12 = new Node(15, 'O');
        n13 = new Node(16, 'P');
        n13 = new Node(17, 'Q');
        n13 = new Node(18, 'R');
        n13 = new Node(19, 'S');
        n14 = new Node(20, 'T');
        n15 = new Node(21, 'X');

        n1.AddEdgeDirected(n2);
        n1.AddEdgeDirected(n3);
        n2.AddEdgeDirected(n4);
        n2.AddEdgeDirected(n5);
        n3.AddEdgeDirected(n6);
        n3.AddEdgeDirected(n7);
        n4.AddEdgeDirected(n8);
        n4.AddEdgeDirected(n9);
        n5.AddEdgeDirected(n10);
        n5.AddEdgeDirected(n11);
        n6.AddEdgeDirected(n12);
        n6.AddEdgeDirected(n13);
        n7.AddEdgeDirected(n14);
        n7.AddEdgeDirected(n15);

        start_p = Calendar.getInstance().getTimeInMillis();
        int par = p.ParallelBreadthFirstSearch(n1, 'X');
        end_p = Calendar.getInstance().getTimeInMillis();
        double time_Par = end_p - start_p;

        switch (par) { // the switch is to handle the three possible Situations Coming from The Bfs Function 
            case -1:
                System.out.println("Element not found ");
                break;
            default:
                System.out.println("Element found in node :" + par);
                break;
        }
        System.out.println("Time Taken :" + (time_Par) + " Mili second");

        System.out.println("*************************************************");
        System.out.println("Performance of parallelizing : " +(time_ser / time_Par) * 100 + "%");

    }

}
