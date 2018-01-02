package Tree;

import sun.reflect.generics.tree.Tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class TreeNode{
    int key;
    TreeNode left,right;

    public TreeNode(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
}

class QNode{
    TreeNode node;
    int hd;//horizontalDistance

    public QNode(TreeNode node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class TopViewOfBinaryTree {

    void printTopVIew(TreeNode root){
        //base case
        if(root==null){
            return;
        }

        Set<Integer> set = new HashSet<>();
        Queue<QNode> queue = new LinkedList<>();

        queue.add(new QNode(root,0) ); //horizontal length of root is 0

        //standard BFS or level Order Traversal Loop
        while (!queue.isEmpty()){
            //Remove the front item and get its details.
            QNode tempNode = queue.remove();

            int hd = tempNode.hd;
            TreeNode treeNode = tempNode.node;

            //It this is the first node at its horizaontal distance,then this node is in the top view
            if(!set.contains(hd)) {
                set.add(hd);

                System.out.print(treeNode.key + " ");
            }

            //Enqueue the left and right childern

            /*
              A node x is there in output if x is the topmost node at its
              horizontal distance. Horizontal distance of left child of a node
              x is equal to horizontal distance of x minus 1, and that of right
              child is horizontal distance of x plus 1.
             */
            if(treeNode.left!=null){
                queue.add(new QNode(treeNode.left,hd-1));
            }

            if(treeNode.right!=null){
                queue.add(new QNode(treeNode.right,hd+1));
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(4);


        /*root.left =new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);*/

        TopViewOfBinaryTree ob = new TopViewOfBinaryTree();
        ob.printTopVIew(root);
    }
}
