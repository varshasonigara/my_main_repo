package DSA;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphTraversalTechniques {
    public static void main(String[] args) {
        /*
                 1
              /  \  \
             2    3   7
             \    /\
             4   5  6
         */
        List<List<Integer>> adjList = List.of(List.of(), List.of(2, 3, 7), List.of(1, 4), List.of(1, 5, 6),
                List.of(2), List.of(3), List.of(3), List.of(1));

        bfs(adjList, 1); // 1 2 3 7 4 5 6
        int[] vis = new int[adjList.size()];
        System.out.println();
        dfs(adjList, 1, vis); // 1 2 4 3 5 6 7
    }

    // TC= O(2E)
    private static void dfs(List<List<Integer>> adjList, int startNode, int[] vis) {
        vis[startNode] = 1;
        System.out.print(startNode + " ");
        for (int i : adjList.get(startNode)) {
            if (vis[i] != 1) {
                dfs(adjList, i, vis);
            }
        }
    }

    // TC = O(N) + O(2E)
    private static void bfs(List<List<Integer>> adjList, int startNode) {
        int[] vis = new int[adjList.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);

        while (!queue.isEmpty()) {
            var val = queue.poll();
            vis[val] = 1;
            System.out.print(val + " ");
            for (int i : adjList.get(val)) {
                if (vis[i] != 1) {
                    queue.add(i);
                }
            }
        }
    }
}
