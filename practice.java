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

/*
check loop in directed graph*/
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
                
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if(isCyclic(V, list) == true)
                System.out.println("Yes");
            else System.out.println("No");
    }
    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> list ){
        boolean visited[]=new boolean[V];
        boolean recS[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfsCheck(i, list, visited, recS))
                 return true;
            }
        }
        return false;

    }
    public static boolean dfsCheck(int start, ArrayList<ArrayList<Integer>> list, boolean[] visited, boolean[] recS){
        visited[start]=true;
        recS[start]=true;

        for(Integer neighbour: list.get(start)){
            if(!visited[neighbour]){
                if(dfsCheck(neighbour, list, visited, recS))
                  return true;
            }
            else if(recS[neighbour]){
                return true;
            }
        }
        recS[start]=false;
        return false;
    }



}
/*class Solution {
    private boolean checkCycle(int node,  ArrayList<ArrayList<Integer>> adj, int vis[], int dfsVis[]) {
        vis[node] = 1; 
        dfsVis[node] = 1; 
        
        for(Integer it: adj.get(node)) {
            if(vis[it] == 0) {
                if(checkCycle(it, adj, vis, dfsVis) == true) {
                    return true; 
                }
            } else if(dfsVis[it] == 1) {
                return true; 
            }
        }
        dfsVis[node] = 0;
        return false; 
    }
    public boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[N];     
        int dfsVis[] = new int[N]; 
        for(int i = 0;i<N;i++) {
            if(vis[i] == 0) {
                if(checkCycle(i, adj, vis, dfsVis) == true) return true; 
            }
        }
        return false; 
    }*/
/*
check looop in undirectedf graph
*/
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
            ArrayList<TreeSet<Integer>> list = new ArrayList<>();
            int N = sc.nextInt();
            int M = sc.nextInt();
            for(int i = 0; i < N+1; i++)
                list.add(i, new TreeSet<Integer>());
                
            for(int i = 0; i < M; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            if(isCyclic(N, list) == true)
                System.out.println("Yes");
            else System.out.println("No");
    }
    public static boolean isCyclic(int N, ArrayList<TreeSet<Integer>> list ){
        boolean visited[]=new boolean[N];
        
        for(int i=0;i<N;i++){
            if(!visited[i]){
                if(dfsCheck(i, list, visited, -1))
                 return true;
            }
        }
        return false;

    }
    public static boolean dfsCheck(int cur, ArrayList<TreeSet<Integer>> list, boolean[] visited, int parent){
        visited[cur]=true;
       

        for(Integer neighbour: list.get(cur)){
            if(!visited[neighbour]){
                if(dfsCheck(neighbour, list, visited,cur))
                  return true;
            }
            else if(parent!=neighbour){
                return true;
            }
        }
      
        return false;
    }



}
