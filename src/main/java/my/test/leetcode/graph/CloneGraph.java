package my.test.leetcode.graph;

import java.util.*;

//Leetcode 133
public class CloneGraph {
    public Node cloneGraph(Node node) {

        if (node == null) {
            return node;
        }

        Map<Integer, Node> map = new HashMap();
        Queue<Node> queue = new LinkedList();
        Node root = new Node(node.val);
        map.put(root.val, root);
        // remember to offer the original input node into the queue which contains all the
        // information
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            for (Node eachNode : curr.neighbors) {
                if (!map.containsKey(eachNode.val)) {
                    map.put(eachNode.val, new Node(eachNode.val));
                    queue.offer(eachNode);
                }
                map.get(curr.val).neighbors.add(map.get(eachNode.val));
            }
        }
        return root;
    }

    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            this.neighbors = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }

        public Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }
}
