import java.util.Scanner;
import java.util.Stack;

class Node {
    String name;
    Node[] children;

    Node(String name) {
        this.name = name;
        this.children = new Node[0];
    }

    Node(String name, Node[] children) {
        this.name = name;
        this.children = children;
    }
}

// Helper class
class NodeStatus {
    Node node;
    String prefix;
    boolean isLast;

    NodeStatus(Node node, String prefix, boolean isLast) {
        this.node = node;
        this.prefix = prefix;
        this.isLast = isLast;
    }
}

public class TreeADT {
    public static void main(String[] args) {

        // Create Nodes (Children)
        Node alberta = new Node("Alberta", new Node[]{
                new Node("Calgary"),
                new Node("Edmonton")
        });

        Node ontario = new Node("Ontario", new Node[]{
                new Node("Toronto"),
                new Node("Guelph"),
                new Node("Ottawa")
        });

        Node bc = new Node("BC", new Node[]{
                new Node("Langley"),
                new Node("Vancouver"),
                new Node("Victoria", new Node[]{
                        new Node("Langford")
                })
        });

        Node quebec = new Node("Quebec", new Node[]{
                new Node("Montreal")
        });

        Node manitoba = new Node("Manitoba", new Node[]{
                new Node("Winnipeg"),
                new Node("Brandon")
        });

        // Create Root (Canada)
        Node canada = new Node("Canada", new Node[]{
                alberta, ontario, bc, quebec, manitoba
        });

        printTree(canada);

        // Ask Input
        Scanner input = new Scanner(System.in);
        System.out.print("\nSelect any Place from Above: ");
        String search = input.nextLine().trim();

        //GetDepth
        int depth = getDepth(canada, search);

        //GetHeight
        int height = getHeight(canada, search);

        // Print Answer
        if (depth == -1) {
            System.out.println("\nSelection is not on the list");
        } else {
            System.out.println("\nDepth of the Node: " + depth);
            System.out.println("Height of the Node: " + height);
        }
    }

    // Print tree
    static void printTree(Node root) {
        Stack<Object[]> stack = new Stack<>();
        stack.push(new Object[]{root, ""});

        while (!stack.isEmpty()) {
            Object[] current = stack.pop();
            Node node = (Node) current[0];
            String indent = (String) current[1];

            System.out.println(indent + "--|" + node.name);

            for (int i = node.children.length - 1; i >= 0; i--) {
                stack.push(new Object[]{node.children[i], indent + "   "});
            }
        }
    }

    // Compute Depth
    static int getDepth(Node root, String name) {
        Stack<Object[]> stack = new Stack<>();
        stack.push(new Object[]{root, 0});

        while (!stack.isEmpty()) {
            Object[] current = stack.pop();
            Node node = (Node) current[0];
            int level = (int) current[1];

            if (node.name.equalsIgnoreCase(name)) {
                return level;
            }

            for (Node child : node.children) {
                stack.push(new Object[]{child, level + 1});
            }
        }
        return -1;
    }

    // Compute Height
    static int getHeight(Node root, String name) {

        Node target = null;
        Stack<Node> stackFind = new Stack<>();
        stackFind.push(root);

        while (!stackFind.isEmpty()) {
            Node node = stackFind.pop();
            if (node.name.equalsIgnoreCase(name)) {
                target = node;
                break;
            }
            for (Node child : node.children) {
                stackFind.push(child);
            }
        }

        if (target == null) return -1;

        //Compute height starting from the node input
        int max = 0;
        Stack<Object[]> stack = new Stack<>();
        stack.push(new Object[]{target, 0});

        while (!stack.isEmpty()) {
            Object[] current = stack.pop();
            Node node = (Node) current[0];
            int h = (int) current[1];
            max = Math.max(max, h);

            for (Node child : node.children) {
                stack.push(new Object[]{child, h + 1});
            }
        }
        return max;

    }

}