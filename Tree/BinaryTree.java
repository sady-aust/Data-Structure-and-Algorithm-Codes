package Tree;

public class BinaryTree {
    Node root;


    public BinaryTree(){

        root = null;
    }


    //left root right
    void printInOrderTraversal(Node node){
        if(node==null){
            return;
        }

        printInOrderTraversal(node.left);

        System.out.print(node.key+" ");

        printInOrderTraversal(node.right);

    }

    //root left right
    void printPreorderTraversal(Node node){
        if(node==null){
            return;
        }

        System.out.print(node.key+" ");
        printPreorderTraversal(node.left);
        printPreorderTraversal(node.right);
    }

    //left right root
    void printPostOrderTraversal(Node node){
        if(node==null){
            return;
        }

        printPostOrderTraversal(node.left);
        printPostOrderTraversal(node.right);
        System.out.print(node.key+" ");
    }

    void printInorder(){
        printInOrderTraversal(root);
    }

    void printPreOrder(){
        printPreorderTraversal(root);
    }

    void printPostOrder(){
        printPostOrderTraversal(root);
    }



    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left =new Node(4);
        tree.root.left.right =new Node(5);
        System.out.println("Inorder Traversal");
        tree.printInorder();
        System.out.println();
        System.out.println("Preorder Traversal");
        tree.printPreOrder();
        System.out.println();
        System.out.println("Postorder Traversal");
        tree.printPostOrder();
    }
}
