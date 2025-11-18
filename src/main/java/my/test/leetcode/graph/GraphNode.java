package my.test.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    public int value;
    public List<GraphNode> neighbors;

    public GraphNode(int x) {
        this.value = x;
        this.neighbors = new ArrayList<>();
    }
}
