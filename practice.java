import java.io.*;

import java.util.*;

public class Main {
     static List<Object> visitedList= new ArrayList<>();;
     static int count=0;

  public static void main(String[] args) throws Exception {
    Map<Object, TreeSet<Object>> graph = new HashMap<>();

        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 5);

        addEdge(graph, 2, 5);

        addEdge(graph, 3, 4);

        addEdge(graph, 4, 5);
        addEdge(graph, 4, 6);

        addEdge(graph, 5, 6);

        addEdge(graph, 11,12);
        addEdge(graph,12,13);

        addEdge(graph, 16,17);
        addEdge(graph,19,17);
        

        // dfsTraversal1(1, graph);
        // System.out.println();
        //  dfsTraversal2(1, graph);
       
      

         
       //  bfsTraversal(1,graph);
        // System.out.println("no of components is"+ count);
        
        

        
}
 
   



    }


    private static void bfsTraversal(Object startingVertex, Map<Object, TreeSet<Object>> graph) {
        
        Queue<Object> queue = new LinkedList<>();

        visitedList.add(startingVertex);
        queue.add(startingVertex);

        while(!queue.isEmpty()) {
            Object currentNode = queue.poll();
            System.out.print(currentNode + " ");

            TreeSet<Object> neighbours = graph.get(currentNode);

            for(Object eachNeighbour : neighbours) {
                if(!visitedList.contains(eachNeighbour)) {
                    queue.add(eachNeighbour);
                    visitedList.add(eachNeighbour);
                }
            }
        }
         for(Object i: graph.keySet()){
            //  if(visitedList.contains(i)){
            //      count++;
            //  }
             if(!visitedList.contains(i) ){
              bfsTraversal(i, graph);
             }
         }
        System.out.println();
    }
     private static void addEdge(Map<Object, TreeSet<Object>> graph, Object u, Object v) {
        if(!graph.containsKey(u)) {
            graph.put(u, new TreeSet<>());
        }
        // if(!graph.containsKey(v)) {
        //     graph.put(v, new TreeSet<>());
        // }

        graph.get(u).add(v);
        // graph.get(v).add(u);
    }







/*private static void dfsTraversal1(Object startingVertex, Map<Object, TreeSet<Object>> graph) {
        List<Object> visitedList = new ArrayList<>();

        dfsTraversalUtil(startingVertex, graph, visitedList);
    }

     private static void addEdge(Map<Object, TreeSet<Object>> graph, Object u, Object v) {
        if(!graph.containsKey(u)) {
            graph.put(u, new TreeSet<>());
        }
        if(!graph.containsKey(v)) {
            graph.put(v, new TreeSet<>());
        }

        graph.get(u).add(v);
        graph.get(v).add(u);
    }
     
     private static void dfsTraversalUtil(Object startingVertex, Map<Object, TreeSet<Object>> graph, List<Object> visitedList) {
        visitedList.add(startingVertex);
        System.out.print(startingVertex + " ");

        TreeSet<Object> neighbours = graph.get(startingVertex);

        for(Object eachNeighbour : neighbours) {
            if(!visitedList.contains(eachNeighbour)) {
                dfsTraversalUtil(eachNeighbour, graph, visitedList);
            }
        }
    }

     private static void dfsTraversal2(Object startingVertex, Map<Object, TreeSet<Object>> graph) {
        List<Object> visitedList = new ArrayList<>();
        Stack<Object> stack = new Stack<>();

        stack.add(startingVertex);

        while(!stack.isEmpty()) {
            Object currentNode = stack.pop();

            if(!visitedList.contains(currentNode)) {
                visitedList.add(currentNode);
                System.out.print(currentNode + " ");
            }

            TreeSet<Object> neighbours = graph.get(currentNode);

            for(Object eachNeighbour : neighbours) {
                if(!visitedList.contains(eachNeighbour)) {
                    stack.add(eachNeighbour);
                }
            }
        }
    }*/

}
