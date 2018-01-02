package Tree;

public class DiameterOfABinaryTree {

    static class Node{
        int n ;
        Node left,right;

        public Node(int n) {
            this.n = n;
            left = right = null;
        }
    }

    //Height is the number of node along the longest path from the root node down to the farthest leaf Node

    int height(Node root){
        if(root==null){
            return 0;
        }
        /* If tree is not empty then height = 1 + max of left
           height and right heights */

        return (1+Math.max(height(root.left),height(root.right)));
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.left.left.left = new Node(8);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);

        DiameterOfABinaryTree ob = new DiameterOfABinaryTree();

        System.out.println(ob.height(root));

    }
}
