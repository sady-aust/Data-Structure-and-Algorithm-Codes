package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversal {

    static class Node{
        int key;
        Node left,right;

        public Node(int key) {
            this.key = key;
            left=right=null;
        }
    }

    void levelOrderTraversal(Node root){

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);



        while (!queue.isEmpty()){
            Node head = queue.poll();
            System.out.print(head.key+" ");
        //    System.out.println();

            if(head.left!=null){
                queue.add(head.left);
            }

            if(head.right!=null){
                queue.add(head.right);
            }

        }
    }

    void printLevelOrderLineByLine(Node root){

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (true){
            //determine Size of Each Level
            int size = queue.size();

            if(size==0){
                break;
            }

            while (size>0){
                Node temp = queue.poll();

                System.out.print(temp.key+" ");

                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }

                size--;
            }
            System.out.println();
        }
    }

    void printInOrderTravaersalWithoutRecurrsion(Node root){
       Stack<Node> stack = new Stack<>();

       Node node = root;

       //left-root-right

        //at first we push all the left node
       while (node!=null){
           stack.push(node);
           node = node.left;
       }

       while (stack.size()>0){
           node = stack.pop();

           //while poping left node we checking is there any node in the right of the current node.If true then we push the right node and then checking
           //is there any node on the left of the current node.. if true we adding the left nodes

           System.out.print(node.key+" ");

           if(node.right!=null){
               node = node.right;

               while (node!=null){
                   stack.push(node);
                   node = node.left;
               }
           }
       }
    }

    void iterativePreorder(Node root){
        Stack<Node> stack  = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()){
            Node temp = stack.peek();
            System.out.print(temp.key+" ");

            stack.pop();

            if(temp.left!=null){
                stack.push(temp.left);
            }

            if(temp.right!=null){
                stack.push(temp.right);
            }
        }
    }



    public static void main(String[] args) {
        Node root =new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        LevelOrderTraversal ob = new LevelOrderTraversal();
       // ob.printLevelOrderLineByLine(root);

        //ob.printInOrderTravaersalWithoutRecurrsion(root);

        ob.iterativePreorder(root);
    }


}
