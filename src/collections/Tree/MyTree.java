package collections.Tree;

import java.util.ArrayList;
import java.util.List;

class Node{
    int data;
    List<Node> children;
    Node(int _data){
        this.data=_data;
        children= new ArrayList<>();
    }
}

public class MyTree {
    // add child to tree
    static void addChild(Node Parent,Node data){
        Parent.children.add(data);
    }

    // print parent of each node
    static void printParents(Node node, Node parent){
        if(parent==null)
            System.out.println(node.data+"-> NULL");
        else
            System.out.println(node.data+" -> "+ parent.data);

        for(Node child: node.children){
            printParents(child,node);
        }
    }

    // print child of each node
    static void printChildren(Node node){
        System.out.println(node.data+" -> ");
        for (Node child: node.children){
            System.out.println(child.data+" ");
        }
        System.out.println();

        for(Node child: node.children){
            printChildren(child);
        }
    }
    // Function to print leaf nodes
    static void printLeafNodes(Node node) {
        if (node.children.isEmpty()) {
            System.out.print(node.data + " ");
            return;
        }
        for (Node child : node.children)
            printLeafNodes(child);
    }

    // print degree for each node
    static void printDegrees(Node node,Node parent){
        int degree= node.children.size();
        if(parent!=null){
            degree++;

        }
        System.out.println(node.data+" -> "+degree);

        for(Node child: node.children){
            printDegrees(child,node);
        }
    }

    public static void main(String[] args) {
        // Creating nodes
        Node root = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        // Constructing tree
        addChild(root, n2);
        addChild(root, n3);
        addChild(n2, n4);
        addChild(n2, n5);

        System.out.println("Parents of each node:");
        printParents(root, null);

        System.out.println("Children of each node:");
        printChildren(root);

        System.out.print("Leaf nodes: ");
        printLeafNodes(root);
        System.out.println();

        System.out.println("Degrees of nodes:");
        printDegrees(root, null);
    }

}
