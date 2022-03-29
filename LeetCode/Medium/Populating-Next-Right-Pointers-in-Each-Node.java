/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
/* 코드 개선 전 */
import java.util.ArrayList;
import java.util.List;
class Solution {
    public static void setNext(List<Node> nodes){

        for(int i=0; i<nodes.size()-1; i++){
            nodes.get(i).next = nodes.get(i+1);
        }

        if(nodes.get(0).left == null) return;


        ArrayList<Node> list = new ArrayList<>();
        for(int i=0; i<nodes.size(); i++){
            list.add(nodes.get(i).left);
            list.add(nodes.get(i).right);
        }
        setNext(list);


    }

    public Node connect(Node root) {
        
        if(root == null) return root;
        else if(root.left == null) return root;
        
        
        List<Node> rootChild = new ArrayList<>();
        rootChild.add(root.left);
        rootChild.add(root.right);
        setNext(rootChild);
        
        
        return root;
    }
}

/* 코드 개선 후 */
import java.util.ArrayList;
import java.util.List;
class Solution {
    public static void setNext(Node leftNode , Node rightNode){

        if(leftNode == null || leftNode == null) return;

        leftNode.next = rightNode;

        setNext(leftNode.left , leftNode.right);
        setNext(leftNode.right, rightNode.left);
        setNext(rightNode.left,rightNode.right);

    }

    public static Node connect(Node root) {

        if(root != null) setNext(root.left , root.right);
        return root;
    }
}


