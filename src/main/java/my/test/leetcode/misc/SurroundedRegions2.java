package my.test.leetcode.misc;

import java.util.*;

//Leetcode 130
public class SurroundedRegions2 {
    /*
     * My completely original solution on 11/1/2021, again, using a pen and paper to visualize my thought process and list out all key steps helps a lot!
     * 1. scan through this board;
     * 2. whenever we find an 'O', we'll do BFS to find all connected points and use the first 'O' as its head point for this entire connected region;
     * 3. whenever we visit a point, mark it as visited.
     */
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        Map<Integer, List<int[]>> headMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    boolean capturable = bfs(i, j, board, visited, headMap);
                    if (capturable) {
                        capture(headMap, board);
                    }
                }
            }
        }
    }

    private void capture(Map<Integer, List<int[]>> headMap, char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int head : headMap.keySet()) {
            List<int[]> list = headMap.get(head);
            for (int[] p : list) {
                board[p[0]][p[1]] = 'X';
            }
            int x = head / m;
            int y = head % n;
            board[x][y] = 'X';
        }
    }

    private boolean bfs(
            int startI,
            int startJ,
            char[][] board,
            boolean[][] visited,
            Map<Integer, List<int[]>> headMap) {
        boolean capturable = true;
        Queue<int[]> queue = new LinkedList<>();
        int m = board.length;
        int n = board[0].length;
        queue.offer(new int[]{startI, startJ});
        int head = startI * n + startJ;
        List<int[]> list = headMap.getOrDefault(head, new ArrayList<>());
        list.add(new int[]{startI, startJ});
        int[] directions = new int[]{0, 1, 0, -1, 0};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (curr[0] == 0 || curr[0] == m - 1 || curr[1] == 0 || curr[1] == n - 1) {
                    capturable = false;
                }
                visited[curr[0]][curr[1]] = true;
                for (int j = 0; j < directions.length - 1; j++) {
                    int newx = directions[j] + curr[0];
                    int newy = directions[j + 1] + curr[1];
                    if (newx >= 0
                            && newx < m
                            && newy >= 0
                            && newy < n
                            && !visited[newx][newy]
                            && board[newx][newy] == 'O') {
                        queue.offer(new int[]{newx, newy});
                        visited[newx][newy] = true;
                        list.add(new int[]{newx, newy});
                    }
                }
            }
        }
        if (!capturable) {
            headMap.remove(head);
        } else {
            headMap.put(head, list);
        }
        return capturable;
    }
}
